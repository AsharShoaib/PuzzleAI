import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {

//	private TileNode rootNode;
//	private Stack<TileNode> stack;
//	private final Board<Tile> board;
//	private ArrayList<TileNode> discoveredPanws;
//
//	public DFS(Tile tile, Board<Tile> board, int numOfPawn) {
//		this.rootNode = new TileNode(tile, false, null, numOfPawn);
//		this.board = board;
//		discoveredPanws = new ArrayList<TileNode>();
//		stack = new Stack<TileNode>();
//		dfsRoot(rootNode);
//	}
//
//	private void dfsRoot(TileNode rootNode2) {
//		ArrayList<Coordinate> movesList = possibleMovement(rootNode2);
//		ArrayList<TileNode> nodeList = new ArrayList<TileNode>();
//		TileNode tile = null;
//		for (Coordinate c : movesList) {
//			tile = new TileNode(board.getTile(c.row, c.col), null, rootNode2, rootNode2.getNumOfPawn());
//			tile = dfs(tile);
//			if (tile != null)
//				nodeList.add(tile);
//		}
//		
//		System.out.println("NodeList:"+ nodeList);
//
//	}
//
//	public TileNode dfs(TileNode source) {
//		source.setVisted(true);
//		if (!source.getTile().getEmpty() && source.getTile().getPiece() instanceof Pawn) {
//			source.setNumOfPawn(source.getNumOfPawn() - 1);
//			return source;
//		} else {
//			ArrayList<Coordinate> movesList = possibleMovement(source);
//			TileNode tile = null;
//			for (Coordinate c : movesList) {
//				tile = new TileNode(board.getTile(c.row, c.col), null, source, source.getNumOfPawn());
//				if (!tile.getVisted()) {
//					if (!tile.getTile().getEmpty() && tile.getTile().getPiece() instanceof Pawn) {
//						tile.setNumOfPawn(tile.getNumOfPawn() - 1);
//						return tile;
//					} else {
//						dfs(tile);
//					}
//				}
//			}
//		}
//		return null;
//
//	}
//
//	public ArrayList<Coordinate> possibleMovement(TileNode t) {
//		ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
//		if (!(t.getTile().getCoordinates().row - 2 < 0)) {
//			if (!(t.getTile().getCoordinates().col - 1 < 0))
//				temp.add(new Coordinate(t.getTile().getCoordinates().row - 2, t.getTile().getCoordinates().col - 1));
//			if (!(t.getTile().getCoordinates().col + 1 > Main.colLength - 1))
//				temp.add(new Coordinate(t.getTile().getCoordinates().row - 2, t.getTile().getCoordinates().col + 1));
//		}
//		if (!(t.getTile().getCoordinates().row + 2 > Main.rowLength - 1)) {
//			if (!(t.getTile().getCoordinates().col - 1 < 0))
//				temp.add(new Coordinate(t.getTile().getCoordinates().row + 2, t.getTile().getCoordinates().col - 1));
//			if (!(t.getTile().getCoordinates().col + 1 > Main.colLength - 1))
//				temp.add(new Coordinate(t.getTile().getCoordinates().row + 2, t.getTile().getCoordinates().col + 1));
//		}
//		if (!(t.getTile().getCoordinates().col - 2 < 0)) {
//			if (!(t.getTile().getCoordinates().row - 1 < 0))
//				temp.add(new Coordinate(t.getTile().getCoordinates().row - 1, t.getTile().getCoordinates().col - 2));
//			if (!(t.getTile().getCoordinates().row + 1 > Main.colLength - 1))
//				temp.add(new Coordinate(t.getTile().getCoordinates().row + 1, t.getTile().getCoordinates().col - 2));
//		}
//		if (!(t.getTile().getCoordinates().col + 2 > Main.colLength - 1)) {
//			if (!(t.getTile().getCoordinates().row - 1 < 0))
//				temp.add(new Coordinate(t.getTile().getCoordinates().row - 1, t.getTile().getCoordinates().col + 2));
//			if (!(t.getTile().getCoordinates().row + 1 > Main.colLength - 1))
//				temp.add(new Coordinate(t.getTile().getCoordinates().row + 1, t.getTile().getCoordinates().col + 2));
//		}
//		// System.out.println(temp.toString());
//		return temp;
//	}

}
