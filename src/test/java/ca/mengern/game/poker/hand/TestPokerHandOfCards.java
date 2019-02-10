package ca.mengern.game.poker.hand;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCard;
import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.cardlibrary.card.standardcard.StandardCardSuit;
import ca.mengern.game.cardlibrary.deck.standarddeck.StandardDeck;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.specific.FlushHandRanking;
import ca.mengern.game.poker.ranking.specific.FourOfAKindHandRanking;
import ca.mengern.game.poker.ranking.specific.FullHouseHandRanking;
import ca.mengern.game.poker.ranking.specific.HighCardHandRanking;
import ca.mengern.game.poker.ranking.specific.PairHandRanking;
import ca.mengern.game.poker.ranking.specific.RoyalFlushHandRanking;
import ca.mengern.game.poker.ranking.specific.StraightFlushHandRanking;
import ca.mengern.game.poker.ranking.specific.StraightHandRanking;
import ca.mengern.game.poker.ranking.specific.ThreeOfAKindHandRanking;
import ca.mengern.game.poker.ranking.specific.TwoPairHandRanking;

class TestPokerHandOfCards {

	private static final StandardCard ACE_SPADES = new StandardCard(StandardCardSuit.SPADE, StandardCardRank.ACE);
	private static final StandardCard ACE_HEARTS = new StandardCard(StandardCardSuit.HEART, StandardCardRank.ACE);
	private static final StandardCard ACE_DIAMONDS = new StandardCard(StandardCardSuit.DIAMOND, StandardCardRank.ACE);
	private static final StandardCard KING_HEARTS = new StandardCard(StandardCardSuit.HEART, StandardCardRank.KING);
	private static final StandardCard QUEEN_HEARTS = new StandardCard(StandardCardSuit.HEART, StandardCardRank.QUEEN);
	private static final StandardCard JACK_HEARTS = new StandardCard(StandardCardSuit.HEART, StandardCardRank.JACK);
	private static final StandardCard TEN_HEARTS = new StandardCard(StandardCardSuit.HEART, StandardCardRank.TEN);
	private static final StandardCard NINE_DIAMONDS = new StandardCard(StandardCardSuit.DIAMOND, StandardCardRank.NINE);
	private static final StandardCard NINE_SPADES = new StandardCard(StandardCardSuit.SPADE, StandardCardRank.NINE);
	private static final StandardCard NINE_CLUBS = new StandardCard(StandardCardSuit.CLUB, StandardCardRank.NINE);
	private static final StandardCard NINE_HEARTS = new StandardCard(StandardCardSuit.HEART, StandardCardRank.NINE);
	private static final StandardCard EIGHT_HEARTS = new StandardCard(StandardCardSuit.HEART, StandardCardRank.EIGHT);
	private static final StandardCard SIX_DIAMONDS = new StandardCard(StandardCardSuit.DIAMOND, StandardCardRank.SIX);
	private static final StandardCard FIVE_DIAMONDS = new StandardCard(StandardCardSuit.DIAMOND, StandardCardRank.FIVE);
	private static final StandardCard FOUR_DIAMONDS = new StandardCard(StandardCardSuit.DIAMOND, StandardCardRank.FOUR);
	private static final StandardCard THREE_DIAMONDS = new StandardCard(StandardCardSuit.DIAMOND,
			StandardCardRank.THREE);
	private static final StandardCard TWO_CLUBS = new StandardCard(StandardCardSuit.CLUB, StandardCardRank.TWO);
	private static final StandardCard TWO_DIAMONDS = new StandardCard(StandardCardSuit.DIAMOND, StandardCardRank.TWO);

	@SuppressWarnings("unused")
	@Test
	void testDrawFromDeck() {

		StandardDeck deck = StandardDeck.buildOrdered52CardDeck();

		new PokerHandOfCards(deck);

		assertTrue("Deck should have 47 cards remaining", deck.size() == 47);
	}

