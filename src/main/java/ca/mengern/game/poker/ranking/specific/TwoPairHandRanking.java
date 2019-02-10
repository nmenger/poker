package ca.mengern.game.poker.ranking.specific;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class TwoPairHandRanking extends PokerHandRanking<TwoPairHandRanking> {

	private final StandardCardRank highPairRank;
	private final StandardCardRank lowPairRank;
	private final StandardCardRank kickerRank;

	public TwoPairHandRanking(StandardCardRank highPairRank, StandardCardRank lowPairRank,
			StandardCardRank kickerRank) {
		super(PokerHandRankingType.TWO_PAIR);

		if (highPairRank.equals(lowPairRank)) {
			throw new IllegalArgumentException("Two pairs cannot be the same rank");
		}
		if (highPairRank.compareTo(lowPairRank) < 0) {
			throw new IllegalArgumentException("High pair cannot be lower than the low pair");
		}

		this.highPairRank = highPairRank;
		this.lowPairRank = lowPairRank;
		this.kickerRank = kickerRank;
	}

	@Override
	protected int compareSameHandType(TwoPairHandRanking otherHand) {
		// Compare the high pair first, then the lower pair, then the kicker
		if (!otherHand.getHighPairRank().equals(highPairRank)) {
			return highPairRank.compareTo(otherHand.getHighPairRank());
		}

		if (!otherHand.getLowPairRank().equals(lowPairRank)) {
			return lowPairRank.compareTo(otherHand.getLowPairRank());
		}

		return kickerRank.compareTo(otherHand.getKickerRank());
	}

	public StandardCardRank getHighPairRank() {
		return highPairRank;
	}

	public StandardCardRank getLowPairRank() {
		return lowPairRank;
	}

	public StandardCardRank getKickerRank() {
		return kickerRank;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("TWO PAIR: ").append(highPairRank.toString()).append("S AND ")
				.append(lowPairRank.toString()).append("S WITH ").append(kickerRank.toString()).append(" KICKER");

		return stringBuilder.toString();
	}
}
