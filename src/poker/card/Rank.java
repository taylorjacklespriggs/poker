package poker.card;

public enum Rank {
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING,
	ACE;
	
	public boolean isBefore(Rank other) {
		return this.compareTo(other) == -1;
	}
	
	public boolean isAfter(Rank other) {
		return this.compareTo(other) == 1;
	}
	
	public String niceName() {
		switch(this) {
		case TWO:
			return "Two";
		case THREE:
			return "Three";
		case FOUR:
			return "Four";
		case FIVE:
			return "Five";
		case SIX:
			return "Six";
		case SEVEN:
			return "Seven";
		case EIGHT:
			return "Eight";
		case NINE:
			return "Nine";
		case TEN:
			return "Ten";
		case JACK:
			return "Jack";
		case QUEEN:
			return "Queen";
		case KING:
			return "King";
		case ACE:
			return "Ace";
		}
		throw new RuntimeException("Tried to get the name of a rank that does not exist: "+ this);
	}
}
