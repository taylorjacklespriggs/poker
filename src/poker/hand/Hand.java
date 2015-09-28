package poker.hand;

import java.util.ArrayList;
import java.util.List;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.strength.Flush;
import poker.hand.strength.HandStrength;
import poker.hand.strength.Flush.NoFlushException;

public class Hand
implements Comparable<Hand>
{
	private List<Card> cards;
	private HandStrength strength;
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new ArrayList<Card>();
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
		evaluateStrength();
	}

	@Override
	public int compareTo(Hand hand) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void getSuit(Suit s, List<Rank> dest) {
		for(Card c : cards)
			if(c.getSuit() == s)
				dest.add(c.getRank());
	}
	
	public int countRank(Rank r) {
		int sum = 0;
		for(Card c : cards)
			if(c.getRank() == r)
				++sum;
		return sum;
	}

	public void getRanks(ArrayList<Rank> dest) {
		for(Card c : cards) {
			dest.add(c.getRank());
		}
	}
	
	private void evaluateStrength() {
		try {
			strength = new Flush(this);
		} catch(NoFlushException e) {
			// TODO strength = new TwoPair(this);
		}
	}
}
