package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import poker.card.Rank;

public class RankTest {

	@Test
	public void compareRanks() {
		assertTrue(Rank.ACE.compareTo(Rank.KING) > 0); // ACE is higher than KING
		assertTrue(Rank.KING.compareTo(Rank.ACE) < 0); // KING is lower than ACE
		assertTrue(Rank.ACE.compareTo(Rank.TWO) > 0); // ACE is higher than TWO
		assertTrue(Rank.TWO.compareTo(Rank.JACK) < 0); // TWO is lower than JACK
		assertTrue(Rank.THREE.isBefore(Rank.FOUR));
		assertTrue(Rank.QUEEN.isAfter(Rank.JACK));
		assertFalse(Rank.QUEEN.isAfter(Rank.KING));
		assertFalse(Rank.TWO.isAfter(Rank.ACE));
	}

}
