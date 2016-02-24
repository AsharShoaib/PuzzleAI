
public class Cell implements Comparable<Cell> {
	int heuristicCost = 0; // Heuristic cost
	int finalCost = 0; // G+H
	int i, j;
	Cell parent;

	Cell(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public Cell() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "[" + this.i + ", " + this.j + "]";
	}

	public int compareTo(Tile other) {
		return Integer.compare(this.finalCost, other.finalCost);
	}

	@Override
	public int compareTo(Cell o) {
		return Integer.compare(this.finalCost, o.finalCost);

	}
}
