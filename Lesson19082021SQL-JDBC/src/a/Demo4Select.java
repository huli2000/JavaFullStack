package a;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.sql.Connection;

public class Demo4Select {

	public static void main(String[] args) {
			
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
				String user = "root";
				String password = "1234";
	
				try (Connection con = DriverManager.getConnection(url, user, password)){
				Statement stmt = con.createStatement();
				String sql = "select * from person;";
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println(sql);
				rs.next();
				rs.next();
				rs.next();
				rs.next();
			
				int id =rs.getInt(1);
				String name = rs.getString(2);
				System.out.println(id);
				System.out.println(name);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	
	}

}
