package euler.problem.p02;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler020 extends AbstractEuler {

	private long n;

	public Euler020(long n) {
		this.n = n;
	}

	/**
	 * n! means n × (n - 1) × ... × 3 × 2 × 1
	 * 
	 * Find the sum of the digits in the number n.
	 */
	@Override
	public void compute() {
		BigInteger mul = BigInteger.ONE;
		for (long i = 2; i <= n; i++) {
			mul = mul.multiply(new BigInteger(String.valueOf(i)));
		}
		result = BigInteger.valueOf(EulerUtils.sumDigits(mul));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler020(100));
	}

}
