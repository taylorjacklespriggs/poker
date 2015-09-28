package poker.hand.strength;

import poker.hand.Hand;

public class ThreeOfAKind extends NOfAKind {

	public ThreeOfAKind(Hand h) throws NoNKindException {
		super(3, h);
	}

}
