package euler.problem.p04;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;
import euler.util.MathUtils;

public class Euler041 extends AbstractEuler {

	/**
	 * We shall say that an n-digit number is pandigital if it makes use of all
	 * the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital
	 * and is also prime.
	 * 
	 * What is the largest n-digit pandigital prime that exists?
	 */
	@Override
	public void compute() {
		// 1+2+3+4+5+6+7+8+9=45 => always dividable by 3
		// 1+2+3+4+5+6+7+8=36 => always dividable by 3
		for (int n = 7; n >= 1; n--) {
			for (int i : EulerUtils.generatePandigitalNumbers(n)) {
				if (MathUtils.isPrime(i)) {
					result = BigInteger.valueOf(i);
					return;
				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler041());
	}

}
