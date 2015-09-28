package poker.game;

import poker.hand.Hand;

public class Player {
	private int ID;
	private Hand hand;
	
	public Player(int id, Hand hnd) {
		ID = id;
		hand = hnd;
	}

	public int getID() {
		return ID;
	}
	
	public Hand getHand() {
		return hand;
	}
}
