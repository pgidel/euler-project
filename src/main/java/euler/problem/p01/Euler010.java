package euler.problem.p01;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler010 extends AbstractEuler {

	private long max;

	public Euler010(long max) {
		this.max = max;
	}

	/**
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * 
	 * Find the sum of all the primes below max.
	 */
	@Override
	public void compute() {
		// XXX Crible d'Eratosthenes
		long sum = 5;
		for (long i = 5; i < max; i += 2) {
			if (MathUtils.isPrime(i)) {
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
		compute(new Euler010(2000000));
	}

}
