package euler.problem.p09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;

public class Euler099 extends AbstractEuler {

	private static final String FILE = "src/main/resources/P099.txt";

	@Override
	public void compute() throws EulerException {
		result = BigInteger.ZERO;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));
			String line;
			BigDecimal maximum = BigDecimal.ZERO;
			long lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				String[] baseExponent = line.split(",");
				BigDecimal base = new BigDecimal(baseExponent[0]);
				BigDecimal exponent = new BigDecimal(baseExponent[1]);
				BigDecimal test = exponent.multiply(BigDecimal.valueOf(Math
						.log(base.doubleValue())));
				if (test.compareTo(maximum) > 0) {
					maximum = test;
					result = BigInteger.valueOf(lineNumber);
				}
			}
		} catch (FileNotFoundException e) {
			result = null;
			throw new EulerException(CodeError.FILE_NOT_FOUND, FILE);
		} catch (IOException e) {
			result = null;
			throw new EulerException(CodeError.ERROR_READING_FILE, FILE);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					result = null;
					throw new EulerException(CodeError.ERROR_CLOSING_FILE, FILE);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler099());
	}

}
