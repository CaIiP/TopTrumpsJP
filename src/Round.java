package TopTrumps;

public class Round {
	private final int ATTR = 5;
	private final Player[] players;
	private Card[] Cards;
	private final int Index;
	private CommunalPile pile;
	private Player winner = null;
	private final Player decidingPlayer;
	private final Pack pack;
	private boolean draw = false;
	private final int[] prevValues;

	public Round(Player[] playersArray, Player CurrentDecidingPlayer, CommunalPile communalPipe, int Index, Pack pack,
			 int numCards) {
	    this.players = playersArray;
	    this.pack = pack;
	    this.pile = communalPipe;
	    this.decidingPlayer=CurrentDecidingPlayer;
	    prevValues = new int[players.length];
	    if (Index == 0) {
		this.Index = getIndex();
	    } else {
		this.Index = Index;
            }
	}

        public Player[] getPlayers() {return players;}
        public Pack getPack() {return pack;}
        public CommunalPile getPile() {return pile;}
        public Player getWinner() {return winner;}
        public boolean isDraw() {return draw;}
        
    
	private int getIndex() {
	    System.out.println(decidingPlayer.getName());
	    Card topCard = decidingPlayer.getHand()[0];
	    int AttributeIndex = 0;
	    int AttributeValue = 0;
	    for (int i = 0; i < ATTR; i++) {
                int Attribute = -1;
                if(i == 1){Attribute = topCard.getAttribute1Val();
                }else if(i == 2){Attribute = topCard.getAttribute2Val();
                }else if(i == 3){Attribute = topCard.getAttribute3Val();
                }else if(i == 4){Attribute = topCard.getAttribute4Val();
                }else if(i == 5){Attribute = topCard.getAttribute5Val();
                }
		if (Attribute > AttributeValue) {
                    AttributeValue = Attribute;
		    AttributeIndex = i;
		}
            }
	    return AttributeIndex;
	}
        
        public void saveValues() {
	    Card[] cards = new Card[players.length];
	    for(int i = 0; i < cards.length; i++) {
		if (players[i].getHand().length != 0) {
		    cards[i] = players[i].getHand()[0];
                    int Attribute = -1;
                    if(Index == 1){Attribute = cards[i].getAttribute1Val();
                    }else if(Index == 2){Attribute = cards[i].getAttribute2Val();
                    }else if(Index == 3){Attribute = cards[i].getAttribute3Val();
                    }else if(Index == 4){Attribute = cards[i].getAttribute4Val();
                    }else if(Index == 5){Attribute = cards[i].getAttribute5Val();}  
		    prevValues[i] = Attribute;
		}
            }
	}
        
        public String getRoundString(int type) {
            if(type == 1){
                String roundString = String.format("");
                String Attribute = "";
                if(Index == 1){Attribute = this.pack.getAttribute1();
                }else if(Index == 2){Attribute = this.pack.getAttribute2();
                }else if(Index == 3){Attribute = this.pack.getAttribute3();
                }else if(Index == 4){Attribute = this.pack.getAttribute4();
                }else if(Index == 5){Attribute = this.pack.getAttribute5();}
                roundString += String.format("Previous round attribute: %s%n", Attribute);
                String score = String.format("");
                for (int i = 0; i < this.players.length; i++) {
                    Player p = players[i];
                    if (p.getHand().length > 0) {
                        Card c = p.getHand()[0];
                        score += String.format("%s: ", players[i].getName());
                        score += String.format("%d    ", prevValues[i]);
                    }
                }
                score += String.format("%n%n");
                roundString += score;

                System.out.println();
                String WinLost = String.format("%n%n");
                Player user = this.players[0];
                if (user.getHand().length == this.pack.getCards().length-this.pile.getCards().length) {
                    if(this.winner != null){
                        WinLost += String.format("YOU WON THE GAME!: "+ this.winner.getName());
                    }else{
                        WinLost += String.format("YOU WON THE GAME!:"+ user.getName());
                    }
                } else if (user.getHand().length == 0) {
                    if(this.winner != null){
                        WinLost += String.format("YOU LOST THE GAME!:"+ this.winner.getName());	
                    }else{
                        WinLost += String.format("YOU LOST THE GAME!:"+ user.getName());
                    }
                }
                roundString += WinLost;
                System.out.println();
                String WinnerDraw = String.format("%n%n");
                if (this.draw) {WinnerDraw += String.format("This round was a draw.%n%n");
                } else {WinnerDraw += String.format("%s won the previous round%n%n", this.winner.getName());}
                roundString += WinnerDraw;
                return roundString;
            }else{
                String roundString = String.format("");
                String Attribute = "";
                if(Index == 1){Attribute = this.pack.getAttribute1();
                }else if(Index == 2){Attribute = this.pack.getAttribute2();
                }else if(Index == 3){Attribute = this.pack.getAttribute3();
                }else if(Index == 4){Attribute = this.pack.getAttribute4();
                }else if(Index == 5){Attribute = this.pack.getAttribute5();}
                roundString += String.format("Previous round attribute: %s%n", Attribute);
                String score = String.format("");
                for (int i = 0; i < this.players.length; i++) {
                    Player p = players[i];
                    if (p.getHand().length > 0) {
                        Card c = p.getHand()[0];
                        score += String.format("%s: ", players[i].getName());
                        score += String.format("%d    ", prevValues[i]);
                    }
                }
                score += String.format("%n%n");
                roundString += score;

                String WinLost = String.format("%n%n");
                
                for (int i = 1; i < players.length; i++) {
                    Player user = this.players[i];
                    if (user.getHand().length == this.pack.getCards().length-this.pile.getCards().length) {
                        if(this.winner != null){
                            WinLost += String.format("YOU WON THE GAME!: "+ this.winner.getName());
                        }else{
                            WinLost += String.format("YOU WON THE GAME!: "+ user.getName());
                        }
                    } 
                }
                roundString += WinLost;
                
                String WinnerDraw = String.format("%n%n");
                if (this.draw) {WinnerDraw += String.format("This round was a draw.%n%n");
                } else {WinnerDraw += String.format("%s won the previous round%n%n", this.winner.getName());}
                roundString += WinnerDraw;
                return roundString;
            }
	}
        
