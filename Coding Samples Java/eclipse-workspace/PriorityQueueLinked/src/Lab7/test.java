package Lab7;

import CITS2200.Iterator;

public class test{
	public static void main(String[] args) {
		PriorityQueueLinked q = new PriorityQueueLinked();
		
		System.out.println("\n Check if empty list is empty: "+q.isEmpty());
		System.out.println("\t Test iterator hasNext: "+q.iterator().hasNext());

		
		q.enqueue("third",3);
		q.enqueue("first",1);
		q.enqueue("second",2);
		q.enqueue("fourth",4);
		q.enqueue("fifth",5);
		
		System.out.println("\n Check if filled list is empty: "+q.isEmpty());
		System.out.println("\t Test iterator hasNext: "+q.iterator().hasNext());
		
		System.out.println("\n Test iterator loop to return all listed values: ");
		Iterator it = q.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}