package euler.problem.p02;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler028 extends AbstractEuler {

	private int n;

	public Euler028(int n) {
		this.n = n;
	}

	/**
	 * Starting with the number 1 and moving to the right in a clockwise
	 * direction a 5 by 5 spiral is formed as follows:
	 * 
	 * 21 22 23 24 25 20 7 8 9 10 19 6 1 2 11 18 5 4 3 12 17 16 15 14 13
	 * 
	 * It can be verified that the sum of both diagonals is 101.
	 * 
	 * What is the sum of both diagonals in a n by n spiral formed in the same
	 * way?
	 */
	@Override
	public void compute() {
		result = BigInteger.valueOf(EulerUtils.sumSpiralDiagonals(n));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler028(1001));
	}

}
