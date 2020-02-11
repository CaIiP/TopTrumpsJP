package view;

import controller.CommunalPileController;
import controller.PlayerController;
import model.Card;
import model.CommunalPile;
import model.Player;
import model.Round;

public class RoundView {
	
	public String getRoundString(Round round) {

		String roundString = String.format("");
		String Attribute = "";
		if (round.getIndex() == 1) {
			Attribute = round.getDeck().getSize();
		} else if (round.getIndex() == 2) {
			Attribute = round.getDeck().getSpeed();
		} else if (round.getIndex() == 3) {
			Attribute = round.getDeck().getRange();
		} else if (round.getIndex() == 4) {
			Attribute = round.getDeck().getFirepower();
		} else if (round.getIndex() == 5) {
			Attribute = round.getDeck().getCargo();
		}
		roundString += String.format("Previous round attribute: %s%n", Attribute);
		String score = String.format("");
		for (int i = 0; i < round.getPlayers().length; i++) {
			Player p = round.getPlayers()[i];
			if (p.getHand().length > 0) {
				score += String.format("%s: ", p.getName());
				score += String.format("%d    ", round.getPrevValues()[i]);
			}
		}
		score += String.format("%n%n");
		roundString += score;

		System.out.println();
		String WinLost = String.format("%n%n");
		Player user = round.getPlayers()[0];
		if (user.getHand().length == round.getDeck().getDeck().size() - round.getPile().getCards().length) {
			if (round.getWinner() != null) {
				WinLost += String.format("YOU WON THE GAME!: " + round.getWinner().getName());
			} else {
				WinLost += String.format("YOU WON THE GAME!:" + user.getName());
			}
		} else if (user.getHand().length == 0) {
			WinLost += String.format("YOU LOST THE GAME!:" + user.getName());
		}
		roundString += WinLost;
		System.out.println();
		String WinnerDraw = String.format("%n%n");
		if (round.isDraw()) {
			WinnerDraw += String.format("This round was a draw.%n%n");
		} else {
			WinnerDraw += String.format("%s won the previous round%n%n", round.getWinner().getName());
		}
		roundString += WinnerDraw;
		return roundString;
	}
	
