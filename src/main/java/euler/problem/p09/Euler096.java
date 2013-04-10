package euler.problem.p09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.SudokuUtils;

public class Euler096 extends AbstractEuler {

	private final static String FILE = "src/main/resources/096.euler";

	@Override
	public void compute() {
		result = BigInteger.ZERO;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(FILE)));
			while (reader.readLine() != null) {
				short[][] matrix = SudokuUtils.solve(reader);
				result = result.add(BigInteger.valueOf(100 * matrix[0][0] + 10
						* matrix[0][1] + matrix[0][2]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler096());
	}

}
