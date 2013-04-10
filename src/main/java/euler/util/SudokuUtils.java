package euler.util;
import java.io.BufferedReader;
import java.io.IOException;

public class SudokuUtils {

	public static short[][] solve(BufferedReader reader) throws IOException {
		short[][] matrix = new short[9][9];
		for (int i = 0; i < 9; i++) {
			String line = reader.readLine();
			for (int j = 0; j < 9; j++) {
				matrix[i][j] = Short.valueOf(String.valueOf(line.charAt(j)));
			}
		}
		solve(matrix, 0, 0);
		return matrix;
	}

	private static boolean solve(short[][] matrix, int i, int j) {
		if (i == 9) {
			i = 0;
			if (++j == 9) {
				return true;
			}
		}
		if (matrix[i][j] != 0) {
			return solve(matrix, i + 1, j);
		}

		for (short value : new Short[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }) {
			if (isValueLegalForRow(matrix, j, value) && isValueLegalForColumn(matrix, i, value)
					&& isValueLegalForBox(matrix, i, j, value)) {
				matrix[i][j] = value;
				if (solve(matrix, i + 1, j)) {
					return true;
				}
			}
		}
		// reset on backtrack
		matrix[i][j] = 0;
		return false;
	}

	private static boolean isValueLegalForRow(short[][] matrix, int j, short value) {
		for (int k = 0; k < 9; ++k) {
			if (value == matrix[k][j]) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValueLegalForColumn(short[][] matrix, int i, short value) {
		for (int k = 0; k < 9; ++k) {
			if (value == matrix[i][k]) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValueLegalForBox(short[][] matrix, int i, int j, short value) {
		int iOffset = (i / 3) * 3;
		int jOffset = (j / 3) * 3;
		for (int k = 0; k < 3; ++k) {
			for (int m = 0; m < 3; ++m) {
				if (value == matrix[iOffset + k][jOffset + m]) {
					return false;
				}
			}
		}
		return true;
	}

}
