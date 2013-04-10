package euler.problem.p01;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler015 extends AbstractEuler {

	private long n;

	public Euler015(long n) {
		this.n = n;
	}

	/**
	 * Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right
	 * corner.
	 * 
	 * How many routes are there through a n×n grid?
	 */
	@Override
	public void compute() {
		result = MathUtils.factorial(2 * n).divide(MathUtils.factorial(n).pow(2));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler015(20));
	}

}
