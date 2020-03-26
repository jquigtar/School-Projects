/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class ObjectList {

		private Object [] data = new Object [100];
		private int numElements = 0;
		
		public ObjectList() {
			this.data = this.data;
			this.numElements = this.numElements;
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
			for(int i = 0; i < numElements; i++) {
				if(i != numElements - 1) {
				array = array + data[i] + ", ";
				}else if(i == numElements -1){
					array = array + data[i];
				}else {
					array = array;
				}
			}
			return array;
		}	
	}
