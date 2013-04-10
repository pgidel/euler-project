package euler.problem.p03;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler038 extends AbstractEuler {

	@Override
	public void compute() {
		result = BigInteger.ZERO;

		for (long i = 1; i < 9999; i++) {
			String concatenation = String.valueOf(i);
			long newC = i;
			long c;
			long multiplier = 2;
			do {
				c = newC;
				concatenation += i * multiplier;
				newC = Long.valueOf(concatenation);
				multiplier++;
			} while (newC <= 9876543210L);
			if (EulerUtils.isPandigital(c, false)
					&& BigInteger.valueOf(c).compareTo(result) > 0)
				result = BigInteger.valueOf(c);
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler038());
	}

}
