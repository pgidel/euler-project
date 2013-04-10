package euler.problem.p06;

import java.math.BigInteger;
import java.util.Arrays;

import euler.problem.AbstractEuler;

public class Euler063 extends AbstractEuler {

	@Override
	public void compute() {
		double[] logs = new double[10];
		for (int n = 2; n < logs.length; n++) {
			logs[n] = Math.log10(n);
		}

		result = BigInteger.valueOf(9);
		for (double n = 2.0; n < 22.0; n++) {
			double limit = (n - 1.0) / n;
			long pos = Arrays.binarySearch(logs, limit);
			result = result.add(BigInteger.valueOf(pos > 0 ? 10 - pos
					: 11 + pos));
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler063());
	}

}
