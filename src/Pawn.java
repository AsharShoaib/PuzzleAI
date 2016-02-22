import java.util.concurrent.ThreadLocalRandom;

public class Pawn extends Pieces{


	/**
	 * @param coordinates
	 */
	public Pawn(Coordinate coordinates) {
		super(coordinates.getRow(), coordinates.getCol());
		this.Movement = ThreadLocalRandom.current().nextInt(Main.minMovementOption, Main.maxMovementOption + 1);
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
	 * @param state
	 *            the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
		switch (this.Movement) {
		case 1:
			this.Movement = 3;
			break;
		case 2:
			this.Movement = 4;
			break;
		case 3:
			this.Movement = 1;
			break;
		case 4:
			this.Movement = 2;
			break;
		}
	}

}
