package controller;

import model.Card;
import model.Player;

public class PlayerController {
	//function used to obtain a letter from the player
	public void giveCard(Card newCard,Player player) {
		Card[] newHand = new Card[player.getHand().length + 1];//a array letter object is created with a player letter
		System.arraycopy(player.getHand(), 0, newHand, 0, player.getHand().length);//all the letters to this new object of the communal pile are copied
		newHand[player.getHand().length] = newCard;//new cards are assigned
		player.setHand(newHand);//and then we assign this new arrangement to the communal pile
	}

}
