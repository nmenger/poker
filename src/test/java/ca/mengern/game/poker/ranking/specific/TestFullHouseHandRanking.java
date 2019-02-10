package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestFullHouseHandRanking extends TestHandRankingSetup {
	@Test
	void testFullHouses() {

		assertTrue("Higher full house should be better",
				FULL_HOUSE_ACES_OVER_KINGS.compareTo(FULL_HOUSE_ACES_OVER_TWOS) > 0);

		assertTrue("Higher full house should be better",
				FULL_HOUSE_ACES_OVER_KINGS.compareTo(FULL_HOUSE_FOURS_OVER_KINGS) > 0);
	}

	@Test
	void testFullHouseBetterThanFlush() {

		assertTrue("Full house should be better than flush",
				FULL_HOUSE_ACES_OVER_KINGS.compareTo(FLUSH_ACE_KING_FIVE_THREE_TWO_FLUSH) > 0);
	}

	@Test
	void testToString() {
		assertEquals("FULL HOUSE: ACES OVER KINGS", FULL_HOUSE_ACES_OVER_KINGS.toString());
	}
}
