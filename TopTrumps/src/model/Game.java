package model;

public class Game {
	//Instance variables
    //attributes
	private int numDraws;
	private int numRounds;

	// Constructor
	public Game(int numDraws, int numRounds) {
		this.numDraws = numDraws;
		this.numRounds = numRounds;
	}

	//getters and setters
	public int getNumDraws() {
		return numDraws;
	}

	public void setNumDraws(int numDraws) {
		this.numDraws = numDraws;
	}

	public int getNumRounds() {
		return numRounds;
	}

	public void setNumRounds(int numRounds) {
		this.numRounds = numRounds;
	}
}
