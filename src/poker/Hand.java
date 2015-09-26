package poker;

import java.util.ArrayList;
import java.util.List;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;

public class Hand {
	private List<Card> cards;
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new ArrayList<Card>();
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
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
}
