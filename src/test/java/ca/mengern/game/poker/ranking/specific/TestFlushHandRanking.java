package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;

class TestFlushHandRanking extends TestHandRankingSetup {

	@Test
	void testFlushes() {

		assertTrue("Higher mid kicker flush is better",
				FLUSH_ACE_KING_FIVE_THREE_TWO_FLUSH.compareTo(FLUSH_ACE_KING_FOUR_THREE_TWO_FLUSH) > 0);

		assertTrue("Same flush mid kicker flush is better",
				FLUSH_ACE_KING_FIVE_THREE_TWO_FLUSH.compareTo(FLUSH_ACE_KING_FOUR_THREE_TWO_FLUSH) > 0);
	}

	@Test
	void testFlushBetterThanStraight() {

		assertTrue("Flush should be better than straight",
				FLUSH_ACE_KING_FIVE_THREE_TWO_FLUSH.compareTo(STRAIGHT_9_HIGH) > 0);
	}

	@SuppressWarnings("serial")
	@Test
	void testIllegalFlush() {

		// Throws IllegalArgumentException for not enough cards
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new FlushHandRanking(new ArrayList<StandardCardRank>() {
					{
						add(StandardCardRank.FOUR);
						add(StandardCardRank.ACE);
						add(StandardCardRank.THREE);
						add(StandardCardRank.KING);
					};
				}), "This flush hand ranking does not have 5 cards");
	}

	@Test
	void testToString() {
		assertEquals("ACE-KING-FIVE-THREE-TWO FLUSH", FLUSH_ACE_KING_FIVE_THREE_TWO_FLUSH.toString());
	}
}
