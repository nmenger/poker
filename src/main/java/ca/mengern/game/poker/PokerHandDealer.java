package ca.mengern.game.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.mengern.game.cardlibrary.deck.standarddeck.StandardDeck;
import ca.mengern.game.poker.hand.PokerHandOfCards;

public class PokerHandDealer {

	public static void main(String[] args) {
		compareXHands(10);
	}

	private static void compareXHands(int numHands) {
		StandardDeck deck = StandardDeck.buildOrdered52CardDeck();

		deck.shuffle();

		List<PokerHandOfCards> listOfHands = new ArrayList<PokerHandOfCards>();
		for (int i = 0; i < numHands; i++) {
			listOfHands.add(new PokerHandOfCards(deck));
		}

		Collections.sort(listOfHands);

		System.out.println(numHands + " hands were drawn");
		System.out.println("The best hand is " + listOfHands.get(listOfHands.size() - 1));
		System.out.println("The worst hand is " + listOfHands.get(0));
	}
}
