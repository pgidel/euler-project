package euler.problem.p04;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler046 extends AbstractEuler {

	@Override
	public void compute() {
		BigInteger increment2 = BigInteger.valueOf(2);

		result = BigInteger.valueOf(9);
		while (true) {
			boolean stop = false;
			if (!MathUtils.isPrime(result)) {
				for (long i = 2; i <= result.longValue() - 2; i++) {
					if (MathUtils.isPrime(i)) {
						double x = Math.sqrt((result.longValue() - i) / 2);
						if (x == (long) x) {
							stop = true;
							break;
						}
					}
				}
				if (!stop) {
					return;
				}
			}
			result = result.add(increment2);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler046());
	}

}
