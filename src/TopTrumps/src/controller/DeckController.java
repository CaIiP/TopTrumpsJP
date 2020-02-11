package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Card;

public class DeckController {
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
        System.out.println("Unshuffled deck:");
        System.out.println();
        for (String line : lines) {
            if (firstRun) {
                firstRun = false;
                continue;
            }
            System.out.println(line);
            deck.add(new Card(line));
        } 
	}
	
	public void shuffleDeck(ArrayList<Card> deck) {
        int packLength = deck.size();
        int[] undeskOfArray = new int[packLength];
        for (int i = 0; i < packLength; i++) {undeskOfArray[i] = i;}

        for (int i = 0; i < packLength; i++) {
            int rand = i + (int) (Math.random() * (packLength - i));
            int randomElement = undeskOfArray[rand];
            undeskOfArray[rand] = undeskOfArray[i];
            undeskOfArray[i] = randomElement;
        }
        ArrayList<Card> packOfCards = new ArrayList<Card>();
        for (int i = 0; i < packLength; i++) {
            packOfCards.add(deck.get(undeskOfArray[i]));
        }
        deck = packOfCards;
        boolean firstRun = true;
        System.out.println();
        System.out.println("Shuffled deck:");
        System.out.println();
        for (Card line : deck ) {
            if (firstRun) {
                firstRun = false;
                continue;
            }           
            System.out.println(line.getName()+" "+line.getSize()+" "+line.getSpeed()+" "+line.getRange()+" "+line.getFirepower()+" "+line.getCargo());
        } 
        System.out.println();
    }
}
