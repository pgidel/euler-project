package euler.problem.p05;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler058 extends AbstractEuler {

	private double p;

	public Euler058(double p) {
		this.p = p;
	}

	/**
	 * @param args
	 */
	@Override
	public void compute() {
		long r = 7;
		int nbPrimes = 8;
		do {
			r += 2;
			if (MathUtils.isPrime(r * r))
				nbPrimes++;
			if (MathUtils.isPrime(r * r - r + 1))
				nbPrimes++;
			if (MathUtils.isPrime(r * r - 2 * r + 2))
				nbPrimes++;
			if (MathUtils.isPrime(r * r - 3 * r + 3))
				nbPrimes++;
		} while (((double) nbPrimes / (2 * r - 1) >= p));

		result = BigInteger.valueOf(r);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler058(0.1));
	}

}
