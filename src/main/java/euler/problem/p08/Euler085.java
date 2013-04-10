package euler.problem.p08;

import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler085 extends AbstractEuler {

	private long max;

	public Euler085(long max) {
		this.max = max;
	}

	@Override
	public void compute() {
		long resultN = 0;
		long resultK = 0;
		double areaMin = max;

		long maxLength = (long) (-1 + Math.sqrt(1 + 4 * 2 * max)) / 2;

		for (long n = 1; n <= maxLength; n++) {
			for (long k = 1; k <= n; k++) {
				double area = Math.abs((1 / 4.0) * n * (n + 1) * k * (k + 1)
						- max);
				if (area < areaMin) {
					resultN = n;
					resultK = k;
					areaMin = area;
				}
			}
		}

		result = BigInteger.valueOf(resultN * resultK);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler085(2000000));
	}

}
