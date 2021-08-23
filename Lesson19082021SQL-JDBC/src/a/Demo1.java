package a;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Demo1 {

	public static void main(String[] args) {

		Enumeration<Driver> drivers = DriverManager.getDrivers();
		
		System.out.println("list of drivers");
		System.out.println("================");
		while (drivers.hasMoreElements()) {
			System.out.println(drivers.nextElement());
			
		}
	}
}