	public void startHovering() {
	    System.out.println("---------------------------");
            Card[] cardsArray = { null, null, null, null, null };
            for (int i = 0; i < players.length; i++) {
		if (players[i].getHand().length != 0) {
                    
                    Card takenCard = players[i].getHand()[0];        
                    Card[] newHand = new Card[players[i].getHand().length-1];
                    for (int j = 0; j < newHand.length; j++){
                        newHand[j] = players[i].getHand()[j+1];
                    }
                    players[i].setHand(newHand);
                    if (players[i].getHand().length == 0){
                        players[i].setKeepPlaying(false);
                    }      
                             
                    Card c = takenCard;
                    cardsArray[i] = c;
		}
            }
	    Cards = cardsArray; 
	    System.out.println("---------------------------");
	    System.out.println("******** Cards in play: ********");
	    String attribute1Name = this.pack.getAttribute1();
	    String attribute2Name = this.pack.getAttribute2();
	    String attribute3Name = this.pack.getAttribute3();
	    String attribute4Name = this.pack.getAttribute4();
	    String attribute5Name = this.pack.getAttribute5();
	    String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
				attribute1Name, attribute2Name, attribute3Name, attribute4Name, attribute5Name);
	    System.out.println(attributeNameString);
            for (Card Card : Cards) {
                if (Card != null) {
                    String nameValue = Card.getName();
                    String att1Value = Integer.toString(Card.getAttribute1Val());
                    String att2Value = Integer.toString(Card.getAttribute2Val());
                    String att3Value = Integer.toString(Card.getAttribute3Val());
                    String att4Value = Integer.toString(Card.getAttribute4Val());
                    String att5Value = Integer.toString(Card.getAttribute5Val());

                    String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                    att1Value, att2Value, att3Value, att4Value, att5Value);

                    System.out.println(attValString);
                }
            }
	    System.out.println("---------------------------");
            String Attribute = "";
            if(Index == 1){Attribute = this.pack.getAttribute1();
            }else if(Index == 2){Attribute = this.pack.getAttribute2();
            }else if(Index == 3){Attribute = this.pack.getAttribute3();
            }else if(Index == 4){Attribute = this.pack.getAttribute4();
            }else if(Index == 5){Attribute = this.pack.getAttribute5();}
            System.out.println("Category selected: " + Attribute);
            System.out.println("Values:");
            for (int i = 0; i < this.players.length; i++) {
		Player p = this.players[i];
		if (p.getHand().length > 0) {
		    Card c = p.getHand()[0];
		    System.out.println(p.getName() + ": " + prevValues[i]);
		}
            }
	    System.out.println();
            boolean drawR = false;
	    int maxScore = 50;
	    int[] playerScores = new int[maxScore];
            System.out.println(playerScores);
	    for (int i = 0; i < players.length; i++) {
		if (Cards[i] != null) {
		    Card c = Cards[i];
                    int AttributeR = -1;
                    if(this.Index == 1){AttributeR = c.getAttribute1Val();
                    }else if(this.Index == 2){AttributeR = c.getAttribute2Val();
                    }else if(this.Index == 3){AttributeR = c.getAttribute3Val();
                    }else if(this.Index == 4){AttributeR = c.getAttribute4Val();
                    }else if(this.Index == 5){AttributeR = c.getAttribute5Val();}
		    int score = AttributeR;
                    if(score == 0){
                        playerScores[score]++;
                    }else{
                        playerScores[score - 1]++;
                    }
                    
                                
		}
            }
	    for (int i = maxScore - 1; i >= 0; i--) {
		if (playerScores[i] == 1) {
		    break;
		} else if (playerScores[i] > 1) {
		    drawR = true;
		    break;
		}
	    }
	    this.draw = drawR; 
            int topS = 0;
	    for (int i = 0; i < this.players.length; i++) {
		if ((players[i].getHand().length + 1) > 0) {
		    try{
			Card c = Cards[i];
                        int AttributeW = -1;
                        if(this.Index == 1){AttributeW = c.getAttribute1Val();
                        }else if(this.Index == 2){AttributeW = c.getAttribute2Val();
                        }else if(this.Index == 3){AttributeW = c.getAttribute3Val();
                        }else if(this.Index == 4){AttributeW = c.getAttribute4Val();
                        }else if(this.Index == 5){AttributeW = c.getAttribute5Val();
                        }
			if (AttributeW == topS) {
			    winner = null;
			} else if (AttributeW > topS) {
			    topS = AttributeW;
			    winner = players[i];
			}
		    } catch (Exception e){
			System.out.println("" + players[i] + " has no cards left.");
		    }				
		}
            }	   
            if (winner == null) {
                for (Card c : Cards) {if (c != null) {this.pile.giveCard(c);}}
	    } else {		
                for (Card c : Cards) {if (c != null) {winner.giveCard(c);}}
                for (Card c : pile.getCards()) {if (c != null) {winner.giveCard(c);}}
		pile = new CommunalPile();
	    }
	    System.out.println("---------------------------");
	    System.out.println("Player hands post-round: \n");
            for (Player p : this.players) {
                if (p.getHand().length > 0) {
                    System.out.println("---------------------------");
                    System.out.println("Cards in hand belonging to: " + p.getName());
                    String attribute1PHandName = this.pack.getAttribute1();
                    String attribute2PHandName = this.pack.getAttribute2();
                    String attribute3PHandName = this.pack.getAttribute3();
                    String attribute4PHandName = this.pack.getAttribute4();
                    String attribute5PHandName = this.pack.getAttribute5();
                    String attributePHandNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
                                    attribute1PHandName, attribute2PHandName, attribute3PHandName, attribute4PHandName, attribute5PHandName);

                    System.out.println(attributePHandNameString);
                    for (Card hand : p.getHand()) {
                        String nameValue = hand.getName();
                        String att1Value = Integer.toString(hand.getAttribute1Val());
                        String att2Value = Integer.toString(hand.getAttribute2Val());
                        String att3Value = Integer.toString(hand.getAttribute3Val());
                        String att4Value = Integer.toString(hand.getAttribute4Val());
                        String att5Value = Integer.toString(hand.getAttribute5Val());
                        String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                        att1Value, att2Value, att3Value, att4Value, att5Value);
                        System.out.println(attValString);
                    }
                    System.out.println();
                }
            }
	    if (this.pile.getCards().length > 0) {
		System.out.println("---------------------------");
		System.out.println("Common Pile:");
		String attribute1CPileName = this.pack.getAttribute1();
		String attribute2CPileName = this.pack.getAttribute2();
		String attribute3CPileName = this.pack.getAttribute3();
		String attribute4CPileName = this.pack.getAttribute4();
		String attribute5CPileName = this.pack.getAttribute5();
		String attributeCPileNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
				attribute1CPileName, attribute2CPileName, attribute3CPileName, attribute4CPileName, attribute5CPileName);

		System.out.println(attributeCPileNameString);
		for (int i = 0; i < this.pile.getCards().length; i++) {
                    String nameValue = this.pile.getCards()[i].getName();
                    String att1Value = Integer.toString(this.pile.getCards()[i].getAttribute1Val());
                    String att2Value = Integer.toString(this.pile.getCards()[i].getAttribute2Val());
                    String att3Value = Integer.toString(this.pile.getCards()[i].getAttribute3Val());
                    String att4Value = Integer.toString(this.pile.getCards()[i].getAttribute4Val());
                    String att5Value = Integer.toString(this.pile.getCards()[i].getAttribute5Val());

                    String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
                                    att1Value, att2Value, att3Value, att4Value, att5Value);

                    System.out.println(attValString);
		}
		System.out.println("---------------------------");
	    }
	}
       
}
