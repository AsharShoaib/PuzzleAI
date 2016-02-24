import java.util.ArrayList;

public abstract class AbstractSearch {

    TileNode startNode;
    ArrayList<Tile> goalNode;

    public AbstractSearch(TileNode startNode, ArrayList<Tile> goalNode2){
        this.startNode = startNode;
        this.goalNode = goalNode2;
    }

    public abstract ArrayList<Tile> execute();

}
