package poker.hand.strength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import poker.card.Rank;
import poker.hand.Hand;

public class NOfAKind extends HandStrength {
	public static class NoNKindException extends Exception {
		private static final long serialVersionUID = -4619868324552688054L;
	}
	
	private Rank rank;
	private int num;
	
	protected NOfAKind(int n, Hand h) throws NoNKindException {
		findPossible(n, h, new ArrayList<Rank>());
	}
	
	protected NOfAKind(int n, Hand h, List<Rank> notPossible) throws NoNKindException {
		findPossible(n, h, notPossible);
	}

	protected NOfAKind(int n, Rank r) {
		init(n, r);
	}
	
	private void findPossible(int n, Hand h, List<Rank> notPossible) throws NoNKindException {
		ArrayList<Rank> possible = new ArrayList<Rank>();
		for(Rank r : Rank.values())
			if(h.countRank(r) == n)
				possible.add(r);
		possible.removeAll(notPossible);
		if(possible.isEmpty())
			throw new NoNKindException();
		init(n, Collections.max(possible));
	}
	
	private void init(int n, Rank r) {
		num = n;
		rank = r;
		switch(n) {
		case 1:
			setValue(Value.HIGH_CARD);
			break;
		case 2:
			setValue(Value.ONE_PAIR);
			break;
		case 3:
			setValue(Value.THREE_OAK);
			break;
		case 4:
			setValue(Value.FOUR_OAK);
			break;
		}
	}

	@Override
	protected int compareEquivalent(HandStrength other) {
		return compareNKind((NOfAKind) other);
	}
	
	public int getN() {
		return num;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	private int compareNKind(NOfAKind other) {
		int cmp = getN() - other.getN();
		if(cmp != 0)
			return cmp;
		cmp = getRank().compareTo(other.getRank());
		return cmp;
	}

}
