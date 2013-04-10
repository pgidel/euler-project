package euler.problem.p05;

import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler057 extends AbstractEuler {

	private long max;

	public Euler057(long max) {
		this.max = max;
	}

	@Override
	public void compute() {
		result = BigInteger.ZERO;

		BigInteger numerator = BigInteger.valueOf(3);
		BigInteger denominator = BigInteger.valueOf(2);

		for (long i = 2; i <= max; i++) {
			numerator = numerator.add(BigInteger.valueOf(2).multiply(
					denominator));
			denominator = numerator.subtract(denominator);
			if (numerator.toString().length() > denominator.toString().length()) {
				result = result.add(BigInteger.ONE);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler057(1000));
	}

}
