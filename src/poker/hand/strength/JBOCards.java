package poker.hand.strength;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import poker.card.Rank;

public class JBOCards // just a bunch of cards
implements Comparable<JBOCards> {
	private ArrayList<Rank> ranks;
	
	public JBOCards(List<Rank> crds) {
		ranks = new ArrayList<Rank>(crds);
		ranks.sort(new Comparator<Rank>() {
			@Override
			public int compare(Rank r1, Rank r2) {
				return -r1.compareTo(r2);
			}
		}); // highest to lowest
	}
	
	protected List<Rank> getRankList() {
		return ranks;
	}

	@Override
	public int compareTo(JBOCards other) {
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
}
