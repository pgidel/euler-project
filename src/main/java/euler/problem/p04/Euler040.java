package euler.problem.p04;

import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler040 extends AbstractEuler {

	private int[] index;

	public Euler040(int[] index) {
		this.index = index;
	}

	/**
	 * An irrational decimal fraction is created by concatenating the positive integers:
	 * 
	 * 0.123456789101112131415161718192021...
	 * 
	 * It can be seen that the 12^(th) digit of the fractional part is 1.
	 * 
	 * If d_(n) represents the n^(th) digit of the fractional part, find the value of the following expression.
	 * 
	 * d_(1) × d_(10) × d_(100) × d_(1000) × d_(10000) × d_(100000) × d_(1000000)
	 */
	@Override
	public void compute() {
		StringBuilder s = new StringBuilder("");
		int k = 1;
		do {
			s.append(k);
			k++;
		} while (s.length() <= 1000000);
		long mul = 1;
		for (Integer i : index) {
			mul *= Character.getNumericValue(s.charAt(i - 1));
		}
		result = BigInteger.valueOf(mul);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler040(new int[] { 1, 10, 100, 1000, 10000, 100000, 1000000 }));
	}

}
