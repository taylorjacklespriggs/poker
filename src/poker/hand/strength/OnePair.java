package poker.hand.strength;

import poker.hand.Hand;

public class OnePair extends NOfAKind {

	public OnePair(Hand h) throws NoNKindException {
		super(2, h);
	}

}
