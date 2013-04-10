package euler.problem.p04;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;
import euler.util.StringUtils;

public class Euler043 extends AbstractEuler {

	@Override
	public void compute() {
		result = BigInteger.ZERO;

		for (String si : StringUtils.permute("0123456789")) {
			long d2 = Long.valueOf(si.substring(1, 4));
			long d3 = Long.valueOf(si.substring(2, 5));
			long d5 = Long.valueOf(si.substring(3, 6));
			long d7 = Long.valueOf(si.substring(4, 7));
			long d11 = Long.valueOf(si.substring(5, 8));
			long d13 = Long.valueOf(si.substring(6, 9));
			long d17 = Long.valueOf(si.substring(7, 10));
			if (MathUtils.divide(d2, 2) && MathUtils.divide(d3, 3)
					&& MathUtils.divide(d5, 5) && MathUtils.divide(d7, 7)
					&& MathUtils.divide(d11, 11) && MathUtils.divide(d13, 13)
					&& MathUtils.divide(d17, 17))
				result = result.add(new BigInteger(si));
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler043());
	}

}
