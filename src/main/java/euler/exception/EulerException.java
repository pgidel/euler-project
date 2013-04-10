package euler.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class EulerException extends Exception {

	private static final long serialVersionUID = -7621625236922614426L;

	private static final ResourceBundle messages = ResourceBundle
			.getBundle("message");

	public EulerException() {
	}

	public EulerException(CodeError message, Object... params) {
		super(MessageFormat.format(messages.getString(message.name()), params));
	}

	public enum CodeError {
		EMPTY_FILE, FILE_NOT_FOUND, ERROR_READING_FILE, ERROR_CLOSING_FILE, ALPHABETIC_ERROR, PRIME_ERROR;
	}

}
