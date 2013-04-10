package euler.problem.p03;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler035 extends AbstractEuler {

	private long max;

	public Euler035(long max) {
		this.max = max;
	}

	/**
	 * The number, 197, is called a circular prime because all rotations of the
	 * digits: 197, 971, and 719, are themselves prime.
	 * 
	 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37,
	 * 71, 73, 79, and 97.
	 * 
	 * How many circular primes are there below max?
	 */
	@Override
	public void compute() {
		int n = 3;
		for (long i = 7; i < max; i += 2) {
			if (EulerUtils.isCircularPrime(i)) {
				n++;
			}
		}
		result = BigInteger.valueOf(n);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler035(1000000));
	}

}
