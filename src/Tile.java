import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Tile extends TileNode {

	private Coordinate coordinates;
	private Boolean empty;
	private Pieces piece;
	private Tile adjacentTiles [];
	private boolean visited;
	
	/**
	 * @param coordinates
	 * @param empty
	 */
	public Tile(Coordinate coordinates, Boolean empty) {
		super();
		this.coordinates = coordinates;
		this.i = coordinates.row;
		this.j = coordinates.col;
		this.empty = empty;
		this.visited = false;
	}
	public void populateAdjacentTiles(Tile[] tileArray) {
		this.adjacentTiles = tileArray;
	}
	/**
	 * @return the coordinates
	 */
	public Coordinate getCoordinates() {
		return coordinates;
	}
	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}
	/**
	 * @return the empty
	 */
	public Boolean getEmpty() {
		return empty;
	}
	/**
	 * @param empty the empty to set
	 */
	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}
	/**
	 * @return the adjacentTiles
	 */
	public Tile[] getAdjacentTiles() {
		return adjacentTiles;
	}
	/**
	 * @param adjacentTiles the adjacentTiles to set
	 */
	public void setAdjacentTiles(Tile[] adjacentTiles) {
		this.adjacentTiles = adjacentTiles;
	}
	/**
	 * @return the piece
	 */
	public Pieces getPiece() {
		return piece;
	}
	/**
	 * @param piece the piece to set
	 */
	public void setPiece(Pawn piece) {
		this.piece = piece;
	}
	
	public void addPiece(){
		piece = new Pawn(coordinates);
	}
	public void addPiece(Pieces p){
		piece = p;
	}
	public void removePawn() {
		piece=null;
	}
	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}
	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public ArrayList<Tile> getChildren(Board<Tile> board) {
		ArrayList<Coordinate> movesList = possibleMovement(this);
		ArrayList<Tile> nodeList = new ArrayList<Tile>();
		Tile tile = null;
		for (Coordinate c : movesList) {
			tile = board.getTile(c.row, c.col);
			nodeList.add(tile);
		}

		return nodeList;
	}

	public ArrayList<Coordinate> possibleMovement(Tile t) {
		ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
		if (!(t.getCoordinates().row - 2 < 0)) {
			if (!(t.getCoordinates().col - 1 < 0))
				temp.add(new Coordinate(t.getCoordinates().row - 2, t.getCoordinates().col - 1));
			if (!(t.getCoordinates().col + 1 > Main.colLength - 1))
				temp.add(new Coordinate(t.getCoordinates().row - 2, t.getCoordinates().col + 1));
		}
		if (!(t.getCoordinates().row + 2 > Main.rowLength - 1)) {
			if (!(t.getCoordinates().col - 1 < 0))
				temp.add(new Coordinate(t.getCoordinates().row + 2, t.getCoordinates().col - 1));
			if (!(t.getCoordinates().col + 1 > Main.colLength - 1))
				temp.add(new Coordinate(t.getCoordinates().row + 2, t.getCoordinates().col + 1));
		}
		if (!(t.getCoordinates().col - 2 < 0)) {
			if (!(t.getCoordinates().row - 1 < 0))
				temp.add(new Coordinate(t.getCoordinates().row - 1, t.getCoordinates().col - 2));
			if (!(t.getCoordinates().row + 1 > Main.colLength - 1))
				temp.add(new Coordinate(t.getCoordinates().row + 1, t.getCoordinates().col - 2));
		}
		if (!(t.getCoordinates().col + 2 > Main.colLength - 1)) {
			if (!(t.getCoordinates().row - 1 < 0))
				temp.add(new Coordinate(t.getCoordinates().row - 1, t.getCoordinates().col + 2));
			if (!(t.getCoordinates().row + 1 > Main.colLength - 1))
				temp.add(new Coordinate(t.getCoordinates().row + 1, t.getCoordinates().col + 2));
		}
		// System.out.println(temp.toString());
		return temp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tile [empty=" + empty + ", piece=" + piece +  ", visited=" + visited + "]";
	}
	
	@Override
	public int compareTo(Tile other) {
	    return Integer.compare(this.finalCost, other.finalCost);
	}
}
