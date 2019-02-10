package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestStraightFlushHandRanking extends TestHandRankingSetup {

	@Test
	void testStraightFlushes() {

		assertTrue("King high straight flush should be better",
				STRAIGHT_FLUSH_KING_HIGH.compareTo(STRAIGHT_FLUSH_9_HIGH) > 0);
	}

	@Test
	void testStraightFlushBetterThanFourOfAKind() {

		assertTrue("Straight flushes should be better",
				STRAIGHT_FLUSH_KING_HIGH.compareTo(FOUR_OF_A_KIND_FOURS_TWO_KICKER) > 0);
	}

	@Test
	void testToString() {
		assertEquals("STRAIGHT FLUSH: KING HIGH", STRAIGHT_FLUSH_KING_HIGH.toString());
	}
}
