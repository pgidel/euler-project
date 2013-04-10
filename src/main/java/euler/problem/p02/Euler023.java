package euler.problem.p02;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler023 extends AbstractEuler {

	/**
	 * A perfect number is a number for which the sum of its proper divisors is
	 * exactly equal to the number. For example, the sum of the proper divisors
	 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
	 * number.
	 * 
	 * A number whose proper divisors are less than the number is called
	 * deficient and a number whose proper divisors exceed the number is called
	 * abundant.
	 * 
	 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
	 * smallest number that can be written as the sum of two abundant numbers is
	 * 24. By mathematical analysis, it can be shown that all integers greater
	 * than 28123 can be written as the sum of two abundant numbers. However,
	 * this upper limit cannot be reduced any further by analysis even though it
	 * is known that the greatest number that cannot be expressed as the sum of
	 * two abundant numbers is less than this limit.
	 * 
	 * Find the sum of all the positive integers which cannot be written as the
	 * sum of two abundant numbers. 28123
	 */
	@Override
	public void compute() {
		int max = 28123;
		Set<Integer> toSums = new HashSet<Integer>();
		List<Integer> abundants = new ArrayList<Integer>();
		for (int i = 1; i <= max; i++) {
			toSums.add(i);
			if (EulerUtils.isAbundant(i)) {
				abundants.add(i);
			}
		}

		for (int i = 0; i < abundants.size(); i++) {
			for (int j = i; j < abundants.size(); j++) {
				toSums.remove(abundants.get(i) + abundants.get(j));
			}
		}

		long sum = 0;
		for (int s : toSums) {
			sum += s;
		}
		result = BigInteger.valueOf(sum);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler023());
	}

}
