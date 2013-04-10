package euler.problem.p03;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.StringUtils;

public class Euler036 extends AbstractEuler {

	private long max;

	public Euler036(long max) {
		this.max = max;
	}

	/**
	 * The decimal number, 585 = 1001001001_(2) (binary), is palindromic in both
	 * bases.
	 * 
	 * Find the sum of all numbers, less than max, which are palindromic in base
	 * 10 and base 2.
	 */
	@Override
	public void compute() {
		int sum = 0;
		for (long i = 1; i < max; i += 2) {
			if (StringUtils.isPalindromic(String.valueOf(i))
					&& StringUtils.isPalindromic(Long.toBinaryString(i))) {
				sum += i;
			}
		}
		result = BigInteger.valueOf(sum);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler036(1000000));
	}

}
