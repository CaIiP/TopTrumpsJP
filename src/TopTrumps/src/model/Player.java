package model;

public class Player {
	//Instance variables
    //attributes
	private Card[] hand;
	private final String name;
	private boolean keepPlaying;

	// Constructor
	public Player(String name) {
		this.name = name;
		this.hand = new Card[0];
		this.keepPlaying = true;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	public boolean isKeepPlaying() {
		return keepPlaying;
	}

	public void setKeepPlaying(boolean keepPlaying) {
		this.keepPlaying = keepPlaying;
	}
}
