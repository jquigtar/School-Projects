/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class IntList {

	private int [] data = new int [100];
	private int numElements = 0;
	
	public IntList() {
		this.data = this.data;
		this.numElements = this.numElements;
	}
	
	/**
	 * add
	 * 
	 * this is a function that adds onto the end of the list of ints
	 * which is an array
	 * @param n
	 * 
	 * Post: the data array will have one more element
	 * 		after the last element in the array
	 */
	public void add(int n) {
		data[numElements] = n;
		numElements++;
	}
	
	/**
	 * toString
	 * 
	 * this is a function that turns the array into a string in
	 * the form 1, 2, 3, 4, 5
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
	
	/**
	 * sum
	 * 
	 * this is a function that shows the sum of all the numbers
	 * in the data array
	 * @return sum : adds all numbers in data array
	 */
	public int sum() {
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum = sum + data[i];
		}
		return sum;
	}
	
	/**
	 * indexOf
	 * 
	 * this is a function that returns the element the target
	 * int is in in the array
	 * @param target: this is the number being targeted in the array
	 * @return the index of the number being targeted in the array 
	 * 			or -1 if number is not found
	 */
	public int indexOf(int target) {
		int index = 0;
		for(int i = 0; i < data.length; i++) {
			if(data[i] != target) {
				index++;
			}else {
				return index;
			}
		}
		return -1;
	}
}
