package euler.problem.p10;

import java.math.BigInteger;
import java.util.List;

import euler.exception.EulerException;
import euler.problem.AbstractEuler;
import euler.util.EulerUtils;
import euler.util.math.geometry.Point;
import euler.util.math.geometry.Triangle;

public class Euler102 extends AbstractEuler {

	private static final String FILE = "src/main/resources/P102.txt";

	private static final Point O = new Point(0, 0);

	@Override
	public void compute() throws EulerException {
		List<Triangle> triangles = EulerUtils.buildTriangles(FILE);

		result = BigInteger.ZERO;
		for (Triangle triangle : triangles) {
			if (triangle.contains(O)) {
				result = result.add(BigInteger.ONE);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler102());
	}

}
