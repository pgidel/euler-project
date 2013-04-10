package euler.problem.p00;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;
import euler.util.MathUtils;

public class Euler005 extends AbstractEuler {

	private long n;

	public Euler005(long n) {
		this.n = n;
	}

	/**
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder.
	 * 
	 * What is the smallest number that is evenly divisible by all of the
	 * numbers from 1 to n?
	 */
	@Override
	public void compute() {
		long product = 1;
		List<Long> primes = EulerUtils.getPrimes(n);
		List<Long> exps = new ArrayList<Long>();
		boolean check = true;
		long limit = MathUtils.sqrt(n);
		int i = 0;
		while (i < primes.size() && primes.get(i) < n) {
			exps.add(i, 1L);
			if (check) {
				if (primes.get(i) <= limit) {
					exps.add(i, MathUtils.floor(Math.log(n)
							/ Math.log(primes.get(i))));
				} else {
					check = false;
				}
			}
			product *= Math.pow(primes.get(i), exps.get(i));
			i++;
		}
		result = BigInteger.valueOf(product);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler005(20));
	}

}
