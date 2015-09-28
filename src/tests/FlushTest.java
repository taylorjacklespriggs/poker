package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Hand;

public class FlushTest {
	
	// PLAIN FLUSH
	private static Hand testHand1 = new Hand(
			new Card(Rank.ACE, Suit.CLUBS),
			new Card(Rank.TWO, Suit.CLUBS),
			new Card(Rank.QUEEN, Suit.CLUBS),
			new Card(Rank.SEVEN, Suit.CLUBS),
			new Card(Rank.NINE, Suit.CLUBS)
			);
	
	// ROYAL FLUSH
	private static Hand testHand2 = new Hand(
			new Card(Rank.TEN, Suit.SPADES),
			new Card(Rank.JACK, Suit.SPADES),
			new Card(Rank.ACE, Suit.SPADES),
			new Card(Rank.QUEEN, Suit.SPADES),
			new Card(Rank.KING, Suit.SPADES)
			);
	
	// STRAIGHT FLUSH
	private static Hand testHand3 = new Hand(
			new Card(Rank.THREE, Suit.HEARTS),
			new Card(Rank.TWO, Suit.HEARTS),
			new Card(Rank.FOUR, Suit.HEARTS),
			new Card(Rank.FIVE, Suit.HEARTS),
			new Card(Rank.SIX, Suit.HEARTS)
			);
	
	// STRAIGHT FLUSH
	private static Hand testHand4 = new Hand(
			new Card(Rank.SEVEN, Suit.HEARTS),
			new Card(Rank.TEN, Suit.HEARTS),
			new Card(Rank.NINE, Suit.HEARTS),
			new Card(Rank.JACK, Suit.HEARTS),
			new Card(Rank.EIGHT, Suit.HEARTS)
			);
	
	// STRAIGHT FLUSH
	private static Hand testHand5 = new Hand(
			new Card(Rank.NINE, Suit.DIAMONDS),
			new Card(Rank.SEVEN, Suit.DIAMONDS),
			new Card(Rank.TEN, Suit.DIAMONDS),
			new Card(Rank.EIGHT, Suit.DIAMONDS),
			new Card(Rank.JACK, Suit.DIAMONDS)
			);
	
	@Test
	public void testValue() {
		assertEquals("Hand 1 is a PLAIN FLUSH", testHand1.getStrength(), Hand.Strength.FLUSH);
		
		assertEquals("Hand 2 is a ROYAL FLUSH", testHand2.getStrength(), Hand.Strength.ROYAL_FLUSH);
		
		assertEquals("Hand 3 is a STRAIGHT FLUSH", testHand3.getStrength(), Hand.Strength.STRAIGHT_FLUSH);
	}

	@Test
	public void testComparison() {
		
		assertTrue("Hand 1 is weaker than hand 2", testHand1.compareTo(testHand3) < 0);
		assertTrue("Hand 2 is stronger than hand 3", testHand2.compareTo(testHand3) > 0);
		assertTrue("Hand 3 is weaker than hand 4", testHand3.compareTo(testHand4) < 0);
		assertTrue("Hand 4 is equivalent to hand 5", testHand4.compareTo(testHand5) == 0);
	}

}
