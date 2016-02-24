import java.util.ArrayList;
import java.util.PriorityQueue;

public class AlgorthimCoordinate {
	public static int UP_COST = 1;
	public static int DOWN_COST = 1;

	// Blocked cells are just null Tile values in grid
//	static Tile[][] grid = new Tile[5][5];

	static PriorityQueue<Tile> open = new PriorityQueue<Tile>();

	static boolean closed[][] = new boolean[Main.rowLength][Main.colLength];
	static Tile start;
	static public ArrayList<Tile> end;
	static public int numOfPawns;
	static public ArrayList<Tile> visitedNodes;
	
	public void setStartCell(Tile t) {
		start = t;
	}

	public void setEndCell(ArrayList<Tile> t) {
		end = t;
	}

	public void checkAndUpdateCost(Tile current, Tile t, int cost) {
		if (t == null || closed[t.i][t.j])
			return;
		int t_final_cost = t.heuristicCost + cost;

		boolean inOpen = open.contains(t);
		if (!inOpen || t_final_cost < t.finalCost) {
			t.finalCost = t_final_cost;
			t.parent = current;
			if (!inOpen)
				open.add(t);
		}
	}

	public ArrayList<Tile> AStar() {
		if(start.i>=Main.rowLength/2){
			this.DOWN_COST = 2;
		}else{
			this.UP_COST = 2;
		}
		numOfPawns = end.size();
		visitedNodes = new ArrayList<>();
		// add the start location to open list.
		open.add(start);
		visitedNodes.add(start);
		Tile current;

		while (true) {
			current = open.poll();
			if (current == null){
				break;
			}
			closed[current.i][current.j] = true;

			if (foundNode(current)) {
				System.out.println("Found the node" + current.finalCost);
				end.remove(current);
				numOfPawns--;
				visitedNodes.add(current);
				if(numOfPawns==0){
					return visitedNodes;
				}
			}

			if (!current.getChildren(Main.board).isEmpty()) {
				ArrayList<Tile> children = current.getChildren(Main.board);
				for (Tile t : children) {
					if(current.i>t.i)
						checkAndUpdateCost(current, t, current.finalCost + UP_COST);
					else
						checkAndUpdateCost(current, t, current.finalCost + DOWN_COST);

				}
			}

		}
		return visitedNodes;
	}

	private boolean foundNode(Tile current) {
		for (Tile tn : end) {
			if (tn.equals(current)) {
				System.out.println("Tile :" + tn.getCoordinates() + " Equals :" + current.getCoordinates());
				return true;
			}
		}
		return false;
	}
}
