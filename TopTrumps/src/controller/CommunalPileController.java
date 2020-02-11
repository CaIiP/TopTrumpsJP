package controller;

import model.Card;
import model.CommunalPile;

public class CommunalPileController {
	//function used to obtain a letter from the communal pile
	public void giveCard(Card newCard,CommunalPile cp) {
		Card[] newHand = new Card[cp.getCards().length + 1];//a array letter object is created with a communal pile letter
		System.arraycopy(cp.getCards(), 0, newHand, 0, cp.getCards().length);//all the letters to this new object of the communal pile are copied
		newHand[cp.getCards().length] = newCard;//new cards are assigned
		cp.setCards(newHand);//and then we assign this new arrangement to the communal pile
	}
}
