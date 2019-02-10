package ca.mengern.game.poker.ranking.specific;

import java.util.ArrayList;

import ca.mengern.game.cardlibrary.card.standardcard.StandardCardRank;

class TestHandRankingSetup {

	protected static final RoyalFlushHandRanking ROYAL_FLUSH = new RoyalFlushHandRanking();

	protected static final StraightFlushHandRanking STRAIGHT_FLUSH_KING_HIGH = new StraightFlushHandRanking(
			StandardCardRank.KING);
	protected static final StraightFlushHandRanking STRAIGHT_FLUSH_9_HIGH = new StraightFlushHandRanking(
			StandardCardRank.NINE);

	protected static final FourOfAKindHandRanking FOUR_OF_A_KIND_KINGS_TWO_KICKER = new FourOfAKindHandRanking(
			StandardCardRank.KING, StandardCardRank.TWO);
	protected static final FourOfAKindHandRanking FOUR_OF_A_KIND_KINGS_ACE_KICKER = new FourOfAKindHandRanking(
			StandardCardRank.KING, StandardCardRank.ACE);
	protected static final FourOfAKindHandRanking FOUR_OF_A_KIND_FOURS_TWO_KICKER = new FourOfAKindHandRanking(
			StandardCardRank.FOUR, StandardCardRank.TWO);

	protected static final FullHouseHandRanking FULL_HOUSE_ACES_OVER_TWOS = new FullHouseHandRanking(
			StandardCardRank.ACE, StandardCardRank.TWO);
	protected static final FullHouseHandRanking FULL_HOUSE_ACES_OVER_KINGS = new FullHouseHandRanking(
			StandardCardRank.ACE, StandardCardRank.KING);
	protected static final FullHouseHandRanking FULL_HOUSE_FOURS_OVER_KINGS = new FullHouseHandRanking(
			StandardCardRank.FOUR, StandardCardRank.KING);

	@SuppressWarnings("serial")
	protected static final FlushHandRanking FLUSH_ACE_KING_FOUR_THREE_TWO_FLUSH = new FlushHandRanking(
			new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.FOUR);
					add(StandardCardRank.ACE);
					add(StandardCardRank.THREE);
					add(StandardCardRank.KING);
					add(StandardCardRank.TWO);
				};
			});

	@SuppressWarnings("serial")
	protected static final FlushHandRanking FLUSH_ACE_KING_FIVE_THREE_TWO_FLUSH = new FlushHandRanking(
			new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.FIVE);
					add(StandardCardRank.ACE);
					add(StandardCardRank.THREE);
					add(StandardCardRank.KING);
					add(StandardCardRank.TWO);
				};
			});

	protected static final StraightHandRanking STRAIGHT_KING_HIGH = new StraightHandRanking(StandardCardRank.KING);
	protected static final StraightHandRanking STRAIGHT_9_HIGH = new StraightHandRanking(StandardCardRank.NINE);

	@SuppressWarnings("serial")
	protected static final ThreeOfAKindHandRanking THREE_OF_A_KIND_ACES_FOUR_TWO_KICKER = new ThreeOfAKindHandRanking(
			StandardCardRank.ACE, new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.FOUR);
					add(StandardCardRank.TWO);
				};
			});

	@SuppressWarnings("serial")
	protected static final ThreeOfAKindHandRanking THREE_OF_A_KIND_ACES_FOUR_THREE_KICKER = new ThreeOfAKindHandRanking(
			StandardCardRank.ACE, new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.FOUR);
					add(StandardCardRank.THREE);
				};
			});

	@SuppressWarnings("serial")
	protected static final ThreeOfAKindHandRanking THREE_OF_A_KIND_KINGS_FOUR_THREE_KICKER = new ThreeOfAKindHandRanking(
			StandardCardRank.KING, new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.FOUR);
					add(StandardCardRank.THREE);
				};
			});

	protected static final TwoPairHandRanking TWO_PAIR_KINGS_FOURS_ACE_KICKER = new TwoPairHandRanking(
			StandardCardRank.KING, StandardCardRank.FOUR, StandardCardRank.ACE);

	protected static final TwoPairHandRanking TWO_PAIR_QUEENS_FOURS_ACE_KICKER = new TwoPairHandRanking(
			StandardCardRank.QUEEN, StandardCardRank.FOUR, StandardCardRank.ACE);

	protected static final TwoPairHandRanking TWO_PAIR_QUEENS_TWOS_ACE_KICKER = new TwoPairHandRanking(
			StandardCardRank.QUEEN, StandardCardRank.TWO, StandardCardRank.ACE);

	protected static final TwoPairHandRanking TWO_PAIR_QUEENS_TWOS_FIVE_KICKER = new TwoPairHandRanking(
			StandardCardRank.QUEEN, StandardCardRank.TWO, StandardCardRank.FIVE);

	@SuppressWarnings("serial")
	protected static final PairHandRanking PAIR_ACES_FIVE_FOUR_THREE_KICKER = new PairHandRanking(StandardCardRank.ACE,
			new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.FIVE);
					add(StandardCardRank.FOUR);
					add(StandardCardRank.THREE);
				};
			});

	@SuppressWarnings("serial")
	protected static final PairHandRanking PAIR_KINGS_FIVE_FOUR_THREE_KICKER = new PairHandRanking(
			StandardCardRank.KING, new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.FIVE);
					add(StandardCardRank.FOUR);
					add(StandardCardRank.THREE);
				};
			});

	@SuppressWarnings("serial")
	protected static final PairHandRanking PAIR_KINGS_FIVE_FOUR_TWO_KICKER = new PairHandRanking(StandardCardRank.KING,
			new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.FIVE);
					add(StandardCardRank.FOUR);
					add(StandardCardRank.TWO);
				};
			});

	@SuppressWarnings("serial")
	protected static final HighCardHandRanking HIGH_CARD_KING_QUEEN_FIVE_FOUR_TWO = new HighCardHandRanking(
			new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.KING);
					add(StandardCardRank.QUEEN);
					add(StandardCardRank.FIVE);
					add(StandardCardRank.FOUR);
					add(StandardCardRank.TWO);
				};
			});

	@SuppressWarnings("serial")
	protected static final HighCardHandRanking HIGH_CARD_KING_JACK_FIVE_FOUR_TWO = new HighCardHandRanking(
			new ArrayList<StandardCardRank>() {
				{
					add(StandardCardRank.KING);
					add(StandardCardRank.JACK);
					add(StandardCardRank.FIVE);
					add(StandardCardRank.FOUR);
					add(StandardCardRank.TWO);
				};
			});
}
