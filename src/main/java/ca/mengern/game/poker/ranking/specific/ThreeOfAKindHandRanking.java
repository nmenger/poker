package ca.mengern.game.poker.ranking.specific;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class ThreeOfAKindHandRanking extends PokerHandRanking<ThreeOfAKindHandRanking> {

	private static final int REMAINING_CARDS = 2;

	private final StandardCardRank threeOfAKindRank;
	private final List<StandardCardRank> sortedHandRanks;

	public ThreeOfAKindHandRanking(StandardCardRank threeOfAKindRank, List<StandardCardRank> otherHandRanks) {
		super(PokerHandRankingType.THREE_OF_A_KIND);

		if (otherHandRanks.size() != REMAINING_CARDS) {
			throw new IllegalArgumentException();
		}

		this.threeOfAKindRank = threeOfAKindRank;
		sortedHandRanks = otherHandRanks;
		Collections.sort(sortedHandRanks);
	}

	@Override
	protected int compareSameHandType(ThreeOfAKindHandRanking otherHand) {
		// Compare the three-of-a-kind first, then compare the remaining cards
		if (!otherHand.getThreeOfAKindRank().equals(threeOfAKindRank)) {
			return threeOfAKindRank.compareTo(otherHand.getThreeOfAKindRank());
		}

		return compareRemainingSortedCards(sortedHandRanks, otherHand.getSortedHandRanks());
	}

	public StandardCardRank getThreeOfAKindRank() {
		return threeOfAKindRank;
	}

	public List<StandardCardRank> getSortedHandRanks() {
		return sortedHandRanks;
	}

	@Override
	public String toString() {
		List<StandardCardRank> reverseSortedHandRanks = new ArrayList<StandardCardRank>(sortedHandRanks);
		Collections.reverse(reverseSortedHandRanks);

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("THREE OF A KIND: ").append(threeOfAKindRank.toString()).append("S WITH ");

		for (StandardCardRank rank : reverseSortedHandRanks) {
			stringBuilder.append(rank.toString()).append("-");
		}

		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append(" KICKER");

		return stringBuilder.toString();
	}
}
