package euler.problem.p06;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler065 extends AbstractEuler {

	private long max;

	public Euler065(long max) {
		this.max = max;
	}

	@Override
	public void compute() {
		BigInteger d = BigInteger.ONE;
		BigInteger n = BigInteger.valueOf(2);

		for (long i = 2; i <= max; i++) {
			BigInteger temp = d;
			long c = 1;
			if (i % 3 == 0) {
				c = 2 * (i / 3);
			}
			d = n;
			n = d.multiply(BigInteger.valueOf(c)).add(temp);
		}

		result = BigInteger.valueOf(EulerUtils.sumDigits(n));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler065(100));
	}

}
