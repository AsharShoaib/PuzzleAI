import java.util.ArrayList;

public class Knight extends Pieces {
	public Knight(Coordinate coordinates) {
		super(coordinates.getRow(), coordinates.getCol());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setState(boolean state) {
		this.Movement = 91;
	}

	public ArrayList<Coordinate> possibleMovement() {
		ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
		if(!(this.row-2<0)){
			if(!(this.col-1<0))
				temp.add(new Coordinate(this.row-2, this.col-1));
			if(!(this.col+1>Main.colLength-1))
				temp.add(new Coordinate(this.row-2, this.col+1));
		}
		if (!(this.row + 2 > Main.rowLength - 1)) {
			if(!(this.col-1<0))
				temp.add(new Coordinate(this.row+2, this.col-1));
			if(!(this.col+1>Main.colLength))
				temp.add(new Coordinate(this.row+2, this.col+1));
		}
		if (!(this.col - 2 < 0)){
			if(!(this.row-1<0))
				temp.add(new Coordinate(this.row-1, this.col-2));
			if(!(this.row+1>Main.colLength))
				temp.add(new Coordinate(this.row+1, this.col-2));
		}
		if(!(this.col + 2 > Main.colLength - 1)){
			if(!(this.row-1<0))
				temp.add(new Coordinate(this.row-1, this.col+2));
			if(!(this.row+1>Main.colLength))
				temp.add(new Coordinate(this.row+1, this.col+2));
		}
		return temp;
	}

}
