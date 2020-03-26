
/**
 * Queue
 * 
 * this is a class that extends the List class and
 * uses the insert and remove methods from list to
 * simulate a Queue which has
 * FIFO nature where it stores objects in a queue and 
 * can only call on the object that was first added into the queue
 * @author jquigtar
 * @version 3/7/19
 */
public class Queue extends List {

	/**
	 * enqueue
	 * 
	 * this is a method that enqueues an object into the queue which
	 * sends it to the front of the line.
	 * this method overrides the insert method from the List class
	 * and always inserts the object to the beginning of the list
	 * @param obj
	 */
	public void enqueue(Object obj) {
		//	inserts to the beginning of the list
		super.insert(obj, 0);
	}
	
	/**
	 * dequeue
	 * 
	 * this is a method that dequeues an object from the front of the 
	 * Queue and returns what that object was that was dequeued.
	 * this is a method that overrides the remove method from the
	 * List class and always removes the object from the end of the List
	 * since it was the first one that was inserted in relation to the
	 * others in the queue
	 * @return
	 */
	public Object dequeue() {
		//	removes from the end of the list
		return super.remove(this.size());
	}
	
	/**
	 * main
	 * 
	 * this is a main method that runs tests for the Queue class
	 * it has a try catch to see if any exceptions are caught
	 * and throws a LinkedListException if there are any runtime
	 * errors. it runs tests on three separate Queues.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
		Queue empty = new Queue();
		Queue one = new Queue();
		Queue multiple = new Queue();

		one.enqueue(5);
		multiple.enqueue(10);
		multiple.enqueue(20);
		multiple.enqueue(30);
		
		System.out.println("Empty.isEmpty(): " + empty.isEmpty());
		System.out.println("One.isEmpty(): " + one.isEmpty());
		System.out.println("Multiple.isEmpty(): " + multiple.isEmpty());
		
		System.out.println("Empty.size(): " + empty.size());
		System.out.println("One.size(): " + one.size());
		System.out.println("Multiple.size(): " + multiple.size());	

		System.out.println("Empty.toString(): " + empty.toString());
		System.out.println("One.toString(): " + one.toString());
		System.out.println("Multiple.toString(): " + multiple.toString());	

		System.out.println("One.dequeue(): " + one.dequeue());
		System.out.println("Multiple.dequeue(): " + multiple.dequeue());
		System.out.println("Multiple.toString(): " + multiple.toString());	
		System.out.println("Multiple.dequeue(): " + multiple.dequeue());
		System.out.println("Multiple.toString(): " + multiple.toString());	

		one.enqueue(600);
		multiple.enqueue(400);
		System.out.println("One.enqueue(600): " + one.toString());
		System.out.println("Multiple.enqueue(400): " + multiple.toString());
		
		one.dequeue();
		one.dequeue();
		//these two dequeue methods ran back to back will throw an exception since you
		//cant dequeue from an empty queue
		}catch(LinkedListException e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
