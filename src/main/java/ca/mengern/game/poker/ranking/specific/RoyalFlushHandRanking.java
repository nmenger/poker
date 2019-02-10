package ca.mengern.game.poker.ranking.specific;

import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class RoyalFlushHandRanking extends PokerHandRanking<RoyalFlushHandRanking> {

	public RoyalFlushHandRanking() {
		super(PokerHandRankingType.ROYAL_FLUSH);
	}

	@Override
	protected int compareSameHandType(RoyalFlushHandRanking otherHand) {
		// All royal flushes are the same rank
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("ROYAL FLUSH");

		return stringBuilder.toString();
	}
}
