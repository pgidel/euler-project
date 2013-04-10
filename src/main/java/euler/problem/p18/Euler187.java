package euler.problem.p18;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler187 extends AbstractEuler {

	private long max = 100000000;

	public Euler187(long max) {
		this.max = max;
	}

	@Override
	public void compute() {
		List<Long> primes = new ArrayList<Long>(MathUtils.getPrimes(max / 2));
		result = BigInteger.ZERO;
		// TODO Improve
		for (int i = 0; i < primes.size(); i++) {
			for (int j = i; j < primes.size(); j++) {
				if (primes.get(i) * primes.get(j) >= max)
					break;
				result = result.add(BigInteger.ONE);
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler187(100000000));
	}

}
