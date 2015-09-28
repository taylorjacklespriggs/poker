package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Hand;
import poker.hand.strength.FourOfAKind;
import poker.hand.strength.NOfAKind;
import poker.hand.strength.NOfAKind.NoNKindException;
import poker.hand.strength.OnePair;
import poker.hand.strength.ThreeOfAKind;

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
	
	@Test(expected=NoNKindException.class)
	public void testConstructor() throws NoNKindException {
		NOfAKind nok = new OnePair(testHand1);
		assertEquals("Hand 1 is KING high pair", nok.getRank(), Rank.KING);
		
		nok = new ThreeOfAKind(testHand2);
		assertEquals("Hand 2 is three TENs", nok.getRank(), Rank.TEN);
		
		nok = new FourOfAKind(testHand3);
		assertEquals("Hand 3 is four THREEs", nok.getRank(), Rank.THREE);
		
		new ThreeOfAKind(testHand1); // no triples
	}

	@Test
	public void testComparison() throws NoNKindException {
		NOfAKind nok1 = new OnePair(testHand1);
		NOfAKind nok2 = new FourOfAKind(testHand3);
		NOfAKind nok3 = new FourOfAKind(testHand4);
		NOfAKind nok4 = new OnePair(testHand5);
		
		assertTrue("Hand 1 is weaker than hand 3", nok1.compareTo(nok2) < 0);
		assertTrue("Hand 1 is weaker than hand 4", nok1.compareTo(nok3) < 0);
		assertTrue("Hand 3 is weaker than hand 4", nok2.compareTo(nok3) < 0);
		assertTrue("Hand 1 is equivalent (for this test) than hand 5", nok1.compareTo(nok4) == 0);
	}

}
