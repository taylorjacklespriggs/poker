package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.hand.Hand;

public class ComparisonTest {
	
	// ROYAL FLUSH
	private static Hand royalFlush = new Hand(
			new Card(Rank.ACE, Suit.CLUBS),
			new Card(Rank.KING, Suit.CLUBS),
			new Card(Rank.JACK, Suit.CLUBS),
			new Card(Rank.QUEEN, Suit.CLUBS),
			new Card(Rank.TEN, Suit.CLUBS)
			);
	
	// STRAIGHT FLUSH
	private static Hand straightFlush1 = new Hand(
			new Card(Rank.NINE, Suit.DIAMONDS),
			new Card(Rank.KING, Suit.DIAMONDS),
			new Card(Rank.JACK, Suit.DIAMONDS),
			new Card(Rank.QUEEN, Suit.DIAMONDS),
			new Card(Rank.TEN, Suit.DIAMONDS)
			);
	
	// STRAIGHT FLUSH
	private static Hand straightFlush2 = new Hand(
			new Card(Rank.SEVEN, Suit.DIAMONDS),
			new Card(Rank.NINE, Suit.DIAMONDS),
			new Card(Rank.EIGHT, Suit.DIAMONDS),
			new Card(Rank.SIX, Suit.DIAMONDS),
			new Card(Rank.FIVE, Suit.DIAMONDS)
			);
	
	// FOUR OF A KIND
	private static Hand fourOfAKind1 = new Hand(
			new Card(Rank.SEVEN, Suit.DIAMONDS),
			new Card(Rank.SEVEN, Suit.SPADES),
			new Card(Rank.SEVEN, Suit.HEARTS),
			new Card(Rank.SEVEN, Suit.CLUBS),
			new Card(Rank.FIVE, Suit.DIAMONDS)
			);
	
	// FOUR OF A KIND
	private static Hand fourOfAKind2 = new Hand(
			new Card(Rank.SIX, Suit.DIAMONDS),
			new Card(Rank.SIX, Suit.SPADES),
			new Card(Rank.SIX, Suit.HEARTS),
			new Card(Rank.SIX, Suit.CLUBS),
			new Card(Rank.FIVE, Suit.CLUBS)
			);
	
	// FULL HOUSE
	private static Hand fullHouse1 = new Hand(
			new Card(Rank.ACE, Suit.DIAMONDS),
			new Card(Rank.ACE, Suit.SPADES),
			new Card(Rank.ACE, Suit.HEARTS),
			new Card(Rank.FIVE, Suit.DIAMONDS),
			new Card(Rank.FIVE, Suit.SPADES)
			);
	
	// FULL HOUSE
	private static Hand fullHouse2 = new Hand(
			new Card(Rank.SIX, Suit.DIAMONDS),
			new Card(Rank.SIX, Suit.SPADES),
			new Card(Rank.SIX, Suit.HEARTS),
			new Card(Rank.FIVE, Suit.HEARTS),
			new Card(Rank.FIVE, Suit.CLUBS)
			);
	
	// FLUSH
	private static Hand flush1 = new Hand(
			new Card(Rank.NINE, Suit.DIAMONDS),
			new Card(Rank.KING, Suit.DIAMONDS),
			new Card(Rank.TWO, Suit.DIAMONDS),
			new Card(Rank.QUEEN, Suit.DIAMONDS),
			new Card(Rank.TEN, Suit.DIAMONDS)
			);
	
	// FLUSH
	private static Hand flush2 = new Hand(
			new Card(Rank.SEVEN, Suit.HEARTS),
			new Card(Rank.SIX, Suit.HEARTS),
			new Card(Rank.EIGHT, Suit.HEARTS),
			new Card(Rank.FIVE, Suit.HEARTS),
			new Card(Rank.THREE, Suit.HEARTS)
			);
	
	// STRAIGHT
	private static Hand straight1 = new Hand(
			new Card(Rank.JACK, Suit.DIAMONDS),
			new Card(Rank.NINE, Suit.DIAMONDS),
			new Card(Rank.TEN, Suit.CLUBS),
			new Card(Rank.QUEEN, Suit.DIAMONDS),
			new Card(Rank.EIGHT, Suit.DIAMONDS)
			);
	
