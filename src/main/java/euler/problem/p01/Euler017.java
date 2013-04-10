package euler.problem.p01;

import java.math.BigInteger;

import euler.exception.AlphabeticException;
import euler.problem.AbstractEuler;
import euler.util.StringUtils;

public class Euler017 extends AbstractEuler {

	private long n;

	public Euler017(long n) {
		this.n = n;
	}

	/**
	 * If the numbers 1 to 5 are written out in words: one, two, three, four,
	 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
	 * 
	 * If all the numbers from 1 to n inclusive were written out in words, how
	 * many letters would be used?
	 */
	@Override
	public void compute() throws AlphabeticException {
		int sum = 0;
		for (BigInteger i = BigInteger.valueOf(1); i.compareTo(BigInteger
				.valueOf(n)) <= 0; i = i.add(BigInteger.ONE)) {
			sum += StringUtils.toAlphabetic(i).replaceAll("\\W", "").length();
		}
		result = BigInteger.valueOf(sum);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler017(1000));
	}

}
