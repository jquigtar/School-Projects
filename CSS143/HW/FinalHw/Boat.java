import java.util.ArrayList;
import java.util.Scanner;

/**
 * Boat
 * 
 * this is a class that extends reservable items and is used
 * to create reservable Boat objects with a name to id the 
 * boat, and 10 time slots to be reserved 
 * @author jquigtar
 * @version 3/16/19
 */
public class Boat extends ReservableItem{

	/**
	 * Boat
	 * 
	 * this is a constructor that uses the scanner inFile
	 * to read from file and initializes the Id of the Boat,
	 * as well as initialize all the time slots to false 
	 * it will aslo print which boat type is being scanned
	 * in
	 * @param fileIn
	 * Pre: file to read from has already been opened 
	 * Post: boat object created and all indexes of timeArray 
	 * 		are set to false as well ass the id of the boat
	 */
	public Boat(Scanner fileIn) {
		super(fileIn);
		super.setId(fileIn.nextLine());
		System.out.println("Adding Boat type: " + super.getId());
	}

	/**
	 * getFitnessValue
	 * 
	 * this is a method to check whether or not the boat object fits the requests of the 
	 * reservation in the parameter. it will first get the list of preferences of boats
	 * from the reservation and then iterate through them to see if the boat is in the 
	 * list of preferences. if it is it will return how low on the list of preferences 
	 * the boat is by returning 100 - the index of where the boat is on the list of 
	 * preferences. if the boat is not in the list of preferences then it will return
	 * 0 the worst fitness value.
	 * @param Reservation res
	 * @return an int for the fitness value of the boat when comparing it to the 
	 * 			list of preferences from the reservation in the parameter
	 */
	@Override
	public int getFitnessValue(Reservation res)  {
		BoatReservation boatRes = (BoatReservation) res;
		ArrayList<String> preferences = boatRes.getPreferences(); 
		for(int i = 0; i < preferences.size(); i++) {
			if(preferences.get(i).equals(this.getId())) {
				return 100 - i;
			}
		}
		return 0;
	}
}
