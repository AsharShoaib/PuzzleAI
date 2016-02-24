import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * depth first search implementation using a stack structure instead of a queue
 * structure as exhibited in the breadth first search algorithm
 */
public class DepthFirstSearch extends AbstractSearch {

	public Tile startNode;
	public ArrayList<Tile> goalNode;
	public Board<Tile> board;
	public ArrayList<Tile> visitedNodes;
	public int numOfPawn;

	public DepthFirstSearch(Tile start, ArrayList<Tile> goalNode, Board<Tile> board, int numOfPawn) {
		super(start, goalNode);
		this.startNode = start;
		this.goalNode = goalNode;
		this.board = board;
		this.numOfPawn = numOfPawn;
	}

	public ArrayList<Tile> execute() {

		Stack<Tile> nodeStack = new Stack<>();
		visitedNodes = new ArrayList<>();

		nodeStack.add(startNode);

		while (numOfPawn!=0) {
			Tile current = nodeStack.pop();
			if (foundNode(current)) {
				System.out.println("Goal node left: " + numOfPawn);
					visitedNodes.add(current);
					numOfPawn--;
					goalNode.remove(current);

			} else {
				visitedNodes.add(current);
				ArrayList<Tile> children = current.getChildren(board);
				for (Tile t : children) {
					if (!visitedNodes.contains(t))
						nodeStack.add(t);
				}
			}
		}
		return visitedNodes;
	}

	private boolean foundNode(Tile current) {
		for (Tile tn : goalNode) {
			if (tn.equals(current)) {
				System.out.println("Tile :" + tn.getCoordinates() + " Equals :" + current.getCoordinates());
				return true;
			}
		}
		return false;
	}

}