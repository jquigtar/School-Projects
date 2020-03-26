import java.util.Scanner;

/**
 * Table
 * 
 * this is a class that extends reservable items and is used
 * to create reservable table objects with a name to id the 
 * table, 10 time slots to be reserved and a number of seats
 * the table holds
 * @author jquigtar
 * @version 3/16/19
 */
public class Table extends ReservableItem {
	
	private int numSeats;

	/**
	 * Table
	 * 
	 * this is a constructor that uses the scanner inFile
	 * to read from file and initializes the Id of the Table,
	 * as well as initialize all the time slots to false and set
	 * the number of seats available at this table
	 * @param inFile
	 * Pre: file to read from has already been opened 
	 * Post: Table object created and all indexes of timeArray 
	 * 		are set to false as well ass the id of the table and 
	 * 		number of seats available at this table
	 */
	public Table (Scanner inFile) {
		//Fills in String id, int numSeats
		super(inFile);
		super.setId(inFile.next());
		this.numSeats = inFile.nextInt();
	}
	
	public int getNumSeats() {
		int copy = this.numSeats;
		return copy;
	}
	
	/**
	 * getFitnessValue
	 * 
	 * this is a method that Finds the appropriate fitness value so tables will be assigned appropriately. 
	 * this is done by first checking if the reservation in the parameter res requests more seats then the 
	 * number of seats available at the table. if this is true then the fitness is set to 0 the lowest 
	 * fitness value. if not then the fitness value will be set by dividing a double number of seats 
	 * needed by a double number of seats available and multiplying this by 100 since it will become a 
	 * decimal. then it it will return this value casted as an int. 
	 * logic is (seatsNeeded/seatsavailable) * 100 the smaller seats needed is the more empty seats there
	 * would be so the fitness value will be smaller.
	 * This will be assigned the highest fitness value.
	 * @param res
	 * @return an int for fitness value of the reservaiton to the table
	 */
	@Override
	public int getFitnessValue(Reservation res) {
		RestaurantReservation resRes = (RestaurantReservation)res;
		if(this.numSeats < resRes.getNumSeatsNeeded()) {
			return 0;
		}else {
			double seatsAvailable = this.numSeats;
			double seatsNeeded = resRes.getNumSeatsNeeded();
			double divide = (seatsNeeded / seatsAvailable) * 100;
			int toReturn = (int)divide;
			return toReturn;
		}
	}

}
