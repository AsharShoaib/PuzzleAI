import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	static Board<Tile> board;

	public static final int min = 1;
	public static final int max = 10;
	public static final int rowLength = 8;
	public static final int colLength = 8;

	public static final int minMovementOption = 1;
	public static final int maxMovementOption = 4;

	private static int numOfPawn;

	public static void main(String[] args) {
		makeBoard();
		addPawns();
		drawBoard();
		movePawns();
	}

	private static void movePawns() {
		for (ArrayList<Tile> rowList : board) {
			for (Tile tile : rowList) {
				if (!tile.getEmpty()){
					switch(tile.getPiece().getMovement()){
					case 1:
						
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					}
					
				}
			}
		}
	}

	private static void drawBoard() {
		for (ArrayList<Tile> rowList : board) {
			for (Tile tile : rowList) {
				if (tile.getEmpty())
					System.out.print("[ ]");
				else
					System.out.print("[P]");

			}
			System.out.println("");
		}

	}

	private static void makeBoard() {
		board = new Board<Tile>();
		initBoard();
		popAdjTiles();
	}

	private static void popAdjTiles() {
		for (ArrayList<Tile> rowList : board) {
			for (Tile tile : rowList) {
				Tile adjacentTiles[] = new Tile[4];
				if (tile.getCoordinates().getRow() > 0)
					adjacentTiles[0] = board.getTile(tile.getCoordinates().getRow() - 1,
							tile.getCoordinates().getCol());
				else {
					adjacentTiles[0] = null;
				}

				if (tile.getCoordinates().getCol() < Main.colLength - 1) {
					adjacentTiles[1] = board.getTile(tile.getCoordinates().getRow(),
							tile.getCoordinates().getCol() + 1);
				} else {
					adjacentTiles[1] = null;
				}
				if (tile.getCoordinates().getRow() < Main.rowLength - 1) {
					adjacentTiles[2] = board.getTile(tile.getCoordinates().getRow() + 1,
							tile.getCoordinates().getCol());
				} else {
					adjacentTiles[2] = null;
				}
				if (tile.getCoordinates().getCol() > 0) {
					adjacentTiles[3] = board.getTile(tile.getCoordinates().getRow(),
							tile.getCoordinates().getCol() - 1);
				} else {
					adjacentTiles[3] = null;
				}
				tile.populateAdjacentTiles(adjacentTiles);
			}
		}

	}

	private static void addPawns() {
		numOfPawn = ThreadLocalRandom.current().nextInt(min, max + 1);
		for (int i = 0; i < numOfPawn; i++) {
			int x = ThreadLocalRandom.current().nextInt(0, rowLength);
			int y = ThreadLocalRandom.current().nextInt(0, colLength);
			board.getTile(x, y).addPawn();
			board.getTile(x, y).setEmpty(false);
		}

	}

	private static void initBoard() {
		int row; // Row number, from 0 to 7
		int col; // Column number, from 0 to 7
		int x, y; // Top-left corner of square

		for (row = 0; row < rowLength; row++) {

			for (col = 0; col < colLength; col++) {
				x = col * 20;
				y = row * 20;
				if ((row % 2) == (col % 2)) {
					board.addToInnerArray(row, col, (new Tile(new Coordinate(row, col), true)));
				} else {
					board.addToInnerArray(row, col, (new Tile(new Coordinate(row, col), true)));
				}

			}
			System.out.println();

		} // end for row
	}
}
