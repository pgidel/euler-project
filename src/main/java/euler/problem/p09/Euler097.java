package euler.problem.p09;

import java.math.BigInteger;

import euler.exception.EulerException;
import euler.problem.AbstractEuler;

public class Euler097 extends AbstractEuler {

	private int n;

	public Euler097(int n) {
		this.n = n;
	}

	/**
	 * The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the
	 * form 2^(6972593)-1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form
	 * 2^(p)-1, have been found which contain more digits.
	 * 
	 * However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits:
	 * 28433×2^(7830457)+1.
	 * 
	 * Find the last n digits of this prime number.
	 */
	@Override
	public void compute() throws EulerException {
		BigInteger p = BigInteger.valueOf(2).modPow(BigInteger.valueOf(7830457), BigInteger.TEN.pow(n));
		BigInteger prime = BigInteger.valueOf(28433).multiply(p).add(BigInteger.ONE);
		result = prime.mod(BigInteger.TEN.pow(n));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler097(10));
	}

}
