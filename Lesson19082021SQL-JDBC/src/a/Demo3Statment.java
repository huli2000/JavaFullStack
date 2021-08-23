package a;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Demo3Statment {

	public static void main(String[] args) {
			
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
				String user = "root";
				String password = "1234";
	
				try (Connection con = DriverManager.getConnection(url, user, password)){
				Statement stmt = con.createStatement();
				String sql = "insert into person values (288,'Daniel', 12);";
				stmt.executeUpdate(sql);
				System.out.println(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	
	}

}
