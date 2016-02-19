
public class LinkedNode<E> {
	
	
	private E element;
	private LinkedNode next;
	private LinkedNode prev;
	
	/**
	 * @param element
	 * @param next
	 * @param prev
	 */
	public LinkedNode(E element, LinkedNode next, LinkedNode prev) {
		super();
		this.setElement(element);
		this.setNext(next);
		this.setPrev(prev);
	}

	/**
	 * @return the next
	 */
	public LinkedNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(LinkedNode next) {
		this.next = next;
	}

	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * @return the prev
	 */
	public LinkedNode getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(LinkedNode prev) {
		this.prev = prev;
	}
}
