/**
 * 
 */

/**
 * Stack
 * 
 * this is a class Stack that simulates a stack with
 * LIFO nature where it stores objects in a stack and 
 * can only call on the last object added to the stack
 * it is also in abstract an infinite capacity object structure
 * @author jquigtar
 * @version 1/31/19
 */
public class Stack {

	private int top = 0;
	//keep track of top of stack in array
	private Object [] data = new Object [1];
	private int size = 0;
	//keep track of number of elements

	/**
	 * push
	 * 
	 * this is a method that "pushes" an object on top of the
	 * stack and also resizes the stack to fit the number of 
	 * objects in the stack each time an object is pushed on
	 * @param other is an object
	 * Post: the stack may be resized as well as a new object
	 * 		will be at top of stack
	 */
	public void push(Object other) {
		if(top + 1 < data.length) {
			// if stack is already large enough to handle another object
			this.data[this.top] = other;
			//new object at the top
			this.top++;
			//top of stack is changed
			this.size++;
			//size or number of objects in stack increases

		}else {
			Object [] copy = new Object[this.data.length + 1];
			for(int i = 0; i < this.data.length; i++) {
				copy[i] = data[i];
			}//created a new array with one more element for space at top of stack
			this.data = copy;//changed the instance array to this copy with one more element
			this.data[this.top] = other;
			this.top++;
			this.size++;
		}
	}

	/**
	 * pop 
	 * 
	 * this is a method that returns the object at the top of the stack
	 * as well as changing what object is at the top of the stack
	 * @return returns an object which was at top of stack
	 * Post: stack has one less object on it now
	 */
	public Object pop() {
		top--;//top of stack goes down one
		size--;//one less element or object in stack
		Object other = this.data[top];
		return other;//returns object popped off top of stack
	}

	/**
	 * size
	 * 
	 * this is a method that returns the size of the stack
	 * or the number of objects in the stack
	 * @return returns an int which is the number of objects in the stack
	 */
	public int size() {
		return this.size;
	}

	/**
	 * toString
	 * 
	 * this is a method that takes the stack and returns it as 
	 * a string in the form "Top of stack: A, B, C" the last 
	 * object in should be at top of stack
	 * @return returns a String stack
	 */
	public String toString() {
		String stack = "Top of stack: ";
		for(int i = size - 1; i >= 0; i--) {
			//start at end of array or top of stack
			if(i != 0) {//add commas except for after last object
				stack = stack + this.data[i] + ", ";
			}else {
				stack = stack + this.data[i];
			}
		}
		return stack;
	}

	/**
	 * isEmpty
	 * 
	 * this is a method that returns a boolean, true if 
	 * there is nothing in the stack or the stack is empty 
	 * and false if there are objects in the stack
	 * @return returns true if stack is empty
	 * 			false if it still holds objects
	 */
	public boolean isEmpty() {
		if(this.size == 0) {
			//size relates to number of objects 
			return true;
		}else {
			return false;
		}
	}

	/**
	 * equals
	 * 
	 * this is a function that checks if the object being passed in
	 * is null and if it is an instance of Stack then checks if
	 * the calling object of Stack is equal to the stack being passed in
	 * by first checking if the sizes of each stack are the same then 
	 * incrementally checking each object in the stack is equal and in the 
	 * same index
	 * @param object other
	 * @return returns true if each stack contains the same objects in 
	 * 			the same order and false if not
	 * 
	 */
	public boolean equals(Object other) {
		if( other == null || !(other instanceof Stack )) {
			return false; //if object is null or not a stack return false
		}else {
			Stack that = (Stack) other;
			//use that to compare to this by type casting object to a stack
			if(this.size == that.size) {
				for(int i = 0; i < size; i++) {
					if(this.data[i] != that.data[i]) {
						return false;
						// if one object is not in the same at each index then return false
					}
				}
				return true;
				//return true since all objects are equal in each index
			}else{
				return false;
				//return false when number of objects in each stack aren't equal
			}
		}
	}
}
