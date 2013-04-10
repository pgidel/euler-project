package euler.problem.p20;

import java.math.BigInteger;
import java.util.regex.Pattern;

import euler.problem.AbstractEuler;

public class Euler206 extends AbstractEuler {

	private static final String patternString = "1.2.3.4.5.6.7.8.9.0";

	private static final Pattern pattern = Pattern.compile(patternString);

	private static final long min = (long) Math.sqrt(Long.valueOf(patternString
			.replaceAll("\\.", "0")));
	private static final long max = (long) Math.sqrt(Long.valueOf(patternString
			.replaceAll("\\.", "9")));

	@Override
	public void compute() {
		for (long i = min; i < max; i += 10) {
			if (pattern.matcher(String.valueOf(i * i)).matches()) {
				result = BigInteger.valueOf(i);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler206());
	}

}
