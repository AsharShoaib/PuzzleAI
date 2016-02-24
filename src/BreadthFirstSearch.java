import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * basic breadth first search in java
 */
public class BreadthFirstSearch extends AbstractSearch {

	Tile startNode;
	public ArrayList<Tile> goalNode;
	public ArrayList<Tile> visitedNodes;
	public int numOfPawn;
	public ArrayList<Pawn> pawnList;

	public BreadthFirstSearch(Tile start, ArrayList<Tile> goalNode, Board<Tile> board, int numOfPawn) {
		super(start, goalNode);
		this.startNode = start;
		this.goalNode = Main.board.getPawns();
//		Main.board.movePawns();
//		for(Tile t :Main.board.getPawns())
//			this.goalNode.add(t);
//		Main.board.movePawns();
		this.numOfPawn = numOfPawn;
		this.pawnList = getPawns();
		
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
				if (current.getChildren(Main.board).isEmpty())
					return false;
				else
					queue.addAll(current.getChildren(Main.board));
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
				if (!current.getChildren(Main.board).isEmpty()){
					ArrayList<Tile> children = current.getChildren(Main.board);
					for (Tile t : children) {
						queue.add(t);
					}
				}
			}
			visitedNodes.add(current);
//			update();
		}

		return visitedNodes;

	}

	
	private void update() {
		Main.board.movePawns();
//		Main.drawBoard();
		
	}

	private ArrayList<Pawn> getPawns(){
		ArrayList<Pawn> pawnList = new ArrayList<Pawn>();
		for (Tile tn : goalNode) {
			pawnList.add((Pawn) tn.getPiece());
		}
		return pawnList;
		
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