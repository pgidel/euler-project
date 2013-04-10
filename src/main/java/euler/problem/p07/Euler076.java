package euler.problem.p07;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler076 extends AbstractEuler {

	private int n;
	private long[] coins;

	public Euler076(int n) {
		this.n = n;
		coins = new long[n - 1];
		for (int i = 0; i < n - 1; i++) {
			coins[i] = i;
		}
	}

	@Override
	public void compute() {
		result = EulerUtils.computeNbWays(n, coins);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler076(100));
	}

}
