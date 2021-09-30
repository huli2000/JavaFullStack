package db.ex;


public class NoSuchCustomerException extends Exception {
    public NoSuchCustomerException(String msg) {
        super(msg);
    }
}
