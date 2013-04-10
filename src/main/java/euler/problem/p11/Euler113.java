package euler.problem.p11;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler113 extends AbstractEuler {

	private long max;

	public Euler113(int max) {
		this.max = max;
	}

	@Override
	public void compute() {

		BigInteger n1 = MathUtils.factorial(max + 10);
		BigInteger d1 = MathUtils.factorial(max).multiply(
				MathUtils.factorial(10));
		BigInteger c1 = n1.divide(d1).subtract(BigInteger.ONE);

		BigInteger n2 = MathUtils.factorial(max + 9);
		BigInteger d2 = MathUtils.factorial(max).multiply(
				MathUtils.factorial(9));
		BigInteger c2 = n2.divide(d2).subtract(BigInteger.ONE);

		BigInteger doublons = BigInteger.valueOf(max).multiply(BigInteger.TEN);

		result = c1.add(c2).subtract(doublons);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler113(100));
	}

}
