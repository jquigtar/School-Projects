
/**
 * 
 */

/**
 * ItemNotFoundException
 * 
 * this is a class that extends RuntimeException and is used
 * to throw exceptions for if an item was not found.
 * @author jquigtar
 * @version 2/23/19
 */
public class ItemNotFoundException extends RuntimeException {
	
	public ItemNotFoundException() {
		super ("The item was not found");
	}
	
	public ItemNotFoundException(String msg) {
		super(msg);
	}
}
