package euler.problem.p03;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler032 extends AbstractEuler {

	private int n;

	public Euler032(int n) {
		this.n = n;
	}

	/**
	 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for
	 * example, the 5-digit number, 15234, is 1 through 5 pandigital.
	 * 
	 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product
	 * is 1 through 9 pandigital.
	 * 
	 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9
	 * pandigital.
	 * 
	 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
	 */
	@Override
	public void compute() {
		Set<Integer> products = new HashSet<Integer>();
		List<Integer> pandigitals = EulerUtils.generatePandigitalNumbers(n);
		for (Integer p : pandigitals) {
			String s = p.toString();
			for (int i = 1; i < s.length() / 2; i++) {
				for (int j = i + 1; j < s.length() / 2 + 2; j++) {
					Integer multiplicand = Integer.valueOf(s.substring(0, i));
					Integer multiplier = Integer.valueOf(s.substring(i, j));
					Integer product = Integer.valueOf(s.substring(j, s.length()));
					if (multiplicand * multiplier == product) {
						products.add(product);
					}
				}
			}
		}
		long sum = 0;
		for (Integer p : products) {
			sum += p;
		}
		result = BigInteger.valueOf(sum);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler032(9));
	}

}
