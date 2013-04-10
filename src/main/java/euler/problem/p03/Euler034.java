package euler.problem.p03;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler034 extends AbstractEuler {

	/**
	 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
	 * 
	 * Find the sum of all numbers which are equal to the sum of the factorial
	 * of their digits.
	 */
	@Override
	public void compute() {
		long sum = 0;
		for (long i = 10; i < 50000; i++) {
			if (EulerUtils.sumDigitFactorials(i) == i) {
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
		compute(new Euler034());
	}

}