	//Function that is used to show the cards in play of the round and also to indicate which cards were left after playing the round.
	public void startHovering(Round round) {
		System.out.println("---------------------------");
		Card[] cardsArray = { null, null, null, null, null };
		for (int i = 0; i < round.getPlayers().length; i++) {
			if (round.getPlayers()[i].getHand().length != 0) {

				Card takenCard = round.getPlayers()[i].getHand()[0];
				Card[] newHand = new Card[round.getPlayers()[i].getHand().length - 1];
				for (int j = 0; j < newHand.length; j++) {
					newHand[j] = round.getPlayers()[i].getHand()[j + 1];
				}
				round.getPlayers()[i].setHand(newHand);
				if (round.getPlayers()[i].getHand().length == 0) {
					round.getPlayers()[i].setKeepPlaying(false);
				}

				Card c = takenCard;
				cardsArray[i] = c;
			}
		}
		round.setCards(cardsArray);
		System.out.println("---------------------------");
		System.out.println("******** Cards in play: ********");
		String attribute1Name = round.getDeck().getSize();
		String attribute2Name = round.getDeck().getSpeed();
		String attribute3Name = round.getDeck().getRange();
		String attribute4Name = round.getDeck().getFirepower();
		String attribute5Name = round.getDeck().getCargo();
		String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
				attribute1Name, attribute2Name, attribute3Name, attribute4Name, attribute5Name);
		System.out.println(attributeNameString);
		for (Card Card : round.getCards()) {
			if (Card != null) {
				String nameValue = Card.getName();
				String att1Value = Integer.toString(Card.getSize());
				String att2Value = Integer.toString(Card.getSpeed());
				String att3Value = Integer.toString(Card.getRange());
				String att4Value = Integer.toString(Card.getFirepower());
				String att5Value = Integer.toString(Card.getCargo());

				String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
						att1Value, att2Value, att3Value, att4Value, att5Value);

				System.out.println(attValString);
			}
		}
		System.out.println("---------------------------");
		String Attribute = "";
		if (round.getIndex() == 1) {
			Attribute = round.getDeck().getSize();
		} else if (round.getIndex() == 2) {
			Attribute = round.getDeck().getSpeed();
		} else if (round.getIndex() == 3) {
			Attribute = round.getDeck().getRange();
		} else if (round.getIndex() == 4) {
			Attribute = round.getDeck().getFirepower();
		} else if (round.getIndex() == 5) {
			Attribute = round.getDeck().getCargo();
		}
		System.out.println("Category selected: " + Attribute);
		System.out.println("Values:");
		for (int i = 0; i < round.getPlayers().length; i++) {
			Player p = round.getPlayers()[i];
			if (p.getHand().length > 0) {
				System.out.println(p.getName() + ": " + round.getPrevValues()[i]);
			}
		}
		System.out.println();
		boolean drawR = false;
		int maxScore = 50;
		int[] playerScores = new int[maxScore];
		// System.out.println(Arrays.toString(playerScores));
		for (int i = 0; i < round.getPlayers().length; i++) {
			if (round.getCards()[i] != null) {
				Card c = round.getCards()[i];
				int AttributeR = -1;
				if (round.getIndex() == 1) {
					AttributeR = c.getSize();
				} else if (round.getIndex() == 2) {
					AttributeR = c.getSpeed();
				} else if (round.getIndex() == 3) {
					AttributeR = c.getRange();
				} else if (round.getIndex() == 4) {
					AttributeR = c.getFirepower();
				} else if (round.getIndex() == 5) {
					AttributeR = c.getCargo();
				}
				int score = AttributeR;
				if (score == 0) {
					playerScores[score]++;
				} else {
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
		round.setDraw(drawR);
		int topS = 0;
		for (int i = 0; i < round.getPlayers().length; i++) {
			if ((round.getPlayers()[i].getHand().length + 1) > 0) {
				try {
					Card c = round.getCards()[i];
					int AttributeW = -1;
					if (round.getIndex() == 1) {
						AttributeW = c.getSize();
					} else if (round.getIndex() == 2) {
						AttributeW = c.getSpeed();
					} else if (round.getIndex() == 3) {
						AttributeW = c.getRange();
					} else if (round.getIndex() == 4) {
						AttributeW = c.getFirepower();
					} else if (round.getIndex() == 5) {
						AttributeW = c.getCargo();
					}
					if (AttributeW == topS) {
						round.setWinner(null);
					} else if (AttributeW > topS) {
						topS = AttributeW;
						round.setWinner(round.getPlayers()[i]);
					}
				} catch (Exception e) {
					System.out.println("" + round.getPlayers()[i].getName() + " has no cards left.");
				}
			}
		}
		if (round.getWinner() == null) {
			CommunalPileController communalPileC = new CommunalPileController();
			for (Card c : round.getCards()) {
				if (c != null) {
					communalPileC.giveCard(c, round.getPile());
				}
			}
		} else {
			PlayerController playerC = new PlayerController();
			for (Card c : round.getCards()) {
				if (c != null) {
					playerC.giveCard(c, round.getWinner());
				}
			}
			for (Card c : round.getPile().getCards()) {
				if (c != null) {
					playerC.giveCard(c, round.getWinner());
				}
			}
			round.setPile(new CommunalPile());
		}
		System.out.println("---------------------------");
		System.out.println("Player hands post-round: \n");
		for (Player p : round.getPlayers()) {
			if (p.getHand().length > 0) {
				System.out.println("---------------------------");
				System.out.println("Cards in hand belonging to: " + p.getName());
				String attribute1PHandName = round.getDeck().getSize();
				String attribute2PHandName = round.getDeck().getSpeed();
				String attribute3PHandName = round.getDeck().getRange();
				String attribute4PHandName = round.getDeck().getFirepower();
				String attribute5PHandName = round.getDeck().getCargo();
				String attributePHandNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s",
						"", attribute1PHandName, attribute2PHandName, attribute3PHandName, attribute4PHandName,
						attribute5PHandName);

				System.out.println(attributePHandNameString);
				for (Card hand : p.getHand()) {
					String nameValue = hand.getName();
					String att1Value = Integer.toString(hand.getSize());
					String att2Value = Integer.toString(hand.getSpeed());
					String att3Value = Integer.toString(hand.getRange());
					String att4Value = Integer.toString(hand.getFirepower());
					String att5Value = Integer.toString(hand.getCargo());
					String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s",
							nameValue, att1Value, att2Value, att3Value, att4Value, att5Value);
					System.out.println(attValString);
				}
				System.out.println();
			}
		}
		if (round.getPile().getCards().length > 0) {
			System.out.println("---------------------------");
			System.out.println("Common Pile:");
			String attribute1CPileName = round.getDeck().getSize();
			String attribute2CPileName = round.getDeck().getSpeed();
			String attribute3CPileName = round.getDeck().getRange();
			String attribute4CPileName = round.getDeck().getFirepower();
			String attribute5CPileName = round.getDeck().getCargo();
			String attributeCPileNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
					attribute1CPileName, attribute2CPileName, attribute3CPileName, attribute4CPileName,
					attribute5CPileName);

			System.out.println(attributeCPileNameString);
			for (int i = 0; i < round.getPile().getCards().length; i++) {
				String nameValue = round.getPile().getCards()[i].getName();
				String att1Value = Integer.toString(round.getPile().getCards()[i].getSize());
				String att2Value = Integer.toString(round.getPile().getCards()[i].getSpeed());
				String att3Value = Integer.toString(round.getPile().getCards()[i].getRange());
				String att4Value = Integer.toString(round.getPile().getCards()[i].getFirepower());
				String att5Value = Integer.toString(round.getPile().getCards()[i].getCargo());

				String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
						att1Value, att2Value, att3Value, att4Value, att5Value);

				System.out.println(attValString);
			}
			System.out.println("---------------------------");
		}
	}

}
