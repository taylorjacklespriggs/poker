package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Hand;
import poker.input.HandInput;
import poker.input.InputException;
import poker.input.console.ConsoleCardInput;

public class HandInputTest {

	@Test
	public void testHandInput() throws InputException {
		System.setIn(new ByteArrayInputStream("a\ns\n2\nc\nQ\nH\nq\nd\nj\nc\n".getBytes()));
		HandInput hi = new HandInput(new ConsoleCardInput());
		hi.setOutput(System.out);
		Hand hand = hi.readHand();
		assertEquals("The hand has 2 clubs", 2, hand.countSuit(Suit.CLUBS));
		assertEquals("The hand has 2 queens", 2, hand.countRank(Rank.QUEEN));
	}

}
