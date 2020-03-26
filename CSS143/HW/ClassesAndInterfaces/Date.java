import java.io.*;

/**
 * Date
 * 
 * this is a class for an object that holds a date with ints
 * month, day, and year and can be manipulated
 * it also implements the Compareable, Cloneable, and Serializable 
 * interfaces to Override compareTo, clone, and readObject and writeObject
 * methods
 * @author jquigtar
 * @version 2/28/2019
 */
public class Date implements Comparable<Date>, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private int month;
	private int day;
	private int year;
	
	public Date(int month, int day, int year){
		//Constructor
		if(month > 0 && month < 13 && day > 0 && day < 32 && year > 2015 && year < 2027) {
			this.setDay(day);
			this.setMonth(month);
			this.setYear(year);
		}else {
			//ends program if date is not set right
			System.out.println("Invalid date");
			System.exit(0);
		}
	}
	
	public Date(Date other){
		//Copy Constructor
		this.setDay(other.getDay());
		this.setMonth(other.getMonth());
		this.setYear(other.getYear());
	}
	
	public int getYear() {
		int getYear = this.year;
		return getYear;
	}
	
	public int getMonth() {
		int getMonth = this.month;
		return getMonth;
	}
	
	public int getDay() {
		int getDay = this.day;
		return getDay;
	}
	
	public void setYear(int year) {
		if(year > 2015 && year < 2027) {
			//only if year is 2016-2026
			this.year = year;
		}
	}
	
	public void setMonth(int month) {
		if(month > 0 && month < 13) {
			//only if month is 1-12
			this.month = month;
		}
	}
	
	public void setDay(int day) {
		if(day > 0 && day < 32) {
			//only if day is 1-31
			this.day = day;
		}
	}
	
	/**
	 * isAfter
	 * 
	 * this is a method that takes a parameter of type Date
	 * compareTo and compares it to the Date object it is called on
	 * to see if the compareTo Date is after that date Object and if it is
	 * the method will return true if not it will return false
	 * @param compareTo type Date
	 * @return returns true if compareTo Date is after Date called on
	 * 			else it returns false if comareTo date is before Date called on
	 */
	public boolean isAfter(Date compareTo){
		if(compareTo.getYear() > this.getYear()) {
			return true;
			//if the date compareTo has a later year then it is true that it is after
		}
		else if(compareTo.getYear() == this.getYear() && compareTo.getMonth() > this.getMonth()) {
			return true;
			//if it has the same year but a later month then it is true that it is after
		}
		else if(compareTo.getYear() == this.getYear() && compareTo.getMonth() == this.getMonth() &&
				compareTo.getDay() > this.getDay()) {
			return true;
			//if its same year, same month but day is later then it is true that it is after
			//changed to if day is after or equal for the sake of paying the bill on the same 
			//day that it is due
		}else {
			return false;
		}
	}
	
	/**
	 * equals
	 * 
	 * this is a method that takes an Object date as a parameter and first checks
	 * if it is of type Date and that it is not null, then if it is, it will check
	 * to see that the day month and year for each date is the same, if they are 
	 * then the method will return true else it will return false
	 * @param Object date
	 * @return if date is of type Date, not null, and has the same day month and year as 
	 * 			the Date object it is called on then the method will return true
	 * 			else it will return false
	 */
	public boolean equals(Object date) {
		if(date == null || !(date instanceof Date)) {
			return false;
			//false if object passed in is null or not a Date object
		}else {
			Date that = (Date) date;
			if(this.getDay() == that.getDay() && this.getMonth() == that.getMonth() &&
					this.getYear() == that.getYear()) {
				return true;
				//if day month and year are the same the dates are equal
			}else {
				return false;
				//return false if day month or year are not the same
			}
		}
	}
	
	/**
	 * toString
	 * 
	 * this is a method that takes the month day and year instance
	 * variables for the object it is called on and returns string in the 
	 * form MM/DD/YYYY
	 * @return a string in the form MM/DD/YYYY
	 * 			if month is less then 10 then it is in the form
	 * 			0M/DD/YYYY
	 */
	public String toString(){
		String month = "0";
		String day = "0";
		String date = "";
		
		if(this.getMonth() < 10) {//if month is less then 10
			date = date + month + this.getMonth() + "/"; 
			//adds 0 in front of month ex: 05/06/2017
		}else{
			date = date + this.getMonth() + "/";
		}
		
		if(this.getDay() < 10) {//day is less then 10
			date = date + day + this.getDay() +"/" + this.getYear();
			//add 0 in front of dat ex: 10/06/2017
		}else {
			date = date + this.getDay() +"/" + this.getYear();
		}
		
		return date;
	}
	
	/**
	 * compareTo
	 * 
	 * this is a compareTo method that Overrides the method from
	 * the compareable interface and returns an int depending on whether
	 * or not the Date objects day month and year comes before or after the Bill
	 * other in the parameter.
	 * @param Date other
	 * @return returns 1 if other comes before the Date the method is called on
	 * 			in terms of day month and year, a 0 if they are equal, and -1
	 * 			if other is after the Date the method is called on in terms of 
	 * 			its day month and year
	 */
	@Override
	public int compareTo(Date other) {
		if(!(other instanceof Date) || other == null) {
			throw new IllegalArgumentException("can not compareTo " + other.getClass());
		}
		if(this.equals(other)) {
			return 0;
		}else if(this.isAfter(other)) {
			return -1;
		}else {
			return 1;
		}
	}
	
	/**
	 * clone
	 * 
	 * this is a clone method for the Date class that overrides
	 * the method from Cloneable interface and is used to create and
	 * return a new deep copy clone of the Date object it is called on
	 * @return returns a new deep copy clone of Date object the method 
	 * 			is called on as a new Date Object
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public Date clone() throws CloneNotSupportedException {
		Date copy = (Date)super.clone();
		return copy;
	}
}
