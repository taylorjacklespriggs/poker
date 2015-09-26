package poker.card;

public class Card {
	private Rank rank;
	private Suit suit;
	
	public Card(Rank r, Suit s) {
		rank = r;
		suit = s;
	}
	
	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}
}
