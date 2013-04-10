package euler.problem.p07;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.math.algebra.Fraction;

public class Euler073 extends AbstractEuler {

	private long max;

	private static final long minDenominateur = 3;
	private static final long maxDenominateur = 2;

	public Euler073(long max) {
		this.max = max;
	}

	@Override
	public void compute() {
		result = BigInteger.ZERO;

		for (long denominator = 1; denominator <= max; denominator++) {
			for (long numerator = denominator / minDenominateur + 1; numerator < (denominator - 1)
					/ maxDenominateur + 1; numerator++) {
				Fraction fraction = new Fraction(numerator, denominator);
				if (fraction.equals(fraction.reduce())) {
					result = result.add(BigInteger.ONE);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler073(12000));
	}

}
