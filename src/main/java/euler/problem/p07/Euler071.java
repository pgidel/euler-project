package euler.problem.p07;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.math.algebra.Fraction;

public class Euler071 extends AbstractEuler {

	private long max;

	private static final Fraction maxFraction = new Fraction(3, 7);

	public Euler071(long max) {
		this.max = max;
	}

	@Override
	public void compute() {
		Fraction fractionResult = new Fraction(0, 1);

		Fraction fraction = new Fraction(1, 1);
		for (long denominator = 1; denominator <= max; denominator++) {
			for (long numerator = fraction.numerator; numerator < denominator; numerator++) {
				fraction = new Fraction(numerator, denominator);
				if (fraction.compareTo(maxFraction) >= 0) {
					break;
				}
				if (fraction.compareTo(fractionResult) > 0) {
					fractionResult = fraction;
				}
			}
		}

		result = BigInteger.valueOf(fractionResult.numerator);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler071(1000000));
	}

}
