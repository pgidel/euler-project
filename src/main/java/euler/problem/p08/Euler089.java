package euler.problem.p08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler089 extends AbstractEuler {

	private static final String FILE = "src/main/resources/P089.txt";

	@Override
	public void compute() throws EulerException {
		result = BigInteger.ZERO;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));
			String line;
			while ((line = reader.readLine()) != null) {
				long arabicNumber = EulerUtils.translateRomanToArabic(line);
				String romanNumber = EulerUtils
						.translateArabicToRoman(arabicNumber);
				result = result.add(BigInteger.valueOf(line.length()
						- romanNumber.length()));
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
		compute(new Euler089());
	}

}
