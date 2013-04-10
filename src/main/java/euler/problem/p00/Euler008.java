package euler.problem.p00;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler008 extends AbstractEuler {

	private final static String FILE = "src/main/resources/008.euler";

	private int max;

	public Euler008(int max) {
		this.max = max;
	}

	/**
	 * Find the greatest product of five consecutive digits in the max-digit
	 * number.
	 */
	@Override
	public void compute() throws EulerException {
		FileReader reader = null;

		try {
			File file = new File(FILE);
			if (file.length() == 0) {
				throw new EulerException(CodeError.EMPTY_FILE, FILE);
			}

			long maxMul = 0;

			char[] buffer = new char[max];
			long offset = 0;
			while (offset < file.length() - max) {
				reader = new FileReader(file);
				reader.skip(offset);
				while (reader.read(buffer) != -1) {
					long mul = 1;
					for (char c : buffer) {
						mul *= Character.getNumericValue(c);
					}
					maxMul = MathUtils.max(maxMul, mul);
				}
				offset++;
			}

			result = BigInteger.valueOf(maxMul);

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
		compute(new Euler008(5));
	}

}
