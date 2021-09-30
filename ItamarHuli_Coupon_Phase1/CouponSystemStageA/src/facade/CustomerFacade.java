package facade;

import java.util.ArrayList;
import java.util.List;

import db.dao.*;
import db.ex.NoSuchCouponException;
import db.ex.NoSuchCustomerException;
import db.ex.ZeroCouponAmountException;
import facade.ex.InvalidLoginException;
import model.Coupon;
import model.Customer;


public class CustomerFacade {
    /*The hosted customer*/
    private final Customer customer;
    private final CustomerDao customerDao;
    private final CouponDao couponDao;

    private CustomerFacade(Customer customer, CustomerDao customerDao, CouponDao couponDao) {
        this.customer = customer;
        this.customerDao = customerDao;
        this.couponDao = couponDao;
    }

    /**
     * Login operation to the customer
     *
     * @param email    The customer email address
     * @param password The customer password
     * @return new CustomerFacade
     * @throws NoSuchCustomerException if no such customer found with the given email and password
     * @throws InvalidLoginException   wrong email and password
     */
    public static CustomerFacade from(String email, String password) throws NoSuchCustomerException, InvalidLoginException {
        CustomerDao customerDao = new CustomerDBDao();
        Customer customer;

        if ((customer = customerDao.login(email, password)) != null) {
            return new CustomerFacade(customer, customerDao, new CouponDBDao());
        } else {
            String failureMessage = String.format("Unable to login with credentials username %s, password %s as "
                                                  + "customer", email, password);
            throw new InvalidLoginException(failureMessage);
        }
    }

    /**
     * Update the customer details
     *
     * @param customer The customer updated - can't update email address
     * @return true if updated , false otherwise
     */
    public boolean updateCustomer(Customer customer) throws NoSuchCustomerException {

        //return false if an attempt to update customer's email was made, true otherwise.
        if (!this.customer.getEmail().equals(customer.getEmail())) {
            return false;
        }

        customerDao.updateCustomer(customer);
        return true;
    }

    /**
     * Perform purchase operation for the hosted customer.
     *
     * @param couponId The id of the coupon to purchase.
     * @return true if purchase was successful, false otherwise.
     */
    public boolean purchaseCoupon(long couponId) throws NoSuchCouponException, NoSuchCustomerException, ZeroCouponAmountException {

        Coupon coupon = couponDao.getCoupon(couponId);
        if (coupon == null) {
            return false;
        }
        //Check if the customer already have this coupon
        List<Coupon> coupons = customerDao.getCoupons(this.customer.getId());
        if (coupons != null) {
            if (coupons.stream().anyMatch(c -> c.getId() == couponId)) {
                return false;
            }
        }

        customerDao.insertCustomerCoupon(coupon.getId(), this.customer.getId());
        couponDao.decrementCouponAmount(coupon.getId());
        return true;
    }

    /**
     * Get all coupons for the customer
     *
     * @return List with all the coupons that's related to this customer
     */
    public List<Coupon> getAllCoupons() throws NoSuchCustomerException, NoSuchCouponException {
        return customerDao.getCoupons(this.customer.getId());
    }

    /**
     * Get all coupons with the given category
     *
     * @param category The category to filter the coupons
     * @return List of all coupons
     */
    public List<Coupon> getCoupons(int category) throws NoSuchCustomerException, NoSuchCouponException {

        List<Coupon> coupons = new ArrayList<>();
        List<Coupon> customerCoupons = customerDao.getCoupons(this.customer.getId());

        //Return only the coupons which are related to this customer and their category columns equals 'category'
        if (customerCoupons != null) {
            for (Coupon coupon : customerCoupons) {
                if (coupon.getCategory() == category) {
                    coupons.add(coupon);
                }
            }
        }

        return coupons;
    }

    /**
     * Get all coupons for customer that's less than the given price
     *
     * @param price - the limit price for the coupons to get
     * @return List of all coupons
     */
    public List<Coupon> getCouponsLowerThanPrice(double price) throws NoSuchCustomerException, NoSuchCouponException {
        if (price < 0) {
            throw new NoSuchCouponException("Invalid price");
        }
        List<Coupon> coupons = new ArrayList<>();
        List<Coupon> customerCoupons = customerDao.getCoupons(this.customer.getId());

        if (customerCoupons != null) {
            for (Coupon coupon : customerCoupons) {
                if (coupon.getPrice() < price) {
                    coupons.add(coupon);
                }
            }
        }

        return coupons;
    }
}
