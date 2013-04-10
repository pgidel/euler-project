package euler.problem.p03;

import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler033 extends AbstractEuler {

	@Override
	public void compute() {
		long r = 1;

		for (double n = 0; n < 9; n++) {
			for (double d = n + 1; d <= 9; d++) {
				double t = n / d;
				for (double m = 1; m <= 9; m++) {
					double nm = n * 10 + m;
					double dm = d * 10 + m;
					double mn = m * 10 + n;
					double md = m * 10 + d;
					if (nm / dm == t || mn / dm == t || nm / md == t
							|| mn / md == t)
						r *= d / n;
				}
			}
		}

		result = BigInteger.valueOf(r);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler033());
	}

}
