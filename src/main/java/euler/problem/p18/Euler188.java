package euler.problem.p18;

import euler.exception.EulerException;
import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler188 extends AbstractEuler {

	private long a;
	private long b;
	private int n;

	public Euler188(long a, long b, int n) {
		this.a = a;
		this.b = b;
		this.n = n;
	}

	/**
	 * The hyperexponentiation or tetration of a number a by a positive integer b, denoted by a↑↑b or ^(b)a, is
	 * recursively defined by:
	 * 
	 * a↑↑1 = a, a↑↑(k+1) = a^((a↑↑k)).
	 * 
	 * Thus we have e.g. 3↑↑2 = 3^(3) = 27, hence 3↑↑3 = 3^(27) = 7625597484987 and 3↑↑4 is roughly
	 * 10^(3.6383346400240996*10^12).
	 * 
	 * Find the last n digits of a↑↑b.
	 */
	@Override
	public void compute() throws EulerException {
		result = MathUtils.hyperExponential(a, b, n);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler188(1777, 1855, 8));
	}

}
