
/**
 * Stack
 * 
 * this is a class that extends the List class and
 * uses the insert and remove methods from list to
 * simulate a Stack which has LIFO nature where
 * it stores objects in a stack and can only call on 
 * the last object added to the stack
 * @author jquigtar
 * @version 3/7/19
 */
public class Stack extends List {

	/**
	 * push
	 * 
	 * this is a method that pushes an object onto the top of the stack
	 * and uses the insert method from the List class and overrides
	 * it to always insert the object to the beginning of the list
	 * @param obj
	 */
	public void push(Object obj) {
		//	inserts to the beginning of the list
		super.insert(obj, 0);
	}
	
	/**
	 * pop
	 * 
	 * this is a method that pops the last object off the top of 
	 * the stack and returns what the object was that was popped of
	 * the top. it uses the remove method from the List class and overrides
	 * it to always remove from the beginning of the list since it was 
	 * the mos recent object that was pushed onto the stack
	 * @return
	 */
	public Object pop() {
		//	removes from the beginning of the list
		return super.remove(0);
	}
	
	/**
	 * main
	 * 
	 * this is a main method that runs tests for the Stack class
	 * it has a try catch to see if any exceptions are caught
	 * and throws a LinkedListException if there are any runtime
	 * errors. it runs tests on three separate Stacks.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		Stack empty = new Stack();
		Stack one = new Stack();
		Stack multiple = new Stack();

		one.push(5);
		multiple.push(10);
		multiple.push (20);
		multiple.push (30);
		
		System.out.println("Empty.isEmpty(): " + empty.isEmpty());
		System.out.println("One.isEmpty(): " + one.isEmpty());
		System.out.println("Multiple.isEmpty(): " + multiple.isEmpty());
		
		System.out.println("Empty.size(): " + empty.size());
		System.out.println("One.size(): " + one.size());
		System.out.println("Multiple.size(): " + multiple.size());	

		System.out.println("Empty.toString(): " + empty.toString());
		System.out.println("One.toString(): " + one.toString());
		System.out.println("Multiple.toString(): " + multiple.toString());	

		System.out.println("One.pop(): " + one.pop());
		System.out.println("Multiple.pop(): " + multiple.pop());
		System.out.println("Multiple.toString(): " + multiple.toString());	
		System.out.println("Multiple.pop(): " + multiple.pop());
		System.out.println("Multiple.toString(): " + multiple.toString());	


		one.push(600);
		multiple.push(400);
		System.out.println("One.push(600): " + one.toString());
		System.out.println("Multiple.push(400): " + multiple.toString());
		
		one.pop();
		one.pop();
		//these two pop methods ran back to back will throw an exception since you
		//cant pop an object from an empty Stack
		}catch(LinkedListException e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}

}
