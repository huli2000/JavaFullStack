package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import db.ConnectionPool;
import db.Schema;
import db.Utilities;
import db.ex.NoSuchCustomerException;
import db.ex.SystemMalfunctionException;
import model.Coupon;
import model.Customer;


public class CustomerDBDao implements CustomerDao {
    static Connection connection = null;
    static PreparedStatement ps = null;

    @Override
    public void createCustomer(Customer customer) throws NoSuchCustomerException {
        if (customer == null) {
            throw new NoSuchCustomerException("customer = null");
        }

        initializeStatementAndConnection();
        try {
            connection = ConnectionPool.getInstance().getConnection();

            /*insert into customer (....) values (?,?,?,?)*/
            ps = connection.prepareStatement(Schema.INSERT_CUSTOMER);
            applyCustomerValuesOnStatement(ps, customer);

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to create customer: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public void removeCustomer(long id) throws NoSuchCustomerException {
        if (id <= 0) {
            throw new NoSuchCustomerException(String.format("Invalid id %d", id));
        }

        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();

            ps = connection.prepareStatement(Schema.DELETE_CUSTOMER);
            ps.setLong(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new NoSuchCustomerException(String.format("No customer found for id: %d", id));
            }
        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to remove customer: " + id + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws NoSuchCustomerException {
        if (customer == null || customer.getId() <= 0) {
            throw new NoSuchCustomerException("customer = null or invalid id");
        }

        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            /*update customer set first_name = ?, last_name = ?, email = ?, password = ? where id = ?*/
            ps = connection.prepareStatement(Schema.UPDATE_CUSTOMER);
            applyCustomerValuesOnStatement(ps, customer);
            ps.setLong(5, customer.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new NoSuchCustomerException(String.format("No customer found for id: %d", customer.getId()));
            }
        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to update customer: " + customer.getId() + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public Customer getCustomer(long id) throws NoSuchCustomerException {
        if (id <= 0) {
            throw new NoSuchCustomerException(String.format("Invalid id: %d", id));
        }
        Customer customer;
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();

            ps = connection.prepareStatement(Schema.SELECT_CUSTOMER_BY_ID);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                customer = Utilities.resultSetToCustomer(rs);
                List<Coupon> coupons = getCoupons(customer.getId());
                if (coupons != null) {
                    customer.setCoupons(new HashSet<>(getCoupons(id)));
                }
            } else {
                throw new NoSuchCustomerException(String.format("No such customer with id %d", id));
            }
        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get customer: " + id + ex.getMessage());

        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() throws NoSuchCustomerException {
        List<Customer> customers = new ArrayList<>();

        initializeStatementAndConnection();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.SELECT_ALL_CUSTOMERS);

            ResultSet rs = ps.executeQuery();

            /*Add to list All customers*/
            while (rs.next()) {
                Customer customer = Utilities.resultSetToCustomer(rs);
                List<Coupon> coupons = getCoupons(customer.getId());
                if (coupons != null) {
                    customer.setCoupons(new HashSet<>(coupons));
                }
                customers.add(customer);
            }

            if (customers.isEmpty()) {
                throw new NoSuchCustomerException("Cant find any customers");
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get all customers: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return customers;
    }

    @Override
    public List<Coupon> getCoupons(long customerId) throws NoSuchCustomerException {
        if (customerId <= 0) {
            throw new NoSuchCustomerException("Invalid customer id");
        }
        return CouponDBDao.getCustomerCoupons(customerId);
    }

    @Override
    public void insertCustomerCoupon(long couponId, long customerId) throws NoSuchCustomerException {

        if (couponId <= 0 || customerId <= 0) {
            throw new NoSuchCustomerException("Invalid id");
        }
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.INSERT_CUSTOMER_COUPON);
            ps.setLong(1, couponId);
            ps.setLong(2, customerId);

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to insert new row with ids : "
                                                 + couponId
                                                 + " ,"
                                                 + customerId
                                                 + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public Customer login(String email, String password) throws NoSuchCustomerException {
        Customer customer;
        initializeStatementAndConnection();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.CUSTOMER_LOGIN);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                customer = Utilities.resultSetToCustomer(rs);
            } else {
                throw new NoSuchCustomerException(String.format("Cant login customer with email: %s password: %s", email, password));
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException(String.format("Unable to login to customer with email: %s password: %s", email, password));
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return customer;
    }

    private static void applyCustomerValuesOnStatement(PreparedStatement ps, Customer customer) throws SQLException {
        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.setString(3, customer.getEmail());
        ps.setString(4, customer.getPassword());
    }

    private static void initializeStatementAndConnection() {
        connection = null;
        ps = null;
    }

}
