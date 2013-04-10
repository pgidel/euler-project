package euler.problem.p01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;

public class Euler013 extends AbstractEuler {

	private final static String FILE = "src/test/resources/013.euler";

	/**
	 * Work out the first ten digits of the sum of the digit numbers from the
	 * file.
	 */
	@Override
	public void compute() throws EulerException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));

			BigInteger sum = BigInteger.ZERO;

			String n;
			while ((n = reader.readLine()) != null) {
				sum = sum.add(new BigInteger(n));
			}

			result = new BigInteger(sum.toString().substring(0, 10));

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
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler013());
	}

}
