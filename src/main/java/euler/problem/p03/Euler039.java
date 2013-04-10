package euler.problem.p03;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler039 extends AbstractEuler {

	private long max;

	public Euler039(long max) {
		this.max = max;
	}

	/**
	 * If p is the perimeter of a right angle triangle with integral length
	 * sides, {a,b,c}, there are exactly three solutions for p = 120.
	 * {20,48,52}, {24,45,51}, {30,40,50}.
	 * 
	 * For which value of p <= n, is the number of solutions maximised?
	 */
	@Override
	public void compute() {
		int m = 0;
		for (int p = 3; p <= max; p++) {
			int cpt = 0;
			for (long i = 1; i < p - 2; i++) {
				for (long j = i + 1; j < p - i; j++) {
					long k = p - i - j;
					if (MathUtils.isPythagoreanTriplet(i, j, k)) {
						cpt++;
					}
				}
			}
			if (cpt > m) {
				m = cpt;
				result = BigInteger.valueOf(p);
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler039(1000));
	}

}
