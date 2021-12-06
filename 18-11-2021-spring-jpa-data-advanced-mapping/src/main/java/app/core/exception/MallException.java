package app.core.exception;

public class MallException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MallException() {
		super();
	}

	public MallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MallException(String message, Throwable cause) {
		super(message, cause);
	}

	public MallException(String message) {
		super(message);
	}

	public MallException(Throwable cause) {
		super(cause);
	}

}
