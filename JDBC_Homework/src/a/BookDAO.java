package a;

import java.sql.*;

public class BookDAO {

	public static void main(String[] args) {

		Book book = new Book("101", "Harry Potter", "JRoling", 42.20, Language.JAPANESE, Date.valueOf("1999-02-12"),
				765);

		createBookDb();

	}

	private static void createBookDb() {

		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		String user = "root";
		String password = "1234";
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "create table book( ";
			sql += "isbn VARCHAR(50), ";
			sql += "author VARCHAR(50), ";
			sql += "title VARCHAR(50), ";
			sql += "price FLOAT, ";
			sql += "pages INT, ";
			sql += "published Date,";
			sql += "language VARCHAR(50))";
			System.out.println(sql);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cannot connect");

		}
	}

}
