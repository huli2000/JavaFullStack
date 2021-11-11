package db.dao;

import java.util.List;

import db.ex.NoSuchCompanyException;
import db.ex.NoSuchCouponException;
import model.Company;
import model.Coupon;


public interface CompanyDao {
    /**
     * Create a new company in that data-source.
     *
     * @param company The new company to create.
     */
    void createCompany(Company company) throws NoSuchCompanyException;

    /**
     * Remove the company with the specified id.
     *
     * @param id The id of the company that should be removed.
     */
    void removeCompany(long id) throws NoSuchCompanyException, NoSuchCompanyException;

    /**
     * Update a {@link Company} in the data-source.
     *
     * @param company The up-to-date {@link Company} that should be used to update the relevant {@link Company}
     *                This {@link Company} should have an id, in order to identify the {@link Company} to be updated.
     */
    void updateCompany(Company company) throws NoSuchCompanyException;

    /**
     * @param id The id of the company
     *
     * @return A company from the data-source which is identified by the given id.
     */
    Company getCompany(long id) throws NoSuchCompanyException, NoSuchCouponException;

    /**
     * @return List of all the companies in the data-source.
     */
    List<Company> getAllCompanies() throws NoSuchCompanyException, NoSuchCouponException;

    /**
     * Get all the coupons for the company identified by the given id.
     *
     * @param companyId The id of the company
     *
     * @return List of all coupons.
     */
    List<Coupon> getCoupons(long companyId) throws NoSuchCompanyException, NoSuchCouponException;

    /**
     * @param email    The email of company.
     * @param password The password of the company.
     *
     * @return A company from the data-source which is identified by the given email and password.
     */
    Company login(String email, String password) throws NoSuchCompanyException;
}
