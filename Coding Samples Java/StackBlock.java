import CITS2200.Stack;
import CITS2200.Overflow;
import CITS2200.Underflow;
/**
 * A class to implement and manage a stack.
 * The private field variables contain a stack of objects, and
 * the index of the stacks top object.
 * @author Grant Alexander Taylor.
 **/

public class StackBlock implements Stack
{
	private Object stack[];
	private int top;

	/**
	 * Creates an empty stack of a given size,
	 * and assigns a top-of-stack index of -1 to represent the empty stack.
	 * @param size the allocated size of the stack.
	 **/
	public StackBlock(int size){
		this.stack = new Object[size];
		this.top = -1;
	}

	/**
	 * Returns true iff the stack is empty.
	 * @return the boolean value to determine if the set is empty or not.
	 */
	public boolean isEmpty(){
		return top < 0;
	}

	/**
	 * Returns true iff the stack is false.
	 * @return the boolean value to determine if the set is full or not.
	 */
	public boolean isFull(){
		return top == stack.length-1;
	}

	/**
	 * Pushes an Object to the top of the stack, 
	 * @param obj the object to be added to the top of the stack.
	 * @exception Overflow if the stack is already full.
	 */
	public void push(Object obj){
		if(top<stack.length-1){
			stack[top+1] = obj;
			top++;
		}
		else{
			throw new Overflow("Stack Overflow");
		}
	}

	/**
	 * Returns the Object at the top of the stack,
	 * @return the object at the top of the stack.
	 * @exception Underflow if the stack is already empty.
	 */
	public Object examine(){
		if(!isEmpty()){
			return stack[top];
		}
		else{
			throw new Underflow("Stack Underflow");
		}
	}

	/**
	 * Returns and removes the Object at the top of the stack.
	 * @return the Object that is removed from the stack.
	 * @exception Underflow if the list is already empty.
	 */
	public Object pop(){
		if(!isEmpty()){
			Object obj = stack[top];
			stack[top] = 0;
			top--;
			return obj;
		}
		else{
			throw new Underflow("Stack Underflow");
		}
	}
}

