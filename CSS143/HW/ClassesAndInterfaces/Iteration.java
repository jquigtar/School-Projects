import java.util.*;

/**
 * Iteration
 * 
 * 
 * @author jquigtar
 * @version 2/28/19
 */
public class Iteration<T> implements Iterator<Object> {


	private Object [] data;
	private int rear = 0;
	
	public Iteration(Object [] array) {
		this.data = new Object[array.length];
		for(int i = 0; i < array.length; i++) {
			this.data[i] = array[i];
		}
	}
	
	/**
	 * hasNext
	 * 
	 * @return
	 */
	@Override
	public boolean hasNext() {
		return this.rear < this.data.length;
	}

	/**
	 * next
	 * 
	 * @return
	 */
	@Override
	public Object next() {
		Object toReturn = this.data[rear];
		rear++;
		return toReturn;
	}

}