	@Test
	void testNotEnoughCards() {

		// Throws IllegalArgumentException for not enough cards
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new PokerHandOfCards(KING_HEARTS, JACK_HEARTS, TEN_HEARTS, QUEEN_HEARTS),
				"This poker hand does not have 5 cards");
	}

	@Test
	void testDuplicateCards() {

		// Throws IllegalArgumentException for duplicate cards
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new PokerHandOfCards(KING_HEARTS, JACK_HEARTS, TEN_HEARTS, QUEEN_HEARTS, QUEEN_HEARTS),
				"This poker hand has duplicate cards");
	}

	@Test
	void testRoyalFlush() {

		PokerHandOfCards hand = new PokerHandOfCards(KING_HEARTS, JACK_HEARTS, TEN_HEARTS, QUEEN_HEARTS, ACE_HEARTS);
		assertTrue("This should be a royal flush", hand.getHandRanking() instanceof RoyalFlushHandRanking);

		hand = new PokerHandOfCards(KING_HEARTS, JACK_HEARTS, TEN_HEARTS, QUEEN_HEARTS, ACE_SPADES);
		assertFalse("This should not be a royal flush", hand.getHandRanking() instanceof RoyalFlushHandRanking);
	}

	@Test
	void testStraightFlush() {

		PokerHandOfCards hand = new PokerHandOfCards(KING_HEARTS, JACK_HEARTS, TEN_HEARTS, QUEEN_HEARTS, NINE_HEARTS);
		PokerHandRanking<?> pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a straight flush", pokerHandRanking instanceof StraightFlushHandRanking);
		assertTrue("The high card rank of this straight flush should be a king",
				((StraightFlushHandRanking) pokerHandRanking).getHighCardRank().equals(StandardCardRank.KING));

		hand = new PokerHandOfCards(ACE_DIAMONDS, TWO_DIAMONDS, THREE_DIAMONDS, FOUR_DIAMONDS, FIVE_DIAMONDS);
		pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a wheel straight flush", pokerHandRanking instanceof StraightFlushHandRanking);
		assertTrue("The high card rank of this straight flush should be a five",
				((StraightFlushHandRanking) pokerHandRanking).getHighCardRank().equals(StandardCardRank.FIVE));

		hand = new PokerHandOfCards(KING_HEARTS, JACK_HEARTS, TEN_HEARTS, QUEEN_HEARTS, EIGHT_HEARTS);
		assertFalse("This should not be a straight flush", hand.getHandRanking() instanceof StraightFlushHandRanking);

		hand = new PokerHandOfCards(ACE_DIAMONDS, TWO_DIAMONDS, THREE_DIAMONDS, FOUR_DIAMONDS, SIX_DIAMONDS);
		assertFalse("This should not be a wheel straight flush",
				hand.getHandRanking() instanceof StraightFlushHandRanking);
	}

	@Test
	void testFourOfAKind() {

		PokerHandOfCards hand = new PokerHandOfCards(KING_HEARTS, NINE_CLUBS, NINE_SPADES, NINE_HEARTS, NINE_DIAMONDS);
		PokerHandRanking<?> pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a four-of-a-kind", pokerHandRanking instanceof FourOfAKindHandRanking);
		assertTrue("The rank of this four-of-a-kind should be a nine",
				((FourOfAKindHandRanking) pokerHandRanking).getFourOfAKindRank().equals(StandardCardRank.NINE));
		assertTrue("The kicker of this four-of-a-kind should be a king",
				((FourOfAKindHandRanking) pokerHandRanking).getKickerRank().equals(StandardCardRank.KING));

		hand = new PokerHandOfCards(KING_HEARTS, NINE_CLUBS, NINE_SPADES, NINE_HEARTS, QUEEN_HEARTS);
		assertFalse("This should not be a four-of-a-kind", hand.getHandRanking() instanceof FourOfAKindHandRanking);
	}

	@Test
	void testFullHouse() {

		PokerHandOfCards hand = new PokerHandOfCards(ACE_HEARTS, NINE_CLUBS, NINE_SPADES, NINE_HEARTS, ACE_DIAMONDS);

		PokerHandRanking<?> pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a full house", pokerHandRanking instanceof FullHouseHandRanking);
		assertTrue("The rank of this full-house's three-of-a-kind should be nine",
				((FullHouseHandRanking) pokerHandRanking).getThreeOfAKindRank().equals(StandardCardRank.NINE));
		assertTrue("The rank of this full-house's pair should be ace",
				((FullHouseHandRanking) pokerHandRanking).getPairRank().equals(StandardCardRank.ACE));
	}

	@Test
	void testFlush() {

		PokerHandOfCards hand = new PokerHandOfCards(KING_HEARTS, JACK_HEARTS, TEN_HEARTS, QUEEN_HEARTS, EIGHT_HEARTS);
		assertTrue("This should be a flush", hand.getHandRanking() instanceof FlushHandRanking);
	}

	@Test
	void testStraight() {

		PokerHandOfCards hand = new PokerHandOfCards(KING_HEARTS, JACK_HEARTS, TEN_HEARTS, QUEEN_HEARTS, NINE_CLUBS);

		PokerHandRanking<?> pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a straight", pokerHandRanking instanceof StraightHandRanking);
		assertTrue("The high card rank of this straight should be a king",
				((StraightHandRanking) pokerHandRanking).getHighCardRank().equals(StandardCardRank.KING));

		hand = new PokerHandOfCards(ACE_HEARTS, TWO_DIAMONDS, THREE_DIAMONDS, FOUR_DIAMONDS, FIVE_DIAMONDS);
		pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a wheel straight", pokerHandRanking instanceof StraightHandRanking);
		assertTrue("The high card rank of this straight should be a five",
				((StraightHandRanking) pokerHandRanking).getHighCardRank().equals(StandardCardRank.FIVE));
	}

	@Test
	void testThreeOfAKind() {

		PokerHandOfCards hand = new PokerHandOfCards(KING_HEARTS, NINE_CLUBS, QUEEN_HEARTS, NINE_HEARTS, NINE_DIAMONDS);

		PokerHandRanking<?> pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a three-of-a-kind", pokerHandRanking instanceof ThreeOfAKindHandRanking);
		assertTrue("The rank of this three-of-a-kind should be nine",
				((ThreeOfAKindHandRanking) pokerHandRanking).getThreeOfAKindRank().equals(StandardCardRank.NINE));
	}

	@Test
	void testTwoPair() {

		PokerHandOfCards hand = new PokerHandOfCards(ACE_HEARTS, NINE_CLUBS, QUEEN_HEARTS, NINE_HEARTS, ACE_DIAMONDS);

		PokerHandRanking<?> pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a two-pair", pokerHandRanking instanceof TwoPairHandRanking);
		assertTrue("The rank of the high pair should be ace",
				((TwoPairHandRanking) pokerHandRanking).getHighPairRank().equals(StandardCardRank.ACE));
		assertTrue("The rank of the low pair should be nine",
				((TwoPairHandRanking) pokerHandRanking).getLowPairRank().equals(StandardCardRank.NINE));
		assertTrue("The rank of the kicker should be queen",
				((TwoPairHandRanking) pokerHandRanking).getKickerRank().equals(StandardCardRank.QUEEN));
	}

	@Test
	void testPair() {

		PokerHandOfCards hand = new PokerHandOfCards(ACE_HEARTS, NINE_CLUBS, QUEEN_HEARTS, NINE_HEARTS, TWO_CLUBS);

		PokerHandRanking<?> pokerHandRanking = hand.getHandRanking();
		assertTrue("This should be a two-pair", pokerHandRanking instanceof PairHandRanking);
		assertTrue("The rank of high pair should be nine",
				((PairHandRanking) pokerHandRanking).getPairRank().equals(StandardCardRank.NINE));
	}

	@Test
	void testHighCard() {

		PokerHandOfCards hand = new PokerHandOfCards(ACE_HEARTS, NINE_CLUBS, QUEEN_HEARTS, THREE_DIAMONDS, TWO_CLUBS);

		assertTrue("This should be a pair", hand.getHandRanking() instanceof HighCardHandRanking);
	}

}
