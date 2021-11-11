package db.dao;

import db.ConnectionPool;
import db.Schema;
import db.Utilities;
import db.ex.*;
import model.Coupon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CouponDBDao implements CouponDao {
    static Connection connection = null;
    static PreparedStatement ps = null;

    @Override
    public void createCoupon(Coupon coupon) throws NoSuchCouponException {
        if (coupon == null) {
            throw new NoSuchCouponException("coupon = null");
        }
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.INSERT_COUPON);

            Utilities.applyCouponValuesOnStatement(ps, coupon);
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to create coupon: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public void removeCoupon(long id) throws NoSuchCouponException {
        if (id <= 0) {
            throw new NoSuchCouponException(String.format("Invalid id %d", id));
        }
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.DELETE_COUPON);
            ps.setLong(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new NoSuchCouponException(String.format("No coupon found for id: %d", id));
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to remove coupon: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public void updateCoupon(Coupon coupon) throws NoSuchCouponException {
        if (coupon == null || coupon.getId() <= 0) {
            throw new NoSuchCouponException("coupon = null or invalid id");
        }
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();

            ps = connection.prepareStatement(Schema.UPDATE_COUPON);
            Utilities.applyCouponValuesOnStatement(ps, coupon);
            ps.setLong(10, coupon.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new NoSuchCouponException(String.format("No coupon found for id: %d", coupon.getId()));
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to update coupon: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public void decrementCouponAmount(long id) throws ZeroCouponAmountException, NoSuchCouponException {

        if (getCoupon(id) == null) {
            throw new NoSuchCouponException("Cant find coupon with id: " + id);
        }

        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.UPDATE_COUPON_AMOUNT);
            ps.setLong(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new ZeroCouponAmountException("The amount of the coupon with id: " + id + " = 0");
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to update coupon amount: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
    }

    @Override
    public Coupon getCoupon(long id) throws NoSuchCouponException {
        if (id <= 0) {
            throw new NoSuchCouponException("Invalid id");
        }
        Coupon coupon;
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.SELECT_COUPON_BY_ID);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                coupon = Utilities.resultSetToCoupon(rs);
            } else {
                throw new NoSuchCouponException(String.format("No such coupon with id %d", id));
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get coupon: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return coupon;
    }

    @Override
    public List<Coupon> getAllCoupons() throws NoSuchCouponException {
        List<Coupon> coupons = new ArrayList<>();
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.SELECT_ALL_COUPONS);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                coupons.add(Utilities.resultSetToCoupon(rs));
            }

            if (coupons.isEmpty()) {
                throw new NoSuchCouponException("No coupons found");
            }
        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get all coupons: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return coupons;
    }

    @Override
    public List<Coupon> getCoupons(int category) throws NoSuchCouponException {
        if (category <= 0) {
            throw new NoSuchCouponException("Invalid category: " + category);
        }
        List<Coupon> coupons = new ArrayList<>();
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.SELECT_COUPON_BY_CATEGORY);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                coupons.add(Utilities.resultSetToCoupon(rs));
            }

            if (coupons.isEmpty()) {
                return null;
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get the coupons for category:"
                                                 + category
                                                 + " , "
                                                 + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return coupons;
    }

    public static List<Coupon> getCustomerCoupons(long customerId) throws NoSuchCustomerException {

        if (customerId <= 0) {
            throw new NoSuchCustomerException(String.format("No such customer for id %d", customerId));
        }

        List<Coupon> coupons = new ArrayList<>();
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.SELECT_CUSTOMER_COUPON_BY_ID);
            ps.setLong(1, customerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                coupons.add(Utilities.resultSetToCoupon(rs));
            }
            if (coupons.isEmpty()) {
                return null;
            }
        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get customer coupons: " + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return coupons;
    }

    public static List<Coupon> getCompanyCoupons(long companyId) throws NoSuchCompanyException {
        if (companyId <= 0) {
            throw new NoSuchCompanyException("Invalid id");
        }

        List<Coupon> coupons = new ArrayList<>();
        initializeStatementAndConnection();

        try {
            connection = ConnectionPool.getInstance().getConnection();
            ps = connection.prepareStatement(Schema.SELECT_COUPONS_BY_COMPANY_ID);
            ps.setLong(1, companyId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                coupons.add(Utilities.resultSetToCoupon(rs));
            }
            if (coupons.isEmpty()) {
                return null;
            }

        } catch (SQLException ex) {
            throw new SystemMalfunctionException("Unable to get all coupons for company with id: " + companyId + " "
                                                 + ex.getMessage());
        } finally {
            Utilities.closeStatementAndPutConnection(ps, connection);
        }
        return coupons;
    }

    private static void initializeStatementAndConnection() {
        connection = null;
        ps = null;
    }
}
