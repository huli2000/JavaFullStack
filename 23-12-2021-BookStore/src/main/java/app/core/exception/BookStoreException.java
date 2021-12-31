package app.core.exception;

public class BookStoreException extends Exception {

		private static final long serialVersionUID = 1L;

	public BookStoreException() {
	}

	public BookStoreException(String message) {
		super(message);
	}

	public BookStoreException(Throwable cause) {
		super(cause);
	}

	public BookStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
