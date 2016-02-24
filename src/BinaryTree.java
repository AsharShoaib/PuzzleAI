import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	private BinaryTree left;
	private BinaryTree right;
	private TileNode rootNode;
	private Queue<TileNode> queue;
	private Knight knight;
	private Board<Tile> board;
	private ArrayList<TileNode> discoveredPanws;
	private int numOfPawn;

	public BinaryTree(Tile tile, Knight knight, Board<Tile> b, int numOfPawn) {
		this.rootNode = new TileNode(tile, false, null, numOfPawn);
		this.knight = knight;
		this.board = b;
		this.numOfPawn = numOfPawn;
		discoveredPanws = new ArrayList<TileNode>();
		queue = new LinkedList<TileNode>();
		queue.add(this.rootNode);
		addNode();
//		for (TileNode t : discoveredPanws)
//			System.out.println(t.toString());
	}

	public void addNode() {
		while (!queue.isEmpty()) {
			TileNode node = queue.remove();
			if (node.getNumOfPawn() == 0) {
				System.out.println("WOOW");
				System.out.println(node.toString());
//				setAllToVisited(node);
				break;
			}

			node.setVisted(true);
			traverse(possibleMovement(node), node);

		}
	}

	private boolean checkIfVisited(TileNode node) {
		if (node.getParentNode() != null) {
			if (node.getParentNode().getTile() == node.getTile()) {
				return true;
			} else {
				checkIfVisited(node.getParentNode());
			}
		} else {
			return false;
		}
		return false;
	}

	private void setAllToVisited(TileNode node) {
		node.setVisted(true);
		if (node.getParentNode() != null)
			setAllToVisited(node.getParentNode());

	}

	// Visit the node first, then left and right sub-trees
	public void traverse(ArrayList<Coordinate> arrayList, TileNode tile) {
		for (Coordinate c : arrayList) {
			Tile t = board.getTile(c.row, c.col);
			TileNode temp = new TileNode(t, false, tile, tile.getNumOfPawn());
//			if (!checkIfVisited(temp)) {
				if (!t.getEmpty()) {
					if (t.getPiece() instanceof Pawn) {
						temp.setNumOfPawn(temp.getNumOfPawn() - 1);
						foundAPawn(temp);
					}
				}
				queue.add(temp);
//			}
		}
	}

	private void foundAPawn(TileNode tileNode) {
		discoveredPanws.add(tileNode);
	}

	public ArrayList<Coordinate> possibleMovement(TileNode t) {
		ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
		if (!(t.getTile().getCoordinates().row - 2 < 0)) {
			if (!(t.getTile().getCoordinates().col - 1 < 0))
				temp.add(new Coordinate(t.getTile().getCoordinates().row - 2, t.getTile().getCoordinates().col - 1));
			if (!(t.getTile().getCoordinates().col + 1 > Main.colLength - 1))
				temp.add(new Coordinate(t.getTile().getCoordinates().row - 2, t.getTile().getCoordinates().col + 1));
		}
		if (!(t.getTile().getCoordinates().row + 2 > Main.rowLength - 1)) {
			if (!(t.getTile().getCoordinates().col - 1 < 0))
				temp.add(new Coordinate(t.getTile().getCoordinates().row + 2, t.getTile().getCoordinates().col - 1));
			if (!(t.getTile().getCoordinates().col + 1 > Main.colLength - 1))
				temp.add(new Coordinate(t.getTile().getCoordinates().row + 2, t.getTile().getCoordinates().col + 1));
		}
		if (!(t.getTile().getCoordinates().col - 2 < 0)) {
			if (!(t.getTile().getCoordinates().row - 1 < 0))
				temp.add(new Coordinate(t.getTile().getCoordinates().row - 1, t.getTile().getCoordinates().col - 2));
			if (!(t.getTile().getCoordinates().row + 1 > Main.colLength - 1))
				temp.add(new Coordinate(t.getTile().getCoordinates().row + 1, t.getTile().getCoordinates().col - 2));
		}
		if (!(t.getTile().getCoordinates().col + 2 > Main.colLength - 1)) {
			if (!(t.getTile().getCoordinates().row - 1 < 0))
				temp.add(new Coordinate(t.getTile().getCoordinates().row - 1, t.getTile().getCoordinates().col + 2));
			if (!(t.getTile().getCoordinates().row + 1 > Main.colLength - 1))
				temp.add(new Coordinate(t.getTile().getCoordinates().row + 1, t.getTile().getCoordinates().col + 2));
		}
		// System.out.println(temp.toString());
		return temp;
	}

}
