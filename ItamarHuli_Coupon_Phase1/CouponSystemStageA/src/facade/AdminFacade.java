package facade;

import java.util.List;


import db.dao.CompanyDBDao;
import db.dao.CompanyDao;
import db.dao.CouponDBDao;
import db.dao.CouponDao;
import db.dao.CustomerDBDao;
import db.dao.CustomerDao;
import db.ex.NoSuchCompanyException;
import db.ex.NoSuchCouponException;
import db.ex.NoSuchCustomerException;
import facade.ex.InvalidLoginException;
import model.Company;
import model.Coupon;
import model.Customer;

import static com.mysql.jdbc.StringUtils.isNullOrEmpty;


public class AdminFacade {

    private final CouponDao couponDao;
    private final CustomerDao customerDao;
    private final CompanyDao companyDao;

    private AdminFacade(CouponDao couponDao, CustomerDao customerDao, CompanyDao companyDao) {
        this.couponDao = couponDao;
        this.customerDao = customerDao;
        this.companyDao = companyDao;
    }

    /**
     * Login operation to the admin
     *
     * @param email    The admin email address
     * @param password The admin password
     * @return new AdminFacade
     * @throws InvalidLoginException wrong email and password
     */
    public static AdminFacade from(String email, String password) throws InvalidLoginException {
        //Check email password is not null
        if (!isNullOrEmpty(email) && !isNullOrEmpty(password)) {

            if (email.equals("admin") && password.equals("1234")) {
                return new AdminFacade(new CouponDBDao(), new CustomerDBDao(), new CompanyDBDao());

            } else {
                String failureMessage = String.format("Unable to login with credentials email %s, password %s as admin",
                        email,
                        password);
                throw new InvalidLoginException(failureMessage);
            }

        } else {
            throw new InvalidLoginException("Unable to login because one or more of the credentials is null or empty");
        }
    }

    /**
     * Create new company with the given Company Object
     *
     * @param company The company to create
     * @return true if created , false otherwise
     */
    public boolean createCompany(Company company) throws NoSuchCouponException, NoSuchCompanyException {
        List<Company> allCompanies = companyDao.getAllCompanies();

        if (allCompanies != null) {
            if (allCompanies.stream().anyMatch(c -> c.getName().equals(company.getName()))) {
                return false;
            }
        }

        companyDao.createCompany(company);
        return true;
    }

    /**
     * Remove company
     *
     * @param companyId The id of company to delete
     */
    public void removeCompany(long companyId) throws NoSuchCouponException, NoSuchCompanyException {
        List<Coupon> coupons = companyDao.getCoupons(companyId);
        if (coupons != null) {
            for (Coupon coupon : coupons) {
                couponDao.removeCoupon(coupon.getId());
            }
        }

        companyDao.removeCompany(companyId);
    }

    /**
     * Update the company with the same id as the company given
     *
     * @param company The updated company
     * @return true if updated , false otherwise
     */
    public boolean updateCompany(Company company) throws NoSuchCouponException, NoSuchCompanyException {

        Company c = companyDao.getCompany(company.getId());

        if (!c.getName().equals(company.getName())) {
            return false;
        }

        companyDao.updateCompany(company);
        return true;
    }

    /**
     * Get all the companies
     *
     * @return List of all companies
     */
    public List<Company> getAllCompanies() throws NoSuchCouponException, NoSuchCompanyException {
        return companyDao.getAllCompanies();
    }

    /**
     * Get the company with given id
     *
     * @param id the company to get
     * @return Company
     */
    public Company getCompany(long id) throws NoSuchCouponException, NoSuchCompanyException {
        return companyDao.getCompany(id);
    }

    /**
     * Create a customer in data-source. Prevent creation of a customer with the same email address.
     *
     * @param customer The customer to create.
     * @return true upon success, false otherwise.
     */
    public boolean createCustomer(Customer customer) throws NoSuchCustomerException, NoSuchCouponException {

        List<Customer> customers = customerDao.getAllCustomers();

        if (customers != null) {
            if (customers.stream().anyMatch(c -> c.getEmail().equals(customer.getEmail()))) {
                return false;
            }
        }

        customerDao.createCustomer(customer);
        return true;
    }

    /**
     * Remove the customer with the specified id.
     *
     * @param id The id of the customer.
     * @return true upon removal, false otherwise.
     */
    public boolean removeCustomer(long id) throws NoSuchCustomerException {
        customerDao.removeCustomer(id);
        return true;
    }

    /**
     * Update a customer in data-source. Prevent email modification.
     *
     * @param customer The customer to update.
     * @return true upon success, false otherwise.
     */
    public boolean updateCustomer(Customer customer) throws NoSuchCustomerException, NoSuchCouponException {

        Customer c = customerDao.getCustomer(customer.getId());
        if (!c.getEmail().equals(customer.getEmail())) {
            return false;
        }

        customerDao.updateCustomer(customer);
        return true;
    }

    /**
     * Get customer with the given id
     *
     * @param id The id of the customer
     * @return Customer
     */
    public Customer getCustomer(long id) throws NoSuchCustomerException, NoSuchCouponException {
        return customerDao.getCustomer(id);
    }

}
