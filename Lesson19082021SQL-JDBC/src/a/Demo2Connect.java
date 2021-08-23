package a;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class Demo2Connect {
public static void main(String[] args) {
	//get connection with URL
	
	String protocol = "jdbc:mysql://";
	String ip = "127.0.0.1:";
	String port = "3306/";
	String route = "db1";
	String url = protocol + ip + port + route;
	
	System.out.println(url);
	
	try {
	java.sql.Connection con =DriverManager.getConnection(url, "root", "1234");
	System.out.println("connected to " + con);
	con.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
}
