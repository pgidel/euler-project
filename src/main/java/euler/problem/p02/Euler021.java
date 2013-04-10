package euler.problem.p02;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler021 extends AbstractEuler {

	private long max;

	public Euler021(long max) {
		this.max = max;
	}

	/**
	 * Let d(n) be defined as the sum of proper divisors of n (numbers less than
	 * n which divide evenly into n). If d(a) = b and d(b) = a, where a != b,
	 * then a and b are an amicable pair and each of a and b are called amicable
	 * numbers.
	 * 
	 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22,
	 * 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1,
	 * 2, 4, 71 and 142; so d(284) = 220.
	 * 
	 * Evaluate the sum of all the amicable numbers under max.
	 */
	@Override
	public void compute() {
		long sum = 0;
		for (int a = 2; a < max; a++) {
			long b = EulerUtils.sumProperDivisorsOf(a);
			if (b > a) {
				if (a == EulerUtils.sumProperDivisorsOf(b)) {
					sum += a + b;
				}
			}
		}
		result = BigInteger.valueOf(sum);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler021(10000));
	}

}
