package euler.problem.p11;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler112 extends AbstractEuler {

	private double percentage;

	public Euler112(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public void compute() {
		BigInteger result = BigInteger.valueOf(100);
		long nbBouncing = 0;
		do {
			if (!EulerUtils.isIncreasing(result)
					&& !EulerUtils.isDecreasing(result)) {
				nbBouncing++;
			}
			result = result.add(BigInteger.ONE);
		} while (((double) nbBouncing) / (result.longValue() - 1) != percentage);

		result = result.subtract(BigInteger.ONE);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler112(0.99));
	}

}
