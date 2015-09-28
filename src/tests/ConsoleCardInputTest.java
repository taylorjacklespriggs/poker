package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.input.CardInput;
import poker.input.InputException;
import poker.input.console.ConsoleCardInput;

public class ConsoleCardInputTest {

	@Test(expected=InputException.class)
	public void testInput() throws InputException {
		System.setIn(new ByteArrayInputStream("a\ns\n2\nc\nj\nd\nQ\nH\n\nf\naksdm\n".getBytes()));
		CardInput ci = new ConsoleCardInput();
		ci.setOutput(System.out);
		
		Card card = ci.readCard();
		assertEquals("First rank is ACE", card.getRank(), Rank.ACE);
		assertEquals("First suit is SPADES", card.getSuit(), Suit.SPADES);
		
		card = ci.readCard();
		assertEquals("Second rank is TWO", card.getRank(), Rank.TWO);
		assertEquals("Second suit is CLUBS", card.getSuit(), Suit.CLUBS);
		
		card = ci.readCard();
		assertEquals("Third rank is JACK", card.getRank(), Rank.JACK);
		assertEquals("Third suit is CLUBS", card.getSuit(), Suit.DIAMONDS);
		
		card = ci.readCard();
		assertEquals("Fourth rank is QUEEN", card.getRank(), Rank.QUEEN);
		assertEquals("Fourth suit is HEARTS", card.getSuit(), Suit.HEARTS);
		
		card = ci.readCard();
	}

}
