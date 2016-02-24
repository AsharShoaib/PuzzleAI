import java.util.ArrayList;
import java.util.Collection;

public class Board<T> extends ArrayList<ArrayList<T>> {

	private ArrayList<Pawn> piece = new ArrayList<Pawn>();
	private Knight knight;

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

	public void addKnight(Knight k) {
		Tile tile = (Tile) getTile(k.getRow(), k.getCol());
		tile.addPiece(k);
		this.knight = k;
		tile.setEmpty(false);
	}

	public void moveKnight(Tile t) {
		Tile tile = (Tile) this.getTile(this.knight.getRow(), this.knight.getCol());
		tile.setEmpty(true);
		tile.setPiece(null);
		tile = (Tile) this.getTile(t.getCoordinates().row, t.getCoordinates().col);
		tile.addPiece(this.knight);
		this.knight.setCol(t.getCoordinates().col);
		this.knight.setRow(t.getCoordinates().row);
		tile.setEmpty(false);

	}

	public void movePawns() {
		for (ArrayList<Tile> rowList : Main.board) {
			for (Tile tile : rowList) {
				if (!tile.getEmpty()) {
					if (!tile.getPiece().isState() && (tile.getPiece() instanceof Pawn)) {
						Tile temp;
						switch (tile.getPiece().getMovement()) {
						case 1:
							tile.setEmpty(true);
							temp = tile.getAdjacentTiles()[0];
							temp.setEmpty(false);
							temp.addPiece((Pawn) tile.getPiece());
							tile.removePawn();
							temp.getPiece().moveUp(1);
							break;
						case 2:
							tile.setEmpty(true);
							temp = tile.getAdjacentTiles()[1];
							temp.setEmpty(false);
							temp.addPiece((Pawn) tile.getPiece());
							tile.removePawn();
							temp.getPiece().moveRight(1);
							break;
						case 3:
							tile.setEmpty(true);
							temp = tile.getAdjacentTiles()[2];
							temp.setEmpty(false);
							temp.addPiece((Pawn) tile.getPiece());
							tile.removePawn();
							temp.getPiece().moveDown(1);
							break;
						case 4:
							tile.setEmpty(true);
							temp = tile.getAdjacentTiles()[3];
							temp.setEmpty(false);
							temp.addPiece((Pawn) tile.getPiece());
							tile.removePawn();
							temp.getPiece().moveLeft(1);
							break;
						}
					}

				}
			}
		}
		movesComplete();
	}

	public static void movePawnsAtTile(Tile tile) {

		if (!tile.getEmpty()) {
			if (!tile.getPiece().isState() && (tile.getPiece() instanceof Pawn)) {
				Tile temp;
				switch (tile.getPiece().getMovement()) {
				case 1:
					tile.setEmpty(true);
					temp = tile.getAdjacentTiles()[0];
					temp.setEmpty(false);
					temp.addPiece((Pawn) tile.getPiece());
					tile.removePawn();
					temp.getPiece().moveUp(1);
					break;
				case 2:
					tile.setEmpty(true);
					temp = tile.getAdjacentTiles()[1];
					temp.setEmpty(false);
					temp.addPiece((Pawn) tile.getPiece());
					tile.removePawn();
					temp.getPiece().moveRight(1);
					break;
				case 3:
					tile.setEmpty(true);
					temp = tile.getAdjacentTiles()[2];
					temp.setEmpty(false);
					temp.addPiece((Pawn) tile.getPiece());
					tile.removePawn();
					temp.getPiece().moveDown(1);
					break;
				case 4:
					tile.setEmpty(true);
					temp = tile.getAdjacentTiles()[3];
					temp.setEmpty(false);
					temp.addPiece((Pawn) tile.getPiece());
					tile.removePawn();
					temp.getPiece().moveLeft(1);
					break;
				}
			}

		}
		movesComplete();
	}

	private static void movesComplete() {
		for (ArrayList<Tile> rowList : Main.board) {
			for (Tile tile : rowList) {
				if (!tile.getEmpty() && tile.getPiece().isState() && (tile.getPiece() instanceof Pawn)) {
					tile.getPiece().setState(false);
				}
			}
		}
	}

	public ArrayList<Tile> getPawns() {
		ArrayList<Tile> temp = new ArrayList<Tile>();
		for (ArrayList<Tile> rowList : Main.board) {
			for (Tile tile : rowList) {
				if (!tile.getEmpty()) {
					if (!tile.getPiece().isState() && (tile.getPiece() instanceof Pawn)) {
						temp.add(tile);
					}
				}
			}
		}
		return temp;
	}

}
