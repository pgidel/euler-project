package euler.exception;

public class AlphabeticException extends EulerException {

	private static final long serialVersionUID = -7621625236922614426L;

	public AlphabeticException() {
	}

	public AlphabeticException(Number n) {
		super(CodeError.ALPHABETIC_ERROR, n);
	}

}
