package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;

class TestThreeOfAKindHandRanking extends TestHandRankingSetup {

	@Test
	void testThreeOfAKinds() {

		assertTrue("Higher three of a kind should be better",
				THREE_OF_A_KIND_ACES_FOUR_TWO_KICKER.compareTo(THREE_OF_A_KIND_KINGS_FOUR_THREE_KICKER) > 0);

		assertTrue("Three of a kind higher kicker should be better",
				THREE_OF_A_KIND_ACES_FOUR_THREE_KICKER.compareTo(THREE_OF_A_KIND_ACES_FOUR_TWO_KICKER) > 0);

		assertTrue("Three of a kind same kicker should be the same",
				THREE_OF_A_KIND_ACES_FOUR_THREE_KICKER.compareTo(THREE_OF_A_KIND_ACES_FOUR_THREE_KICKER) == 0);
	}

	@SuppressWarnings("serial")
	@Test
	void testIllegalThreeOfAKind() {

		// Throws IllegalArgumentException for not enough cards
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new ThreeOfAKindHandRanking(StandardCardRank.ACE, new ArrayList<StandardCardRank>() {
					{
						add(StandardCardRank.ACE);
						add(StandardCardRank.THREE);
						add(StandardCardRank.KING);
					};
				}), "This three-of-a-kind does not have 2 extra cards");
	}

	@Test
	void testThreeOfAKindBetterThanTwoPair() {

		assertTrue("Three-of-a-kind should be better than two pair",
				THREE_OF_A_KIND_ACES_FOUR_THREE_KICKER.compareTo(TWO_PAIR_KINGS_FOURS_ACE_KICKER) > 0);
	}

	@Test
	void testToString() {
		assertEquals("THREE OF A KIND: ACES WITH FOUR-TWO KICKER", THREE_OF_A_KIND_ACES_FOUR_TWO_KICKER.toString());
	}
}
