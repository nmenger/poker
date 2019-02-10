package ca.mengern.game.poker.ranking.specific;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;
import ca.mengern.game.poker.ranking.PokerHandRanking;
import ca.mengern.game.poker.ranking.PokerHandRankingType;

public class FullHouseHandRanking extends PokerHandRanking<FullHouseHandRanking> {

	private final StandardCardRank threeOfAKindRank;
	private final StandardCardRank pairRank;

	public FullHouseHandRanking(StandardCardRank threeOfAKindRank, StandardCardRank pairRank) {
		super(PokerHandRankingType.FULL_HOUSE);

		this.threeOfAKindRank = threeOfAKindRank;
		this.pairRank = pairRank;
	}

	@Override
	protected int compareSameHandType(FullHouseHandRanking otherHand) {
		// Compare the three-of-a-kind first, then compare the remaining pair
		if (!otherHand.getThreeOfAKindRank().equals(threeOfAKindRank)) {
			return threeOfAKindRank.compareTo(otherHand.getThreeOfAKindRank());
		}

		return pairRank.compareTo(otherHand.getPairRank());
	}

	public StandardCardRank getThreeOfAKindRank() {
		return threeOfAKindRank;
	}

	public StandardCardRank getPairRank() {
		return pairRank;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("FULL HOUSE: ").append(threeOfAKindRank.toString()).append("S OVER ")
				.append(pairRank.toString()).append("S");

		return stringBuilder.toString();
	}
}
