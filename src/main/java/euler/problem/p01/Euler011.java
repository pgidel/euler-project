package euler.problem.p01;

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
import euler.util.MathUtils;

public class Euler011 extends AbstractEuler {

	private final static String FILE = "src/test/resources/011.euler";
	private final static String DELIM = " ";

	private int n;

	public Euler011(int n) {
		this.n = n;
	}

	/**
	 * What is the greatest product of four adjacent numbers in any direction
	 * (up, down, left, right, or diagonally) in the n^n grid?
	 */
	@Override
	public void compute() throws EulerException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));

			List<List<Long>> t = new ArrayList<List<Long>>();

			String ligne;
			while ((ligne = reader.readLine()) != null) {
				String[] s = ligne.split(DELIM);
				List<Long> l = new ArrayList<Long>();
				for (int j = 0; j < s.length; j++) {
					l.add(Long.parseLong(s[j]));
				}
				t.add(l);
			}

			int iMax = t.size();
			int jMax = t.get(0).size();

			long product = 0;
			for (int i = 0; i < iMax; i++) {
				for (int j = 0; j < jMax; j++) {
					if (i <= (iMax - n) && j <= (jMax - n)) {
						long p1 = t.get(i).get(j);
						long p2 = t.get(i).get(j);
						long p3 = t.get(i).get(j);
						for (int k = 1; k < n; k++) {
							p1 *= t.get(i).get(j + k);
							p2 *= t.get(i + k).get(j);
							p3 *= t.get(i + k).get(j + k);
						}
						product = MathUtils.max(product, p1);
						product = MathUtils.max(product, p2);
						product = MathUtils.max(product, p3);
					} else if (i <= (iMax - n)) {
						long p = t.get(i).get(j);
						for (int k = 1; k < n; k++) {
							p *= t.get(i + k).get(j);
						}
						product = MathUtils.max(product, p);
					} else if (j <= (jMax - n)) {
						long p = t.get(i).get(j);
						for (int k = 1; k < n; k++) {
							p *= t.get(i).get(j + k);
						}
						product = MathUtils.max(product, p);
					}
					if (i > n && j < jMax - n) {
						long p = t.get(i).get(j);
						for (int k = 1; k < n; k++) {
							p *= t.get(i - k).get(j + k);
						}
						product = MathUtils.max(product, p);
					}
				}
			}

			result = BigInteger.valueOf(product);

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
		compute(new Euler011(4));
	}

}
