package euler.problem.p06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler067 extends AbstractEuler {

	private final static String FILE = "src/test/resources/067.euler";
	private final static String DELIM = " ";

	/**
	 * By starting at the top of the triangle below and moving to adjacent
	 * numbers on the row below, the maximum total from top to bottom is 23.
	 * 
	 * 3 7 5 2 4 6 8 5 9 3
	 * 
	 * That is, 3 + 7 + 4 + 9 = 23.
	 * 
	 * Find the maximum total from top to bottom in a 15K text file containing a
	 * triangle with one-hundred rows.
	 */
	@Override
	public void compute() throws EulerException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));

			List<Long> triangle = new ArrayList<Long>();
			List<Boolean> triangleCheck = new ArrayList<Boolean>();

			String ligne;
			while ((ligne = reader.readLine()) != null) {
				String[] tab = ligne.split(DELIM);
				for (String n : tab) {
					triangle.add(Long.parseLong(n));
					triangleCheck.add(false);
				}
			}

			result = BigInteger.valueOf(EulerUtils.maxTriangleSum(triangle,
					triangleCheck, 1, 0, 0));

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
		compute(new Euler067());
	}

}
