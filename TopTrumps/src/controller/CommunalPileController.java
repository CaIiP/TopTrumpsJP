package controller;

import model.Card;
import model.CommunalPile;

public class CommunalPileController {
	public void giveCard(Card newCard,CommunalPile cp) {
		Card[] newHand = new Card[cp.getCards().length + 1];
		System.arraycopy(cp.getCards(), 0, newHand, 0, cp.getCards().length);
		newHand[cp.getCards().length] = newCard;
		cp.setCards(newHand);
	}
}
