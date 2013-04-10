package euler.problem.p00;

import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler006 extends AbstractEuler {

	private long n;

	public Euler006(long n) {
		this.n = n;
	}

	/**
	 * The sum of the squares of the first ten natural numbers is, 1^(2) + 2^(2)
	 * + ... + 10^(2) = 385
	 * 
	 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... +
	 * 10)^(2) = 55^(2) = 3025
	 * 
	 * Hence the difference between the sum of the squares of the first ten
	 * natural numbers and the square of the sum is 3025 - 385 = 2640.
	 * 
	 * Find the difference between the sum of the squares of the first n natural
	 * numbers and the square of the sum.
	 */
	@Override
	public void compute() {
		long sumSquare = 0;
		long squareSum = 0;
		for (int i = 0; i <= n; i++) {
			sumSquare += i;
			squareSum += i * i;
		}
		result = BigInteger.valueOf(sumSquare * sumSquare - squareSum);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler006(100));
	}

}
