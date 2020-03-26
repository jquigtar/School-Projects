/**
 * 
 */

/**
 * ArrayList
 * 
 * this is a class that is ArrayList like in that
 * you can add to the list or array of objects at any 
 * point and also can remove the object at any index in the
 * list
 * @author jquigtar
 * @version
 */
public class ArrayList {

	private Object [] data = new Object[1];
	private int rear = 0;

	/**
	 * insert
	 * 
	 * this is a method that inserts the given object into the 
	 * list array at the given index in the parameter and then
	 * moves each object over if there is already objects
	 * in that index
	 * @param other is an object
	 * @param index is given point in list you would like 
	 * 			to insert the object
	 */
	public void insert(Object other, int index) {
		if(rear + 1 < this.data.length) {
			//if list is already big enough
			Object move;
			for(int i = rear; i >= index; i--) {
				move  = this.data[i];
				//holds value of object needed to be moved
				this.data[i + 1] = move;
				//moves everything to the right
			}
			rear++;//one more object in list
			this.data[index] = other;
			//sets the index in list to the Object other
		}else {//if the list is not big enough to handle one
			//more object then it is resized
			Object[] copy =  new Object[this.data.length +1];
			//copy array with one more element 
			for(int i = 0; i< this.data.length; i++) {
				copy[i] = this.data[i];
				//copys the whole list to the copy array
			}
			this.data = copy;
			//instance array is now the copy array
			Object move;
			for(int i = rear; i >= index; i--) {
				move  = this.data[i];
				this.data[i + 1] = move;
				//moves each object to the right
			}
			rear++;//one more object in list
			this.data[index] = other;
			//object in parameter is now at given index
		}
	}

	/**
	 * remove
	 * 
	 * this is a class that removes the object at the given index
	 * and returns that object as well as moves each object in the
	 * list to replace the object that was removed
	 * @param index
	 * @return
	 */
	public Object remove(int index) {
		Object removed = this.data[index];
		//store object that was removed to be returned later
		Object move;
		for(int i = index; i < rear; i++) {
			//start at index and move to the end of list
			move = this.data[i + 1];
			//object to be moved is equal to object to the right
			this.data[i] = move;// moves it left to takeover
		}
		rear--;//one less object in list
		return removed;//return object that was removed
	}

	/**
	 * size
	 * 
	 * this is a method that returns number of objects in the list
	 * @return returns an int for number of objects in list
	 */
	public int size() {
		return this.rear;
		//rear is the end of the list and is equal to the 
		//number of objects in the list because array index
		//starts at 0 and each object added increments it 1
	}

	/**
	 * toString
	 * 
	 * this is a method that returns a string that shows the list
	 * in the correct order in terms of what object each index in the 
	 * list holds
	 * @return a string in the form "List: A, B, C"
	 */
	public String toString() {
		String objectsInString = "List: ";
		for(int i = 0; i < rear; i++) {
			if(i != rear - 1) {
				objectsInString = objectsInString + this.data[i].toString() + ", ";
			}else {
				objectsInString = objectsInString + this.data[i].toString();
			}//last object doesn't need a comma after being listed
		}

		return objectsInString;
	}

	/**
	 * isEmpty
	 * 
	 * this is a method that returns true if there is nothing in
	 * the array or list and false if there is any object in the list
	 * @return true if list is empty, false if it holds objects
	 */
	public boolean isEmpty() {
		if(rear == 0) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * indexOf
	 * 
	 * this is a method that returns the index in the list
	 * of the object  given in parameter and returns -1 if
	 * the object is not found in the list
	 * @param other
	 * @return index of object in list, -1 if not found in list
	 * Pre: assumes object passed in has an equals method
	 */
	public int indexOf(Object other) {
		//Returns -1 if not found
		for(int i = 0; i <= rear; i++) {
			if(other.equals(this.data[i])) {
				return i;
				//if found return the first index it was found at
			}
		}
		return -1;
		//else return -1 when its not found
	}
	/**
	 * equals
	 * 
	 * this is a method that checks first if the object being
	 * passed in is not null, and it is an instance of ArrayList
	 * so it can be compared to the ArrayList object it is being
	 * called on and then checks to see if each list has the same 
	 * number of objects and the same object at each index in the list
	 *  @return true if each list has the same number of objects and 
	 *  		the object at each index in the lists is the same
	 *  		returns false if these are not true
	 */
	public boolean equals(Object other) {
		boolean same = false;
		if( other == null || !(other instanceof ArrayList )) {
			return false; 
			//false if object is null or not an arrayList
		}else {
			ArrayList that = (ArrayList) other;
			if(this.rear == that.rear) {
				for(int i = 0; i < this.rear; i++) {
					if(this.data[i] == that.data[i]) {
						same = true;
					}else {
						same = false;
						return same;
						//once one object is different return false;
					}
				}
			}else {
				return false;
				//returns false if they have different number of objects
			}
		}
		return same;
		//returns true for same number of objects and both lists are the same
	}

	/**
	 * get
	 * 
	 * this is a method that returns the object in the list at the given index
	 * in the parameter
	 * @param index
	 * @return the object at the given index in parameter
	 */
	public Object get(int index) {
		//Returns the object at index specified.
		Object atIndex = this.data[index];
		return atIndex;
	}
}
