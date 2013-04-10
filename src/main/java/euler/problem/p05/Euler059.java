package euler.problem.p05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;

public class Euler059 extends AbstractEuler {

	private final static String FILE = "src/main/resources/059.euler";
	private final static String DELIM = ",";

	@Override
	public void compute() throws EulerException {
		char[] lowerCases = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };

		result = BigInteger.ZERO;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(FILE));
			String line = br.readLine();
			String[] strings = line.split(DELIM);
			char[] chars = new char[strings.length];
			for (int i = 0; i < strings.length; i++) {
				chars[i] = (char) Integer.parseInt(strings[i]);
			}

			char[] code = new char[3];
			boolean ok = false;
			for (char c1 : lowerCases) {
				for (char c2 : lowerCases) {
					for (char c3 : lowerCases) {
						for (int i = 1; i < chars.length - 3; i = i + 3) {
							String the = (char) (chars[i - 1] ^ c1) + ""
									+ (char) (chars[i] ^ c2) + ""
									+ (char) (chars[i + 1] ^ c3) + ""
									+ (char) (chars[i + 2] ^ c1) + ""
									+ (char) (chars[i + 3] ^ c2);
							if (" the ".equals(the)) {
								code = new char[] { c1, c2, c3 };
								ok = true;
								break;
							}
						}
						if (ok) {
							break;
						}
					}
					if (ok) {
						break;
					}
				}
				if (ok) {
					break;
				}
			}

			for (int i = 0; i < chars.length; i++) {
				result = result.add(BigInteger.valueOf(chars[i]
						^ code[i % code.length]));
			}

		} catch (FileNotFoundException e) {
			throw new EulerException(CodeError.FILE_NOT_FOUND, FILE);
		} catch (IOException e) {
			throw new EulerException(CodeError.ERROR_READING_FILE, FILE);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
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
		compute(new Euler059());
	}

}
