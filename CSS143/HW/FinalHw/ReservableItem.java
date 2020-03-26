import java.util.Scanner;

/**
 * ReservableItem
 * 
 * this is an abstract parent class to be implemented for items that 
 * can be reserved in a reservation system including Table and Boat objects
 * which are subclasses of this class. each reservable item has an id
 * that is read in from a file , as well as an array of 10 time slots that
 * can be reserved for each item.
 * @author jquigtar
 * @version 3/16/19
 */
public abstract class ReservableItem {
	
	private String Id;
	private static final int NUM_OF_SLOTS = 10;
	private boolean [] timeArray = new boolean[NUM_OF_SLOTS];
	
	/**
	 * fillArray
	 * 
	 * this is private method for a ReservableItem to be used in the 
	 * constructor that will fill the timeArray with each index being false
	 * meaning when it is created each time slot is open to be reserved
	 * Pre: timeArray is created and null
	 * Post: timeArray will be filled with each index being false
	 */
	private void fillArray() {
		for(int i = 0; i< timeArray.length; i++) {
			timeArray[i] = false;
		}
	}
	
	/**
	 * ReservableItem
	 * 
	 * this is a constructor for the ResrvableItem class that excepts a scanner
	 * object fileIn to be used in subclasses to read in, set and initialize the 
	 * Id of the ReservableItem, which would be the name or description of the item,
	 * as well as any other instance variables in the subclass.  
	 * @param fileIn Scanner object
	 * Pre: file to read from has already been opened 
	 * Post: all indexes of timeArray are set to false as well as 
	 * 		all instance variables set in subclasses
	 */
	public ReservableItem(Scanner fileIn){
		fillArray();
	}
	
	public void setId(String Id) {
		this.Id = Id;
	}
	
	public String getId(){
		// name of the item, such as table3 or kayak
		String copy = this.Id;
		return copy;
	}
	
	/**
	 * getFitnessValue
	 * 
	 * this is an abstract method that Returns an integer between 0 and 100 which tells the 
	 * caller how well fit a reservation is for this ReservableItem.  0 means not at all fit. 
	 * 100 means best fit. Only implemented in subclasses.
	 * @param res Reservation
	 * @return an int, 0 meaning not at all fit, 100 meaning best fit
	 */
	public abstract int getFitnessValue(Reservation res);
	
	public boolean[] getTimeArray()  {
		// Returns a deep copy array of time slots timeArray
		boolean [] copy = new boolean[this.timeArray.length];
		for(int i = 0; i < copy.length; i++) {
			copy[i] = this.timeArray[i];
		}
		return copy;
	}
	
	/**
	 * setReserved
	 * 
	 * this is a method that helps set the time slot specified 
	 * in the parameter (index) to true in the timeArray.
	 * used in subclasses when setting a reservation.
	 * index in timeArray is true when ReservableItem is reserved 
	 * at that time, and false when not.
	 * @param index
	 * pre: timeArray at this index is set to false meaning it
	 * 		is not currently reserved at this timeSlot
	 * Post: timeArray is not set to true at this index meaning
	 * 		that it has been set to reserved at this timeSlot
	 */
	public void setReserved(int index) {
		this.timeArray[index] = true;
	}
}
