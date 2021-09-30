package facade.ex;


public class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}
