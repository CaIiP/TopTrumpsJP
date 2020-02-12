package controller;

import model.Card;
import model.Player;

public class PlayerController {
	
	public void giveCard(Card newCard,Player player) {
		Card[] newHand = new Card[player.getHand().length + 1];
		System.arraycopy(player.getHand(), 0, newHand, 0, player.getHand().length);
		newHand[player.getHand().length] = newCard;
		player.setHand(newHand);;
	}

}
