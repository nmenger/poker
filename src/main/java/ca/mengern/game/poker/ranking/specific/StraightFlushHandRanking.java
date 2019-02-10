package ca.mengern.game.poker.ranking.specific;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class StraightFlushHandRanking extends PokerHandRanking<StraightFlushHandRanking> {

	private final StandardCardRank highCardRank;

	public StraightFlushHandRanking(StandardCardRank highCardRank) {
		super(PokerHandRankingType.STRAIGHT_FLUSH);

		this.highCardRank = highCardRank;
	}

	@Override
	protected int compareSameHandType(StraightFlushHandRanking otherHand) {
		return highCardRank.compareTo(otherHand.getHighCardRank());
	}

	public StandardCardRank getHighCardRank() {
		return highCardRank;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("STRAIGHT FLUSH: ");

		stringBuilder.append(highCardRank.toString() + " HIGH");

		return stringBuilder.toString();
	}
}
