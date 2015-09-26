package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;

public class CardTest {
	
	private void testConstructor(Rank r, Suit s) {
		Card c = new Card(r, s);
		assertEquals(c.getRank(), r);
		assertEquals(c.getSuit(), s);
	}

	@Test
	public void testCardConstructor() {
		for(Rank r : Rank.values()) {
			for(Suit s : Suit.values()) {
				testConstructor(r, s);
			}
		}
	}

}
