package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Flush;
import poker.hand.Hand;
import poker.hand.HandStrength;

public class FlushTest {
	
	private static Hand testHand1 = new Hand(
			new Card(Rank.ACE, Suit.CLUBS),
			new Card(Rank.TWO, Suit.CLUBS),
			new Card(Rank.ACE, Suit.CLUBS),
			new Card(Rank.JACK, Suit.CLUBS),
			new Card(Rank.QUEEN, Suit.CLUBS)
			);
	
	private static Hand testHand2 = new Hand(
			new Card(Rank.THREE, Suit.SPADES),
			new Card(Rank.TWO, Suit.SPADES),
			new Card(Rank.ACE, Suit.SPADES),
			new Card(Rank.QUEEN, Suit.SPADES),
			new Card(Rank.ACE, Suit.SPADES)
			);
	
	private static Hand testHand3 = new Hand(
			new Card(Rank.THREE, Suit.HEARTS),
			new Card(Rank.TWO, Suit.HEARTS),
			new Card(Rank.ACE, Suit.HEARTS),
			new Card(Rank.QUEEN, Suit.HEARTS),
			new Card(Rank.FOUR, Suit.HEARTS)
			);

	@Test
	public void testFlush() {
		List<Rank> r1 = new ArrayList<Rank>();
		testHand1.getSuit(Suit.CLUBS, r1);
		Flush f1 = new Flush(HandStrength.Value.FLUSH, r1);
		
		List<Rank> r2 = new ArrayList<Rank>();
		testHand2.getSuit(Suit.SPADES, r2);
		Flush f2 = new Flush(HandStrength.Value.FLUSH, r2);
		
		List<Rank> r3 = new ArrayList<Rank>();
		testHand3.getSuit(Suit.HEARTS, r3);
		Flush f3 = new Flush(HandStrength.Value.FLUSH, r3);
		
		assertTrue("Hand 1 is stronger than hand 2", f1.compareTo(f2) > 0);
		assertTrue("Hand 2 is stronger than hand 3", f2.compareTo(f3) > 0);
		assertTrue("Hand 1 is stronger than hand 3", f1.compareTo(f3) > 0);
	}

}
