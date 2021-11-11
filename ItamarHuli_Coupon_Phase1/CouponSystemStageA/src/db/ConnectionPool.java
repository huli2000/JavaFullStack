package db;

import db.ex.ConnectionPoolMalfunctionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class ConnectionPool {

    private static final String DATABASE_NAME = "cs";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME + "?serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    private static final int MAX_CONNECTIONS = 10;
    private static ConnectionPool instance;
    private final BlockingQueue<Connection> connections;

    private ConnectionPool() {
        connections = new LinkedBlockingQueue<>(MAX_CONNECTIONS);
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                connections.offer(createConnection());
            } catch (SQLException exception) {
                /*Ignore*/
            }
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    public synchronized Connection getConnection() {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            throw new ConnectionPoolMalfunctionException("Interrupted while trying to get a connection!");
        }
    }

    public synchronized void putConnection(Connection connection) {
        try {
            connections.put(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolMalfunctionException("Interrupted while trying to put a connection!");
        }
    }

    public synchronized void closeAllConnections() {
        Connection connection;
        while ((connection = connections.poll()) != null) {
            try {
                connection.close();
            } catch (SQLException exception) {
                throw new ConnectionPoolMalfunctionException(exception.getMessage());
            }
        }
    }

    public synchronized static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
}

