package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Hand;

public class HandTest {
	
	private static Hand testHand = new Hand(
			new Card(Rank.ACE, Suit.CLUBS),
			new Card(Rank.TWO, Suit.CLUBS),
			new Card(Rank.ACE, Suit.SPADES),
			new Card(Rank.JACK, Suit.SPADES),
			new Card(Rank.QUEEN, Suit.DIAMONDS)
			);

	@Test
	public void testSuits() {
		Hand hand = testHand;
		List<Rank> check = new ArrayList<Rank>();
		
		hand.getSuit(Suit.CLUBS, check);
		assertTrue("Hand contains TWO of CLUBS", check.contains(Rank.TWO));
		assertFalse("Hand does not contain JACK of CLUBS", check.contains(Rank.JACK));
		check.clear();
		
		hand.getSuit(Suit.DIAMONDS, check);
		assertTrue("Hand contains QUEEN of DIAMONDS", check.contains(Rank.QUEEN));
		assertFalse("Hand does not contain JACK of DIAMONDS", check.contains(Rank.JACK));
		check.clear();
		
		hand.getSuit(Suit.HEARTS, check);
		assertEquals("There are no HEARTS in the hand", check.size(), 0);
	}
	
	@Test
	public void testRank() {
		Hand hand = testHand;

		assertEquals("Hand contains 1 JACK", hand.countRank(Rank.JACK), 1);
		assertEquals("Hand contains 0 KINGs", hand.countRank(Rank.KING), 0);
		assertEquals("Hand contains 2 ACEs", hand.countRank(Rank.ACE), 2);
	}

}
