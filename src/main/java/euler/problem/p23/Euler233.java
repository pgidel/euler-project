package euler.problem.p23;

import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler233 extends AbstractEuler {

	private long n;

	public Euler233(int n) {
		this.n = n;
	}

	@Override
	public void compute() {
		result = BigInteger.ZERO;
		for (long i = 1; i <= n; i++) {
			if (i % 100000 == 0) {
				System.out.println(i);
			}
			if (f(i) == 420) {
				result = result.add(BigInteger.ONE);
			}
		}
		// System.out.println(f(10000)); // = 36
		// System.out.println(f(1328125)); // = 180
		// System.out.println(f(359125)); // = 420
		// System.out.println(f(84246500)); // = 420
		// System.out.println(f(248431625)); // = 420
	}

	// TODO Improve
	private static long f(long n) {
		long f = 4;

		double min = n / 2 * (1 - Math.sqrt(2));
		long floor = (long) Math.floor(min);

		if (n != 1 && floor == min) {
			f += 4;
		}

		for (long i = floor + 1; i <= -1; i++) {
			double delta = n * n - 4 * i * (i - n);
			double x = (n - Math.sqrt(delta)) / 2;
			if (x == Math.round(x)) {
				f += 8;
			}
		}

		return f;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// private static final long n = 100000000000l;
		compute(new Euler233(38000000)); // 30875234922
	}

}
