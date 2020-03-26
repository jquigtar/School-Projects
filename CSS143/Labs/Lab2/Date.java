/**
 * 
 */

/**
 * @author jquigtar
 *
 */
public class Date {
	//In Class Code: Yoda
	private int day;
	private int month;
	private int year;

	public Date() {
		this.day = 1;
		this.month = 1;
		this.year = 2019;
		//Default date
	}

	public Date(int month, int day, int year) {
		this.day = day;
		this.year = year;
		this.month = month;
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
	public void setDate(int day, int month, int year) {
		if(day >= 1 && day <=31) {
			this.day = day;
		}else {
			System.out.println("Invalid value for days, can not be " + day);
		}
		if(month >= 1 && month <= 12) {
			this.month = month;
		}else {
			System.out.println("invalid value for months, can not be " + month);
		}
		this.year = year;
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
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
