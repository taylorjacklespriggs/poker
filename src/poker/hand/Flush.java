package poker.hand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import poker.card.Rank;

public class Flush extends HandStrength {
	private List<Rank> ranks;

	public Flush(Value val, List<Rank> rs) {
		super(val);
		assert(ranks.size() == 5);
		ranks = new ArrayList<Rank>(rs);
		ranks.sort(new Comparator<Rank>() {
			@Override
			public int compare(Rank r1, Rank r2) {
				return -r1.compareTo(r2);
			}
		}); // Highest card to lowest
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
			if(cmp != 0) {
				return -cmp;
			}
		}
		return 0;
	}
}
