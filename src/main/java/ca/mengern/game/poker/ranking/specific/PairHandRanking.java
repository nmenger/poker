package ca.mengern.game.poker.ranking.specific;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class PairHandRanking extends PokerHandRanking<PairHandRanking> {

	private static final int REMAINING_CARDS = 3;

	private final StandardCardRank pairRank;
	private final List<StandardCardRank> sortedHandRanks;

	public PairHandRanking(StandardCardRank pairRank, List<StandardCardRank> otherHandRanks) {
		super(PokerHandRankingType.PAIR);

		if (otherHandRanks.size() != REMAINING_CARDS) {
			throw new IllegalArgumentException();
		}

		this.pairRank = pairRank;
		sortedHandRanks = otherHandRanks;
		Collections.sort(sortedHandRanks);
	}

	@Override
	protected int compareSameHandType(PairHandRanking otherHand) {
		// Compare the pair rank first, then compare the remaining cards
		if (!otherHand.getPairRank().equals(pairRank)) {
			return pairRank.compareTo(otherHand.getPairRank());
		}

		return compareRemainingSortedCards(sortedHandRanks, otherHand.getSortedHandRanks());
	}

	public StandardCardRank getPairRank() {
		return pairRank;
	}

	public List<StandardCardRank> getSortedHandRanks() {
		return sortedHandRanks;
	}

	@Override
	public String toString() {
		List<StandardCardRank> reverseSortedHandRanks = new ArrayList<StandardCardRank>(sortedHandRanks);
		Collections.reverse(reverseSortedHandRanks);

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("PAIR OF ").append(pairRank.toString()).append("S WITH ");

		for (StandardCardRank rank : reverseSortedHandRanks) {
			stringBuilder.append(rank.toString()).append("-");
		}

		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append(" KICKER");

		return stringBuilder.toString();
	}
}
