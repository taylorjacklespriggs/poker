package poker.hand.strength;

import poker.hand.Hand;

public class FourOfAKind extends NOfAKind {

	public FourOfAKind(Hand h) throws NoNKindException {
		super(4, h);
	}

}
