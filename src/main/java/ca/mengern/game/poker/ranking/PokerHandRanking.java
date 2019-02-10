package ca.mengern.game.poker.ranking;

import java.util.List;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;

public abstract class PokerHandRanking<T extends PokerHandRanking<?>> implements Comparable<PokerHandRanking<?>> {

	private PokerHandRankingType handRankingType;

	public PokerHandRanking(PokerHandRankingType handRankingType) {
		super();
		this.handRankingType = handRankingType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(PokerHandRanking<?> otherHand) {
		if (!otherHand.getHandRankingType().equals(handRankingType)) {
			return handRankingType.compareTo(otherHand.getHandRankingType());
		}

		return compareSameHandType((T) otherHand);
	}

	public PokerHandRankingType getHandRankingType() {
		return handRankingType;
	}

	protected abstract int compareSameHandType(T otherHand);

	protected int compareRemainingSortedCards(List<StandardCardRank> sortedHandRanks,
			List<StandardCardRank> otherSortedHandRanks) {

		for (int i = 0; i < sortedHandRanks.size(); i++) {
			StandardCardRank thisIthCardRank = sortedHandRanks.get(i);
			StandardCardRank otherIthCardRank = otherSortedHandRanks.get(i);

			if (!thisIthCardRank.equals(otherIthCardRank)) {
				return thisIthCardRank.compareTo(otherIthCardRank);
			}
		}

		return 0;
	}
}
