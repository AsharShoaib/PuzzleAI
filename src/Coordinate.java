
public class Coordinate {
//	public static final int A = 0;
//	public static final int B = 1;
//	public static final int C = 2;
//	public static final int D = 3;
//	public static final int E = 4;
//	public static final int F = 5;
//	public static final int G = 6;
//	public static final int H = 7;
//	public static final int I = 8;
//	public static final int J = 9;
//	public static final int K = 10;
//	public static final int L = 11;
//	public static final int M = 12;
//	public static final int N = 13;
//	public static final int O = 14;
//	public static final int P = 15;
//	public static final int Q = 16;
//	public static final int R = 17;
//	public static final int S = 18;
//	public static final int T = 19;
//	public static final int U = 20;
//	public static final int V = 21;
//	public static final int W = 22;
//	public static final int X = 23;
//	public static final int Y = 24;
//	public static final int Z = 25;

	protected int row, col;
	
	public Coordinate(int r, int c) {
		setRow(r);
		setCol(c);
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	public void moveUp(int i) {
		row--;
		
	}

	public void moveRight(int i) {
		col++;
		
	}

	public void moveDown(int i) {
		row++;
	}

	public void moveLeft(int i) {
		col--;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coordinate [row=" + row + ", col=" + col + "]";
	}

}
