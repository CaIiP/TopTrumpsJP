package TopTrumps;

/**
 *
 * @author PC-ON
 */
public class Pack {
    private Card[] cards;
    private final String attribute1;
    private final String attribute2;
    private final String attribute3;
    private final String attribute4;
    private final String attribute5;

    // Constructor
    public Pack(Card[] cards, String attribute1, 
            String attribute2, String attribute3, String attribute4, 
            String attribute5) {
        this.cards = cards;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
    }

    public void shufflePack() {
        int packLength = this.cards.length;
        int[] undeskOfArray = new int[packLength];
	for (int i = 0; i < packLength; i++) {undeskOfArray[i] = i;}
        
	for (int i = 0; i < packLength; i++) {
	    int rand = i + (int) (Math.random() * (packLength - i));
	    int randomElement = undeskOfArray[rand];
	    undeskOfArray[rand] = undeskOfArray[i];
	    undeskOfArray[i] = randomElement;
	}
        int[] packOfIntArray = undeskOfArray;
        Card[] packOfCards = new Card[packLength];
        for (int i = 0; i < packLength; i++) {
            packOfCards[packOfIntArray[i]] = this.cards[i];
        }
        this.cards = packOfCards;
    }

    public String getAttribute1() {return attribute1;}
    public String getAttribute2() {return attribute2;}
    public String getAttribute3() {return attribute3;}
    public String getAttribute4() {return attribute4;}
    public String getAttribute5() {return attribute5;}
    public Card[] getCards() {return cards;}
    public void setCards(Card[] cards) {this.cards = cards;}
    
}
