/**
 * 
 */

/**
 * ExpenseAccount
 * 
 * this is a class that extends arrayList and holds
 * a list of bills as expenses
 * @author jquigtar
 * @version 2/28/19
 */
public class ExpenseAccount extends ArrayList{
	
	/**
	 * insert
	 * 
	 * this is a method Overrides the insert method from ArrayList 
	 * and inserts the the given Bill into the 
	 * list array at the given index in the parameter and then
	 * moves each Bill over if there is already Bills
	 * in that index
	 * @param other is an object
	 * @param index is given point in list you would like 
	 * 			to insert the object
	 * @throws IllegalArgumentException if it is not a bill being added
	 * 			to the list of expenses
	 */
	@Override
	public void insert(Object other, int index) throws IllegalArgumentException {
		if(!(other instanceof Bill)) {
			throw new IllegalArgumentException("can not insert this");
		}
		
		super.insert((Bill)other, index);
		
	}
	
	/**
	 * remove
	 * 
	 * this is a class that Overrides the remove method from ArrayList
	 * and removes the Bill at the given index
	 * and returns that Bill as well as moves each Bill in the
	 * list to replace the object that was removed
	 * @param index
	 * @return Bill removed from the index
	 */
	@Override
	public Bill remove(int index) {
		Bill toRemove;
		toRemove = (Bill)super.remove(index);
		return toRemove;
	}
}
