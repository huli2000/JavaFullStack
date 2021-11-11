package db;

import model.Company;
import model.Coupon;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilities {


    public static void closeStatementAndPutConnection(PreparedStatement ps, Connection connection) {
        if (connection != null) {
            ConnectionPool.getInstance().putConnection(connection);
        }

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Sql Exception: " + ex.getMessage());
        }
    }

    public static void applyCouponValuesOnStatement(PreparedStatement ps, Coupon coupon) throws SQLException {
        ps.setLong(1, coupon.getCompanyId());
        ps.setInt(2, coupon.getCategory());
        ps.setString(3, coupon.getTitle());
        ps.setDate(4, coupon.getStartDate());
        ps.setDate(5, coupon.getEndDate());
        ps.setInt(6, coupon.getAmount());
        ps.setString(7, coupon.getDescription());
        ps.setDouble(8, coupon.getPrice());
        ps.setString(9, coupon.getImage());
    }

    public static Customer resultSetToCustomer(ResultSet rs) throws SQLException {
        return new Customer(rs.getLong(Schema.COL_ID),
                rs.getString(Schema.COL_FIRST_NAME),
                rs.getString(Schema.COL_LAST_NAME),
                rs.getString(Schema.COL_EMAIL),
                rs.getString(Schema.COL_PASSWORD));
    }

    public static Coupon resultSetToCoupon(ResultSet rs) throws SQLException {
        return new Coupon(rs.getLong(Schema.COL_ID),
                rs.getLong(Schema.COL_COMPANY_ID),
                rs.getInt(Schema.COL_CATEGORY),
                rs.getString(Schema.COL_TITLE),
                rs.getDate(Schema.COL_START_DATE),
                rs.getDate(Schema.COL_END_DATE),
                rs.getInt(Schema.COL_AMOUNT),
                rs.getString(Schema.COL_DESC),
                rs.getDouble(Schema.COL_PRICE),
                rs.getString(Schema.COL_IMAGE));
    }

    public static Company resultSetToCompany(ResultSet rs) throws SQLException {
        return new Company(rs.getLong(Schema.COL_ID),
                rs.getString(Schema.COL_NAME),
                rs.getString(Schema.COL_EMAIL),
                rs.getString(Schema.COL_PASSWORD)
        );
    }

    public static boolean isDifferent(long num1, long num2) {
        return num1 != num2;
    }
}
