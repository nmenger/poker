package ca.mengern.game.poker.ranking.specific;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class StraightHandRanking extends PokerHandRanking<StraightHandRanking> {

	private final StandardCardRank highCardRank;

	public StraightHandRanking(StandardCardRank highCardRank) {
		super(PokerHandRankingType.STRAIGHT);

		this.highCardRank = highCardRank;
	}

	@Override
	protected int compareSameHandType(StraightHandRanking otherHand) {
		return highCardRank.compareTo(otherHand.getHighCardRank());
	}

	public StandardCardRank getHighCardRank() {
		return highCardRank;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("STRAIGHT: ");

		stringBuilder.append(highCardRank.toString() + " HIGH");

		return stringBuilder.toString();
	}
}
