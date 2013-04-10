package euler.problem.p05;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import euler.exception.PrimeException;
import euler.problem.AbstractEuler;
import euler.util.StringUtils;

public class Euler052 extends AbstractEuler {

	private long max;

	public Euler052(long max) {
		this.max = max;
	}

	/**
	 * It can be seen that the number, 125874, and its double, 251748, contain
	 * exactly the same digits, but in a different order.
	 * 
	 * Find the smallest positive integer, x, such that 2x, 3x, ..., maxX
	 * contain the same digits.
	 */
	@Override
	public void compute() throws PrimeException {
		Set<BigInteger> codes;
		boolean ok;
		int i = 2;
		do {
			i++;
			ok = true;
			codes = new HashSet<BigInteger>();
			for (long j = 1; j <= max; j++) {
				codes.add(StringUtils.cipherUnically(String.valueOf(i * j)));
				if (codes.size() > 1) {
					ok = false;
					break;
				}
			}
		} while (!ok);
		result = BigInteger.valueOf(i);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler052(6));
	}

}
