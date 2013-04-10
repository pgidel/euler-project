package euler.problem.p04;

import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler048 extends AbstractEuler {

	private long max;
	private int n;

	public Euler048(long max, int n) {
		this.max = max;
		this.n = n;
	}

	/**
	 * The series, 1^(1) + 2^(2) + 3^(3) + ... + 10^(10) = 10405071317.
	 * 
	 * Find the last n digits of the series, 1^(1) + 2^(2) + 3^(3) + ... +
	 * max^(max).
	 */
	@Override
	public void compute() {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= max; i++) {
			sum = sum.add(BigInteger.valueOf(i).pow(i));
			sum = sum.mod(BigInteger.TEN.pow(n));
		}
		result = sum;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler048(1000, 10));
	}

}
