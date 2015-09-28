package poker.hand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import poker.card.Rank;

public class RankList
implements Comparable<RankList> {
	private static final int HAND_SIZE = 5;
	private static final Comparator<Rank> order = new Comparator<Rank>() {
		@Override
		public int compare(Rank r1, Rank r2) {
			return -r1.compareTo(r2);
		}
	};
	
	private ArrayList<Rank> ranks;
	private HashMap<Integer, ArrayList<Rank>> sets;
	
	public RankList(List<Rank> crds) {
		ranks = new ArrayList<Rank>(crds);
		initSets();
		for(Rank r : Rank.values()) {
			int sum = countRank(r);
			if(sum != 0) {
				ArrayList<Rank> list = sets.get(sum);
				list.add(r);
			}
		}
		sort();
	}
	
	public RankList() {
		ranks = new ArrayList<Rank>();
		initSets();
	}
	
	private void initSets() {
		sets = new HashMap<Integer, ArrayList<Rank>>();
		for(int i = 1; i <= HAND_SIZE; ++i) {
			ArrayList<Rank> list = new ArrayList<Rank>();
			sets.put(i, list);
		}
	}

	public void addRank(Rank r) {
		int sum = countRank(r);
		if(sum != 0)
			sets.get(sum).remove(r);
		ranks.add(r);
		sets.get(sum + 1).add(r);
		sort();
	}
	
	protected List<Rank> getRankList() {
		return ranks;
	}
	
	protected HashMap<Integer, ArrayList<Rank>> getSets() {
		return sets;
	}

	@Override
	public int compareTo(RankList other) {
		HashMap<Integer, ArrayList<Rank>> otherSets = other.getSets();
		for(int i = HAND_SIZE; i > 0; --i) {
			int cmp = lexOrder(sets.get(i), otherSets.get(i));
			if(cmp != 0)
				return cmp;
		}
		return 0;
	}
	
	private int lexOrder(ArrayList<Rank> l1, ArrayList<Rank> l2) {
		int i = 0;
		while(i < l1.size() && i < l2.size()) {
			int cmp = l1.get(i).compareTo(l2.get(i));
			if(cmp != 0)
				return cmp;
			++i;
		}
		return l1.size() - l2.size();
	}

	public Iterable<Rank> getRanks() {
		return ranks;
	}
	
	private void sort() {
		ranks.sort(order);
		for(ArrayList<Rank> list : sets.values())
			list.sort(order);
	}
	
	private int countRank(Rank r) {
		int sum = 0;
		for(Rank rnk : ranks)
			if(r == rnk)
				++sum;
		return sum;
	}
}
