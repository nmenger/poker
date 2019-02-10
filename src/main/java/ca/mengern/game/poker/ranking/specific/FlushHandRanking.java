package ca.mengern.game.poker.ranking.specific;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.hand.PokerHandOfCards;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class FlushHandRanking extends PokerHandRanking<FlushHandRanking> {

	private final List<StandardCardRank> sortedHandRanks;

	public FlushHandRanking(List<StandardCardRank> handRanks) {
		super(PokerHandRankingType.FLUSH);

		if (handRanks.size() != PokerHandOfCards.POKER_CARDS) {
			throw new IllegalArgumentException();
		}

		sortedHandRanks = handRanks;
		Collections.sort(sortedHandRanks);
	}

	@Override
	protected int compareSameHandType(FlushHandRanking otherHand) {
		return compareRemainingSortedCards(sortedHandRanks, otherHand.getSortedHandRanks());
	}

	public List<StandardCardRank> getSortedHandRanks() {
		return sortedHandRanks;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		List<StandardCardRank> reversedHandRanks = new ArrayList<StandardCardRank>(sortedHandRanks);
		Collections.reverse(reversedHandRanks);

		int i = 0;
		for (StandardCardRank rank : reversedHandRanks) {
			stringBuilder.append(rank.toString());

			if (i < reversedHandRanks.size() - 1) {
				stringBuilder.append("-");
			}
			i++;
		}

		stringBuilder.append(" FLUSH");

		return stringBuilder.toString();
	}
}
