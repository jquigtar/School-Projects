/**
 * 
 */

/**
 * Queue
 * 
 * this is a class Queue that simulates a queue with
 * FIFO nature where it stores objects in a queue and 
 * can only call on the object that was first added into the queue
 * it is also, in abstract an infinite capacity object structure
 * meaning that it can resize infinitely
 * @author jquigtar
 * @version
 */
public class Queue {

	private ArrayList data = new ArrayList();

	/**
	 * enqueue
	 * 
	 * this is a method that enqueue's an object into the queue
	 * or in other words adds it into the end of of the queue
	 * first object that is enqueued should be in front of queue
	 * it uses a method from ArrayList that adds the object in front
	 * of the list and moves other objects back in the list
	 * @param other
	 * Post: queue will have been resized if need be
	 */
	public void enqueue(Object other) {
		this.data.insert(other, 0);
		//insert other at index 0 in list and other objects move back
	}

	/**
	 * dequeue
	 * 
	 * this is a method that removes an object from the queue 
	 * which should be the object in the front of queue (which was the 
	 * first in) and returns it as an object
	 * @return an object from the front of the queue
	 * Post: number of objects in queue is one less
	 */
	public Object dequeue() {
		return this.data.remove(this.data.size() - 1);
		//this method from ArrayList removes the object in the 
		//list and returns it as well as moves everything over
		//in the list, therefore the object that was second
		//in line in the queue is now first

	}

	/**
	 * size
	 * 
	 * this is a method that returns the size of the queue
	 * as an int, or in other words the number of objects that are 
	 * in the queue
	 * @return an int which is the number of objects in the queue
	 */
	public int size() {
		return this.data.size();
		//this method from array list returns the number of 
		//objects in the list
	}

	/**
	 * toString
	 * 
	 * this is a method that returns a string that 
	 * shows where the front of the queue is and then
	 * shows the rest of the queue in order from front
	 * to back
	 * @return returns objectQueue which is a string 
	 * 			in the form "Front of queue: A, B, C"
	 */
	public String toString() {
		String objectQueue = "Front of Queue: ";
		for(int i = this.data.size() - 1; i >= 0; i--) {
			//must start from back of ArrayList because
			//this is the object first in
			if(i != 0) {
				objectQueue = objectQueue + this.data.get(i).toString() + ", ";
			}else {
				objectQueue = objectQueue + this.data.get(i).toString();
			}//last object does not need a comma after
		}
		return objectQueue;
	}

	/**
	 * isEmpty
	 * 
	 * this is a method that returns true if the queue
	 * has no objects in it and false if there is at least
	 * one object in it, it uses an isEmpty method from ArrayList
	 * class
	 * @return returns true for a queue with no objects
	 * 			and false for queue with any number of objects
	 */
	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	/**
	 * equals
	 * 
	 * this is a method that returns true if the object being 
	 * passed is a queue and that the queue being passed in 
	 * and the queue the method is called on have the same exact 
	 * objects in the same exact spot in queue, it will return false if 
	 * this is not true
	 * @return true if object is not null, instance of queue, and has
	 * 			same exact number and order of objects in each queue
	 * 			false if any one of these is not true
	 */
	public boolean equals(Object other) {
		if( other == null || !(other instanceof Queue )) {
			return false; 
			//false if object is null or not a queue
		}else {
			Queue that = (Queue) other;
			if(this.data.equals(that.data) ) {
				//runs ArrayList equals method to check each list is equal
				return true;//true if equal
			}else {
				return false;//false if not equal
			}
		}
	}
}
