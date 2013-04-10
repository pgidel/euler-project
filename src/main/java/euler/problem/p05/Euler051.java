package euler.problem.p05;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler051 extends AbstractEuler {

	@Override
	public void compute() {
		BigInteger increment2 = BigInteger.valueOf(2);

		result = BigInteger.valueOf(11);
		while (true) {
			if (MathUtils.isPrime(result)) {
				String s = String.valueOf(result);
				for (char c : s.toCharArray()) {
					int cpt = 0;
					for (int i = 0; i <= 9; i++) {
						String test = s.replaceAll(c + "", String.valueOf(i));
						if (!test.startsWith("0")
								&& MathUtils.isPrime(Long.valueOf(test))) {
							cpt++;
							if (cpt == 8) {
								return;
							}
						}
					}
				}
			}
			result = result.add(increment2);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler051());
	}

}
