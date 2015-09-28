package poker.hand.strength;

import java.util.ArrayList;

import poker.card.Rank;
import poker.hand.Hand;
import poker.hand.strength.NOfAKind.NoNKindException;

public class NMOfAKind extends HandStrength {
	private NOfAKind moreN, lessM;
	
	public NMOfAKind(int n, int m, Hand h) throws NoNKindException {
		assert(n <= m);
		moreN = new NOfAKind(n, h);
		Rank r = moreN.getRank();
		ArrayList<Rank> notPossible = new ArrayList<Rank>();
		notPossible.add(r);
		lessM = new NOfAKind(m, h, notPossible);
		if(m == 2) {
			switch(n) {
			case 2:
				setValue(Value.TWO_PAIR);
				break;
			case 3:
				setValue(Value.FULL_HOUSE);
				break;
			}
		}
	}

	@Override
	protected int compareEquivalent(HandStrength other) {
		return compareNMOfAKind((NMOfAKind) other);
	}
	
	protected NOfAKind getNOfAKind() {
		return moreN;
	}
	
	protected NOfAKind getMOfAKind() {
		return lessM;
	}
	
	private int compareNMOfAKind(NMOfAKind other) {
		int cmp = getNOfAKind().compareTo(other.getNOfAKind());
		if(cmp != 0)
			return cmp;
		return getMOfAKind().compareTo(other.getMOfAKind());
	}
}
