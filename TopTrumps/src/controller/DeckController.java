package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Card;

public class DeckController {
	//Constructor and load the deck in the game
	public void generateDeck(ArrayList<String> lines,ArrayList<Card> deck) {
		try (BufferedReader br = new BufferedReader(new FileReader("StarCitizenDeck.txt")))	{
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                lines.add(sCurrentLine);
            }
        }catch (IOException e)	{
            e.printStackTrace();
        }
        boolean firstRun = true;
        //System.out.println("Unshuffled deck:");
        //System.out.println();
        for (String line : lines) {
            if (firstRun) {
                firstRun = false;
                continue;
            }
            //System.out.println(line);
            deck.add(new Card(line));
        } 
	}
	//function to shuffle the deck after loading
	public void shuffleDeck(ArrayList<Card> deck) {
        int packLength = deck.size(); //size of the original deck loaded to the game
        int[] undeskOfArray = new int[packLength];//an array of integers is created that will be used to shuffle the loaded deck
        for (int i = 0; i < packLength; i++) {undeskOfArray[i] = i;}//the whole array is filled with the same amount as the original deck

        //this for is used to change the order of the integers of the arrangement through the ramdom () function, which is believed to be the way the original deck was lowered
        for (int i = 0; i < packLength; i++) {
            int rand = i + (int) (Math.random() * (packLength - i));
            int randomElement = undeskOfArray[rand];
            undeskOfArray[rand] = undeskOfArray[i];
            undeskOfArray[i] = randomElement;
        }
        //Here the new arrangement to the deck is loaded so that it is now shuffled
        ArrayList<Card> packOfCards = new ArrayList<Card>();
        for (int i = 0; i < packLength; i++) {
            packOfCards.add(deck.get(undeskOfArray[i]));
        }
        deck = packOfCards;
        /*boolean firstRun = true;
        ///System.out.println();
        //System.out.println("Shuffled deck:");
        //System.out.println();
        for (Card line : deck ) {
            if (firstRun) {
                firstRun = false;
                continue;
            }           
            //System.out.println(line.getName()+" "+line.getSize()+" "+line.getSpeed()+" "+line.getRange()+" "+line.getFirepower()+" "+line.getCargo());
        } */
        //System.out.println();
    }
}
