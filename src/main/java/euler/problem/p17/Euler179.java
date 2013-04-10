package euler.problem.p17;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler179 extends AbstractEuler {

	@Override
	public void compute() {
		result = BigInteger.ZERO;
		int tmp = 0;
		// TODO Improve
		for (int i = 1; i < 10000000; i++) {
			int nbDiv = EulerUtils.getNbDivisors(i);
			if (tmp == nbDiv)
				result = result.add(BigInteger.ONE);
			tmp = nbDiv;
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler179());
	}

}
