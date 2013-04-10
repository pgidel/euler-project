package euler.problem.p07;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler074 extends AbstractEuler {

	private long max;
	private long maxLength;

	public Euler074(int max, int maxLength) {
		this.max = max;
		this.maxLength = maxLength;
	}

	@Override
	public void compute() {
		result = BigInteger.ZERO;

		long n = 1;
		do {
			Set<Long> map = new HashSet<Long>();
			map.add(n);

			long f = n;
			long fs = factorialSum(f);
			while (fs != f && map.size() < maxLength) {
				if (!map.contains(fs)) {
					map.add(fs);
				} else {
					break;
				}
				f = fs;
				fs = factorialSum(f);
			}

			if (!map.contains(fs)) {
				map.add(fs);
			}

			if (fs != f && map.size() == maxLength) {
				result = result.add(BigInteger.ONE);
			}

			n++;
		} while (n < max);
	}

	private static long factorialSum(long n) {
		long f = 0;
		while (n > 0) {
			f += MathUtils.factorial(n % 10).longValue();
			n /= 10;
		}
		return f;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler074(1000000, 60));
	}

}
