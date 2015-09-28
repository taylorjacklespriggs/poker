package poker.hand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import poker.card.Rank;

public class RankList
implements Comparable<RankList> {
	private static final Comparator<Rank> order = new Comparator<Rank>() {
		@Override
		public int compare(Rank r1, Rank r2) {
			return -r1.compareTo(r2);
		}
	};
	
	private ArrayList<Rank> ranks;
	
	public RankList(List<Rank> crds) {
		ranks = new ArrayList<Rank>(crds);
		sort();
	}
	
	public RankList() {
		ranks = new ArrayList<Rank>();
	}

	public void addRank(Rank r) {
		ranks.add(r);
		sort();
	}
	
	protected List<Rank> getRankList() {
		return ranks;
	}

	@Override
	public int compareTo(RankList other) {
		List<Rank> otherRanks = other.getRankList();
		assert(otherRanks.size() == ranks.size());
		int cmp, i, end;
		end = ranks.size();
		for(i = 0; i < end; ++i) {
			cmp = ranks.get(i).compareTo(otherRanks.get(i));
			if(cmp != 0)
				return cmp;
		}
		return 0;
	}

	public Iterable<Rank> getRanks() {
		return ranks;
	}
	
	private void sort() {
		ranks.sort(order);
	}
}
