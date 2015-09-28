package poker.hand.strength;

import poker.hand.Hand;
import poker.hand.strength.NOfAKind.NoNKindException;

public class FullHouse extends NMOfAKind {

	public FullHouse(Hand h) throws NoNKindException {
		super(3, 2, h);
	}

}
