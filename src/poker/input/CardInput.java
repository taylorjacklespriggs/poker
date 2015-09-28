package poker.input;

import java.io.PrintStream;

import poker.card.Card;

public interface CardInput {
	
	public void setOutput(PrintStream ps);
	
	public Card readCard() throws InputException;

}
