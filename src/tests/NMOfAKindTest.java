package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Hand;

public class NMOfAKindTest {
	
	// TWO PAIR (KING high)
	private static Hand testHand1 = new Hand(
			new Card(Rank.KING, Suit.CLUBS),
			new Card(Rank.KING, Suit.DIAMONDS),
			new Card(Rank.QUEEN, Suit.SPADES),
			new Card(Rank.QUEEN, Suit.HEARTS),
			new Card(Rank.ACE, Suit.CLUBS)
			);
	
	// FULL HOUSE
	private static Hand testHand2 = new Hand(
			new Card(Rank.TEN, Suit.HEARTS),
			new Card(Rank.TEN, Suit.SPADES),
			new Card(Rank.KING, Suit.DIAMONDS),
			new Card(Rank.TEN, Suit.CLUBS),
			new Card(Rank.KING, Suit.SPADES)
			);
	
	// FULL HOUSE
	private static Hand testHand3 = new Hand(
			new Card(Rank.THREE, Suit.HEARTS),
			new Card(Rank.TWO, Suit.DIAMONDS),
			new Card(Rank.THREE, Suit.SPADES),
			new Card(Rank.THREE, Suit.DIAMONDS),
			new Card(Rank.TWO, Suit.CLUBS)
			);
	
	// TWO PAIR (KING high)
	private static Hand testHand4 = new Hand(
			new Card(Rank.KING, Suit.HEARTS),
			new Card(Rank.KING, Suit.SPADES),
			new Card(Rank.JACK, Suit.SPADES),
			new Card(Rank.JACK, Suit.HEARTS),
			new Card(Rank.ACE, Suit.DIAMONDS)
			);

	@Test
	public void testComparison() {
		
		assertTrue("Hand 1 is weaker than hand 2", testHand1.compareTo(testHand2) < 0);
		assertTrue("Hand 2 is stronger than hand 3", testHand2.compareTo(testHand3) > 0);
		assertTrue("Hand 1 is stronger than hand 4", testHand1.compareTo(testHand4) > 0);
	}

}
