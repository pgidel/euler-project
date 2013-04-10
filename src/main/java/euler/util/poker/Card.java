package euler.util.poker;

public class Card implements Comparable<Card> {

	enum Color {
		C(1), D(2), H(3), S(4);

		private int rank;

		private Color(int rank) {
			this.rank = rank;
		}

		public int getRank() {
			return rank;
		}
	}

	private Color color;
	private short value;

	public Card(String c) {
		String v = c.substring(0, 1);
		if ("T".equals(v)) {
			value = 10;
		} else if ("J".equals(v)) {
			value = 11;
		} else if ("Q".equals(v)) {
			value = 12;
		} else if ("K".equals(v)) {
			value = 13;
		} else if ("A".equals(v)) {
			value = 14;
		} else {
			value = Short.valueOf(v);
		}
		color = Color.valueOf(c.substring(1, 2));
	}

	public Color getColor() {
		return color;
	}

	public short getValue() {
		return value;
	}

	@Override
	public int compareTo(Card o) {
		if (this.value == o.value)
			return this.color.compareTo(o.color);
		return this.value > o.value ? 1 : -1;
	}

	@Override
	public String toString() {
		return (value < 10 ? " " : "") + value + ":" + color;
	}

}