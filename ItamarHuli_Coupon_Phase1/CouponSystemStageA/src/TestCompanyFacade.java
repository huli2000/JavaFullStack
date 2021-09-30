import db.ex.NoSuchCompanyException;
import db.ex.NoSuchCouponException;
import facade.CompanyFacade;
import facade.ex.InvalidLoginException;
import facade.ex.PermissionDeniedException;
import model.Coupon;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class TestCompanyFacade {
    public static void main(String[] args) {
        CompanyFacade companyFacade;
        try {
            //Test Login
            System.out.println("Login:");
            companyFacade = CompanyFacade.from("facebook@gmail.com", "1234");
            System.out.println("Login successfully!");

            //Test createCoupon
            System.out.println("createCoupon:");
            Date startDate = Date.valueOf(LocalDate.now().minusDays(30));
            Date endDate = Date.valueOf(LocalDate.now().plusYears(1));
            boolean coupon = companyFacade.createCoupon(new Coupon(1, 2, 1, "751% off!", startDate, endDate,
                    500, "751% off on all products!", 15.2, "http://img.co.il"));
            if (coupon) {
                System.out.println("New coupon as been created!");
            }

            //Test getCoupon
            System.out.println("getCoupon:");
            Coupon coupon1 = companyFacade.getCoupon(3);
            System.out.println(coupon1.getTitle());

            //Test updateCoupon
            System.out.println("updateCoupon:");
            boolean b = companyFacade.updateCoupon(new Coupon(3, 2, 2, "75% off!", startDate, endDate, 490, "after update", 22, "http://img.co.il"));
            if (b) {
                System.out.println("Coupon as been updated!");
            } else {
                System.out.println("cant update title!");
            }

            //Test getAllCoupons
            System.out.println("getAllCoupons:");
            List<Coupon> allCoupons = companyFacade.getAllCoupons();
            if (allCoupons != null) {
                for (Coupon allCoupon : allCoupons) {
                    System.out.println(allCoupon.toString());
                }
            }

            //Test getCoupons
            System.out.println("getCoupons:");
            List<Coupon> coupons = companyFacade.getCoupons(2);
            if (coupons != null) {
                for (Coupon coupon2 : coupons) {
                    System.out.println(coupon2.toString());
                }
            }

            //Test removeCoupon
            System.out.println("removeCoupon:");
            boolean b1 = companyFacade.removeCoupon(3);
            if (b1) {
                System.out.println("Coupon removed successfully!");
            } else {
                throw new NoSuchCouponException("Can't find coupon to removed");
            }

            //Test getCouponsLowerThanPrice
            System.out.println("getCouponsLowerThanPrice:");
            List<Coupon> coupons1 = companyFacade.getCouponsLowerThanPrice(30);
            if (coupons1 != null) {
                coupons1.forEach(coupon2 -> System.out.println(coupon2.toString()));
            } else {
                System.out.println("No such coupons lower than given price");
            }

            //Test getCouponsBeforeEndDate
            System.out.println("getCouponsBeforeEndDate:");
            List<Coupon> couponsBeforeEndDate = companyFacade.getCouponsBeforeEndDate(LocalDate.now().plusYears(2));
            if (couponsBeforeEndDate != null) {
                couponsBeforeEndDate.forEach(coupon2 -> System.out.println(coupon2.toString()));
            } else {
                System.out.println("No such coupons before the given date");
            }

        } catch (NoSuchCouponException ex) {
            System.out.println("Coupon Exception: " + ex.getMessage());
        } catch (NoSuchCompanyException ex) {
            System.out.println("Company Exception: " + ex.getMessage());
        } catch (PermissionDeniedException ex) {
            System.out.println("Permission Denied Exception: " + ex.getMessage());
        } catch (InvalidLoginException ex) {
            System.out.println("Invalid Login Exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
