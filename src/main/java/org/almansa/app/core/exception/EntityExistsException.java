package org.almansa.app.core.exception;

public class EntityExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntityExistsException() {
		super();
	}

	public EntityExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityExistsException(String message) {
		super(message);
	}

	public EntityExistsException(Throwable cause) {
		super(cause);
	}

}
