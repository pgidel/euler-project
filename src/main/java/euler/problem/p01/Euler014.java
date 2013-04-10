package euler.problem.p01;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler014 extends AbstractEuler {

	private long max;

	public Euler014(long max) {
		this.max = max;
	}

	/**
	 * The following iterative sequence is defined for the set of positive
	 * integers:
	 * 
	 * n -> n/2 (n is even) n -> 3n + 1 (n is odd)
	 * 
	 * Using the rule above and starting with 13, we generate the following
	 * sequence: 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
	 * 
	 * It can be seen that this sequence (starting at 13 and finishing at 1)
	 * contains 10 terms. Although it has not been proved yet (Collatz Problem),
	 * it is thought that all starting numbers finish at 1.
	 * 
	 * Which starting number, under max, produces the longest chain?
	 */
	@Override
	public void compute() {
		long size = 0;
		long number = 0;
		for (long i = 1; i < max; i++) {
			long tmp = i;
			long cpt = 1;
			while (tmp != 1) {
				cpt++;
				if (MathUtils.isDivider(tmp, 2)) {
					tmp /= 2;
				} else {
					tmp = 3 * tmp + 1;
				}
			}
			if (cpt > size) {
				size = cpt;
				number = i;
			}
		}
		result = BigInteger.valueOf(number);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler014(1000000));
	}

}
