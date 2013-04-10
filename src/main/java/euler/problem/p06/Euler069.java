package euler.problem.p06;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler069 extends AbstractEuler {

	private long max;

	public Euler069(long max) {
		this.max = max;
	}

	public void compute() {
		long r = 1;

		long p = 2;
		do {
			if (MathUtils.isPrime(p)) {
				r *= p;
			}
			p++;
		} while (r <= max);
		result = BigInteger.valueOf(r / (p - 1));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler069(1000000));
	}

}
