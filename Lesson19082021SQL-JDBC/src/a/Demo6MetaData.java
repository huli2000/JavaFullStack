package a;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;

public class Demo6MetaData {

	public static void main(String[] args) {
			
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
				String user = "root";
				String password = "1234";
	
				try (Connection con = DriverManager.getConnection(url, user, password)){
				Statement stmt = con.createStatement();
				String sql = "select * from person;";
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println(sql);
				
				ResultSetMetaData rsMeta = rs.getMetaData();
				for (int i = 0; i < args.length; i++) {
					
				}
				
				while (rs.next()) {
					int id =rs.getInt("id");
					String name = rs.getString("personName");
					int age = rs.getInt("age");
					System.out.println(id + ", " + name + ", " + age);
				}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
	
	}

}
