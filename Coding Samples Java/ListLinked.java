import CITS2200.Link;
import CITS2200.List;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

/**
 * A class to implement and manage a linked list.
 * The private field variables contain nodes that 
 * exist before the beginning of the list and after the end of the list.
 * @author  Grant Alexander Taylor.
 */
public class ListLinked implements List
{
	private Link beforefirst;
	private Link afterlast;

	/**
	 * Initializes the linked list.
	 */
	public ListLinked() {
		this.afterlast = new Link(null, null);
		this.beforefirst = new Link(null,afterlast);
	}

	/**
	 * Returns true iff the linked list is empty. 
	 * @return the boolean value to determine if the linked list is empty. 
	 */
	public boolean isEmpty() {
		return beforefirst.successor==afterlast;
	}

	/**
	 * Returns true iff the window is set before the first list item.
	 * @return the boolean value to determine if the window of the linked list is set before the first node.
	 */
	public boolean isBeforeFirst(WindowLinked window) {
		return window.link == beforefirst;
	}

	/**
	 * Returns true iff the window is set after the last list item.
	 * @return the boolean value to determine if the window of the linked list is set after the last node.
	 */
	public boolean isAfterLast(WindowLinked window) {
		return window.link == afterlast;
	}

	/**
	 * Sets the window to the position before the first list item.
	 */
	public void beforeFirst(WindowLinked window) {
		window.link = beforefirst;
	}

	/**
	 * Sets the window to the position after the last list item.
	 */
	public void afterLast(WindowLinked window) {
		window.link = afterlast;
	}

	/**
	 * Sets the window to the next item in the list.
	 * @exception OutOfBounds iff the window is already set after the last node in the list.
	 */
	public void next(WindowLinked window) throws OutOfBounds {
		if(!isAfterLast(window)) {
			window.link = window.link.successor;
		}
		else {
			throw new OutOfBounds("Window is after the last link: Nothing is after nothing.");
		}
	}

	/**
	 * Sets the window to the previous item in the list.
	 * @exception OutOfBounds iff the window is already set before the first node in the list.
	 */
	public void previous(WindowLinked window) throws OutOfBounds {
		if(!isBeforeFirst(window)) {
			Link finder = beforefirst.successor;
			Link previous = beforefirst;
			while(finder != window.link) {
				previous = finder;
				finder = finder.successor;
			}
			window.link = previous;
		}
		else {
			throw new OutOfBounds("Window is before the first link: Nothing is previous to nothing.");
		}
	}

	/**
	 * Inserts a node after a specified position in the list.
	 * @exception OutOfBounds iff the window is already set after the last node in the list.
	 */
	public void insertAfter(Object obj, WindowLinked window) {
		if(!isAfterLast(window)) {
			window.link.successor = new Link(obj, window.link.successor);
		}
		else {
			throw new OutOfBounds("Window is after the last link: Cannot insert after nothing.");
		}
	}

	/**
	 * Inserts a node before a specified position in the list.
	 * @exception OutOfBounds iff the window is already set before the first node in the list.
	 */
	public void insertBefore(Object obj, WindowLinked window) throws OutOfBounds {
		if(!isBeforeFirst(window)) {
			window.link.successor = new Link(window.link.item, window.link.successor);
			if(isAfterLast(window)) {
				afterlast = window.link.successor;
			}
			window.link.item = obj;
			window.link = window.link.successor;
		}
		else {
			throw new OutOfBounds("Window is before the first link: Cannot insert before nothing.");
		}
	}

	/**
	 * Returns the object at a specified point in the list.
	 * @return the object from the specified point in the list.
	 * @exception OutOfBounds if the window is already set after the last node in the list, or before the first node in the list.
	 */
	public Object examine(WindowLinked window) throws OutOfBounds {
		if(!isAfterLast(window) && !isBeforeFirst(window)) {
			return window.link.item;
		}
		else if(isAfterLast(window)) {
			throw new OutOfBounds("Window is after the last link: Cannot return no object.");
		}
		else {
			throw new OutOfBounds("Window is before the first link: Cannot return no object.");
		}
	}

	/**
	 * Replaces an object in a specified node of the linked list and returns the old object.
	 * @return the object being replaced.
	 * @exception OutOfBounds if the window is already set after the last node in the list, or before the first node in the list.
	 */
	public Object replace(Object obj, WindowLinked window) throws OutOfBounds {
		if(!isAfterLast(window) && !isBeforeFirst(window)) {
			Object out = window.link.item;
			window.link.item = obj;
			return out;
		}
		else if(isAfterLast(window)) {
			throw new OutOfBounds("Window is after the last link: Cannot replace and return no object.");
		}
		else {
			throw new OutOfBounds("Window is before the first link: Cannot replace and return no object.");
		}
	}

	/**
	 * Deletes a node in the linked list and returns its object.
	 * @return the object being deleted.
	 * @exception OutOfBounds if the window is already set after the last node in the list, or before the first node in the list.
	 */
	public Object delete(WindowLinked window) throws OutOfBounds {
		if(!isAfterLast(window) && !isBeforeFirst(window)) {
			Object obj = window.link.item;
			if(window.link.successor != afterlast) {
				window.link.item = window.link.successor.item;
				window.link.successor = window.link.successor.successor;
			}
			else {
				window.link.item = null;
				window.link.successor = null;
				afterlast = window.link;
			}
			return obj;
		}
		else if(isAfterLast(window)) {
			throw new OutOfBounds("Window is after the last link: Cannot delete and return no object.");
		}
		else {
			throw new OutOfBounds("Window is before the first link: Cannot delete and return no object.");
		}
	}
}
