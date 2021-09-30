package facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.Utilities;
import db.dao.CompanyDBDao;
import db.dao.CompanyDao;
import db.dao.CouponDBDao;
import db.dao.CouponDao;
import db.ex.NoSuchCompanyException;
import db.ex.NoSuchCouponException;
import facade.ex.InvalidLoginException;
import facade.ex.PermissionDeniedException;
import model.Company;
import model.Coupon;


public class CompanyFacade {
    /*The hosted company*/
    private final Company company;
    private final CompanyDao companyDao;
    private final CouponDao couponDao;

    private CompanyFacade(Company company, CompanyDao companyDao, CouponDao couponDao) {
        this.company = company;
        this.companyDao = companyDao;
        this.couponDao = couponDao;
    }

    /**
     * Login operation to the company
     *
     * @param email    The company email address
     * @param password The company password
     * @return new CompanyFacade
     * @throws InvalidLoginException  wrong email and password
     * @throws NoSuchCompanyException if no such company found with the given email and password
     */
    public static CompanyFacade from(String email, String password) throws InvalidLoginException, NoSuchCompanyException {
        CompanyDao companyDao = new CompanyDBDao();
        Company company;

        if ((company = companyDao.login(email, password)) != null) {

            return new CompanyFacade(company, companyDao, new CouponDBDao());
        } else {
            String failureMessage = String.format("Unable to login with credentials username %s, password %s as "
                                                  + "company", email, password);
            throw new InvalidLoginException(failureMessage);
        }
    }

    /**
     * Create new coupon for the company
     *
     * @param coupon coupon to create
     * @return true if created , false otherwise
     * @throws PermissionDeniedException if try to create coupon to different company
     */
    public boolean createCoupon(Coupon coupon) throws NoSuchCouponException, PermissionDeniedException {
        //Prevent creation of coupon which is not related to this company.
        if (Utilities.isDifferent(this.company.getId(), coupon.getCompanyId())) {
            throw new PermissionDeniedException("This coupon id is not related to this company");
        }

        //Prevent creation of a coupon with a title that already exists.
        List<Coupon> coupons = couponDao.getAllCoupons();
        if (coupons != null) {
            if (coupons.stream().anyMatch(c -> c.getTitle().equals(coupon.getTitle()))) {
                return false;
            }
        }

        couponDao.createCoupon(coupon);
        return true;
    }

    /**
     * Update the coupon with the same id that given in the coupon param
     *
     * @param coupon the coupon to update
     * @return true if updated , false otherwise
     */
    public boolean updateCoupon(Coupon coupon) throws NoSuchCouponException {
        //Prevent updating coupon's title.
        Coupon c = couponDao.getCoupon(coupon.getId());
        if (!c.getTitle().equals(coupon.getTitle())) {
            return false;
        }

        couponDao.updateCoupon(coupon);
        return true;
    }

    /**
     * Get coupon with the couponId
     *
     * @param couponId the id of the coupon to get
     * @return the coupon with the same id as the couponId
     * @throws PermissionDeniedException if try to get coupon to different company
     */
    public Coupon getCoupon(long couponId) throws NoSuchCouponException, PermissionDeniedException {

        Coupon coupon = couponDao.getCoupon(couponId);
        //Prevent retrieval of a coupon which is not related to this company.
        if (Utilities.isDifferent(this.company.getId(), coupon.getCompanyId())) {
            throw new PermissionDeniedException("This coupon id is not related to this company");
        }

        return couponDao.getCoupon(couponId);
    }

    /**
     * Get all coupons for the hosted company
     *
     * @return List of coupons that's belong to the hosted company
     */
    public List<Coupon> getAllCoupons() throws NoSuchCouponException, NoSuchCompanyException {

        //Return only the coupons which are related to this company.
        return companyDao.getCoupons(this.company.getId());
    }

    /**
     * Get all coupons with the given category
     *
     * @param category the filter for the given coupons
     * @return List of coupons that's equal the given category

     */
    public List<Coupon> getCoupons(int category) throws NoSuchCouponException, NoSuchCompanyException {
        List<Coupon> coupons = new ArrayList<>();
        List<Coupon> companyCoupons = companyDao.getCoupons(this.company.getId());

        //Return only the coupons which are related to this company and their category columns equals 'category'
        if (companyCoupons != null) {
            for (Coupon coupon : companyCoupons) {
                if (coupon.getCategory() == category) {
                    coupons.add(coupon);
                }
            }
        }
        return coupons;
    }

    /**
     * Remove coupon with the id param
     *
     * @param id id of the coupon to delete
     * @return true if deleted , false otherwise
     * @throws PermissionDeniedException if try to delete coupon to different company
     */
    public boolean removeCoupon(long id) throws NoSuchCouponException, PermissionDeniedException {
        //Prevent removal of coupon which is not related to this company.
        Coupon coupon = couponDao.getCoupon(id);

        if (Utilities.isDifferent(this.company.getId(), coupon.getCompanyId())) {
            throw new PermissionDeniedException("This coupon id is not related to this company");
        }

        couponDao.removeCoupon(id);
        return true;
    }

    /**
     * Get all coupons lower than the given price
     *
     * @param price the price to compare the coupons price
     * @return List of all coupons that's price is lower than the given price
     */
    public List<Coupon> getCouponsLowerThanPrice(double price) throws NoSuchCouponException, NoSuchCompanyException {
        if (price < 0) {
            throw new NoSuchCouponException("Invalid price");
        }
        List<Coupon> coupons = new ArrayList<>();
        List<Coupon> companyCoupons = companyDao.getCoupons(this.company.getId());

        if (companyCoupons != null) {
            for (Coupon coupon : companyCoupons) {
                if (coupon.getPrice() < price) {
                    coupons.add(coupon);
                }
            }
        }

        return coupons;
    }

    /**
     * Get all coupons that's end date is later than the given date
     *
     * @param date the date to compare the end date of the coupon
     * @return All coupons that's end date is later than the given date
     */
    public List<Coupon> getCouponsBeforeEndDate(LocalDate date) throws NoSuchCouponException, NoSuchCompanyException {
        List<Coupon> coupons = new ArrayList<>();
        List<Coupon> companyCoupons = companyDao.getCoupons(this.company.getId());

        if (companyCoupons != null) {
            for (Coupon coupon : companyCoupons) {
                if (coupon.getEndDate().toLocalDate().isBefore(date)) {
                    coupons.add(coupon);
                }
            }
        }

        return coupons;
    }

}
