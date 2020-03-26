
/**
 * Reservation
 * 
 * this is  a parent class to be used to hold reservations with the
 * a string customerName holding the name used for the reservation,
 * an int for the timeslot they have requested as well as a string
 * Id for which reservableItem they have reserved. this class also 
 * implements the comparable interface with using generics of type
 * reservation meaning it should be used with other objects with 
 * instance of reservation
 * @author jquigtar
 * @version 3/16/19
 */
public class Reservation implements Comparable<Reservation> {
	
	private String customerName;
	private int timeSlot;
	private String Id;

	/**
	 * Reservation
	 * 
	 * this is a constructor that initializes customerName for the reservation
	 * as well as the timeSlot that they have reserved
	 * @param customerName
	 * @param timeSlot
	 * Post: customerName, and timeSlot will be initialized and object created
	 */
	public Reservation (String customerName, int timeSlot)  {
		// Create a reservation request for a name, and slot
		this.customerName = customerName;
		this.timeSlot = timeSlot;
	}
	
	public String getCustomer() {
		String copy = this.customerName;
		return copy;
	}
	
	public int getTime() {
		int copy = this.timeSlot;
		return copy;
	}
	
	/**
	 * toString
	 * 
	 * this is a method to print out the name for the reservation, the time that
	 * the reservation has reserved as well as the id for which reservableItem 
	 * object is reserved
	 * @return a string in the form 
	 *			"Reservation name: cusomerName time: timeSlot id: reservableItem id"
	 */
	public String toString() {
		return "Reservation name: " + this.customerName + " time: " + this.timeSlot + " id: " + this.Id;
	}
	
	public void setResourceId(String id) {
		// Set the id of the reservableItem.  
		this.Id = id;
	}

	/**
	 * compareTo
	 * 
	 * this is a compareTo method that Overrides the method from
	 * the comparable interface and returns an int depending on whether
	 * or not the customerName for the reservation object the method is called on
	 * comes before or after the customerName for the Reservation object o in the parameter.
	 * this check is done alphabetically and uses the string compareTo method
	 * @param Reservation o
	 * @return returns 1 if o.customerName comes before the this.customerName
	 * 			alphabetically or a 0 if there names are equal, and -1
	 * 			if o.customerName is after this.customerName 
	 */
	@Override
	public int compareTo(Reservation o) {
		// TODO Auto-generated method stub
		return this.customerName.compareTo(o.customerName);
	}
}
