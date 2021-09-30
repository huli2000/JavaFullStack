import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.ConnectionPool;
import db.Schema;


public class TestInsertCompany {

    public static void main(String[] args) {

        try {

            Connection connection = ConnectionPool.getInstance().getConnection();

            if (connection != null) {
                PreparedStatement preStatement = connection.prepareStatement(Schema.INSERT_COMPANY);

                preStatement.setString(1, "Amazon");
                preStatement.setString(2, "amazong@gmail.com");
                preStatement.setString(3, "h42fon3489");

                preStatement.executeUpdate();

                System.out.println("New company inserted!");
            }
        } catch (SQLException throwables) {
            System.out.println("Something went wrong while trying to insert a new company");
        }
    }
}
