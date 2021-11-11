package db.dao;

import db.ex.NoSuchCouponException;
import db.ex.ZeroCouponAmountException;
import model.Company;
import model.Coupon;

import java.util.List;

public interface CouponDao {
    /**
     * Create a new coupon in that data-source.
     *
     * @param coupon The new coupon to create.
     */
    void createCoupon(Coupon coupon) throws NoSuchCouponException;

    /**
     * Remove the coupon with the specified id.
     *
     * @param id The id of the coupon that should be removed.
     */
    void removeCoupon(long id) throws NoSuchCouponException;

    /**
     * Update a {@link Coupon} in the data-source.
     *
     * @param coupon The up-to-date {@link Coupon} that should be used to update the relevant {@link Coupon}
     *                This {@link Coupon} should have an id, in order to identify the {@link Coupon} to be updated.
     */
    void updateCoupon(Coupon coupon) throws NoSuchCouponException;

    /**
     * Decrement coupon amount
     * @param id The id of the coupon to decrement
     */
    void decrementCouponAmount(long id) throws ZeroCouponAmountException, NoSuchCouponException;

    /**
     * @param id the id of the coupon
     * @return A coupon from the data-source which is identified by the given id.
     */
    Coupon getCoupon(long id) throws NoSuchCouponException;

    /**
     * @return List of all the coupons in the data-source.
     */
    List<Coupon> getAllCoupons() throws NoSuchCouponException;

    /**
     * @param category The category to get all the coupons from
     * @return List of all coupons
     */
    List<Coupon> getCoupons(int category) throws NoSuchCouponException;
}
