package euler.problem.p02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler022 extends AbstractEuler {

	private final static String FILE = "src/test/resources/022.euler";
	private final static String DELIM = ",";

	/**
	 * Using a 46K text file containing over five-thousand first names, begin by
	 * sorting it into alphabetical order. Then working out the alphabetical
	 * value for each name, multiply this value by its alphabetical position in
	 * the list to obtain a name score.
	 * 
	 * For example, when the list is sorted into alphabetical order, COLIN,
	 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
	 * So, COLIN would obtain a score of 938 × 53 = 49714.
	 * 
	 * What is the total of all the name scores in the file?
	 */
	@Override
	public void compute() throws EulerException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));

			BigInteger totalScore = BigInteger.ZERO;

			String ligne = reader.readLine();
			if (ligne != null) {
				String[] tab = ligne.split(DELIM);
				SortedSet<String> list = new TreeSet<String>();
				for (String nom : tab) {
					list.add(nom.substring(1, nom.length() - 1));
				}
				int i = 1;
				for (String nom : list) {
					totalScore = totalScore.add(BigInteger.valueOf(i).multiply(
							BigInteger.valueOf(EulerUtils.getScore(nom))));
					i++;
				}
			}

			result = totalScore;

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
		compute(new Euler022());
	}

}
