package db.ex;


public class SystemMalfunctionException extends RuntimeException {
    public SystemMalfunctionException(String msg) {
        super(msg);
    }
}
