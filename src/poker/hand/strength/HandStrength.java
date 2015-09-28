package poker.hand.strength;

public abstract class HandStrength
implements Comparable<HandStrength> // natural ordering is lowest to highest strength
{
	public enum Value
	implements Comparable<Value> // lowest to highest rank
	{
		HIGH_CARD,
		ONE_PAIR,
		TWO_PAIR,
		THREE_OAK,
		STRAIGHT,
		FLUSH,
		FULL_HOUSE,
		FOUR_OAK,
		STRAIGHT_FLUSH,
		ROYAL_FLUSH;
	}
	
	public final int compareTo(HandStrength other) {
		int cmp = getValue().compareTo(other.getValue());
		if(cmp != 0) { // not the same value
			return cmp;
		}
		return compareEquivalent(other);
	}
	
	protected abstract int compareEquivalent(HandStrength other);
	
	private Value value;
	
	protected HandStrength() {
		value = null;
	}
	
	public Value getValue() {
		return value;
	}
	
	protected void setValue(Value val) {
		value = val;
	}
}
