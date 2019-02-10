package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;

class TestPairHandRanking extends TestHandRankingSetup {

	@Test
	void testPairs() {

		assertTrue("Higher pair should be better",
				PAIR_ACES_FIVE_FOUR_THREE_KICKER.compareTo(PAIR_KINGS_FIVE_FOUR_THREE_KICKER) > 0);

		assertTrue("Higher kickers should be better",
				PAIR_KINGS_FIVE_FOUR_THREE_KICKER.compareTo(PAIR_KINGS_FIVE_FOUR_TWO_KICKER) > 0);
	}

	@SuppressWarnings("serial")
	@Test
	void testIllegalPair() {

		// Throws IllegalArgumentException for not enough cards
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new PairHandRanking(StandardCardRank.ACE, new ArrayList<StandardCardRank>() {
					{
						add(StandardCardRank.ACE);
						add(StandardCardRank.THREE);
						add(StandardCardRank.KING);
						add(StandardCardRank.FOUR);
					};
				}), "This pair does not have 3 extra cards");
	}

	@Test
	void testPairBetterThanHighCard() {

		assertTrue("Pair should be better than high card",
				PAIR_ACES_FIVE_FOUR_THREE_KICKER.compareTo(HIGH_CARD_KING_JACK_FIVE_FOUR_TWO) > 0);
	}

	@Test
	void testToString() {
		assertEquals("PAIR OF ACES WITH FIVE-FOUR-THREE KICKER", PAIR_ACES_FIVE_FOUR_THREE_KICKER.toString());
	}
}
