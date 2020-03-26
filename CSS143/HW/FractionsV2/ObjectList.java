/**
 * 
 */

/**
 * ObjectList
 * 
 * this is a class used to create an instance of an
 * object list, it has instance variables of int size and num elements,
 * and Object data [] which is used to store a list of objects
 * @author jquigtar
 * @version 1/25/19
 */
public class ObjectList {
	private int size;
	//used to initialize size of the list
	private Object [] data;
	//array to hold list of objects
	private int numElements = 0;
	//total number of elements in list

	//empty constructor
	public ObjectList() {

	}

	public ObjectList(int size) {
		this.size = size;
		data = new Object[size];
	}

	/**
	 * add
	 * 
	 * this is a function that adds onto the end of the list of objects
	 * which is an array
	 * @param n
	 * 
	 * Post: the data array will have one more element
	 * 		after the last element in the array
	 */
	public void add(Object n) {
		data[numElements] = n;
		numElements++;
	}

	/**
	 * toString
	 * 
	 * this is a function that turns the array into a string in
	 * the form object, object, object
	 * Pre: assumes each object has a toString function
	 */
	public String toString() {
		String array = "";
		for(int i = 0; i < this.numElements; i++) {
			if(i != this.numElements - 1) {
				array = array + data[i] + ", ";
			}else if(i == this.numElements -1){
				array = array + data[i];
			}else {
				array = array;
			}
		}
		return array;
	}	

	/**
	 * indexOf
	 * 
	 * this is a method that takes in an object as a 
	 * parameter and returns the index of that object
	 * in list(array) of objects
	 * @param object
	 * @return index of the object in the list of objects
	 * 			returns -1 if not found
	 */
	public int indexOf(Object object) {
		int count = 0;
		for(int i = 0; i < this.numElements; i++) {
			if(data[i] != object) {
				count++;
			}else {
				return i;
			}
		}
		return -1;
	}

	/**
	 * contains
	 * 
	 * this is a method that takes in a parameter of
	 * type object and returns true or false if that
	 * object is included in the list of objects
	 * @param object
	 * @return returns true of the object is found in the list
	 * 			returns false of the object is not found
	 */
	public boolean contains(Object object) {
		for(int i = 0; i < this.numElements; i++) {
			if(object.equals(data[i])) {
				return true;
			}
		}
		return false;
	}

	public Object getObject(int target) {
		return this.data[target];
	}

	public int getNumElements() {
		return numElements;
	}
}

