package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import poker.card.Rank;

public class RankTest {

	@Test
	public void compareRanks() {
		assertTrue("ACE is higher than KING", Rank.ACE.compareTo(Rank.KING) > 0);
		assertTrue("KING is lower than ACE", Rank.KING.compareTo(Rank.ACE) < 0);
		assertTrue("ACE is higher than TWO", Rank.ACE.compareTo(Rank.TWO) > 0);
		assertTrue("TWO is lower than JACK", Rank.TWO.compareTo(Rank.JACK) < 0);
		assertTrue("THREE is before FOUR", Rank.THREE.isBefore(Rank.FOUR));
		assertTrue("QUEEN is after JACK", Rank.QUEEN.isAfter(Rank.JACK));
		assertFalse("QUEEN is not after KING", Rank.QUEEN.isAfter(Rank.KING));
		assertFalse("TWO is not after ACE", Rank.TWO.isAfter(Rank.ACE));
	}
	
	@Test
	public void checkRoyalty() {
		assertTrue("TEN is royal", Rank.TEN.isRoyal());
		assertTrue("JACK is royal", Rank.JACK.isRoyal());
		assertTrue("QUEEN is royal", Rank.QUEEN.isRoyal());
		assertTrue("KING is royal", Rank.KING.isRoyal());
		assertTrue("ACE is royal", Rank.ACE.isRoyal());
		assertFalse("TWO is not royal", Rank.TWO.isRoyal());
		assertFalse("NINE is not royal", Rank.NINE.isRoyal());
	}

}
