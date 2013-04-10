package euler.util.poker;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import euler.util.poker.Card.Color;

public class Hand implements Comparable<Hand> {

	enum HandRank {
		HIGH_CARD(1), ONE_PAIR(2), TWO_PAIRS(3), THREE_OF_A_KIND(4), STRAIGHT(5), FLUSH(
				6), FULL_HOUSE(7), FOUR_OF_A_KIND(8), STRAIGHT_FLUSH(9), ROYAL_FLUSH(
				9);

		private int rank;

		private HandRank(int rank) {
			this.rank = rank;
		}

		public int getRank() {
			return rank;
		}
	}

	private LinkedList<Card> cards = new LinkedList<Card>();

	private HandRank rank;

	private Card highestRankValue;
	private Card highestValue;

	public Hand(String... cards) {
		for (String c : cards) {
			this.cards.add(new Card(c));
		}
		this.rank = computeRank();
	}

	@Override
	public String toString() {
		String s = "";
		for (Card c : cards) {
			s += c + " ";
		}
		if (rank != null) {
			s += "= " + rank;
		}
		return s;
	}

	private HandRank computeRank() {
		Collections.sort(cards);
		if (isRoyalFlush()) {
			return HandRank.ROYAL_FLUSH;
		}
		if (isStraightFlush()) {
			return HandRank.STRAIGHT_FLUSH;
		}
		if (isFourOfAKind()) {
			return HandRank.FOUR_OF_A_KIND;
		}
		if (isFullHouse()) {
			return HandRank.FULL_HOUSE;
		}
		if (isFlush()) {
			return HandRank.FLUSH;
		}
		if (isStraight()) {
			return HandRank.STRAIGHT;
		}
		if (isThreeOfAKind()) {
			return HandRank.THREE_OF_A_KIND;
		}
		if (isTwoPairs()) {
			return HandRank.TWO_PAIRS;
		}
		if (isOnePair()) {
			return HandRank.ONE_PAIR;
		}
		highestRankValue = cards.getLast();
		highestValue = cards.get(cards.size() - 2);
		return HandRank.HIGH_CARD;
	}

	private boolean isRoyalFlush() {
		if (cards.getFirst().getValue() != 10) {
			return false;
		}
		return isStraightFlush();
	}

	private boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	private boolean isFourOfAKind() {
		int index = isNOfAKind(4, 0);
		if (index == -1)
			return false;

		return true;
	}

	private boolean isFullHouse() {
		return isOnePair() && isThreeOfAKind();
	}

	private boolean isFlush() {
		Color c = cards.getFirst().getColor();
		for (int i = 1; i < cards.size(); i++) {
			if (cards.get(i).getColor() != c)
				return false;
		}

		highestRankValue = cards.getLast();
		return true;
	}

	private boolean isStraight() {
		short v = cards.getFirst().getValue();
		for (int i = 1; i < cards.size(); i++) {
			if (cards.get(i).getValue() != v + i) {
				return false;
			}
		}

		highestRankValue = cards.getLast();
		return true;
	}

	private boolean isThreeOfAKind() {
		int index = isNOfAKind(3, 0);
		if (index == -1)
			return false;

		return true;
	}

	private boolean isTwoPairs() {
		int index = isNOfAKind(2, 0);
		if (index == -1)
			return false;

		Card hrv1 = highestRankValue;
		Card hv1 = highestValue;

		index = isNOfAKind(2, index);
		if (index == -1)
			return false;

		Card hrv2 = highestRankValue;
		Card hv2 = highestValue;

		if (hrv1.compareTo(hrv2) > 0) {
			highestRankValue = hrv1;
			highestValue = hv2;
		} else {
			highestRankValue = hrv2;
			highestValue = hv1;
		}
		return true;
	}

	private boolean isOnePair() {
		int index = isNOfAKind(2, 0);
		if (index == -1)
			return false;

		return true;
	}

	private int isNOfAKind(int n, int index) {
		if (index + n > cards.size()) {
			return -1;
		}
		for (int i = index; i < index + n; i++) {
			if (cards.get(i).getValue() != cards.get(index).getValue()) {
				return isNOfAKind(n, i);
			}
		}
		if (index + n < cards.size()
				&& cards.get(index + n).getValue() == cards.get(index)
						.getValue()) {
			return isNOfAKind(n, index + n);
		}

		highestRankValue = cards.get(index + n - 1);
		if (index + n == cards.size())
			highestValue = cards.get(index - 1);
		else
			highestValue = cards.get(index + n);
		return index + n;
	}

	public List<Card> getCards() {
		return cards;
	}

	@Override
	public int compareTo(Hand o) {
		int c = this.rank.compareTo(o.rank);
		if (c != 0)
			return c;
		if (highestRankValue == null)
			return 0;
		c = this.highestRankValue.compareTo(o.highestRankValue);
		if (c != 0)
			return c;
		if (highestValue == null)
			return 0;
		return this.highestValue.compareTo(o.highestValue);
	}

}
