import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestConnection {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cs?serverTimezone=UTC";

    public static void main(String[] args) {
        String username = "root";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, username, password);
            System.out.println("Everything works just fine! We have a connection to the server!");
        } catch (SQLException throwables) {
            System.out.println("Something went wrong...:-(!");
        }
    }
}
