package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Hand;

public class NOfAKindTest {
	
	// TWO PAIR (KING high)
	private static Hand testHand1 = new Hand(
			new Card(Rank.KING, Suit.CLUBS),
			new Card(Rank.KING, Suit.DIAMONDS),
			new Card(Rank.QUEEN, Suit.SPADES),
			new Card(Rank.QUEEN, Suit.HEARTS),
			new Card(Rank.ACE, Suit.CLUBS)
			);
	
	// THREE OAK
	private static Hand testHand2 = new Hand(
			new Card(Rank.TEN, Suit.HEARTS),
			new Card(Rank.TEN, Suit.SPADES),
			new Card(Rank.QUEEN, Suit.SPADES),
			new Card(Rank.TEN, Suit.CLUBS),
			new Card(Rank.KING, Suit.SPADES)
			);
	
	// FOUR OAK high THREE
	private static Hand testHand3 = new Hand(
			new Card(Rank.THREE, Suit.HEARTS),
			new Card(Rank.TWO, Suit.DIAMONDS),
			new Card(Rank.THREE, Suit.SPADES),
			new Card(Rank.THREE, Suit.DIAMONDS),
			new Card(Rank.THREE, Suit.CLUBS)
			);
	
	// FOUR OAK high QUEEN
	private static Hand testHand4 = new Hand(
			new Card(Rank.QUEEN, Suit.HEARTS),
			new Card(Rank.TWO, Suit.DIAMONDS),
			new Card(Rank.QUEEN, Suit.SPADES),
			new Card(Rank.QUEEN, Suit.DIAMONDS),
			new Card(Rank.QUEEN, Suit.CLUBS)
			);
	
	// ONE PAIR (KING high)
	private static Hand testHand5 = new Hand(
			new Card(Rank.KING, Suit.HEARTS),
			new Card(Rank.KING, Suit.SPADES),
			new Card(Rank.QUEEN, Suit.CLUBS),
			new Card(Rank.TEN, Suit.HEARTS),
			new Card(Rank.ACE, Suit.DIAMONDS)
			);
	
	// HIGH CARD (TEN high)
	private static Hand testHand6 = new Hand(
			new Card(Rank.THREE, Suit.HEARTS),
			new Card(Rank.SIX, Suit.SPADES),
			new Card(Rank.SEVEN, Suit.CLUBS),
			new Card(Rank.TWO, Suit.HEARTS),
			new Card(Rank.TEN, Suit.DIAMONDS)
			);
	
	// HIGH CARD (NINE high)
	private static Hand testHand7 = new Hand(
			new Card(Rank.SEVEN, Suit.HEARTS),
			new Card(Rank.NINE, Suit.SPADES),
			new Card(Rank.EIGHT, Suit.CLUBS),
			new Card(Rank.SIX, Suit.HEARTS),
			new Card(Rank.TWO, Suit.DIAMONDS)
			);
	
	@Test
	public void testConstructor() {
		assertEquals("Hand 6 is high card", testHand6.getStrength(), Hand.Strength.HIGH_CARD);
		
		assertEquals("Hand 1 is one pair", testHand1.getStrength(), Hand.Strength.ONE_PAIR);
		
		assertEquals("Hand 2 is three of a kind", testHand2.getStrength(), Hand.Strength.THREE_OAK);
		
		assertEquals("Hand 3 is four of a kind", testHand3.getStrength(), Hand.Strength.FOUR_OAK);
	}

	@Test
	public void testComparison() {
		assertTrue("Hand 1 is weaker than hand 3", testHand1.compareTo(testHand3) < 0);
		
		assertTrue("Hand 1 is weaker than hand 4", testHand1.compareTo(testHand4) < 0);
		
		assertTrue("Hand 3 is weaker than hand 4", testHand3.compareTo(testHand4) < 0);
		
		assertTrue("Hand 1 is stronger than hand 5", testHand1.compareTo(testHand5) > 0);
		
		assertTrue("Hand 6 is stronger than hand 7", testHand6.compareTo(testHand7) > 0);
	}

}
