package euler.problem.p05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler050 extends AbstractEuler {

	private long max;

	public Euler050(long max) {
		this.max = max;
	}

	@Override
	public void compute() {
		List<Long> primes = new ArrayList<Long>(MathUtils.getPrimes(max));
		long max = 0;
		// TODO Improve
		for (int i = 0; i < primes.size(); i++) {
			long prime = primes.get(i);
			for (int j = 0; j < i; j++) {
				long tmp = prime;
				int k = 0;
				do {
					tmp -= primes.get(j + k);
					k++;
				} while (tmp > 0);
				if (tmp == 0 && k > max) {
					result = BigInteger.valueOf(prime);
					max = k;
				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler050(1000000));
	}

}
