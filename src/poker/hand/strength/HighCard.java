package poker.hand.strength;

import poker.hand.Hand;

public class HighCard extends NOfAKind {

	public HighCard(Hand h) throws NoNKindException {
		super(1, h);
	}

}
