package ca.mengern.game.poker.ranking.specific;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;

class TestHighCardHandRanking extends TestHandRankingSetup {

	@Test
	void testHighCard() {

		assertTrue("Higher kicker should be better",
				HIGH_CARD_KING_QUEEN_FIVE_FOUR_TWO.compareTo(HIGH_CARD_KING_JACK_FIVE_FOUR_TWO) > 0);
	}

	@SuppressWarnings("serial")
	@Test
	void testIllegalHighCard() {

		// Throws IllegalArgumentException for not enough cards
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new HighCardHandRanking(new ArrayList<StandardCardRank>() {
					{
						add(StandardCardRank.QUEEN);
						add(StandardCardRank.ACE);
						add(StandardCardRank.THREE);
						add(StandardCardRank.KING);
					};
				}), "This high card does not have 5 cards");
	}

	@Test
	void testToString() {
		assertEquals("HIGH CARD: KING-QUEEN-FIVE-FOUR-TWO", HIGH_CARD_KING_QUEEN_FIVE_FOUR_TWO.toString());
	}
}
