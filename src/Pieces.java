
abstract class Pieces extends Coordinate{
	public Pieces(int r, int c) {
		super(r, c);
		// TODO Auto-generated constructor stub
	}

	protected int Movement;
	protected boolean state = false;

	/**
	 * @return the movement
	 */
	public int getMovement() {
		return Movement;
	}

	/**
	 * @param movement
	 *            the movement to set
	 */
	public void setMovement(int movement) {
		Movement = movement;
	}

	public void moveUp(int i) {
		if (!this.state) {
			this.setRow(this.getRow() - 1);
			this.state = true;
		}
	}

	public void moveRight(int i) {
		if (!this.state) {
			this.setCol(this.getCol() + 1);
			this.state = true;
		}
	}

	public void moveDown(int i) {
		if (!this.state) {
			this.setRow(this.getRow() + 1);
			this.state = true;
		}
	}

	public void moveLeft(int i) {
		if (!this.state) {
			this.setCol(this.getCol() - 1);
			this.state = true;
		}
	}
	
	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Coordinate coordinates) {
		this.setRow(coordinates.getRow());
		this.setRow(coordinates.getRow());
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public abstract void setState(boolean state);
}
