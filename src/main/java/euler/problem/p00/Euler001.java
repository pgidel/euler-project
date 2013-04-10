package euler.problem.p00;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler001 extends AbstractEuler {

	private long max;
	private long div1;
	private long div2;

	public Euler001(long max, long div1, long div2) {
		this.max = max;
		this.div1 = div1;
		this.div2 = div2;
	}

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
	 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * 
	 * Find the sum of all the multiples of div1 or div2 below max.
	 */
	@Override
	public void compute() {
		result = BigInteger.valueOf(EulerUtils.sumDivisibleBy(div1, max)
				+ EulerUtils.sumDivisibleBy(div2, max)
				- EulerUtils.sumDivisibleBy(div1 * div2, max));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler001(1000, 3, 5));
	}

}
