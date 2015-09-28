package poker.hand;

import java.util.ArrayList;
import java.util.List;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;

public class Hand implements Comparable<Hand> {
	public enum Strength
	implements Comparable<Strength> // lowest to highest rank
	{
		HIGH_CARD,
		ONE_PAIR,
		TWO_PAIR, 
		THREE_OAK, 
		STRAIGHT, 
		FLUSH, 
		FULL_HOUSE, 
		FOUR_OAK, 
		STRAIGHT_FLUSH, 
		ROYAL_FLUSH;

		public String niceName() {
			String str = toString();
			return str.charAt(0) + str.substring(1).toLowerCase().replace('_', ' ');
		}
	}

	private List<Card> cards;
	private Strength strength;
	private RankList ranks;

	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new ArrayList<Card>();
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		ranks = new RankList();
		for (Card c : cards) {
			ranks.addRank(c.getRank());
		}
		evaluateStrength();
	}

	public Strength getStrength() {
		return strength;
	}

	@Override
	public int compareTo(Hand hand) {
		int cmp = getStrength().compareTo(hand.getStrength());
		if (cmp != 0)
			return cmp;
		return getRankList().compareTo(hand.getRankList());
	}

	@Override
	public String toString() {
		return getStrength().niceName() + " -> " + cards.get(0) + ", " + cards.get(1) + ", " + cards.get(2) + ", "
				+ cards.get(3) + ", " + cards.get(4);
	}

	public void getSuit(Suit s, List<Rank> dest) {
		for (Card c : cards)
			if (c.getSuit() == s)
				dest.add(c.getRank());
	}

	public int countSuit(Suit s) {
		int sum = 0;
		for (Card c : cards)
			if (c.getSuit() == s)
				++sum;
		return sum;
	}

	public int countRank(Rank r) {
		int sum = 0;
		for (Card c : cards)
			if (c.getRank() == r)
				++sum;
		return sum;
	}

	public void getRanks(ArrayList<Rank> dest) {
		for (Card c : cards) {
			dest.add(c.getRank());
		}
	}

	protected RankList getRankList() {
		return ranks;
	}

	private void evaluateStrength() {
		if (isRoyalFlush()) {
			strength = Strength.ROYAL_FLUSH;
		} else if (isStraightFlush()) {
			strength = Strength.STRAIGHT_FLUSH;
		} else if (isFourOfAKind()) {
			strength = Strength.FOUR_OAK;
		} else if (isFullHouse()) {
			strength = Strength.FULL_HOUSE;
		} else if (isFlush()) {
			strength = Strength.FLUSH;
		} else if (isStraight()) {
			strength = Strength.STRAIGHT;
		} else if (isThreeOfAKind()) {
			strength = Strength.THREE_OAK;
		} else if (isTwoPair()) {
			strength = Strength.TWO_PAIR;
		} else if (isOnePair()) {
			strength = Strength.ONE_PAIR;
		} else {
			strength = Strength.HIGH_CARD;
		}
	}

	private boolean isRoyalFlush() {
		return isStraightFlush() && isRoyal();
	}

	private boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	private boolean isFourOfAKind() {
		return isNKind(4);
	}

	private boolean isFullHouse() {
		return isNKind(3) && isNKind(2);
	}

	private boolean isFlush() {
		for (Suit s : Suit.values())
			if (countSuit(s) == 5)
				return true;
		return false;
	}

	private boolean isStraight() {
		Rank lr = null;
		for (Rank r : ranks.getRanks()) {
			if (lr != null && !lr.isPrevious(r))
				return false;
			lr = r;
		}
		return true;
	}

	private boolean isThreeOfAKind() {
		return isNKind(3);
	}

	private boolean isTwoPair() {
		boolean one = false;
		for (Rank r : Rank.values()) {
			if (countRank(r) == 2) {
				if (one)
					return true;
				one = true;
			}
		}
		return false;
	}

	private boolean isOnePair() {
		return isNKind(2);
	}

	private boolean isRoyal() {
		for (Rank r : ranks.getRanks())
			if (!r.isRoyal())
				return false;
		return true;
	}

	private boolean isNKind(int n) {
		for (Rank r : Rank.values())
			if (countRank(r) == n)
				return true;
		return false;
	}
}
