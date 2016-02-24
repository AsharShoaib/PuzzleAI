import java.util.Arrays;

public class Tile {

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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tile [empty=" + empty + ", piece=" + piece +  ", visited=" + visited + "]";
	}
}
