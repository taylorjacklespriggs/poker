package poker.hand.strength;

import poker.hand.Hand;
import poker.hand.strength.NOfAKind.NoNKindException;

public class TwoPair extends NMOfAKind {

	public TwoPair(Hand h) throws NoNKindException {
		super(2, 2, h);
	}

}
