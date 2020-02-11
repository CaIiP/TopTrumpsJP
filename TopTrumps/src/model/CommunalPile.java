package model;


public class CommunalPile {
	//Instance variables
    //attributes
	private Card[] cards;

	// Constructor
	public CommunalPile() {
		this.cards = new Card[0];
	}
	
	//getters and setters 
	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

}
