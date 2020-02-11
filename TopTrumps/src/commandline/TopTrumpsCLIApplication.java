package commandline;

import model.Card;
import model.CommunalPile;
import model.Deck;
import model.Game;
import model.Player;
import model.Round;
import view.RoundView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import controller.DeckController;
import controller.PlayerController;
import controller.RoundController;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	private final int no_cards;
	private final String user_name;
	private final ArrayList<Card> Deck = new ArrayList<Card>();;
	private final Deck deck = new Deck(Deck, "Size", "Speed", "Range", "FirePower", "Cargo");
	private Player[] Players;
	private Player decidingPlayer;
	private Player[] NewPlayers;
	private Game Game;
	private Round Round;
	private CommunalPile currentPile;
	private int numPlayers;
	private String prevRoundString;
	private boolean userWantsToQuit; // flag to check whether the user wants to quit the application
	private ArrayList<String> lines = new ArrayList<String>();
	private DeckController deckC = new DeckController();
	// Constructor

	public TopTrumpsCLIApplication(String deck_file, int no_cards, String user_name) {
		this.no_cards = no_cards;
		this.user_name = user_name;
	}

	// main
	public static void main(String[] args) {
		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		if (args[0].equalsIgnoreCase("true"))
			writeGameLogsToFile = true; // Command line selection
		TopTrumpsCLIApplication TopTrumps = new TopTrumpsCLIApplication("StarCitizenDeck.txt", 40, "Human");// The class
																											// // played
		// Loop until the user wants to exit the game
		int index = 0;
		while (!TopTrumps.userWantsToQuit) {
			if(index != 0) {
				TopTrumps = new TopTrumpsCLIApplication("StarCitizenDeck.txt", 40, "Human");// The class
			}
			
			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			TopTrumps.userWantsToQuit = true;
			TopTrumps.prevRoundString = "";// String variable that is used to show the results of the rounds that are
			TopTrumps.deckC.generateDeck(TopTrumps.lines, TopTrumps.Deck);
			TopTrumps.deckC.shuffleDeck(TopTrumps.Deck); // given
			TopTrumps.Game = new Game(0, 0); // An object of the Game class is created
			/*
			 * System.out.println
			 * ("Please choose with how many players you want to play between 2 and 5.");
			 * String entradaTeclado; Scanner entradaEscaner = new Scanner (System.in);
			 * entradaTeclado = entradaEscaner.nextLine (); if(isNumeric(entradaTeclado)){
			 * if(entradaTeclado == "1"){ System.out.println
			 * ("Please choose with how many players you want to play between 2 and 5.");
			 * TopTrumps.userWantsToQuit=true; } else if(Integer.parseInt(entradaTeclado) >
			 * 5){ System.out.println ("You cannot play more than 5 players");
			 * TopTrumps.userWantsToQuit=true; }else{
			 */
			TopTrumps.numPlayers = 5; // In this variable it is indicated how many players will be in the game,
										// including the human if this were the option chosen
			TopTrumps.NewPlayers = new Player[TopTrumps.numPlayers]; // The variable that will handle all the players of
																		// the new game is created.
			Player Human = new Player(TopTrumps.user_name);
			TopTrumps.NewPlayers[0] = Human;
			String[] CompPlayerNames = { "BotOne", "BotTwo", "BotThree", "BotFour" };
			for (int i = 1; i < TopTrumps.numPlayers; i++) {
				TopTrumps.NewPlayers[i] = new Player(CompPlayerNames[i - 1]);
			}
			TopTrumps.Players = TopTrumps.NewPlayers;

			Random rand = new Random();
			int decidingPlayerIndex = rand.nextInt(TopTrumps.Players.length);
			TopTrumps.decidingPlayer = TopTrumps.Players[decidingPlayerIndex];

			String WhoseTurn = String.format("Current player turn: %s%n%n", TopTrumps.decidingPlayer.getName());
			System.out.println(WhoseTurn);

			TopTrumps.currentPile = new CommunalPile();
			PlayerController playerC = new PlayerController();
			for (int i = 0; i < TopTrumps.no_cards; i++) {
				Player p = TopTrumps.Players[i % TopTrumps.numPlayers];
				playerC.giveCard(TopTrumps.Deck.get(i), p);
			}
			String UserCardInfo;
			Player user = TopTrumps.Players[0];
			if (user.getHand().length == 0) {
				String s = String.format(TopTrumps.user_name + " have no cards left.\n\n");
				UserCardInfo = s;
			} else {
				Card UserCurrentCard = user.getHand()[0];
				String CardDescription = String.format("%s%n", UserCurrentCard.getName());
				String CardAttribute1 = String.format("%s: %s   ", TopTrumps.deck.getSize(), UserCurrentCard.getSize());
				String CardAttribute2 = String.format("%s: %s   ", TopTrumps.deck.getSpeed(),
						UserCurrentCard.getSpeed());
				String CardAttribute3 = String.format("%s: %s   ", TopTrumps.deck.getRange(),
						UserCurrentCard.getRange());
				String CardAttribute4 = String.format("%s: %s   ", TopTrumps.deck.getFirepower(),
						UserCurrentCard.getFirepower());
				String CardAttribute5 = String.format("%s: %s   %n%n", TopTrumps.deck.getCargo(),
						UserCurrentCard.getCargo());
				UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 + CardAttribute3 + CardAttribute4
						+ CardAttribute5;
			}
			System.out.println("Current card: " + UserCardInfo);

			if (TopTrumps.decidingPlayer.getName().equals(TopTrumps.user_name)) {
				TopTrumps.UserPicking();
			} else {
				TopTrumps.playRound(0);
			}

			System.out.println();
			String attribute1 = TopTrumps.deck.getSize();
			String attribute2 = TopTrumps.deck.getSpeed();
			String attribute3 = TopTrumps.deck.getRange();
			String attribute4 = TopTrumps.deck.getFirepower();
			String attribute5 = TopTrumps.deck.getCargo();
			String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
					attribute1, attribute2, attribute3, attribute4, attribute5);
			System.out.println(attributeNameString);
			for (int i = 0; i < TopTrumps.no_cards; i++) {
				Card CurrentCard = TopTrumps.Deck.get(i);
				String nameValue = CurrentCard.getName();
				String attribute1Val = Integer.toString(CurrentCard.getSize());
				String attribute2Val = Integer.toString(CurrentCard.getSpeed());
				String attribute3Val = Integer.toString(CurrentCard.getRange());
				String attribute4Val = Integer.toString(CurrentCard.getFirepower());
				String attribute5Val = Integer.toString(CurrentCard.getCargo());

				String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
						attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);
				System.out.println(attValString);
			}
			System.out.println();
			for (Player P : TopTrumps.Players) {
				System.out.println("-------------------------------------");
				System.out.println("Cards belonging to: " + P.getName());
				String attrCard1 = TopTrumps.deck.getSize();
				String attrCard2 = TopTrumps.deck.getSpeed();
				String attrCard3 = TopTrumps.deck.getRange();
				String attrCard4 = TopTrumps.deck.getFirepower();
				String attrCard5 = TopTrumps.deck.getCargo();

				String attrCardsNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
						attrCard1, attrCard2, attrCard3, attrCard4, attrCard5);

				System.out.println(attrCardsNameString);
				for (Card hand : P.getHand()) {
					String nameValue = hand.getName();
					String attribute1Val = Integer.toString(hand.getSize());
					String attribute2Val = Integer.toString(hand.getSpeed());
					String attribute3Val = Integer.toString(hand.getRange());
					String attribute4Val = Integer.toString(hand.getFirepower());
					String attribute5Val = Integer.toString(hand.getCargo());

					String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s",
							nameValue, attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);

					System.out.println(attValString);
				}
				System.out.println();

			}
			//System.out.println(TopTrumps.userWantsToQuit);
			//TopTrumps.userWantsToQuit = true;
			index++;
		}
	}

	public static boolean isNumeric(String cadena) {
		boolean result;

		try {
			Integer.parseInt(cadena);
			result = true;
		} catch (NumberFormatException excepcion) {
			result = false;
		}

		return result;
	}

	//Function that is used for the human player to decide with what player attribute in the current round
	private void UserPicking() {
		//The user is requested to enter the corresponding values
		System.out.println(
				"Please choose what attribute you want to take for the round: Size choose 1, Speed choose 2, Range choose 3, FirePower choose 4, Cargo choose 5");
		String entradaTeclado;
		Scanner entradaEscaner = new Scanner(System.in);
		entradaTeclado = entradaEscaner.nextLine();

		if (isNumeric(entradaTeclado)) {
			switch (entradaTeclado) {
			case "1":
				playRound(1);
				break;
			case "2":
				playRound(2);
				break;
			case "3":
				playRound(3);
				break;
			case "4":
				playRound(4);
				break;
			case "5":
				playRound(5);
				break;
			default:
				System.out.println("You must choose an attribute based on those available to play");
				UserPicking();
				break;
			}
		} else {
			System.out.println("You must place a numeric value between the given values in order to play");
			UserPicking();
		}
	}

	private void checkIfGameOver() {
		int pass = 0;
		for (int i = 0; i < this.numPlayers; i++) {
			Player user = this.Round.getPlayers()[i];
			int length = user.getHand().length;
			if (length == 40) {
				System.out.println("Game over, Win " + user.getName());
				System.out.println("If you want to play again option 1 if you want to show the statistics of the game option 2, if you select another option the game will end");
				String entradaTeclado; Scanner entradaEscaner = new Scanner (System.in);
				entradaTeclado = entradaEscaner.nextLine (); 
				if(isNumeric(entradaTeclado)){
					if(Integer.parseInt(entradaTeclado) == 1){ 
						this.userWantsToQuit=false; 
					} else if(Integer.parseInt(entradaTeclado) == 2){ 
						System.out.println ("Show statistics here");
						this.userWantsToQuit = true;
					}else{
						this.userWantsToQuit = true;
					}
				}
				pass = 1;
				break;
			}
		}
		if (pass == 0) {
			if (decidingPlayer.getName().equals(user_name)) {
				UserPicking();
			} else {
				playRound(0);
			}
		}
	}

	private void playRound(int trumpIndex) {
		Round CurrRound;
		RoundController roundC = new RoundController();
		RoundView roundV = new RoundView();
		CurrRound = new Round(Players, decidingPlayer, currentPile, trumpIndex, deck, no_cards);
		if (trumpIndex == 0) {
			CurrRound.setIndex(roundC.getIndex(decidingPlayer, CurrRound.getATTR()));
		} else {
			CurrRound.setIndex(trumpIndex);
		}

		this.Round = CurrRound;
		roundC.saveValues(this.Round.getPlayers(), this.Round.getIndex(), this.Round.getPrevValues());
		roundV.startHovering(this.Round);
		currentPile = Round.getPile();
		if (!this.Round.isDraw()) {
			this.decidingPlayer = this.Round.getWinner();
		}
		String WhoseTurn = String.format("Current player turn: %s%n%n", this.decidingPlayer.getName());
		System.out.println(WhoseTurn);
		System.out.println("Cards in pile: " + this.Round.getPile().getCards().length);

		this.prevRoundString = roundV.getRoundString(this.Round);
		String displayText = this.prevRoundString;
		System.out.println(displayText);
		if (this.Round.isDraw()) {
			this.Game.setNumDraws(this.Game.getNumDraws() + 1);
		}
		this.Game.setNumRounds(this.Game.getNumRounds() + 1);

		Player user = this.Players[0];
		String UserCardInfo;
		if (user.getHand().length == 0) {
			String s = String.format(this.user_name + " have no cards left.\n\n");
			UserCardInfo = s;
		} else {
			Card UserCurrentCard = user.getHand()[0];
			String CardDescription = String.format("%s%n", UserCurrentCard.getName());
			String CardAttribute1 = String.format("%s: %s   ", deck.getSize(), UserCurrentCard.getSize());
			String CardAttribute2 = String.format("%s: %s   ", deck.getSpeed(), UserCurrentCard.getSpeed());
			String CardAttribute3 = String.format("%s: %s   ", deck.getRange(), UserCurrentCard.getRange());
			String CardAttribute4 = String.format("%s: %s   ", deck.getFirepower(), UserCurrentCard.getFirepower());
			String CardAttribute5 = String.format("%s: %s   %n%n", deck.getCargo(), UserCurrentCard.getCargo());
			UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 + CardAttribute3 + CardAttribute4
					+ CardAttribute5;
		}

		System.out.println("Cards left in hand: " + Players[0].getHand().length + "\nCurrent card: " + UserCardInfo);
		switch (this.Players.length) {
		case 2:
			System.out.println("Bot 1 Cards left in hand:\n" + this.Players[1].getHand().length);
			break;
		case 3:
			System.out.println("Bot 1 Cards left in hand:\n" + this.Players[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + this.Players[2].getHand().length);
			break;
		case 4:
			System.out.println("Bot 1 Cards left in hand:\n" + this.Players[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + this.Players[2].getHand().length);
			System.out.println("Bot 3 Cards left in hand:\n" + this.Players[3].getHand().length);
			break;
		case 5:
			System.out.println("Bot 1 Cards left in hand:\n" + this.Players[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + this.Players[2].getHand().length);
			System.out.println("Bot 3 Cards left in hand:\n" + this.Players[3].getHand().length);
			System.out.println("Bot 4 Cards left in hand:\n" + this.Players[4].getHand().length);
			break;
		}

		checkIfGameOver();
	}

}
