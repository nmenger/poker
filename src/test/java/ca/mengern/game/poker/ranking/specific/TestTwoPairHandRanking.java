package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;

class TestTwoPairHandRanking extends TestHandRankingSetup {

	@Test
	void testTwoPairs() {

		assertTrue("Higher high pair should be better",
				TWO_PAIR_KINGS_FOURS_ACE_KICKER.compareTo(TWO_PAIR_QUEENS_FOURS_ACE_KICKER) > 0);

		assertTrue("Higher low pair should be better",
				TWO_PAIR_QUEENS_FOURS_ACE_KICKER.compareTo(TWO_PAIR_QUEENS_TWOS_ACE_KICKER) > 0);

		assertTrue("Higher kicker should be better",
				TWO_PAIR_QUEENS_TWOS_ACE_KICKER.compareTo(TWO_PAIR_QUEENS_TWOS_FIVE_KICKER) > 0);
	}

	@Test
	void testIllegalTwoPair() {

		// Throws IllegalArgumentException for high and low pair equal
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new TwoPairHandRanking(StandardCardRank.ACE, StandardCardRank.ACE, StandardCardRank.FIVE),
				"This two pair should fail with the high and low pair equal");

		// Throws IllegalArgumentException for low pair higher than high pair
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new TwoPairHandRanking(StandardCardRank.KING, StandardCardRank.ACE, StandardCardRank.FIVE),
				"This two pair should fail with the low pair higher than the high pair");
	}

	@Test
	void testTwoPairBetterThanPair() {

		assertTrue("Two pair should be better than pair",
				TWO_PAIR_KINGS_FOURS_ACE_KICKER.compareTo(PAIR_ACES_FIVE_FOUR_THREE_KICKER) > 0);
	}

	@Test
	void testToString() {
		assertEquals("TWO PAIR: QUEENS AND FOURS WITH ACE KICKER", TWO_PAIR_QUEENS_FOURS_ACE_KICKER.toString());
	}
}
