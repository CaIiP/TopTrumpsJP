package commandline;


import TopTrumps.Pack;
import TopTrumps.Card;
import TopTrumps.Player;
import TopTrumps.Game;
import TopTrumps.Round;
import TopTrumps.CommunalPile;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

        private final String deck_file;
        private final int no_cards;
        private final String user_name;
	private Pack Pack;  		 
        private Player[] Players; 
        private Player decidingPlayer;
        private Player[] NewPlayers;
	private Game Game;  		 
	private Round Round;		 
	private CommunalPile currentPile;
        private int numPlayers;
	private String prevRoundString;
        private boolean userWantsToQuit; // flag to check whether the user wants to quit the application
        

        public TopTrumpsCLIApplication(String deck_file, int no_cards, String user_name) {
            this.deck_file = deck_file;
            this.no_cards = no_cards;
            this.user_name = user_name;
        }
        
	public static void main(String[] args) {
            boolean writeGameLogsToFile = false; // Should we write game logs to file?
            if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
            TopTrumpsCLIApplication TopTrumps = new TopTrumpsCLIApplication("StarCitizenDeck.txt",40,"Human");
		// Loop until the user wants to exit the game
            while (!TopTrumps.userWantsToQuit) {
                // ----------------------------------------------------
		// Add your game logic here based on the requirements
		// ----------------------------------------------------
                TopTrumps.generateDeck();
                TopTrumps.userWantsToQuit=true; 
                TopTrumps.prevRoundString = "";
                TopTrumps.Pack.shufflePack();		
                TopTrumps.Game = new Game(0,0);     
                /*System.out.println ("Please choose with how many players you want to play between 2 and 5.");
                String entradaTeclado;
                Scanner entradaEscaner = new Scanner (System.in); 
                entradaTeclado = entradaEscaner.nextLine ();
                if(isNumeric(entradaTeclado)){
                    if(entradaTeclado == "1"){
                        System.out.println ("Please choose with how many players you want to play between 2 and 5.");
                        TopTrumps.userWantsToQuit=true; 
                    } else if(Integer.parseInt(entradaTeclado) > 5){
                        System.out.println ("You cannot play more than 5 players");
                        TopTrumps.userWantsToQuit=true; 
                    }else{*/
                        //System.out.println (args[1]+" PASO");
                        TopTrumps.numPlayers = 5;
                        TopTrumps.NewPlayers = new Player[TopTrumps.numPlayers];
                        System.out.println (args.length+" PASO");
                        if(args.length > 1){
                            System.out.println (" PASO");
                        }
                        if(args.length > 1){
                            if(!args[1].equals("-b")){
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
                                String WhoseTurn = String.format("Current player turn: %s%n%n", 
                                                           TopTrumps.decidingPlayer.getName());
                                System.out.println(WhoseTurn);
                                TopTrumps.currentPile = new CommunalPile();
                                for (int i = 0; i < TopTrumps.no_cards; i++) {
                                    Player p = TopTrumps.Players[i % TopTrumps.numPlayers];
                                    p.giveCard(TopTrumps.Pack.getCards()[i]);
                                }
                                String UserCardInfo;
                                Player user = TopTrumps.Players[0];
                                if (user.getHand().length == 0) {
                                    String s = String.format(TopTrumps.user_name + " have no cards left.\n\n");
                                    UserCardInfo = s;
                                }else{
                                    Card UserCurrentCard = user.getHand()[0];
                                    String CardDescription = String.format("%s%n", UserCurrentCard.getName());
                                    String CardAttribute1 = String.format("%s: %s   ", TopTrumps.Pack.getAttribute1(),
                                                        UserCurrentCard.getAttribute1Val());
                                    String CardAttribute2 = String.format("%s: %s   ", TopTrumps.Pack.getAttribute2(),
                                                        UserCurrentCard.getAttribute2Val());
                                    String CardAttribute3 = String.format("%s: %s   ", TopTrumps.Pack.getAttribute3(),
                                                        UserCurrentCard.getAttribute3Val());
                                    String CardAttribute4 = String.format("%s: %s   ", TopTrumps.Pack.getAttribute4(),
                                                        UserCurrentCard.getAttribute4Val());
                                    String CardAttribute5 = String.format("%s: %s   %n%n", TopTrumps.Pack.getAttribute5(),
                                                    UserCurrentCard.getAttribute5Val());
                                    UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 
                                                                + CardAttribute3 + CardAttribute4 + CardAttribute5;
                                }
                                System.out.println("Current card: " + UserCardInfo);

                                if (TopTrumps.decidingPlayer.getName().equals(TopTrumps.user_name)) {
                                    TopTrumps.UserPicking(1);
                                } else {
                                    TopTrumps.playRound(0,1);
                                }

                                System.out.println();
                                String attribute1 = TopTrumps.Pack.getAttribute1();
                                String attribute2 = TopTrumps.Pack.getAttribute2();
                                String attribute3 = TopTrumps.Pack.getAttribute3();
                                String attribute4 = TopTrumps.Pack.getAttribute4();
                                String attribute5 = TopTrumps.Pack.getAttribute5();
                                String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
                                                attribute1, attribute2, attribute3, attribute4, attribute5);
                                System.out.println(attributeNameString);
                                for (int i = 0; i < TopTrumps.no_cards; i++) {
                                    Card CurrentCard = TopTrumps.Pack.getCards()[i];
                                    String nameValue = CurrentCard.getName();
                                    String attribute1Val = Integer.toString(CurrentCard.getAttribute1Val());
                                    String attribute2Val = Integer.toString(CurrentCard.getAttribute2Val());
                                    String attribute3Val = Integer.toString(CurrentCard.getAttribute3Val());
                                    String attribute4Val = Integer.toString(CurrentCard.getAttribute4Val());
                                    String attribute5Val = Integer.toString(CurrentCard.getAttribute5Val());

                                    String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                                        attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);
                                    System.out.println(attValString);
                                }
                                System.out.println();
                                for (Player P : TopTrumps.Players) {
                                    System.out.println("-------------------------------------");
                                    System.out.println("Cards belonging to: " + P.getName());
                                    String attrCard1 = TopTrumps.Pack.getAttribute1();
                                    String attrCard2 = TopTrumps.Pack.getAttribute2();
                                    String attrCard3 = TopTrumps.Pack.getAttribute3();
                                    String attrCard4 = TopTrumps.Pack.getAttribute4();
                                    String attrCard5 = TopTrumps.Pack.getAttribute5();

                                    String attrCardsNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
                                                    attrCard1, attrCard2, attrCard3, attrCard4, attrCard5);

                                    System.out.println(attrCardsNameString);
                                    for (Card hand : P.getHand()) {
                                        String nameValue = hand.getName();
                                        String attribute1Val = Integer.toString(hand.getAttribute1Val());
                                        String attribute2Val = Integer.toString(hand.getAttribute2Val());
                                        String attribute3Val = Integer.toString(hand.getAttribute3Val());
                                        String attribute4Val = Integer.toString(hand.getAttribute4Val());
                                        String attribute5Val = Integer.toString(hand.getAttribute5Val());

                                        String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                                                attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);

                                        System.out.println(attValString);
                                    }
                                    System.out.println();

                                }
                                TopTrumps.userWantsToQuit=true; 
                            }else{
                                String[] CompPlayerNames = { "BotOne", "BotTwo", "BotThree", "BotFour","BotFive" };
                                for (int i = 0; i < TopTrumps.numPlayers; i++) {
                                    TopTrumps.NewPlayers[i] = new Player(CompPlayerNames[i]);
                                }
                                TopTrumps.Players = TopTrumps.NewPlayers; 

                                Random rand = new Random();
                                int decidingPlayerIndex = rand.nextInt(TopTrumps.Players.length);
                                TopTrumps.decidingPlayer = TopTrumps.Players[decidingPlayerIndex];
                                String WhoseTurn = String.format("Current player turn: %s%n%n", 
                                                           TopTrumps.decidingPlayer.getName());
                                System.out.println(WhoseTurn);
                                TopTrumps.currentPile = new CommunalPile();
                                for (int i = 0; i < TopTrumps.no_cards; i++) {
                                    Player p = TopTrumps.Players[i % TopTrumps.numPlayers];
                                    p.giveCard(TopTrumps.Pack.getCards()[i]);
                                }

                                TopTrumps.playRound(0,2);

                                System.out.println();
                                String attribute1 = TopTrumps.Pack.getAttribute1();
                                String attribute2 = TopTrumps.Pack.getAttribute2();
                                String attribute3 = TopTrumps.Pack.getAttribute3();
                                String attribute4 = TopTrumps.Pack.getAttribute4();
                                String attribute5 = TopTrumps.Pack.getAttribute5();
                                String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
                                                attribute1, attribute2, attribute3, attribute4, attribute5);
                                System.out.println(attributeNameString);
                                for (int i = 0; i < TopTrumps.no_cards; i++) {
                                    Card CurrentCard = TopTrumps.Pack.getCards()[i];
                                    String nameValue = CurrentCard.getName();
                                    String attribute1Val = Integer.toString(CurrentCard.getAttribute1Val());
                                    String attribute2Val = Integer.toString(CurrentCard.getAttribute2Val());
                                    String attribute3Val = Integer.toString(CurrentCard.getAttribute3Val());
                                    String attribute4Val = Integer.toString(CurrentCard.getAttribute4Val());
                                    String attribute5Val = Integer.toString(CurrentCard.getAttribute5Val());

                                    String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                                        attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);
                                    System.out.println(attValString);
                                }
                                System.out.println();
                                for (Player P : TopTrumps.Players) {
                                    System.out.println("-------------------------------------");
                                    System.out.println("Cards belonging to: " + P.getName());
                                    String attrCard1 = TopTrumps.Pack.getAttribute1();
                                    String attrCard2 = TopTrumps.Pack.getAttribute2();
                                    String attrCard3 = TopTrumps.Pack.getAttribute3();
                                    String attrCard4 = TopTrumps.Pack.getAttribute4();
                                    String attrCard5 = TopTrumps.Pack.getAttribute5();

                                    String attrCardsNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
                                                    attrCard1, attrCard2, attrCard3, attrCard4, attrCard5);

                                    System.out.println(attrCardsNameString);
                                    for (Card hand : P.getHand()) {
                                        String nameValue = hand.getName();
                                        String attribute1Val = Integer.toString(hand.getAttribute1Val());
                                        String attribute2Val = Integer.toString(hand.getAttribute2Val());
                                        String attribute3Val = Integer.toString(hand.getAttribute3Val());
                                        String attribute4Val = Integer.toString(hand.getAttribute4Val());
                                        String attribute5Val = Integer.toString(hand.getAttribute5Val());

                                        String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                                                attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);

                                        System.out.println(attValString);
                                    }
                                    System.out.println();

                                }
                                TopTrumps.userWantsToQuit=true; 
                            }
                        }else{
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
                            String WhoseTurn = String.format("Current player turn: %s%n%n", 
                                                           TopTrumps.decidingPlayer.getName());
                            System.out.println(WhoseTurn);
                            TopTrumps.currentPile = new CommunalPile();
                            for (int i = 0; i < TopTrumps.no_cards; i++) {
                                Player p = TopTrumps.Players[i % TopTrumps.numPlayers];
                                p.giveCard(TopTrumps.Pack.getCards()[i]);
                            }
                            String UserCardInfo;
                            Player user = TopTrumps.Players[0];
                            if (user.getHand().length == 0) {
                                String s = String.format(TopTrumps.user_name + " have no cards left.\n\n");
                                UserCardInfo = s;
                            }else{
                                Card UserCurrentCard = user.getHand()[0];
                                String CardDescription = String.format("%s%n", UserCurrentCard.getName());
                                String CardAttribute1 = String.format("%s: %s   ", TopTrumps.Pack.getAttribute1(),
                                                        UserCurrentCard.getAttribute1Val());
                                String CardAttribute2 = String.format("%s: %s   ", TopTrumps.Pack.getAttribute2(),
                                                        UserCurrentCard.getAttribute2Val());
                                String CardAttribute3 = String.format("%s: %s   ", TopTrumps.Pack.getAttribute3(),
                                                        UserCurrentCard.getAttribute3Val());
                                String CardAttribute4 = String.format("%s: %s   ", TopTrumps.Pack.getAttribute4(),
                                                        UserCurrentCard.getAttribute4Val());
                                String CardAttribute5 = String.format("%s: %s   %n%n", TopTrumps.Pack.getAttribute5(),
                                                    UserCurrentCard.getAttribute5Val());
                                UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 
                                                                + CardAttribute3 + CardAttribute4 + CardAttribute5;
                            }
                            System.out.println("Current card: " + UserCardInfo);

                            if (TopTrumps.decidingPlayer.getName().equals(TopTrumps.user_name)) {
                                TopTrumps.UserPicking(1);
                            } else {
                                TopTrumps.playRound(0,1);
                            }

                            System.out.println();
                            String attribute1 = TopTrumps.Pack.getAttribute1();
                            String attribute2 = TopTrumps.Pack.getAttribute2();
                            String attribute3 = TopTrumps.Pack.getAttribute3();
                            String attribute4 = TopTrumps.Pack.getAttribute4();
                            String attribute5 = TopTrumps.Pack.getAttribute5();
                            String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
                                                attribute1, attribute2, attribute3, attribute4, attribute5);
                            System.out.println(attributeNameString);
                            for (int i = 0; i < TopTrumps.no_cards; i++) {
                                Card CurrentCard = TopTrumps.Pack.getCards()[i];
                                String nameValue = CurrentCard.getName();
                                String attribute1Val = Integer.toString(CurrentCard.getAttribute1Val());
                                String attribute2Val = Integer.toString(CurrentCard.getAttribute2Val());
                                String attribute3Val = Integer.toString(CurrentCard.getAttribute3Val());
                                String attribute4Val = Integer.toString(CurrentCard.getAttribute4Val());
                                String attribute5Val = Integer.toString(CurrentCard.getAttribute5Val());

                                String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                                        attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);
                                System.out.println(attValString);
                            }
                            System.out.println();
                            for (Player P : TopTrumps.Players) {
                                System.out.println("-------------------------------------");
                                System.out.println("Cards belonging to: " + P.getName());
                                String attrCard1 = TopTrumps.Pack.getAttribute1();
                                String attrCard2 = TopTrumps.Pack.getAttribute2();
                                String attrCard3 = TopTrumps.Pack.getAttribute3();
                                String attrCard4 = TopTrumps.Pack.getAttribute4();
                                String attrCard5 = TopTrumps.Pack.getAttribute5();

                                String attrCardsNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
                                                    attrCard1, attrCard2, attrCard3, attrCard4, attrCard5);

                                System.out.println(attrCardsNameString);
                                for (Card hand : P.getHand()) {
                                    String nameValue = hand.getName();
                                    String attribute1Val = Integer.toString(hand.getAttribute1Val());
                                    String attribute2Val = Integer.toString(hand.getAttribute2Val());
                                    String attribute3Val = Integer.toString(hand.getAttribute3Val());
                                    String attribute4Val = Integer.toString(hand.getAttribute4Val());
                                    String attribute5Val = Integer.toString(hand.getAttribute5Val());

                                    String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                                                attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);

                                    System.out.println(attValString);
                                }
                                System.out.println();

                            }
                            TopTrumps.userWantsToQuit=true;
                        }
                    /*}
                }else{
                    System.out.println("You must enter a numerical value between the opciones given");
                    TopTrumps.userWantsToQuit=false; 
                }*/
            }
	}
        
        public static boolean isNumeric(String cadena){
            boolean result;
            
            try {
                Integer.parseInt(cadena);
                result = true;
            } catch (NumberFormatException excepcion){
                result = false;
            }
            
            return result;
        }
        
        private void UserPicking(int type) {
            System.out.println ("Please choose what attribute you want to take for the round: Attr1 choose 1, Attr2 choose 2, Attr3 choose 3, Attr4 choose 4, Attr5 choose 5");
            String entradaTeclado;
            Scanner entradaEscaner = new Scanner (System.in); 
            entradaTeclado = entradaEscaner.nextLine ();
            if(isNumeric(entradaTeclado)){
                switch (entradaTeclado) {
                    case "1":playRound(1,type);break;
                    case "2":playRound(2,type);break;
                    case "3":playRound(3,type);break;
                    case "4":playRound(4,type);break;
                    case "5":playRound(5,type);break;
                    default:
                        System.out.println ("You must choose an attribute based on those available to play");
                        UserPicking(type);
                        break;
                }
            }else{
                System.out.println ("You must place a numeric value between the given values in order to play");
                UserPicking(type);
            }
	}

	private void checkIfGameOver(int type) {
            if(type == 1){
                Player user = this.Round.getPlayers()[0];	
                if (user.getHand().length == this.Round.getPack().getCards().length-this.Round.getPile().getCards().length 
                        || user.getHand().length == 0) {
                    String Result = "Lost";
                    if(this.Round.getWinner() != null){
                        if (this.Round.getWinner().getName().equals(this.user_name)) {
                            Result = "Win";
                        }
                        System.out.println ("Game over, you " + Result);
                        this.userWantsToQuit = false;
                    }
                }else{
                    if (decidingPlayer.getName().equals(user_name)) {
                        UserPicking(type);
                    } else {
                        playRound(0,type);
                    }
                }
            }else if(type == 2){
                for (int i = 1; i < this.numPlayers; i++) {
                    Player user = this.Round.getPlayers()[i];	
                    if (user.getHand().length == this.Round.getPack().getCards().length-this.Round.getPile().getCards().length 
                            || user.getHand().length == 0) {
                        String Result;
                        if(this.Round.getWinner() != null){
                            if (this.Round.getWinner().getName().equals(user.getName())) {
                                Result = "Win";
                                System.out.println ("Game over, "+ user.getName() +" "+ Result);
                            }
                        }
                        
                        this.userWantsToQuit = false;
                    }else{
                        if (decidingPlayer.getName().equals(user_name)) {
                            UserPicking(type);
                        } else {
                            playRound(0,type);
                        }
                    }
                }
            }
	}

	private void generateDeck() {
	    int arrayLength = no_cards + 1;
            String[] linesArray = new String[arrayLength];
            try {
                FileReader reader = new FileReader(this.deck_file);
                try (Scanner in = new Scanner(reader)) {
                    for (int i = 0; i < arrayLength; i++) {linesArray[i] = in.nextLine();}
                }
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
                System.exit(-1);
            }
	    String[] deckLineStrings = linesArray;
	    String names = deckLineStrings[0];
	    String[] namesStringArray = names.split(" +");
	    String attri1Name = namesStringArray[1];
	    String attri2Name = namesStringArray[2];
	    String attri3Name = namesStringArray[3];
	    String attri4Name = namesStringArray[4];
	    String attri5Name = namesStringArray[5];
            Card[] CardArray = new Card[deckLineStrings.length - 1];
	    for (int i = 1; i < deckLineStrings.length; i++) {
		String numString = deckLineStrings[i];
		String[] numStringArray = numString.split(" +");
		String cardName = numStringArray[0];
		int attri1 = Integer.parseInt(numStringArray[1]);
		int attri2 = Integer.parseInt(numStringArray[2]);
		int attri3 = Integer.parseInt(numStringArray[3]);
		int attri4 = Integer.parseInt(numStringArray[4]);
		int attri5 = Integer.parseInt(numStringArray[5]);
		Card newCard = new Card(cardName, attri1, attri2, attri3, attri4, attri5);
		CardArray[i - 1] = newCard;
	    }
	    this.Pack = new Pack(CardArray, attri1Name, attri2Name, attri3Name, attri4Name, attri5Name);
	    System.out.println("-------------------------------------");
	    System.out.println("Unshuffled pack:");
	    String attribute1 = Pack.getAttribute1();
	    String attribute2 = Pack.getAttribute2();
	    String attribute3 = Pack.getAttribute3();
	    String attribute4 = Pack.getAttribute4();
	    String attribute5 = Pack.getAttribute5();

	    String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
				attribute1, attribute2, attribute3, attribute4, attribute5);

	    System.out.println(attributeNameString);

	    for (int i = 0; i < no_cards; i++) {
		Card CurrentCard = Pack.getCards()[i];
		String nameValue = CurrentCard.getName();
                String attribute1Val = Integer.toString(CurrentCard.getAttribute1Val());
                String attribute2Val = Integer.toString(CurrentCard.getAttribute2Val());
                String attribute3Val = Integer.toString(CurrentCard.getAttribute3Val());
                String attribute4Val = Integer.toString(CurrentCard.getAttribute4Val());
                String attribute5Val = Integer.toString(CurrentCard.getAttribute5Val());

                String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                        attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);

                System.out.println(attValString);

	    }
	    System.out.println("-------------------------------------");
	}

	private void playRound(int trumpIndex, int type) {
	    Round CurrRound;
            CurrRound = new Round(Players, decidingPlayer, currentPile, 
                    trumpIndex, Pack,
                    no_cards);
	    this.Round = CurrRound;		  
	    this.Round.saveValues();
	    this.Round.startHovering();	      
	    currentPile = Round.getPile(); 
	    if (!this.Round.isDraw()) {
		this.decidingPlayer = this.Round.getWinner();
	    }			  
            String WhoseTurn = String.format("Current player turn: %s%n%n", 
				           this.decidingPlayer.getName());
	    System.out.println (WhoseTurn);
	    System.out.println ("Cards in pile: "+this.Round.getPile().getCards().length);
	    this.prevRoundString = Round.getRoundString(type);
	    String displayText = this.prevRoundString;
	    System.out.println(displayText);
	    if (this.Round.isDraw()) {
		this.Game.setNumDraws(this.Game.getNumDraws()+1);
	    }
	    this.Game.setNumRounds(this.Game.getNumRounds()+1);
            
	    if(type == 1){
                Player user = this.Players[0];
                String UserCardInfo;
                if (user.getHand().length == 0) {
                    String s = String.format(this.user_name + " have no cards left.\n\n");
                    UserCardInfo = s;
                }else{
                    Card UserCurrentCard = user.getHand()[0];
                    String CardDescription = String.format("%s%n", UserCurrentCard.getName());
                    String CardAttribute1 = String.format("%s: %s   ", Pack.getAttribute1(),
                                        UserCurrentCard.getAttribute1Val());
                    String CardAttribute2 = String.format("%s: %s   ", Pack.getAttribute2(),
                                        UserCurrentCard.getAttribute2Val());
                    String CardAttribute3 = String.format("%s: %s   ", Pack.getAttribute3(),
                                        UserCurrentCard.getAttribute3Val());
                    String CardAttribute4 = String.format("%s: %s   ", Pack.getAttribute4(),
                                        UserCurrentCard.getAttribute4Val());
                    String CardAttribute5 = String.format("%s: %s   %n%n", Pack.getAttribute5(),
                                        UserCurrentCard.getAttribute5Val());
                    UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 
                                                    + CardAttribute3 + CardAttribute4 + CardAttribute5;
                }

                System.out.println ("Cards left in hand: " + Players[0].getHand().length 
				           + "\nCurrent card: " + UserCardInfo);
                switch (this.Players.length) {
                    case 2:
                        System.out.println ("Bot 1 Cards left in hand:\n" + this.Players[1].getHand().length);
                        break;
                    case 3:
                        System.out.println ("Bot 1 Cards left in hand:\n" + this.Players[1].getHand().length);
                        System.out.println ("Bot 2 Cards left in hand:\n" + this.Players[2].getHand().length);
                        break;
                    case 4:
                        System.out.println ("Bot 1 Cards left in hand:\n" + this.Players[1].getHand().length);
                        System.out.println ("Bot 2 Cards left in hand:\n" + this.Players[2].getHand().length);
                        System.out.println ("Bot 3 Cards left in hand:\n" + this.Players[3].getHand().length);
                        break;
                    case 5:
                        System.out.println ("Bot 1 Cards left in hand:\n" + this.Players[1].getHand().length);
                        System.out.println ("Bot 2 Cards left in hand:\n" + this.Players[2].getHand().length);
                        System.out.println ("Bot 3 Cards left in hand:\n" + this.Players[3].getHand().length);
                        System.out.println ("Bot 4 Cards left in hand:\n" + this.Players[4].getHand().length);
                        break;
                }
            }else if(type == 2){
                switch (this.Players.length) {
                    case 5:
                        System.out.println ("Bot 1 Cards left in hand:\n" + this.Players[0].getHand().length);
                        System.out.println ("Bot 2 Cards left in hand:\n" + this.Players[1].getHand().length);
                        System.out.println ("Bot 3 Cards left in hand:\n" + this.Players[2].getHand().length);
                        System.out.println ("Bot 4 Cards left in hand:\n" + this.Players[3].getHand().length);
                        System.out.println ("Bot 5 Cards left in hand:\n" + this.Players[4].getHand().length);
                        break;
                }
            }
            checkIfGameOver(type);
	}

}
