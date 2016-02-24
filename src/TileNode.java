import java.util.ArrayList;
import java.util.Collection;

public class TileNode extends Cell {

	private Tile tile;
	private Boolean visted;
	private TileNode parentNode;
	private int numOfPawn;

	/**
	 */
	public TileNode() {
		super();
		this.setVisted(false);
	}

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile
	 *            the tile to set
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
	 * @param visted
	 *            the visted to set
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
	 * @param parentNode
	 *            the parentNode to set
	 */
	public void setParentNode(TileNode parentNode) {
		this.parentNode = parentNode;
	}

	/*
	 * (non-Javadoc)
	 * 
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
	 * @param numOfPawn
	 *            the numOfPawn to set
	 */
	public void setNumOfPawn(int numOfPawn) {
		this.numOfPawn = numOfPawn;
	}
	@Override
	public int compareTo(Tile other) {
	    return Integer.compare(this.finalCost, other.finalCost);
	}
}
