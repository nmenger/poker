package ca.mengern.game.poker.ranking.specific;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class FourOfAKindHandRanking extends PokerHandRanking<FourOfAKindHandRanking> {

	private final StandardCardRank fourOfAKindRank;
	private final StandardCardRank kickerRank;

	public FourOfAKindHandRanking(StandardCardRank fourOfAKindRank, StandardCardRank kickerRank) {
		super(PokerHandRankingType.FOUR_OF_A_KIND);

		this.fourOfAKindRank = fourOfAKindRank;
		this.kickerRank = kickerRank;
	}

	@Override
	protected int compareSameHandType(FourOfAKindHandRanking otherHand) {
		// Compare the four-of-a-kind first, then compare the remaining high card
		if (!otherHand.getFourOfAKindRank().equals(fourOfAKindRank)) {
			return fourOfAKindRank.compareTo(otherHand.getFourOfAKindRank());
		}

		return kickerRank.compareTo(otherHand.getKickerRank());
	}

	public StandardCardRank getFourOfAKindRank() {
		return fourOfAKindRank;
	}

	public StandardCardRank getKickerRank() {
		return kickerRank;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("FOUR OF A KIND: ").append(fourOfAKindRank.toString()).append("S WITH A ")
				.append(kickerRank.toString()).append(" KICKER");

		return stringBuilder.toString();
	}
}
