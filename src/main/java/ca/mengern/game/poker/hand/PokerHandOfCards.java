package ca.mengern.game.poker.hand;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCard;
import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.cardlibrary.deck.standarddeck.StandardDeck;
import ca.mengern.game.cardlibrary.hand.standardhand.StandardHandOfCards;
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

public class PokerHandOfCards extends StandardHandOfCards implements Comparable<PokerHandOfCards> {

	public static final int POKER_CARDS = 5;

	private final PokerHandRanking<?> handRanking;

	public PokerHandOfCards(StandardDeck deck) {
		super(deck, POKER_CARDS);

		handRanking = getPokerHandRanking();

		checkInvariant();
	}

	public PokerHandOfCards(StandardCard... cards) {
		super(cards);

		handRanking = getPokerHandRanking();

		checkInvariant();
	}

	public PokerHandRanking<?> getHandRanking() {
		return handRanking;
	}

	@Override
	public int compareTo(PokerHandOfCards otherHand) {
		return handRanking.compareTo(otherHand.getHandRanking());
	}

	private PokerHandRanking<?> getPokerHandRanking() {
		if (isFlush()) {
			if (isRegularStraight(sortedHandRanks)) {
				// Highest card must be an ace and lowest must be a ten
				if (getHighestRank(sortedHandRanks) == StandardCardRank.ACE
						&& sortedHandRanks.get(0) == StandardCardRank.TEN) {
					return new RoyalFlushHandRanking();
				}

				return new StraightFlushHandRanking(getHighestRank(sortedHandRanks));
			} else if (isWheelStraight(sortedHandRanks)) {
				return new StraightFlushHandRanking(StandardCardRank.FIVE);
			}

			return new FlushHandRanking(sortedHandRanks);
		}

		// Not a flush
		if (isRegularStraight(sortedHandRanks)) {
			return new StraightHandRanking(getHighestRank(sortedHandRanks));
		} else if (isWheelStraight(sortedHandRanks)) {
			return new StraightHandRanking(StandardCardRank.FIVE);
		}

		List<StandardCard> possibleFourOfAKind = getFirstBunchOfDuplicates(4);
		if (possibleFourOfAKind != null) {
			// One card will be remaining in this hand of cards
			StandardHandOfCards remainingCards = removeAll(possibleFourOfAKind);

			return new FourOfAKindHandRanking(possibleFourOfAKind.get(0).getRank(),
					StandardHandOfCards.getHighestRank(remainingCards.getSortedHandRanks()));
		}

		List<StandardCard> possibleThreeOfAKind = getFirstBunchOfDuplicates(3);
		if (possibleThreeOfAKind != null) {
			// Two cards will be remaining in this hand of cards
			StandardHandOfCards remainingCards = removeAll(possibleThreeOfAKind);

			// Check the remainder for a pair
			List<StandardCard> possibleRemainingPair = remainingCards.getFirstBunchOfDuplicates(2);
			if (possibleRemainingPair != null) {
				return new FullHouseHandRanking(possibleThreeOfAKind.get(0).getRank(),
						possibleRemainingPair.get(0).getRank());
			}

			return new ThreeOfAKindHandRanking(possibleThreeOfAKind.get(0).getRank(),
					remainingCards.getSortedHandRanks());
		}

		List<StandardCard> possiblePair = getFirstBunchOfDuplicates(2);
		if (possiblePair != null) {
			// Three cards will be remaining in this hand of cards
			StandardHandOfCards remainingCards = removeAll(possiblePair);

			StandardCardRank firstPairRank = possiblePair.get(0).getRank();

			List<StandardCard> possible2ndPair = remainingCards.getFirstBunchOfDuplicates(2);
			if (possible2ndPair != null) {
				// 1 card will be remaining in this hand of cards
				remainingCards = remainingCards.removeAll(possible2ndPair);

				StandardCardRank secondPairRank = possible2ndPair.get(0).getRank();
				StandardCardRank highPairRank = firstPairRank.compareTo(secondPairRank) > 0 ? firstPairRank
						: secondPairRank;
				StandardCardRank lowPairRank = highPairRank.equals(firstPairRank) ? secondPairRank : firstPairRank;

				return new TwoPairHandRanking(highPairRank, lowPairRank,
						StandardHandOfCards.getHighestRank(remainingCards.getSortedHandRanks()));
			}

			return new PairHandRanking(firstPairRank, remainingCards.getSortedHandRanks());

		}

		return new HighCardHandRanking(sortedHandRanks);
	}

	private void checkInvariant() {
		Set<StandardCard> uniqueCards = new HashSet<StandardCard>();
		for (StandardCard card : hand) {
			uniqueCards.add(card);
		}

		if (uniqueCards.size() != POKER_CARDS) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return handRanking.toString();
	}
}
