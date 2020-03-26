import java.util.ArrayList;

/**
 * ResManager
 * 
 * this is a class that uses generics to handle ItemType objects which
 * extend ReservableItem class, and ResType which extends the Reservation
 * class. this class holds an array list of reservableItems which handle 
 * ItemType objects and an arrayList of reservations which handle ResType.
 * this class has methods to add reservable items to the list of reservableItems
 * and make reservations as well as sort the reservations by name and print them
 * to the screen.
 * @author jquigtar
 * @version 3/16/19
 */
public class ResManager <ItemType extends ReservableItem, ResType extends Reservation>{

	private ArrayList<ResType> reservations;
	private ArrayList<ItemType> reservableItems;
	
	/**
	 * ResManager
	 * 
	 * this is a constructor that initializes the reservations arrayList
	 * and reservableItmes arrayList to be used throughout the class
	 * Post: both reservations, and reservableItems have been initialized
	 * 		to the new ResManger object
	 */
	public ResManager(){
		// No argument constructor
		reservations = new ArrayList<ResType>();
		reservableItems = new ArrayList<ItemType>();
	}
	
	/**
	 * addReservable
	 * 
	 * this is method used to add reservableItems to the list of 
	 * reservableItems and takes an ItemType object in the parameter
	 * Item
	 * @param item ItemType
	 * Post: reservableItems size grows by one with a new item in the list
	 */
	public void addReservable(ItemType item) {
		// Adds an item to the manager
		reservableItems.add(item);
	}
	
	/**
	 * makeReservation
	 * 
	 * this is a method that attempts to make a reservation based on the info in trialRes.  
	 * to do this it will first check for each ReservableItem in the reservableItems arrayList,
	 * if the item is available in the time slot requested from trialRes. it will then take the 
	 * fitness value, and track the best one and which item it was, if there is any ReservableItem
	 * with fitness > 0 take that item with the best one, mark that item's time slot taken 
	 * (array entry set to true) set which item was reserved for that reservation using resourceID 
	 * and then put the reservation in the reservations arrayList, and return that reservaiton back
	 * from the arrayList
	 * If the method fails returns null and print the failure message 
	 * @param trialRes
	 * @return the reservation object that was made and added to the Reservations array list
	 * 			or if failed to make the reservation then return null and print
	 * 			"unsuccessful reservation: trialRes.toString()"
	 * Post: reservations may have added a new reservation to the list.
	 */
	public Reservation makeReservation(ResType trialRes) {
		int bestFitnessValue = 0;
		//to track best fitness value
		int bestFitItem = -1;
		//index to be changed if found an item with fitness value > 0
		int count = 0;
		for(ReservableItem item: reservableItems) {
			//for each loop to look at each item in reservableItems
			boolean [] times = item.getTimeArray();
			//gets time array for each item
			int currentFitnessValue = item.getFitnessValue(trialRes);
			//gets fitness value for each itme using trailRes information
			
			if(times[trialRes.getTime()] == false) {
				//if the time is not reserved for this item at the time requested by trialRes
				//otherwise it can not be reserved for this time so fitness value is 0 anyway
				if(currentFitnessValue > bestFitnessValue) {
					//if fitness value for this item is higher then the best fitness value then 
					//then track this item by setting bestFitItem = count 
					bestFitnessValue = currentFitnessValue;
					bestFitItem = count;
				}
				
			}
			count++;
			//count each item checked to be used for setting which item has best fitness value
		}
		if(bestFitItem > -1) {
			//if the index for the best fit item was set meaning an item had a fitness value
			//greater then 0 and had the time slot available requested from trialRes
			reservableItems.get(bestFitItem).setReserved(trialRes.getTime());
			//set the time requested by trialRes, for this item to reserved
			//by setting the boolean to true
			trialRes.setResourceId(reservableItems.get(bestFitItem).getId());
			//set which item this reservation now has reserved
			this.reservations.add(trialRes);
			//add this item to the reservations arrayList and return it
			return reservations.get(reservations.size()-1);
		}
		System.out.println("Unsuccessful reservation: " + trialRes.toString());
		return null;
		//if this method doesnt find a best fit item then it will return null 
		//and print an error message
	}
	
	/**
	 * sortReservations
	 * 
	 * this is a method that will take the reservations arrayList and sort it
	 * alphabetically by customer name using bubble sort logic
	 */
	public void sortReservations()   {
		for(int i = 0; i < this.reservations.size() - 1; i++) {
			for(int j = 0; j < this.reservations.size() - 1; j++) {
				
				if(reservations.get(j).compareTo(reservations.get(j+1)) > 0) {
					ResType toSwitch = reservations.get(j);
					reservations.set(j,reservations.get(j+1));
					reservations.set(j+1,toSwitch);
				}
			}
		}
	}
	
	/**
	 * toString
	 * 
	 * this is a method that will print all of the reservations
	 * in the reservations arrayList to their own line in the console
	 * @return a string with each reservation from the reservations
	 * 			arrayList on its own line
	 */
	public String toString() {
		// creates string listing reservations
		String allReservations = "";
		for(Reservation res: this.reservations) {
			allReservations = allReservations + res.toString() + "\n";
		}
		return allReservations;
	}
}
