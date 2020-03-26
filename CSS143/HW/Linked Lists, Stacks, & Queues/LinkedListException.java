
/**
 * LinkedListException
 * 
 * this is a class that extends RuntimeException and is used
 * to throw exceptions for if the List class.
 * @author jquigtar
 * @version 3/7/19
 */
public class LinkedListException extends RuntimeException {

	public LinkedListException() {
		super ("An error occured in the List class");
		
	}
	
	public LinkedListException(String msg) {
		super(msg);
	}
}
