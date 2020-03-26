
/**
 * List
 * 
 * this is a class with inner class node that holds a list
 * of objects as nodes that point to the next object for reference
 * @author jquigtar
 * @version 3/7/19
 */
public class List {

	/**
	 * main
	 * 
	 * this is a main method that runs tests for the List class
	 * it has a try catch to see if any exceptions are caught
	 * and throws a LinkedListException if there are any runtime
	 * errors. it runs tests on three separate lists.
	 * @param args
	 * @throws LinkedListExcpeption
	 */
	public static void main(String[] args) {
		List empty = new List();
		List one = new List();
		List multiple = new List();

		try {
		one.append(5);
		multiple.append(10);
		multiple.append (20);
		multiple.append (30);
		
		System.out.println("Empty.isEmpty(): " + empty.isEmpty());
		System.out.println("One.isEmpty(): " + one.isEmpty());
		System.out.println("Multiple.isEmpty(): " + multiple.isEmpty());
		
		System.out.println("Empty.size(): " + empty.size());
		System.out.println("One.size(): " + one.size());
		System.out.println("Multiple.size(): " + multiple.size());	

		System.out.println("Empty.toString(): " + empty.toString());
		System.out.println("One.toString(): " + one.toString());
		System.out.println("Multiple.toString(): " + multiple.toString());	

		System.out.println("multiple.indexOf(10): " + multiple.indexOf(10));
		System.out.println("multiple.indexOf(20): " + multiple.indexOf(20));
		System.out.println("multiple.indexOf(30): " + multiple.indexOf(30));
		
		one.remove(0);
		multiple.remove(1);
		System.out.println("One.remove(0): " + one.toString());
		System.out.println("One.isEmpty(): " + one.isEmpty());
		System.out.println("One.size(): " + one.size());
		System.out.println("Multiple.remove(1): " + multiple.toString());

		one.append(600);
		multiple.append(400);
		System.out.println("One.append(600): " + one.toString());
		System.out.println("Multiple.append(400): " + multiple.toString());
		
		//one.insert(1, -1);
		//one.insert(12, 5);
		//these first two are to check that you can not insert at these indexes
		//that are below 0 as well above the size of the list because these are
		//out of bounds
		//one.remove(0);
		//one.remove(0);
		//these two if ran twice back to back will throw an error since you can not
		//remove on an empty list.
		//one.remove(-1);
		//one.remove(10);
		//can not remove on these indexes
		//that are below 0 as well above the size of the list because these are
		//out of bounds
		
		}catch(LinkedListException e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	/**
	 * Node
	 * 
	 * this is an inner class for the List class and is used
	 * to hold a an object and point to an instance of another object
	 * that also points to the next and so on.
	 * @author jquigtar
	 *
	 */
	private class Node  {
		private Object data;
		private Node next;

		// Constructor with no parameters and sets data and next to null
		public Node(){
			this.data = null;
			this.next = null;
		}

		// Parameterized constructor for inner class
		//sets data to newData and next to the next node nextLink
		public Node (Object newData, Node nextLink) {
			this.data = newData;
			this.next = nextLink;
		}
	}
	
	private Node head = new Node();  

	/**
	 * insert
	 * 
	 * this is a method that inserts an object at the specified index 
	 * in the list. it will change the head node if the list is empty or
	 * has one element in the list. otherwise the it will iterate through
	 * the list until it reaches the specified index and insert the object
	 * in between the current data at that index and that current next data.
	 * in other words the current data will point to the new object and the 
	 * new object will point to the old object at that index.
	 * @param next is object to be inserted
	 * @param index is an int on where to insert object into list
	 * @throws LinkedListException
	 */
	public void insert(Object next, int index) {
		
		if(this.isEmpty()) {
			//if empty change head to new next and points to old null head
			this.head = new Node(next, this.head);
		}else if(index < 0 || index > this.size()) {
			throw new LinkedListException();
			//throw exception on out of bounds call
		}else if(this.size() == 1) {
			//if list only has one element
			if(index==0) {
				this.head = new Node(next, this.head);
				//same as empty list
			}else if(index == 1){
				Node emptyNode = new Node();
				this.head.next = new Node(next, emptyNode);
				//change head.next to new object that points to null node
			}else {
				throw new LinkedListException();
				//throw out of bounds exception
			}
		}else{
			if(index == 0) {
				this.head = new Node(next, this.head);
			}else {
			Node emptyNode = new Node();
			Node current = this.head;
			//node holding current object
			Node newNode = new Node(next,emptyNode);
			//nod holding new object
			for (int i = 0; current != null && i < index - 1; i++) {
				//iterates through list until it reaches index or null node
	            current = current.next;
	        }
	        //Node is inserted at specified index and points to node that used to hold that index
	        newNode.next = current.next;
	        current.next = newNode;
			}
		}
	}

	/**
	 * remove
	 * 
	 * this is a method that removes the object at the index of the list
	 * specifies and returns that object. it first checks if the list is empty
	 * and throws an exception if it is. it also throws exceptions if the index
	 * is out of bounds on the list. otherwise it will remove and return either the object
	 * at head node if the list only has one element, or iterate through the list 
	 * and remove and return the object at the node at the specified index.
	 * @param index
	 * @return object from the node at the specified index
	 * @throws LinkedListException
	 */
	public Object remove(int index) {
		Object toReturn;
		if(this.isEmpty() || index < 0 || index > this.size()) {
			throw new LinkedListException();
			//throw exception if index called is out of bounds
			//also throws exception if trying to remove from an empty list
		}else if(this.size() == 1) {
			toReturn = this.head.data;
			this.head = new Node();
			//if list is only one element it will remove the element
			//and set the node at the head equal to null
		}else{
			if(index == 0) {
				//return object at beginning and change head node
				//to head.next
				toReturn = this.head.data;
				this.head = this.head.next;
			}else {
				Node current = this.head;
				for (int i = 0; current != null && i < index - 1; i++) {
					//iterate through the list until reaches one before specified index
					//or reaches a null node
		            current = current.next;
		        }
				toReturn = current.data;
				current.next = current.next.next;
				//replaces node at index with the next node
				}
		}
		return toReturn;
		//returns the object removed from the list
	}

	/**
	 * size
	 * 
	 * this is a method that iterates through the list and counts each
	 * node or objects in the list
	 * @return an int for the size of the list
	 */
	public int size() {
		Node current = this.head;  
		int count = 0;
		if(current == null) {
			//if empty list count is 0
			return count;
		}
		while(current.next != null )    {     
			//count goes up until current points to a null node
			count++;      
			current = current.next;    
		}
		return count;
	}

	/**
	 * toString
	 * 
	 * this is a method that Enumerates the list and returns
	 * this enumeration as a String.
	 * @return a string of each object in the list enumerated
	 */
	public String toString() {
		Node current = this.head;   
		String string = "";
		if(current == null) {
			return string;
		}
		while(current.next != null )    {     
			//adds each object to a string
			string = string + current.data.toString();     
			current = current.next;  
		}     
		return string;
	}

	/**
	 * isEmpty
	 * 
	 * this is a method that returns a true or false of the list
	 * is empty or not by checking if the head node of the list is
	 * empty or not
	 * @return true if list is empty, false if list is not empty
	 */
	public boolean isEmpty() {
		if(this.head == null || this.head.data == null) {
			return true;
			//list is empty if head is null 
		}
		return false;
	}

	/**
	 * indexOf
	 * 
	 * this is a method that searches the list for a target object and 
	 * returns the index of where the target is found in the list
	 * and returns -1 if the target is not found
	 * @param target
	 * @return int of the index target is found
	 * 			returns -1 if target is not found
	 */
	public int indexOf(Object target) {
		Node current = this.head;  
		int count = 0;

		while(current.next != null )    { 
			if(current.data.equals(target)) {
				//if object at current equals target return count
				return count;
			}
			count++;  //count goes up every time target is not found at a node
			current = current.next;  //changes to next node to check
		}
		return -1;
	}

	/**
	 * append
	 * 
	 * this is a method that Appends to the end of the list.
	 * by using the insert method to add the specified object
	 * to the end of the list.
	 * @param obj
	 */
	public void append(Object obj) {
		this.insert(obj, this.size());
		//insert object at end of list
	}
}
