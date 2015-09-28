package poker.input;

import java.io.PrintStream;

import poker.card.Card;
import poker.hand.Hand;

public class HandInput {
	private CardInput cardIn;
	private PrintStream output;
	
	public HandInput(CardInput ci) {
		cardIn = ci;
	}
	
	public void setOutput(PrintStream ps) {
		output = ps;
		cardIn.setOutput(ps);
	}
	
	public Hand readHand() throws InputException {
		Card[] cs = new Card[5];
		output.println("Please input the 5 card that make up a hand");
		for(int i = 0; i < 5; ++i) {
			cs[i] = cardIn.readCard();
		}
		return new Hand(cs[0], cs[1], cs[2], cs[3], cs[4]);
	}
}
