
public class TileNode {

	private Tile tile;
	private Boolean visted;
	private TileNode parentNode;
	private int numOfPawn;
	
	/**
	 * @param tile
	 * @param visted
	 * @param numOfPawn 
	 */
	public TileNode(Tile tile, Boolean visited, TileNode t, int numOfPawn) {
		super();
		this.setTile(tile);
		this.setParentNode(t);
		this.setNumOfPawn(numOfPawn);
		this.setVisted(visited);
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile the tile to set
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	/**
	 * @return the visted
	 */
	public Boolean getVisted() {
		return this.visted;
	}

	/**
	 * @param visted the visted to set
	 */
	public void setVisted(Boolean visited) {
		this.visted = visited;
	}

	/**
	 * @return the parentNode
	 */
	public TileNode getParentNode() {
		return parentNode;
	}

	/**
	 * @param parentNode the parentNode to set
	 */
	public void setParentNode(TileNode parentNode) {
		this.parentNode = parentNode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TileNode [tile=" + tile + ", visted=" + visted + ", parentNode=" + parentNode + ", numOfPawn="
				+ numOfPawn + "]";
	}

	/**
	 * @return the numOfPawn
	 */
	public int getNumOfPawn() {
		return numOfPawn;
	}

	/**
	 * @param numOfPawn the numOfPawn to set
	 */
	public void setNumOfPawn(int numOfPawn) {
		this.numOfPawn = numOfPawn;
	}
}
