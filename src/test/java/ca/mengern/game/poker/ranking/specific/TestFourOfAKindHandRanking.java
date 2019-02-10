package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestFourOfAKindHandRanking extends TestHandRankingSetup {

	@Test
	void testFourOfAKinds() {

		assertTrue("Higher four of a kind should be better",
				FOUR_OF_A_KIND_KINGS_TWO_KICKER.compareTo(FOUR_OF_A_KIND_FOURS_TWO_KICKER) > 0);

		assertTrue("Four of a kind higher kicker should be better",
				FOUR_OF_A_KIND_KINGS_ACE_KICKER.compareTo(FOUR_OF_A_KIND_KINGS_TWO_KICKER) > 0);
	}

	@Test
	void testFourOfAKindBetterThanFullHouse() {

		assertTrue("Four of a kind should be better",
				FOUR_OF_A_KIND_FOURS_TWO_KICKER.compareTo(FULL_HOUSE_ACES_OVER_KINGS) > 0);
	}

	@Test
	void testToString() {
		assertEquals("FOUR OF A KIND: KINGS WITH A TWO KICKER", FOUR_OF_A_KIND_KINGS_TWO_KICKER.toString());
	}
}
