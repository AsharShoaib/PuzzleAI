import java.util.*;

public class AStartAlgor {
	public static final int DIAGONAL_COST = 14;
	public static final int V_H_COST = 1;

	// Blocked cells are just null Tile values in grid
//	static Tile[][] grid = new Tile[5][5];

	static PriorityQueue<Tile> open = new PriorityQueue<Tile>();

	static boolean closed[][] = new boolean[Main.rowLength][Main.colLength];
	static Tile start;
	static public ArrayList<Tile> end;

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

	public void AStar() {

		// add the start location to open list.
		open.add(start);

		Tile current;

		while (true) {
			current = open.poll();
			if (current == null)
				break;
			closed[current.i][current.j] = true;

			if (end.contains(current)) {
				return;
			}

			if (!current.getChildren(Main.board).isEmpty()) {
				ArrayList<Tile> children = current.getChildren(Main.board);
				for (Tile t : children) {
					checkAndUpdateCost(current, t, current.finalCost + V_H_COST);
				}
			}

		}
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