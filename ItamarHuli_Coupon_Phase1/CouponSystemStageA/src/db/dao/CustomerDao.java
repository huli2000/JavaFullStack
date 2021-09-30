package db.dao;

import java.util.List;

import db.ex.NoSuchCouponException;
import db.ex.NoSuchCustomerException;
import model.Coupon;
import model.Customer;


public interface CustomerDao {

    /**
     * Creates a {@link Customer} in the data-source.
     *
     * @param customer The customer to insert.
     */
    void createCustomer(Customer customer) throws NoSuchCustomerException;

    /**
     * Removes a {@link Customer} by a specified id.
     *
     * @param id The id of the {@link Customer} to be removed.
     */
    void removeCustomer(long id) throws NoSuchCustomerException;

    /**
     * Update a {@link Customer} in the data-source.
     *
     * @param customer The up-to-date {@link Customer} that should be used to update the relevant {@link Customer}
     *                 This {@link Customer} should have an id, in order to identify the {@link Customer} to be updated.
     */
    void updateCustomer(Customer customer) throws NoSuchCustomerException;

    /**
     * @param id The id of the {@link Customer}
     *
     * @return Retrieves a {@link Customer} from data-source, by a specified id.
     */
    Customer getCustomer(long id) throws NoSuchCustomerException, NoSuchCouponException;

    /**
     * Get all {@link Customer}s in data-source.
     *
     * @return A list of all {@link Customer}s.
     */
    List<Customer> getAllCustomers() throws NoSuchCustomerException, NoSuchCouponException;

    /**
     * Get all {@link Coupon}s of a specific {@link Customer} by a given id.
     *
     * @param id The id of the {@link Customer}
     *
     * @return A list of all {@link Coupon}s for the {@link Customer}
     */
    List<Coupon> getCoupons(long id) throws NoSuchCustomerException, NoSuchCouponException;

    /**
     * Insert a pair (coupon_id,customer_id) to the customer_coupon table in order to create a relation between a
     * {@link Coupon} and a {@link Customer}.
     *
     * @param couponId
     * @param customerId
     */
    void insertCustomerCoupon(long couponId, long customerId) throws NoSuchCustomerException;

    /**
     * Get a {@link Customer} by email and password.
     *
     * @param email    The email of the {@link Customer}
     * @param password The password of the {@link Customer}
     *
     * @return A {@link Customer} from the data-source.
     */
    Customer login(String email, String password) throws NoSuchCustomerException;
}
