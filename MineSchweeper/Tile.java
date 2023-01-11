package MineSchweeper;

//     Types
// Empty = 0
// Mine  = 1
// Flag  = 2
//

public class Tile {
    //--------------- Attributes ------------------
    
    //Info about the Tile
    int type = 0;
    boolean covering = false;
    
    //Location
    int x = -1;
    int y = -1;
    
    //Neighboring Tiles
    Tile North = null;
    Tile South = null;
    Tile West  = null;
    Tile East  = null;
    
    //-------------- Constructors -----------------
    public Tile(int xIn,int yIn){ // Default Empty Constructor
        covering = true;
        x = xIn;
        y = yIn;
    }
    
    public Tile(int typeIn, int xIn, int yIn){ // Constructor with type
        covering = true;
        type = typeIn;
        x = xIn;
        y = yIn;
    }
    
    public void getDisplay(){}
    
    public void uncover(){covering = false;}
    public void   cover(){covering = true; }
}
