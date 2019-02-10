package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestStraightHandRanking extends TestHandRankingSetup {

	@Test
	void testStraights() {

		assertTrue("King high straight should be better", STRAIGHT_KING_HIGH.compareTo(STRAIGHT_9_HIGH) > 0);
	}

	@Test
	void testStraightBetterThanThreeOfAKind() {

		assertTrue("Straight should be better than three-of-a-kind",
				STRAIGHT_9_HIGH.compareTo(THREE_OF_A_KIND_ACES_FOUR_THREE_KICKER) > 0);
	}

	@Test
	void testToString() {
		assertEquals("STRAIGHT: KING HIGH", STRAIGHT_KING_HIGH.toString());
	}
}
