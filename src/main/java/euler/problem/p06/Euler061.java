package euler.problem.p06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler061 extends AbstractEuler {

	public enum Polygon {
		TRIANGLE, SQUARE, PENTAGON, HEXAGON, HEPTAGON, OCTAGON;
	}

	private static Map<Polygon, List<Long>> polygonals = new HashMap<Polygon, List<Long>>();
	{
		generatePolygonals();
	}

	private long min;

	public Euler061(int min) {
		this.min = min;
	}

	@Override
	public void compute() {
		// FIXME
		for (Entry<Polygon, List<Long>> polygonalList : polygonals.entrySet()) {
			for (Long l : polygonalList.getValue()) {
				System.out.print(l + " ");
			}
			System.out.println();
		}
	}

	private void generatePolygonals() {
		for (Polygon polygon : Polygon.values()) {
			List<Long> numbers = new ArrayList<Long>();
			long p = 0;
			long n = 1;
			do {
				switch (polygon) {
				case TRIANGLE:
					p = EulerUtils.getTriangle(n);
					break;
				case SQUARE:
					p = EulerUtils.getSquare(n);
					break;
				case PENTAGON:
					p = EulerUtils.getPentagonal(n);
					break;
				case HEXAGON:
					p = EulerUtils.getHexagonal(n);
					break;
				case HEPTAGON:
					p = EulerUtils.getHeptagonal(n);
					break;
				case OCTAGON:
					p = EulerUtils.getOctagonal(n);
					break;
				}
				if (p >= min) {
					numbers.add(p);
				}
				n++;
			} while (p <= min * 10 - 1);
			polygonals.put(polygon, numbers);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler061(1000));
	}

}
