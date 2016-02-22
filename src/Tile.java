
public class Tile {

	private Coordinate coordinates;
	private Boolean empty;
	private Pawn piece;
	private Tile adjacentTiles [];
	
	/**
	 * @param coordinates
	 * @param empty
	 */
	public Tile(Coordinate coordinates, Boolean empty) {
		super();
		this.coordinates = coordinates;
		this.empty = empty;
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
	public Pawn getPiece() {
		return piece;
	}
	/**
	 * @param piece the piece to set
	 */
	public void setPiece(Pawn piece) {
		this.piece = piece;
	}
	
	public void addPawn(){
		piece = new Pawn(coordinates);
	}
	public void addPawn(Pawn p){
		piece = p;
	}
	public void removePawn() {
		piece=null;
	}
}
