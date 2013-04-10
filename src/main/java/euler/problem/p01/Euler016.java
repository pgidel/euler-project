package euler.problem.p01;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;
import euler.util.MathUtils;

public class Euler016 extends AbstractEuler {

	private BigInteger n;

	public Euler016(BigInteger n) {
		this.n = n;
	}

	/**
	 * 2^(15) = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	 * 
	 * What is the sum of the digits of the number n?
	 */
	@Override
	public void compute() {
		result = BigInteger.valueOf(EulerUtils.sumDigits(n));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler016(BigInteger.valueOf(MathUtils.pow(2, 1000))));
	}

}
