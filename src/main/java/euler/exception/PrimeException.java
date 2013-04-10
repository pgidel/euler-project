package euler.exception;

public class PrimeException extends EulerException {

	private static final long serialVersionUID = -7621625236922614426L;

	public PrimeException() {
	}

	public PrimeException(Character c) {
		super(CodeError.PRIME_ERROR, c);
	}

}
