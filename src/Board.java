import java.util.ArrayList;
import java.util.Collection;

public class Board<T> extends ArrayList<ArrayList<T>> {
	
	
	public void addToInnerArray(int index, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }
        this.get(index).add(element);
    }

    public void addToInnerArray(int index, int index2, T element) {
        while (index >= this.size()) {
            this.add(new ArrayList<T>());
        }

        ArrayList<T> inner = this.get(index);
        while (index2 >= inner.size()) {
            inner.add(null);
        }

        inner.set(index2, element);
    }
    
    public ArrayList<T> getRow(int index){
    	return this.get(index);
    }
    
    public T getTile(int index, int index2){
    	return this.get(index).get(index2);
    }

	public void drawBoard() {
		
	}
    
    
}
