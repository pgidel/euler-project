package euler.problem.p00;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;
import euler.util.StringUtils;

public class Euler004 extends AbstractEuler {

	private long n;

	public Euler004(long n) {
		this.n = n;
	}

	/**
	 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit
	 * numbers is 9009 = 91 × 99.
	 * 
	 * Find the largest palindrome made from the product of two n-digit numbers.
	 */
	@Override
	public void compute() {
		long min = MathUtils.pow(10, n - 1);
		long max = MathUtils.pow(10, n) - 1;
		long palindrome = 0;
		for (long i = max; i >= min; i--) {
			for (long j = i; j >= min; j--) {
				long p = i * j;
				if (p > palindrome && StringUtils.isPalindromic(String.valueOf(p))) {
					palindrome = p;
				}
			}
		}
		result = BigInteger.valueOf(palindrome);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler004(3));
	}

}
