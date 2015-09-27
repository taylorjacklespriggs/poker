package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Flush;
import poker.hand.Flush.NoFlushException;
import poker.hand.Hand;
import poker.hand.HandStrength;

public class FlushTest {
	
	// NOT A FLUSH
	private static Hand testHand0 = new Hand(
			new Card(Rank.ACE, Suit.HEARTS),
			new Card(Rank.TWO, Suit.CLUBS),
			new Card(Rank.QUEEN, Suit.SPADES),
			new Card(Rank.SEVEN, Suit.DIAMONDS),
			new Card(Rank.NINE, Suit.CLUBS)
			);
	
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
	
	@Test(expected=Flush.NoFlushException.class)
	public void testNotAFlush() throws NoFlushException {
		new Flush(testHand0);
	}
	
	@Test
	public void testValue() throws NoFlushException {
		Flush flush = new Flush(testHand1);
		assertEquals("Hand 1 is a PLAIN FLUSH", flush.getValue(), HandStrength.Value.FLUSH);
		
		flush = new Flush(testHand2);
		assertEquals("Hand 2 is a ROYAL FLUSH", flush.getValue(), HandStrength.Value.ROYAL_FLUSH);
		
		flush = new Flush(testHand3);
		assertEquals("Hand 3 is a STRAIGHT FLUSH", flush.getValue(), HandStrength.Value.STRAIGHT_FLUSH);
	}

	@Test
	public void testComparison() throws NoFlushException {
		Flush f1 = new Flush(testHand1);
		Flush f2 = new Flush(testHand2);
		Flush f3 = new Flush(testHand3);
		Flush f4 = new Flush(testHand4);
		Flush f5 = new Flush(testHand5);
		
		assertTrue("Hand 1 is weaker than hand 2", f1.compareTo(f2) < 0);
		assertTrue("Hand 2 is stronger than hand 3", f2.compareTo(f3) > 0);
		assertTrue("Hand 3 is weaker than hand 4", f3.compareTo(f4) < 0);
		assertTrue("Hand 4 is equivalent to hand 5", f4.compareTo(f5) == 0);
	}

}
