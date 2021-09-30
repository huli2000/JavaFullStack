package facade.ex;

public class PermissionDeniedException extends  Exception{
    public PermissionDeniedException(String message) {
        super(message);
    }
}
