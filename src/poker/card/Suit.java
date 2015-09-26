package poker.card;

public enum Suit {
	HEARTS,
	DIAMONDS,
	SPADES,
	CLUBS;
	
	public String niceName() {
		switch(this) {
		case HEARTS:
			return "Hearts";
		case DIAMONDS:
			return "Diamonds";
		case SPADES:
			return "Spades";
		case CLUBS:
			return "Clubs";
		}
		throw new RuntimeException("Tried to get the name of a suit that does not exist: "+ this);
	}
}
