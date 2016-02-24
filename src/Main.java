import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static Board<Tile> board;

	static Knight knightPlayer;

	public static final int min = 1;
	public static final int max = 10;
	public static final int rowLength = 8;
	public static final int colLength = 8;

	public static final int minMovementOption = 1;
	public static final int maxMovementOption = 4;
	public static ArrayList<Tile> pawns;
	static DepthFirstSearch dfs;
	static BreadthFirstSearch bfs;

	private static int numOfPawn;
	private static AStartAlgor aStar;
	public static void main(String[] args) {
		makeBoard();
		addPawns();
		initPlayer();
		drawBoard();

//		 dfs = new DepthFirstSearch(board.getTile(knightPlayer.row,knightPlayer.col), pawns, board, numOfPawn);
//		 dfs.execute();
//		 Main.makeMovements(dfs.visitedNodes);

//		bfs = new BreadthFirstSearch(board.getTile(knightPlayer.row, knightPlayer.col), pawns, board, numOfPawn);
//		Main.makeMovements(bfs.execute());
		
		aStar = new AStartAlgor();
		aStar.setStartCell(board.getTile(knightPlayer.row, knightPlayer.col));
		aStar.setEndCell(pawns);
		aStar.AStar();
		// int i = 0;
		// while (i < 5) {
		// ArrayList<Coordinate> ltemp = knightPlayer.possibleMovement();
		// System.out.println(ltemp);
		// movePawns();
		// drawBoard();
		// i++;
		// }
	}

	static void makeMovements(ArrayList<Tile> visitedNodes) {
		for (Tile t : visitedNodes) {
			System.out.println(t.getCoordinates());
			
			//Main.board.movePawns();
			board.moveKnight(t);
			drawBoard();
		}

	}

	private static void initPlayer() {
		knightPlayer = new Knight(getEmptyTile());
		board.addKnight(knightPlayer);

	}

	private static Coordinate getEmptyTile() {
		Boolean flag = false;
		Coordinate c = null;
		while (!flag) {
			int x = ThreadLocalRandom.current().nextInt(1, rowLength - 1);
			int y = ThreadLocalRandom.current().nextInt(1, colLength - 1);
			if (board.getTile(x, y).getEmpty()) {
				flag = true;
				c = new Coordinate(x, y);
			}
		}
		return c;
	}

	private static boolean getEmptyTile(int x, int y) {

		if (board.getTile(x, y).getEmpty()) {
			return true;
		}

		return false;
	}

	private static Coordinate getEmptyTileForPawn() {
		Boolean flag = false;
		Coordinate c = null;
		while (!flag) {
			int x = ThreadLocalRandom.current().nextInt(1, rowLength - 1);
			int y = ThreadLocalRandom.current().nextInt(1, colLength - 1);
			if (board.getTile(x, y).getEmpty() && getEmptyTile(x + 1, y) && getEmptyTile(x - 1, y)
					&& getEmptyTile(x, y + 1) && getEmptyTile(x, y - 1)) {
				flag = true;
				c = new Coordinate(x, y);
			}
		}
		return c;
	}

	static void movePawns() {
		for (ArrayList<Tile> rowList : board) {
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

	static void movePawnsAtTile(Tile tile) {

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
		for (ArrayList<Tile> rowList : board) {
			for (Tile tile : rowList) {
				if (!tile.getEmpty() && tile.getPiece().isState() && (tile.getPiece() instanceof Pawn)) {
					tile.getPiece().setState(false);
				}
			}
		}
	}

	public static void drawBoard() {
		int temp = 0;
		int temp2 = 0;
		System.out.println("-------------------------------");
		System.out.println("");

		for (int i = 0; i < Main.rowLength; i++) {
			System.out.print(temp);
			temp++;
			for (int k = 0; k < Main.colLength; k++) {

				if (board.getTile(i, k).getEmpty())
					System.out.print("[ ]");
				else if (board.getTile(i, k).getPiece() instanceof Pawn) {
					System.out.print("[P]");
					temp2++;
				} else {
					System.out.print("[K]");
				}

			}
			System.out.println("");
		}
		System.out.println("");
		System.out.print(temp2);
		System.out.println("");
	}

	private static void makeBoard() {
		board = new Board<Tile>();
		initBoard();
		popAdjTiles();
	}

	private static void popAdjTiles() {
		int row; // Row number, from 0 to 7
		int col; // Column number, from 0 to 7
		for (row = 0; row < rowLength; row++) {
			for (col = 0; col < colLength; col++) {
				Tile adjacentTiles[] = new Tile[4];
				Tile tile = board.getTile(row, col);
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
		pawns = new ArrayList<Tile>();
		System.out.println(numOfPawn);
		for (int i = 0; i < numOfPawn; i++) {
			Coordinate c = getEmptyTileForPawn();
			board.addPawn(c.getRow(), c.getCol());
			pawns.add(board.getTile(c.getRow(), c.getCol()));
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
