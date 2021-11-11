package coupons.core.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import coupons.core.exceptions.CouponSystemException;

public class ConnectionPool {

	// the singleton ConnectionPool reference

	private static ConnectionPool instance;
	private Set<Connection> connections = new HashSet<Connection>();
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	private int size;

	public static void main(String[] args) throws CouponSystemException {
		ConnectionPool.getInstance();
	}

	// private CTOR

	private ConnectionPool() throws CouponSystemException {

		// create connection and store in the set

		Properties properties = new Properties();
		File file = new File("files/app.properties");
		try (FileInputStream in = new FileInputStream(file)) {
			properties.load(in); // load all properties from file
			this.dbUrl = properties.getProperty("db.url");
			this.dbUser = properties.getProperty("db.user");
			this.dbPassword = properties.getProperty("db.pass");
			this.size = Integer.parseInt(properties.getProperty("db.connection.pool.size"));

			System.out.println(this.dbUrl);
			System.out.println(this.dbPassword);
			System.out.println(this.dbUser);
			System.out.println(this.size);
		} catch (IOException e) {
			throw new CouponSystemException("ConnectionPool loading failed", e);
		}
		// create connections and store in the set

		try {
			for (int i = 0; i < size; i++) {
				Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
				this.connections.add(con);

			}

			System.out.println("connection pool is up with " + this.connections.size() + " connections");
		} catch (SQLException e) {
			throw new CouponSystemException("ConnectionPool init failed", e);
		}
	}

	// getter for the single instance

	public static ConnectionPool getInstance() throws CouponSystemException {
		if (instance == null) {
			instance = new ConnectionPool();

		}

		return instance;
	}

	public synchronized Connection getConnection() {
		// wait until connection is available
		while (this.connections.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		// get a connection from the pool
		Iterator<Connection> it = this.connections.iterator();
		Connection con = it.next();
		// remove it from the pool
		it.remove();
		// return to the pool
		return con;

	}

	public void restoreConnection(Connection connection) {
		// add the connection to the set
		// notify other threads
	}

	public void closeAllConnections() {
		// close the pool - no more connections going out
		// wait for all connections to be back
		// close all connections

	}
}
