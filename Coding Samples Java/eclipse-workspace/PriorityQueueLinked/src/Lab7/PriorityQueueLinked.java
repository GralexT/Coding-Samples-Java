package Lab7;

import CITS2200.IllegalValue;
import CITS2200.Iterator;
import CITS2200.OutOfBounds;
import CITS2200.PriorityQueue;
import CITS2200.Underflow;

/**
 * A class to implement and manage a Priority Queue as a Linked List.
 * The private field variable contains the first, most prioritized node
 * in the queue.
 */
public class PriorityQueueLinked implements PriorityQueue<Object>{

	private Link first;

	public PriorityQueueLinked() {
		first = null;
	}

	@Override
	/**
	 * Removes the first first, most prioritized node from the queue and returns its object.
	 * @return The most prioritized object.
	 * @exception Underflow if the queue is already empty.
	 */
	public Object dequeue() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Empty Queue");
		} else {
			Object temp = first.item;
			first = first.next;
			return temp;
		}
	}

	@Override
	/**
	 * Adds an object to its correct position in the queue, given its priority value.
	 * @exception IllegalValue if the priority value is less than 0.
	 */
	public void enqueue(Object obj, int priorityvalue) throws IllegalValue {
		if(priorityvalue < 0) {
			throw new IllegalValue("Priority value must be greater than 0.");
		} else if (isEmpty() || priorityvalue > first.priority) {
			first = new Link(obj, priorityvalue, first);
		} else {
			Link list = first;
			while (list.next != null && list.next.priority >= priorityvalue) {
				list = list.next;
			}
			list.next = new Link(obj, priorityvalue, list.next);
		}
	}

	@Override
	/**
	 * Peeks at the first item in the queue.
	 * @return the first item in the queue.
	 * @exception Underflow if the queue is empty.
	 */
	public Object examine() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Empty Queue");
		} else {
			return first.item;
		}
	}

	@Override
	/**
	 * Checks if the queue is empty.
	 * @return true iff the queue is empty.
	 */
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	/**
	 * Generates an iterator to examine the entire queue.
	 * @return an iterator for the class's queue.
	 */
	public Iterator iterator() {
		return new PriorityQueueLinkedIterator();
	}

	/**
	 * A nested class to generate an iterator for the queue.
	 * The private field contains the current iteration through the queues nodes.
	 */
	class PriorityQueueLinkedIterator implements Iterator {
		private Link node;

		public PriorityQueueLinkedIterator() {
			node = first;
		}

		@Override
		/**
		 * Checks if there is a node after the current iteration.
		 * @return true iff there is a node after the current iteration.
		 */
		public boolean hasNext() {
			return (!isEmpty() && (node.next != null));
		}

		@Override
		/**
		 * Moves iterator to the next node in the queue and returns the object of that node.
		 * @return the object of the next node in line.
		 * @exception OutOfBounds iff there is no next node.
		 */
		public Object next() throws OutOfBounds {
			if (!hasNext()) {
				throw new OutOfBounds("No next object.");
			} else {
				node = node.next;
				return node.item;
			}
		}
	}

	/**
	 * A nested class to generate a Link with a priority value.
	 * The private field variables contain an object to be contained in the link,
	 * the priority of the object when queued and the next link pointing to the
	 * next more prioritized link.
	 */
	class Link extends PriorityQueueLinked{
		private Object item;
		private int priority;
		private Link next;

		public Link(Object obj, int priorityvalue, Link next) {
			this.item = obj;
			this.priority = priorityvalue;
			this.next = next;
		}
	}
}
