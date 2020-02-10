package TopTrumps;

/**
 */
public class Card {
    
	// Instance variables
    private final String name;
    private final int attribute1;
    private final int attribute2;
    private final int attribute3;
    private final int attribute4;
    private final int attribute5;

    // Constructor
    public Card(String name, int attribute1, int attribute2, int attribute3, 
            int attribute4, int attribute5) {
        
        this.name = name;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
    }

    public String getName() {return name;}
    public int getAttribute1Val() {return attribute1;}
    public int getAttribute2Val() {return attribute2;}
    public int getAttribute3Val() {return attribute3;}
    public int getAttribute4Val() {return attribute4;}  
    public int getAttribute5Val() {return attribute5;}
 
}