	// STRAIGHT
	private static Hand straight2 = new Hand(
			new Card(Rank.TWO, Suit.DIAMONDS),
			new Card(Rank.FIVE, Suit.HEARTS),
			new Card(Rank.THREE, Suit.DIAMONDS),
			new Card(Rank.FOUR, Suit.CLUBS),
			new Card(Rank.SIX, Suit.DIAMONDS)
			);
	
	// THREE OF A KIND
	private static Hand threeOfAKind1 = new Hand(
			new Card(Rank.SEVEN, Suit.DIAMONDS),
			new Card(Rank.SEVEN, Suit.SPADES),
			new Card(Rank.SEVEN, Suit.HEARTS),
			new Card(Rank.SIX, Suit.CLUBS),
			new Card(Rank.FIVE, Suit.DIAMONDS)
			);
	
	// THREE OF A KIND
	private static Hand threeOfAKind2 = new Hand(
			new Card(Rank.SIX, Suit.DIAMONDS),
			new Card(Rank.SIX, Suit.SPADES),
			new Card(Rank.SIX, Suit.HEARTS),
			new Card(Rank.TEN, Suit.CLUBS),
			new Card(Rank.FIVE, Suit.CLUBS)
			);
	
	// 2 PAIR
	private static Hand twoPair1 = new Hand(
			new Card(Rank.SEVEN, Suit.DIAMONDS),
			new Card(Rank.SEVEN, Suit.SPADES),
			new Card(Rank.THREE, Suit.HEARTS),
			new Card(Rank.THREE, Suit.CLUBS),
			new Card(Rank.FIVE, Suit.DIAMONDS)
			);
	
	// 2 PAIR
	private static Hand twoPair2 = new Hand(
			new Card(Rank.SEVEN, Suit.CLUBS),
			new Card(Rank.SEVEN, Suit.HEARTS),
			new Card(Rank.THREE, Suit.DIAMONDS),
			new Card(Rank.THREE, Suit.SPADES),
			new Card(Rank.FOUR, Suit.CLUBS)
			);
	
	// 1 PAIR
	private static Hand onePair1 = new Hand(
			new Card(Rank.SEVEN, Suit.DIAMONDS),
			new Card(Rank.SEVEN, Suit.SPADES),
			new Card(Rank.TWO, Suit.HEARTS),
			new Card(Rank.THREE, Suit.CLUBS),
			new Card(Rank.ACE, Suit.DIAMONDS)
			);
	
	// 1 PAIR
	private static Hand onePair2 = new Hand(
			new Card(Rank.SEVEN, Suit.CLUBS),
			new Card(Rank.SEVEN, Suit.HEARTS),
			new Card(Rank.SIX, Suit.DIAMONDS),
			new Card(Rank.THREE, Suit.SPADES),
			new Card(Rank.FOUR, Suit.CLUBS)
			);
	
	// HIGH CARD
	private static Hand highCard1 = new Hand(
			new Card(Rank.ACE, Suit.CLUBS),
			new Card(Rank.SEVEN, Suit.HEARTS),
			new Card(Rank.SIX, Suit.DIAMONDS),
			new Card(Rank.THREE, Suit.SPADES),
			new Card(Rank.FOUR, Suit.CLUBS)
			);
	
	// 1 PAIR
	private static Hand highCard2 = new Hand(
			new Card(Rank.TEN, Suit.CLUBS),
			new Card(Rank.TWO, Suit.HEARTS),
			new Card(Rank.FIVE, Suit.DIAMONDS),
			new Card(Rank.NINE, Suit.SPADES),
			new Card(Rank.THREE, Suit.CLUBS)
			);
	

	@Test
	public void testComparison() {
		Hand[] sorted = new Hand[] {
				royalFlush, straightFlush1, straightFlush2,
				fourOfAKind1, fourOfAKind2, fullHouse1, fullHouse2,
				flush1, flush2, straight1, straight2,
				threeOfAKind1, threeOfAKind2, twoPair1, twoPair2,
				onePair1, onePair2, highCard1, highCard2
		};
		ArrayList<Hand> hands = new ArrayList<Hand>();
		for(int i = sorted.length - 1; i >= 0; --i)
			hands.add(sorted[i]);
		hands.sort(new Comparator<Hand>() {
			@Override
			public int compare(Hand h1, Hand h2) {
				return -h1.compareTo(h2); // highest to lowest
			}
		});
		for(int i = 0; i < sorted.length; ++i) {
			Hand h1, h2;
			h1 = sorted[i];
			h2 = hands.get(i);
			assertEquals("The list is sorted", h1, h2);
		}
	}

}
