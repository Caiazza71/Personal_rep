package MineSchweeper;
import java.util.ArrayList;
import java.util.Random;

public class Board {
    int width = 0;
    int height = 0;
    Tile Head = null;
    
    //Arrays of all objects for easier access
    ArrayList<Tile> linearBoard = new ArrayList<Tile>();
    ArrayList<Tile>    mines    = new ArrayList<Tile>();
    
    public Board(int mineTotal, int x, int y){
        width  = x;
        height = y;
        
        Head = createTiles(x, y);
        placeMines(mineTotal,Head);
    }
    
    //Initializing the Tiles and connecting them all together
    private Tile createTiles(int x, int y){
        Tile head = new Tile(0,0);
        Tile currentHead = head;
        Tile previous    = head;
        //Loop creating the rows
        for(int h = 0; h < y; h ++){
            
            //creates one row at a time with the assumption that the first is already there
            for(int w = 1; w < x; w++){
                Tile newTile = new Tile(w,h);
                if(previous.North != null){// Theres a line above
                    if(previous.North.East != null){
                        previous.North.East.South = newTile;
                        newTile.North             = previous.North.East;
                    }
                }
                newTile.West  = previous;
                previous.East = newTile;
            }
            
            //First Node of the next Row created if height isnt reached
            if(h == y-1){
                Tile temp = new Tile(0,h);
                temp.North        = currentHead;
                currentHead.South = temp;
                
                currentHead = temp;
            }
        }
        //Returns the head for later access
        return head;
    }
    
    //Placing the Mines one the Map
    Random rand = new Random();
    private void placeMines(int mineTotal, Tile Head){
        
        for(int i = 0; i < mineTotal; i++){
            
            //Creating a random set of coordinates for a new mine
            int x = rand.nextInt(width -1);
            int y = rand.nextInt(height-1);
            
            //Looping until the one found isnt a mine
            while(getTile(x,y).type != 1){
                x = rand.nextInt(width -1);
                y = rand.nextInt(height-1);
            }
            
            //getting the valid tile and adding it to the mines list
            Tile newMine = getTile(x,y);
            mines.add(newMine);
            
            //Changing the type to a mine
            newMine.type = 1;
        }
    }
    
    //uses the linear board structure to easily jump to a Tile 
        //less looping and a little easier to implement
    public Tile getTile(int x, int y){
        Tile foundTile = null;
        
        //using the x and y values to get a linear index
        int index = (x) + (y*width);
        foundTile = linearBoard.get(index);
        
        return foundTile;
    }
    
    public ArrayList<Tile> getNeighbors(Tile spot){
        ArrayList<Tile> neighbors = new ArrayList<Tile>();
        
        
        return neightbors;
    }
}
