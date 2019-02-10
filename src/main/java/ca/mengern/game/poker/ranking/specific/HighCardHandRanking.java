package ca.mengern.game.poker.ranking.specific;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class HighCardHandRanking extends PokerHandRanking<HighCardHandRanking> {

	private static final int REMAINING_CARDS = 5;

	private final List<StandardCardRank> sortedHandRanks;

	public HighCardHandRanking(List<StandardCardRank> otherHandRanks) {
		super(PokerHandRankingType.HIGH_CARD);

		if (otherHandRanks.size() != REMAINING_CARDS) {
			throw new IllegalArgumentException();
		}

		sortedHandRanks = otherHandRanks;
		Collections.sort(sortedHandRanks);
	}

	@Override
	protected int compareSameHandType(HighCardHandRanking otherHand) {
		return compareRemainingSortedCards(sortedHandRanks, otherHand.getSortedHandRanks());
	}

	public List<StandardCardRank> getSortedHandRanks() {
		return sortedHandRanks;
	}

	@Override
	public String toString() {
		List<StandardCardRank> reverseSortedHandRanks = new ArrayList<StandardCardRank>(sortedHandRanks);
		Collections.reverse(reverseSortedHandRanks);

		StringBuilder stringBuilder = new StringBuilder("HIGH CARD: ");

		for (StandardCardRank rank : reverseSortedHandRanks) {
			stringBuilder.append(rank.toString()).append("-");
		}

		stringBuilder.deleteCharAt(stringBuilder.length() - 1);

		return stringBuilder.toString();
	}
}
