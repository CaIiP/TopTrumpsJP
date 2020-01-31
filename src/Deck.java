package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Deck {
	private ArrayList<String> lines = new ArrayList<String>();
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck()	{
		try (BufferedReader br = new BufferedReader(new FileReader("StarCitizenDeck.txt")))	{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}
		}
		catch (IOException e)	{
			e.printStackTrace();
		}
		boolean firstRun = true;
		for (String line : lines) {
			if (firstRun) {
				firstRun = false;
				continue;
			}
			System.out.println(line);
			deck.add(new Card(line));
		} 
	}
}
