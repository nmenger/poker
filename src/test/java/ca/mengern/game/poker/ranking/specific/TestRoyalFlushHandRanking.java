package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestRoyalFlushHandRanking extends TestHandRankingSetup {

	@Test
	void testRoyalFlushes() {

		assertTrue("Royal flushes should be equal", ROYAL_FLUSH.compareTo(ROYAL_FLUSH) == 0);
	}

	@Test
	void testRoyalFlushBetterThanStraightFlush() {

		assertTrue("Royal flushes should be better", ROYAL_FLUSH.compareTo(STRAIGHT_FLUSH_KING_HIGH) > 0);
	}

	@Test
	void testToString() {
		assertEquals("ROYAL FLUSH", ROYAL_FLUSH.toString());
	}
}
