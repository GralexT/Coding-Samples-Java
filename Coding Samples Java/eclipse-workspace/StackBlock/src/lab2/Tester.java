package lab2;

public class Tester {
	public static void main(String[] args) {
		StackBlock nums = new StackBlock(2);
		
		System.out.println(nums.isEmpty());
		System.out.println(nums.isFull());
		//System.out.println(nums.examine());
		
		nums.push(2);
		System.out.println(nums.isEmpty());
		System.out.println(nums.isFull());
		System.out.println(nums.examine());
		
		nums.push(4);
		System.out.println(nums.isEmpty());
		System.out.println(nums.isFull());
		System.out.println(nums.examine());
		
		nums.pop();
		System.out.println(nums.isEmpty());
		System.out.println(nums.isFull());
		System.out.println(nums.examine());
		
		nums.pop();
		System.out.println(nums.isEmpty());
		System.out.println(nums.isFull());
		//System.out.println(nums.examine());
		
		nums.pop();
		
	}
}
