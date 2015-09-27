package poker.hand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poker.card.Rank;
import poker.card.Suit;

public class Flush extends HandStrength {
	public static class NoFlushException extends Exception {
		private static final long serialVersionUID = -3843693918945211405L;
	}
	
	private List<Rank> ranks;

	public Flush(Hand hand) throws NoFlushException {
		Map<Suit, Integer> count = new HashMap<Suit, Integer>();
		ranks = new ArrayList<Rank>();
		findFlush(hand);
		init();
	}
	
	private void findFlush(Hand h) throws NoFlushException {
		for(Suit s : Suit.values()) {
			h.getSuit(s, ranks);
			if(ranks.size() == 5)
				return;
			ranks.clear();
		}
		throw new NoFlushException();
	}
	
	private void init() {
		ranks.sort(new Comparator<Rank>() {
			@Override
			public int compare(Rank r1, Rank r2) {
				return -r1.compareTo(r2);
			}
		}); // Highest card to lowest
		// check for straight
		if(isStraight()) {
			// check for royal flush
			if(isRoyal())
				setValue(Value.ROYAL_FLUSH);
			else
				setValue(Value.STRAIGHT_FLUSH);
		} else {
			setValue(Value.FLUSH);
		}
	}
	
	private boolean isStraight() {
		Rank lr = null;
		for(Rank r : ranks) {
			if(lr != null && !r.isBefore(lr))
				return false;
			lr = r;
		}
		return true;
	}
	
	private boolean isRoyal() {
		for(Rank r : ranks)
			if(!r.isRoyal())
				return false;
		return true;
	}

	@Override
	protected int compareEquivalent(HandStrength other) {
		return compareFlush((Flush) other);
	}
	
	protected int compareRank(int idx, Rank r) {
		return ranks.get(idx).compareTo(r);
	}
	
	private int compareFlush(Flush other) {
		int cmp;
		for(int i = 0; i < ranks.size(); ++i) {
			cmp = other.compareRank(i, ranks.get(i));
			if(cmp != 0)
				return -cmp;
		}
		return 0;
	}
}
