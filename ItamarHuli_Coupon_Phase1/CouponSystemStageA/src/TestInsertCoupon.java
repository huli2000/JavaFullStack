import db.Schema;
import model.Coupon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestInsertCoupon {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cs?serverTimezone=UTC";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                PreparedStatement psInsertCoupon = connection.prepareStatement(Schema.INSERT_COUPON);

                applyCouponValuesOnStatement(psInsertCoupon, getRandomCoupon());

                psInsertCoupon.executeUpdate();

                System.out.println("New coupon was inserted successfully!");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void applyCouponValuesOnStatement(PreparedStatement stmt, Coupon coupon) throws SQLException {
        stmt.setLong(1, coupon.getCompanyId());
        stmt.setInt(2, coupon.getCategory());
        stmt.setString(3, coupon.getTitle());
        stmt.setDate(4, coupon.getStartDate());
        stmt.setDate(5, coupon.getEndDate());
        stmt.setInt(6, coupon.getAmount());
        stmt.setString(7, coupon.getDescription());
        stmt.setDouble(8, coupon.getPrice());
        stmt.setString(9, coupon.getImage());
    }

    private static Coupon getRandomCoupon() {
        return new Coupon(0,1, 7, "50% Discount!", Date.valueOf("2019-08-04"), Date.valueOf("2021-11-04"), 4,
                          "50% " + "Discount on all leather jackets.", 123.456, "http://www.someimage.com/foo.png");
    }

    private static Connection getConnection() {
        String username = "root";
        String password = "1234";

        try {
            return DriverManager.getConnection(DATABASE_URL, username, password);
        } catch (SQLException throwables) {
            /*Ignore*/
        }
        return null;
    }
}
