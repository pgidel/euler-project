package euler.problem.p09;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler092 extends AbstractEuler {

	private long max;

	private long stopValue;

	public Euler092(long max, long stopValue) {
		this.max = max;
		this.stopValue = stopValue;
	}

	@Override
	public void compute() {
		result = BigInteger.ZERO;

		for (long i = 1; i < max; i++) {
			Set<Long> stock = new HashSet<Long>();
			long squareSum = EulerUtils.sumPowDigits(i, 2);
			while (squareSum != stopValue && !stock.contains(squareSum)) {
				stock.add(squareSum);
				squareSum = EulerUtils.sumPowDigits(squareSum, 2);
			}
			if (squareSum == stopValue) {
				result = result.add(BigInteger.ONE);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler092(10000000, 89));
	}

}
