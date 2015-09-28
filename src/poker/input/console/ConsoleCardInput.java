package poker.input.console;

import java.io.PrintStream;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.input.CardInput;
import poker.input.InputException;

public class ConsoleCardInput extends ConsoleInput implements CardInput {
	private PrintStream output;
	
	private Rank getRank() throws InputException {
		try {
			output.print("Please enter the rank [2-9, (T)en, (J)ack, (Q)ueen, (K)ing, (A)ce]: ");
			switch(readChar()) {
			case '2':
				return Rank.TWO;
			case '3':
				return Rank.THREE;
			case '4':
				return Rank.FOUR;
			case '5':
				return Rank.FIVE;
			case '6':
				return Rank.SIX;
			case '7':
				return Rank.SEVEN;
			case '8':
				return Rank.EIGHT;
			case '9':
				return Rank.NINE;
			case 't':
				return Rank.TEN;
			case 'j':
				return Rank.JACK;
			case 'q':
				return Rank.QUEEN;
			case 'k':
				return Rank.KING;
			case 'a':
				return Rank.ACE;
			}
		} catch (Exception e) {
		}
		throw new InputException();
	}
	
	private Suit getSuit() throws InputException {
		try {
			output.print("Please enter the suit [(H)earts, (D)iamonds, (C)lubs, (S)pades]: ");
			switch(readChar()) {
			case 'h':
				return Suit.HEARTS;
			case 'd':
				return Suit.DIAMONDS;
			case 'c':
				return Suit.CLUBS;
			case 's':
				return Suit.SPADES;
			}
		} catch (Exception e) {
		}
		throw new InputException();
	}

	@Override
	public Card readCard() throws InputException {
		output.println("Please enter a card");
		return new Card(getRank(), getSuit());
	}

	@Override
	public void setOutput(PrintStream ps) {
		output = ps;
	}
}
