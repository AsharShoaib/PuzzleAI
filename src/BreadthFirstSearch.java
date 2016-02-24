import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * basic breadth first search in java
 */
public class BreadthFirstSearch extends AbstractSearch {

	Tile startNode;
	public ArrayList<Tile> goalNode;
	public Board<Tile> board;
	public ArrayList<Tile> visitedNodes;
	public int numOfPawn;

	public BreadthFirstSearch(Tile start, ArrayList<Tile> goalNode, Board<Tile> board, int numOfPawn) {
		super(start, goalNode);
		this.startNode = start;
		this.goalNode = goalNode;
		this.board = board;
		this.numOfPawn = numOfPawn;
		// this.compute();
	}

	public boolean compute() {

		if (this.startNode.equals(goalNode)) {
			System.out.println("Goal Node Found!");
			System.out.println(startNode);
		}

		Queue<Tile> queue = new LinkedList<>();
		visitedNodes = new ArrayList<>();
		queue.add(this.startNode);
		visitedNodes.add(startNode);

		while (numOfPawn != 0) {
			Tile current = queue.remove();
			if (foundNode(current)) {
				System.out.println(visitedNodes);
				numOfPawn--;
				return true;
			} else {
				if (current.getChildren(board).isEmpty())
					return false;
				else
					queue.addAll(current.getChildren(board));
			}
			visitedNodes.add(current);
		}

		return false;

	}

	@Override
	public ArrayList<Tile> execute() {

		Queue<Tile> queue = new LinkedList<>();
		visitedNodes = new ArrayList<>();
		queue.add(this.startNode);
		visitedNodes.add(startNode);

		while (numOfPawn != 0)

		{
			Tile current = queue.remove();
			if (foundNode(current)) {
				numOfPawn--;
				goalNode.remove(current);
			} else {
				if (!current.getChildren(board).isEmpty())
					queue.addAll(current.getChildren(board));
			}
			visitedNodes.add(current);
			moveMadeAdjustBoard();
		}

		return visitedNodes;

	}

	private void moveMadeAdjustBoard() {
		for (Tile tn : goalNode) {
			Main.movePawnsAtTile(tn);
		}

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