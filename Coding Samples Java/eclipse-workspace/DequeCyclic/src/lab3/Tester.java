package lab3;

public class Tester {
	public static void main(String[] args) {
		
		DequeCyclic que = new DequeCyclic(4);
		
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		
		que.pushRight(1);
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		
		que.pushRight(2);
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		
		que.pushLeft(4);
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		
		que.pushLeft(4);
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		
		que.popLeft();
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		que.popLeft();
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		que.popLeft();
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		que.pushRight(88);
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		que.pushLeft(99);
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		que.pushRight(88);
		System.out.println("isEmpty: "+que.isEmpty());
		System.out.println("isFull: "+que.isFull());
		System.out.println();
		

	}
}
