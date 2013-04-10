package euler.problem.p00;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler007 extends AbstractEuler {

	private long n;

	public Euler007(long n) {
		this.n = n;
	}

	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
	 * see that the 6^(th) prime is 13.
	 * 
	 * What is the n^(st) prime number?
	 */
	@Override
	public void compute() {
		if (n == 1) {
			result = BigInteger.valueOf(2);
			return;
		}
		long prime = 1;
		long cpt = 1;
		do {
			prime += 2;
			if (MathUtils.isPrime(prime)) {
				cpt++;
			}
		} while (cpt < n);
		result = BigInteger.valueOf(prime);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler007(10001));
	}

}
