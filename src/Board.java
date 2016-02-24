import java.util.ArrayList;
import java.util.Collection;

public class Board<T> extends ArrayList<ArrayList<T>> {

	private ArrayList<Pawn> piece = new ArrayList<Pawn>();

	public void addToInnerArray(int index, T element) {
		while (index >= this.size()) {
			this.add(new ArrayList<T>());
		}
		this.get(index).add(element);
	}

	public void addToInnerArray(int index, int index2, T element) {
		while (index >= this.size()) {
			this.add(new ArrayList<T>());
		}

		ArrayList<T> inner = this.get(index);
		while (index2 >= inner.size()) {
			inner.add(null);
		}

		inner.set(index2, element);
	}

	public ArrayList<T> getRow(int index) {
		return this.get(index);
	}

	public T getTile(int index, int index2) {
		return this.get(index).get(index2);
	}

	/**
	 * @return the piece
	 */
	public ArrayList<Pawn> getPiece() {
		return piece;
	}

	/**
	 * @param piece
	 *            the piece to set
	 */
	public void setPiece(ArrayList<Pawn> piece) {
		this.piece = piece;
	}

	public void addPawn(int x, int y) {

		Tile tile = (Tile) getTile(x, y);
		tile.addPiece();
		tile.setEmpty(false);
		this.piece.add((Pawn) tile.getPiece());

	}
	
	public void addKnight(Knight k){
		Tile tile = (Tile) getTile(k.getRow(), k.getCol());
		tile.addPiece(k);
		tile.setEmpty(false);
	}

}
