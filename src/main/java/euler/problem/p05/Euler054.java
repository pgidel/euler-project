package euler.problem.p05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.problem.AbstractEuler;
import euler.util.poker.Hand;

public class Euler054 extends AbstractEuler {

	private static final String FILE = "src/main/resources/P054.txt";

	@Override
	public void compute() throws EulerException {
		result = BigInteger.ZERO;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split(" ");
				Hand hand1 = new Hand(split[0], split[1], split[2], split[3],
						split[4]);
				Hand hand2 = new Hand(split[5], split[6], split[7], split[8],
						split[9]);
				if (hand1.compareTo(hand2) > 0) {
					result = result.add(BigInteger.ONE);
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
		compute(new Euler054());
	}

}
