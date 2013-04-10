package euler.problem.p04;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler047 extends AbstractEuler {

	@Override
	public void compute() {
		int n = 4;
		short cpt = 0;
		int i = 2 * 3 * 5 * 7;
		while (true) {
			if (MathUtils.getDistinctPrimeDecomposition(i).size() == n) {
				cpt++;
				if (cpt == n) {
					result = BigInteger.valueOf(i - (n - 1));
					break;
				}
			} else {
				cpt = 0;
			}
			i++;
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler047());
	}

}
