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
import db.ex.NoSuchCompanyException;
import db.ex.SystemMalfunctionException;
import model.Company;
import model.Coupon;


public class CompanyDBDao implements CompanyDao {

    static Connection connection = null;
    static PreparedStatement ps = null;

    @Override
    public void createCompany(Company company) throws NoSuchCompanyException {
        if (company == null) {
            throw new NoSuchCompanyException("company = null");
        }

        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.INSERT_COMPANY);
            applyCompanyValuesOnStatement(ps, company);

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to create company: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public void removeCompany(long id) throws NoSuchCompanyException {
        if (id <= 0) {
            throw new NoSuchCompanyException(String.format("Invalid id %d", id));
        }
        initializeStatementAndConnection();
        try {
            connection = ConnectionPool.getInstance().getConnection();

            ps = connection.prepareStatement(Schema.DELETE_COMPANY);
            ps.setLong(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new NoSuchCompanyException(String.format("No company found for id: %d", id));
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to remove company: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public void updateCompany(Company company) throws NoSuchCompanyException {
        if (company == null || company.getId() <= 0) {
            throw new NoSuchCompanyException("company = null or invalid id");
        }

        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.UPDATE_COMPANY);
            applyCompanyValuesOnStatement(ps, company);
            ps.setLong(4, company.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new NoSuchCompanyException(String.format("No company found for id: %d", company.getId()));
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to update company: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public Company getCompany(long id) throws NoSuchCompanyException {
        if (id <= 0) {
            throw new NoSuchCompanyException(String.format("Invalid id %d", id));
        }

        Company company;
        initializeStatementAndConnection();
        try {
            connection = ConnectionPool.getInstance().getConnection();

            ps = connection.prepareStatement(Schema.SELECT_COMPANY_BY_ID);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                company = Utilities.resultSetToCompany(rs);
                List<Coupon> coupons = getCoupons(company.getId());
                if (coupons != null) {
                    company.setCoupons(new HashSet<>(coupons));
                }
            } else {
                throw new NoSuchCompanyException(String.format("No such company with id %d", id));
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get company: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }

        return company;
    }

    @Override
    public List<Company> getAllCompanies() throws NoSuchCompanyException {
        List<Company> companies = new ArrayList<>();
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.SELECT_ALL_COMPANIES);

            ResultSet rs = ps.executeQuery();

            /*Add to list All companies*/
            while (rs.next()) {
                Company company = Utilities.resultSetToCompany(rs);
                List<Coupon> coupons = getCoupons(company.getId());
                if (coupons != null) {
                    company.setCoupons(new HashSet<>(coupons));
                }
                companies.add(company);
            }

            if (companies.isEmpty()) {
                throw new NoSuchCompanyException("No companies");
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get all companies: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return companies;
    }

    @Override
    public List<Coupon> getCoupons(long companyId) throws NoSuchCompanyException {

        return CouponDBDao.getCompanyCoupons(companyId);
    }

    @Override
    public Company login(String email, String password) throws NoSuchCompanyException {
        Company company;
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.COMPANY_LOGIN);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                company = Utilities.resultSetToCompany(rs);
            } else {
                throw new NoSuchCompanyException(String.format("No company found with email: %s password: %s", email, password));
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException(String.format("Unable to login to company with email: %s password: %s", email, password));
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return company;
    }

    private static void applyCompanyValuesOnStatement(PreparedStatement ps, Company company) throws SQLException {
        ps.setString(1, company.getName());
        ps.setString(2, company.getEmail());
        ps.setString(3, company.getPassword());
    }

    private static void initializeStatementAndConnection() {
        connection = null;
        ps = null;
    }

}
