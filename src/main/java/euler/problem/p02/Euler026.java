package euler.problem.p02;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler026 extends AbstractEuler {

	private long n;

	public Euler026(long n) {
		this.n = n;
	}

	/**
	 * A unit fraction contains 1 in the numerator. The decimal representation
	 * of the unit fractions with denominators 2 to 10 are given:
	 * 
	 * ^(1)/_(2) = 0.5 ^(1)/_(3) = 0.(3) ^(1)/_(4) = 0.25 ^(1)/_(5) = 0.2
	 * ^(1)/_(6) = 0.1(6) ^(1)/_(7) = 0.(142857) ^(1)/_(8) = 0.125 ^(1)/_(9) =
	 * 0.(1) ^(1)/_(10) = 0.1
	 * 
	 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can
	 * be seen that ^(1)/_(7) has a 6-digit recurring cycle.
	 * 
	 * Find the value of d < 1000 for which ^(1)/_(d) contains the longest
	 * recurring cycle in its decimal fraction part.
	 */
	@Override
	public void compute() {
		long r = 0;
		int max = 0;
		for (long i = 1; i < n; i++) {
			int l = EulerUtils.getRecurringCycleLength(i);
			if (l > max) {
				max = l;
				r = i;
			}
		}
		result = BigInteger.valueOf(r);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler026(1000));
	}

}
