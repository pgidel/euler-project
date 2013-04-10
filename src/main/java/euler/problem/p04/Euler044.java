package euler.problem.p04;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler044 extends AbstractEuler {

	@Override
	public void compute() {
		boolean ok = false;

		long n1 = 1;
		do {
			long p1 = EulerUtils.getPentagonal(n1);
			for (long n2 = n1 - 1; n2 > 0; n2--) {
				long p2 = EulerUtils.getPentagonal(n2);
				if (EulerUtils.isPentagonal(p1 + p2)
						&& EulerUtils.isPentagonal(p1 - p2)) {
					result = BigInteger.valueOf(p1 - p2);
					ok = true;
					break;
				}
			}
			n1++;
		} while (!ok);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler044());
	}

}
