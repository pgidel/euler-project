package euler.problem.p08;

import java.math.BigInteger;

import euler.exception.EulerException;
import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler082 extends AbstractEuler {

	private static final String FILE = "src/main/resources/P082.txt";

	@Override
	public void compute() throws EulerException {
		BigInteger[][] matrix = EulerUtils.buildMatrix(FILE);

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix.length - 1; j >= 0; j--) {
				if (i == matrix.length - 1 && j == matrix.length - 1) {
					continue;
				}
				BigInteger minimum;
				if (i == matrix.length - 1) {
					minimum = matrix[i][j + 1];
				} else if (j == matrix.length - 1) {
					minimum = matrix[i + 1][j];
				} else if (matrix[i + 1][j].compareTo(matrix[i][j + 1]) > 0) {
					minimum = matrix[i][j + 1];
				} else {
					minimum = matrix[i + 1][j];
				}
				matrix[i][j] = matrix[i][j].add(minimum);
			}
		}

		result = matrix[0][0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler082());
	}

}
