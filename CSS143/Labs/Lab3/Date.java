/**
 * 
 */

/**
 * Date
 * 
 * this is a class that holds a day month and year
 * for a date to be used for other objects
 * @author jquigtar
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;

	public Date() {
		this.day = 23;
		this.month = 6;
		this.year = 1912;
		//Default date
	}

	public Date(int month, int day, int year) {
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
	}
	
	public Date(Date other) {
		this.setMonth(other.getMonth());
		this.setDay(other.getDay());
		this.setYear(other.getYear());
	}

	/**
	 * equals
	 * 
	 * this is a function that returns a boolean if two dates 
	 * are the same
	 * @return returns true if the day month and year 
	 * 			are the same for the two dates
	 */
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Date)) {
			return false;
		}else {
			Date that = (Date) other;
			if(this.getDay() == that.getDay() && this.getMonth() == that.getMonth() &&
					this.getYear() == that.getYear()) {
				return true;
			}else {
				return false;
			}
		}

		
	}
	
	/**
	 * SetDate
	 * 
	 * this is a function to set values for day month and year
	 * @param day
	 * @param month
	 * @param year
	 * 
	 * Post: will change the values of day month and year 
	 * to user set values
	 */
	public void setDate(int month, int day, int year) {
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}

	/**
	 * report
	 * 
	 * this is a function to print the date to the console
	 */
	public void report() {
		System.out.println(this.toString());
	}

	/**
	 * toString
	 * 
	 * this is a function that returns the set date and its values
	 * back as a string in the form MM/DD/YYYY
	 */
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day > 0 && day < 32) {
			this.day = day;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month > 0 && month < 13) {
			this.month = month;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year > 0) {
			this.year = year;
		}
	}
}
