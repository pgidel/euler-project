package euler.util.math.geometry;

public class Triangle {

	public Point a;
	public Point b;
	public Point c;

	public boolean contains(Point o) {
		Point v1 = new Point(b.x - a.x, b.y - a.y);
		Point v2 = new Point(c.x - a.x, c.y - a.y);
		double d = det(v1, v2);
		double m = (det(o, v2) - det(a, v2)) / d;
		double n = -(det(o, v1) - det(a, v1)) / d;
		return m > 0 && n > 0 && m + n < 1;
	}

	private static double det(Point a, Point b) {
		return a.x * b.y - a.y * b.x;
	}

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString() {
		return a + " " + b + " " + c;
	}
}
