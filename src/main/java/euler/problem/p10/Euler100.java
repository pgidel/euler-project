package euler.problem.p10;

import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler100 extends AbstractEuler {

	@Override
	public void compute() {
		result = BigInteger.ONE;
		long n = 1;
		while (n < Math.pow(10, 12)) {
			long b = result.longValue();
			result = BigInteger.valueOf(3 * b + 2 * n - 2);
			n = 4 * b + 3 * n - 3;
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler100());
	}

}
