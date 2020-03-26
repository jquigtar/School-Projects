import java.util.ArrayList;

/**
 * BoatReservation
 * 
 * this is a class that extends Reservation 
 * to help create reservations for boat objects in ResManager
 * it holds an arrayList of preferences for which boats the 
 * customer would prefer to reserve
 * @author jquigtar
 * @version 3/16/19
 */
public class BoatReservation extends Reservation{
	private ArrayList<String> preferences;

	/**
	 * BoatReservation
	 * 
	 * this is a constructor that calls the super constructor from the reservation
	 * class to set the customer name for the reservation as well as the timeSlot
	 * requested. it also initialize the preferences array list to have 
	 * the customers preferences added for which boats it would prefer later
	 * @param timeslot
	 * @param customerName
	 * Post: boatReservation object initialized with timeslot and cutomername
	 */
	public BoatReservation(int timeslot, String customerName){
		super(customerName, timeslot);
		preferences = new ArrayList<String>();
	}
	
	/**
	 * addBoatPreference
	 * 
	 * this is method that adds a boat name to the arrayList of preferences 
	 * that the customer would prefer to reserve
	 * @param boatName String 
	 * Post: preferences arrayList size will grow by 1 adding a 
	 * 		new string boatName to the list
	 */
	public void addBoatPreference(String boatName){
		preferences.add(boatName);
	}
	
	public ArrayList<String> getPreferences(){
		// returns list of customer’s boat preferences
		ArrayList<String> copy = new ArrayList<String>(preferences.size());
		
		for(int i = 0; i < this.preferences.size(); i++) {
			copy.add(this.preferences.get(i));
		}
		
		return copy;
	}
}
