import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTree {

//	private TileNode rootNode;
//	private Queue<TileNode> queue;
//	private final Board<Tile> board;
//	private ArrayList<TileNode> discoveredPanws;
//	private int numOfPawn;
//
//	public BinaryTree(Tile tile, Knight knight, Board<Tile> b, int numOfPawn) {
//		this.rootNode = new TileNode(tile, false, null, numOfPawn);
//		this.board = b;
//		this.numOfPawn = numOfPawn;
//		discoveredPanws = new ArrayList<TileNode>();
//		queue = new LinkedList<TileNode>();
//		queue.add(this.rootNode);
//		addNode();
//		// for (TileNode t : discoveredPanws)
//		// System.out.println(t.toString());
//	}
//
//	public void addNode() {
//		while (!queue.isEmpty()) {
//			TileNode node = queue.remove();
//
//			node.setVisted(true);
//			if (traverse(possibleMovement(node), node)) {
//				System.out.println("--------Traverse 1-------");
//				printOutPath(node);
//				System.out.println("Node Number of Pawns:" + node.getNumOfPawn());
//
//				// setAllToVisited(node);
//				break;
//			}
//			// System.out.println("Queue Size:" + queue.size());
//		}
//	}
//
//	private void printOutPath(TileNode node) {
//		System.out.println(node.getTile().getCoordinates());
//		if (node.getParentNode() != null) {
//			printOutPath(node.getParentNode());
//		}
//
//	}
//
//	// Visit the node first, then left and right sub-trees
//	public boolean traverse(ArrayList<Coordinate> arrayList, TileNode tile) {
//		for (Coordinate c : arrayList) {
//			Tile t = board.getTile(c.row, c.col);
//			TileNode temp = new TileNode(t, false, tile, tile.getNumOfPawn());
//			if (!t.getEmpty()) {
//				if (t.getPiece() instanceof Pawn) {
//					temp.setNumOfPawn(temp.getNumOfPawn() - 1);
//					if (temp.getNumOfPawn() == 0) {
//						System.out.println("--------Traverse 2-------");
//						printOutPath(temp);
//						System.out.println("Node Number of Pawns:" + temp.getNumOfPawn());
//						return true;
//					}
//					// foundAPawn(temp);
//				}
//			}
//			if (tile.getParentNode() == null || temp.getTile() != tile.getParentNode().getTile()) {
////				if (!checkIfVisited(temp, temp.getTile().getCoordinates().row, temp.getTile().getCoordinates().col)) {
//				if(!temp.getVisted()){
//					queue.add(temp);
//				}
//			}
//		}
//		return false;
//
//	}
//
//	private boolean checkIfVisited(TileNode node, int row, int col) {
//		if (node.getParentNode() != null) {
//			int i = node.getParentNode().getTile().getCoordinates().row;
//			int k = node.getParentNode().getTile().getCoordinates().col;
//			if (i == row) {
//				if (k == col) {
//					System.out.println("not");
//					return true;
//				}
//			} else {
//				checkIfVisited(node.getParentNode(), row, col);
//			}
//		}
//		return false;
//	}
//
//	private void foundAPawn(TileNode tileNode) {
//		discoveredPanws.add(tileNode);
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
