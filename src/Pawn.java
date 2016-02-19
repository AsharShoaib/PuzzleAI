import java.util.concurrent.ThreadLocalRandom;

public class Pawn {
	
	
	private Coordinate coordinates;
	private int Movement;

	/**
	 * @param coordinates
	 */
	public Pawn(Coordinate coordinates) {
		super();
		this.coordinates = coordinates;
		this.Movement = ThreadLocalRandom.current().nextInt(Main.minMovementOption, Main.maxMovementOption + 1);
	}


	/**
	 * @return the coordinates
	 */
	public Coordinate getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}


	/**
	 * @return the movement
	 */
	public int getMovement() {
		return Movement;
	}


	/**
	 * @param movement the movement to set
	 */
	public void setMovement(int movement) {
		Movement = movement;
	}

	
}
