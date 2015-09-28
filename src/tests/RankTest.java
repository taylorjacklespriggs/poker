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
		assertTrue("FOUR is next from THREE", Rank.THREE.isNext(Rank.FOUR));
		assertTrue("JACK is previous from QUEEN", Rank.QUEEN.isPrevious(Rank.JACK));
		assertFalse("KING is not previous to QUEEN", Rank.QUEEN.isPrevious(Rank.KING));
		assertFalse("ACE is not previous to TWO", Rank.TWO.isPrevious(Rank.ACE));
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
