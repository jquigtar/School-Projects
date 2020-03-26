
/**
 * RestaurantReservation 
 * 
 * this is a class that extends Reservation 
 * to help create reservations for table objects in ResManager
 * it holds an int for the number of seats the party would 
 * like to have in their reservation
 * @author jquigtar
 * @version 3/16/19
 */
public class RestaurantReservation extends Reservation {
	private int numSeatsNeeded;

	/**
	 * RestaurantReservation
	 * 
	 * this is a constructor that calls the super constructor to set the
	 * customers name for the reservation as well as the time slot
	 * they would like to reserve it also intializes the number of seats 
	 * needed for the reservation
	 * @param numSeatsNeeded
	 * @param startTime
	 * @param name
	 * Post: Restuarant Reservation object created with number of seats needed 
	 * 		time slot and customer name.
	 */
	public RestaurantReservation(int numSeatsNeeded, int startTime, String name) {
		super(name, startTime);
		this.numSeatsNeeded = numSeatsNeeded;
	}
	
	public int getNumSeatsNeeded() {
		int copy = this.numSeatsNeeded;
		return copy;
	}
	
	/**
	 * toString
	 * 
	 * this is a mehthod that overrides the reservation to string to return
	 * the super.toString and add the number of customer seats needed to the end
	 * @return a string in the form
	 * 			Reservation name: name time: time id: id(name of table) customer seats: numSeats
	 */
	@Override
	public String toString() {
		return super.toString() + " customer seats: " + this.numSeatsNeeded;
	}
}