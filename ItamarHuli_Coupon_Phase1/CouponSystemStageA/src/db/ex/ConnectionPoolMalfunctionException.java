package db.ex;


public class ConnectionPoolMalfunctionException extends RuntimeException {
    public ConnectionPoolMalfunctionException(String msg) {
        super(msg);
    }
}
