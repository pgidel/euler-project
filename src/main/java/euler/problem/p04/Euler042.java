package euler.problem.p04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;
import euler.util.EulerUtils;
import euler.util.StringUtils;

public class Euler042 extends AbstractEuler {

	private final static String FILE = "src/main/resources/042.euler";
	private final static String DELIM = ",";

	/**
	 * The n^(th) term of the sequence of triangle numbers is given by, t_(n) =
	 * 1/2n(n+1); so the first ten triangle numbers are:
	 * 
	 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	 * 
	 * By converting each letter in a word to a number corresponding to its
	 * alphabetical position and adding these values we form a word value. For
	 * example, the word value for SKY is 19 + 11 + 25 = 55 = t_(10). If the
	 * word value is a triangle number then we shall call the word a triangle
	 * word.
	 * 
	 * Using a 16K text file containing nearly two-thousand common English
	 * words, how many are triangle words?
	 */
	@Override
	public void compute() throws EulerException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));

			int cpt = 0;

			String ligne = reader.readLine();
			if (ligne != null) {
				String[] tab = ligne.split(DELIM);
				for (String nom : tab) {
					nom = nom.substring(1, nom.length() - 1);
					if (EulerUtils.isTriangle(StringUtils
							.cipherAlphabeticaly(nom))) {
						cpt++;
					}
				}
			}

			result = BigInteger.valueOf(cpt);

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
		compute(new Euler042());
	}

}
