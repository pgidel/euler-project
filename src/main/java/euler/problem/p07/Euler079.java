package euler.problem.p07;

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
import euler.util.StringUtils;

public class Euler079 extends AbstractEuler {

	private final static String FILE = "079.euler";

	/**
	 * A common security method used for online banking is to ask the user for
	 * three random characters from a passcode. For example, if the passcode was
	 * 531278, they may asked for the 2nd, 3rd, and 5th characters; the expected
	 * reply would be: 317.
	 * 
	 * The text file contains fifty successful login attempts.
	 * 
	 * Given that the three characters are always asked for in order, analyse
	 * the file so as to determine the shortest possible secret passcode of
	 * unknown length.
	 */
	@Override
	public void compute() throws EulerException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));

			List<String> tries = new ArrayList<String>();

			String ligne;
			while ((ligne = reader.readLine()) != null) {
				tries.add(ligne);
			}

			result = new BigInteger(StringUtils.determinePasscode(tries));

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
		compute(new Euler079());
	}

}
