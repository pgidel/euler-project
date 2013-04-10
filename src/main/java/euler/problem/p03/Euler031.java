package euler.problem.p03;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler031 extends AbstractEuler {

	private long n;
	private long[] coins = new long[] { 1, 2, 5, 10, 20, 50, 100, 200 };

	public Euler031(long n) {
		this.n = n;
	}

	/**
	 * In England the currency is made up of pound, £, and pence, p, and there
	 * are eight coins in general circulation:
	 * 
	 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
	 * 
	 * It is possible to make £2 in the following way:
	 * 
	 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
	 * 
	 * How many different ways can £2 be made using any number of coins?
	 */
	@Override
	public void compute() {
		result = EulerUtils.computeNbWays(n, coins);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler031(20));
		compute(new Euler031(50));
		compute(new Euler031(100));
		compute(new Euler031(200));
	}

}
