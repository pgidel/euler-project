package euler.problem.p05;

import java.math.BigInteger;

import euler.exception.PrimeException;
import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler053 extends AbstractEuler {

	private long m;
	private long max;

	public Euler053(long m, long max) {
		this.m = m;
		this.max = max;
	}

	/**
	 * There are exactly ten ways of selecting three from five, 12345:
	 * 
	 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
	 * 
	 * In combinatorics, we use the notation, ^(5)C_(3) = 10.
	 * 
	 * In general, ^(n)C_(r) = n! / r!(n-r)! , where r <= n, n! = n×(n-1)×...×3×2×1, and 0! = 1.
	 * 
	 * It is not until n = 23, that a value exceeds one-million: ^(23)C_(10) = 1144066.
	 * 
	 * How many, not necessarily distinct, values of ^(n)C_(r), for 1 <= n <= n, are greater than max?
	 */
	@Override
	public void compute() throws PrimeException {
		long cpt = 0;
		for (long n = 0; n <= m; n++) {
			for (long r = 0; r <= n / 2; r++) {
				if (MathUtils.C(n, r).compareTo(BigInteger.valueOf(max)) > 0) {
					for (long k = r; k <= n / 2; k++) {
						if (k == n / 2.)
							cpt += 1;
						else
							cpt += 2;
					}
					break;
				}
			}
		}
		result = BigInteger.valueOf(cpt);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler053(100, 1000000));
	}

}
