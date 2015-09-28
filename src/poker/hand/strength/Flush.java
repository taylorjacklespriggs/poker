package poker.hand.strength;

import java.util.ArrayList;

import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Hand;

public class Flush extends HandStrength {
	public static class NoFlushException extends Exception {
		private static final long serialVersionUID = -3843693918945211405L;
	}
	
	private JBOCards cards;

	public Flush(Hand hand) throws NoFlushException {
		ArrayList<Rank> ranks = new ArrayList<Rank>();
		findFlush(hand, ranks);
		cards = new JBOCards(ranks);
		init();
	}
	
	private static void findFlush(Hand h, ArrayList<Rank> ranks) throws NoFlushException {
		for(Suit s : Suit.values()) {
			h.getSuit(s, ranks);
			if(ranks.size() == 5)
				return;
			ranks.clear();
		}
		throw new NoFlushException();
	}
	
	private void init() {
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
		for(Rank r : cards.getRanks()) {
			if(lr != null && !r.isBefore(lr))
				return false;
			lr = r;
		}
		return true;
	}
	
	private boolean isRoyal() {
		for(Rank r : cards.getRanks())
			if(!r.isRoyal())
				return false;
		return true;
	}

	@Override
	protected int compareEquivalent(HandStrength other) {
		return compareFlush((Flush) other);
	}
	
	protected JBOCards getCards() {
		return cards;
	}
	
	private int compareFlush(Flush other) {
		return getCards().compareTo(other.getCards());
	}
}
