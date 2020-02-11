package model;

public class Round {
	//Instance variables
    //attributes
	private int ATTR = 5;
	private final Player[] players;
	private Card[] Cards;
	private int Index;
	private CommunalPile pile;
	private Player winner = null;
	private final Deck deck;
	private boolean draw = false;
	private int[] prevValues;
	
	// Constructor
	public Round(Player[] playersArray, Player CurrentDecidingPlayer, CommunalPile communalPipe, int Index, Deck deck,
			int numCards) {
		this.players = playersArray;
		this.deck = deck;
		this.pile = communalPipe;
		prevValues = new int[players.length];
	}
	
	//getters and setters
	public Player[] getPlayers() {
		return players;
	}

	public Deck getDeck() {
		return deck;
	}

	public CommunalPile getPile() {
		return pile;
	}

	public Player getWinner() {
		return winner;
	}

	public boolean isDraw() {
		return draw;
	}

	public void setIndex(int index) {
		Index = index;
	}
	
	public int getATTR() {
		return ATTR;
	}
	
	public int getIndex() {
		return Index;
	}
	
	public int[] getPrevValues() {
		return prevValues;
	}

	public void setPrevValues(int[] prevValues) {
		this.prevValues = prevValues;
	}
	
	public Card[] getCards() {
		return Cards;
	}

	public void setCards(Card[] cards) {
		Cards = cards;
	}

	public void setDraw(boolean draw) {
		this.draw = draw;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public void setPile(CommunalPile pile) {
		this.pile = pile;
	}
	
	
	
	


}
