package euler.problem.p03;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler037 extends AbstractEuler {

	/**
	 * The number 3797 has an interesting property. Being prime itself, it is
	 * possible to continuously remove digits from left to right, and remain
	 * prime at each stage: 3797, 797, 97, and 7. Similarly we can work from
	 * right to left: 3797, 379, 37, and 3.
	 * 
	 * Find the sum of the only eleven primes that are both truncatable from
	 * left to right and right to left.
	 */
	@Override
	public void compute() {
		int sum = 0;
		long i = 0;
		int cpt = 0;
		while (cpt < 11) {
			if (EulerUtils.isTruncatablePrime(i)) {
				sum += i;
				cpt++;
			}
			i++;
		}
		result = BigInteger.valueOf(sum);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler037());
	}

}
