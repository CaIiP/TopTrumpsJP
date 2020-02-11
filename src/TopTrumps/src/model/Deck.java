package model;

import java.util.ArrayList;

public class Deck {
	//Instance variables
    //attributes
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	private String size;
	private String speed;
	private String firepower;
	private String cargo;
	private String range;
	
	// Constructor
	public Deck(ArrayList<Card> deck,String size, String speed, String firepower, String cargo, String range) {
        this.size = size;
        this.speed = speed;
        this.firepower = firepower;
        this.cargo = cargo;
        this.range = range;
        
    }
	
	//getters and setters
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getFirepower() {
		return firepower;
	}

	public void setFirepower(String firepower) {
		this.firepower = firepower;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

}