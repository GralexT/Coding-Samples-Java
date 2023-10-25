import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

/**
 * A class to implement and manage a double-ended queue.
 * The private field variables contain a double-ended queue,
 * and the indexes of both ends of the queue.
 * @author Grant Alexander Taylor.
 */
public class DequeCyclic implements Deque
{
	private Object[] deque;
	private int topleft;
	private int topright;

	/**
	 * Creates an empty double-ended queue of a specified size, 
	 * and initializes the ends of the queue to empty values of -1.
	 * @param size The size of the double-ended queue.
	 */
	public DequeCyclic(int size) {
		this.deque = new Object[size];
		this.topleft = -1;
		this.topright = -1;
	}

	/**
	 * Returns true iff the double-ended queue is empty.
	 * @return the boolean value to determine if the double-ended queue is empty or not.
	 */
	public boolean isEmpty() {
		return topleft<0 || topright<0;
	}

	/**
	 * Returns true iff the double-ended queue is full.
	 * @return the boolean value to determine if the double-ended queue is full or not.
	 */
	public boolean isFull() {
		return ((topright+1+deque.length) % deque.length) == topleft;
	}

	/**
	 * Adds the first object to an empty double-ended queue and gives it side end values.
	 * @param obj the first Object added to the double-ended queue.
	 */
	private void addFirstObject(Object obj) {
		deque[0] = obj;
		topright++;
		topleft++;
	}

	/**
	 * Inserts a new object to the left-most available index.
	 * @param obj the object to be added to the left queue.
	 * @exception Overflow if the double-ended queue is already full.
	 */
	public void pushLeft(Object obj) {
		if(isFull()) {
			throw new Overflow("Deque Overflow.");
		}else if(isEmpty()) {
			addFirstObject(obj);
		}else {
			topleft = ((topleft-1+deque.length) % deque.length);
			deque[topleft]=obj;
		}
	}

	/**
	 * Inserts a new object to the right-most available index.
	 * @param obj the object to be added to the right queue.
	 * @exception Overflow if the double-ended queue is already full.
	 */
	public void pushRight(Object obj) {
		if(isFull()) {
			throw new Overflow("Deque Overflow.");
		}else if(isEmpty()) {
			addFirstObject(obj);
		}else {
			topright = ((topright+1+deque.length) % deque.length);
			deque[topright]=obj;
		}
	}

	/**
	 * Returns the top object on the right side of the double-ended queue.
	 * @return the top object on the right side of the double-ended queue.
	 */
	public Object peekRight() {
		if(isEmpty()) {
			throw new Underflow("Deque Underflow.");
		} else {
			return deque[topright];
		}
	}

	/**
	 * Returns the top object on the left side of the double-ended queue.
	 * @return the top object on the left side of the double-ended queue.
	 */
	public Object peekLeft() {
		if(isEmpty()) {
			throw new Underflow("Deque Underflow.");
		}else {
			return deque[topleft];
		}
	}

	/**
	 * Returns and removes the top object on the left side of the double-ended queue.
	 * @return the top object on the left side of the double-ended queue.
	 */
	public Object popLeft() {
		if(isEmpty()) {
			throw new Underflow("Deque Underflow.");
		} else {
			Object popped = deque[topleft];
			pop(topleft);
			return popped;
		}
	}

	/**
	 * Returns and removes the top object on the right side of the double-ended queue.
	 * @return the top object on the right side of the double ended queue.
	 */
	public Object popRight() {
		if(isEmpty()) {
			throw new Underflow("Deque Underflow Exception.");
		} else {
			Object popped = deque[topright];
			pop(topright);
			return popped;
		}
	}
	
	/**
	 * Removes the top object on the given side of the double-ended queue and sets the new top for that side.
	 * @param side the index of the side of the double-ended queue to be popped.
	 */
	private void pop(int side) {
		deque[side] = null;
		if(topleft==topright) {
			topleft = -1;
			topright = -1;
		} else if(side == topright) {
			topright = ((topright-1+deque.length)%deque.length);
		} else if(side == topleft) {
			topleft = ((topleft+1+deque.length)%deque.length);
		}
	}
}

