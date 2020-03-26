import java.io.*;

/**
 * Money
 * 
 * this is class that holds value for USD money with 
 * ints dollars and cents and can be manipulated
 * it also implements the Compareable, Cloneable, and Serializable 
 * interfaces to Override compareTo, clone, and readObject and writeObject
 * methods
 * @author jquigtar
 * @version 2/28/2019
 */
public class Money implements Comparable<Money>, Cloneable, Serializable{

	private static final long serialVersionUID = 1L;
	private int dollars;
	private int cents;
	
	public Money() {}
	
	public Money(int dol){
		//Constructor which sets the dollar amount, and sets cents to 0
		this.setMoney(dol, 0);
	}
	
	public Money(int dol, int cent){
		//Constructor which initialized dollars and cents. 
		this.setMoney(dol, cent);
	}
	
	public Money(Money other){
		//Copy Constructor
		int dol = other.getDollars();
		int cent = other.getCents();
		this.dollars = dol;
		this.cents = cent;
	}
	
	public int getDollars(){
		int dol = this.dollars;
		return dol;
	}
	
	public int getCents(){
		int cents = this.cents;
		return cents;
	}
	
	/**
	 * setMoney
	 * 
	 * this is a method that takes two int parameters for dollars and cents
	 * and sets the instance variables to the correct amount for instance it 
	 * will convert any amount of cents over 100 to the amount of dollars and
	 * cents it is equal too
	 * @param int dollars
	 * @param int cents
	 * Post: the instance variables will have changed for dollar and cents
	 */
	public void setMoney(int dollars, int cents){
		if(dollars > -1 && cents > -1) {
			//only uses positive amounts of dollars and cents
			if(cents >= 100) {
				//cents is over 100 change to dollar amount
				int extraDollars = cents / 100;
				int change = cents % 100;
				this.dollars = dollars + extraDollars;
				this.cents = change;
				//remainder after changing cents to amount of dollars
				//is the new amount for cents
			}else {
				this.dollars = dollars;
				this.cents = cents;
			}
		}else {
			System.out.println("invalid amount, no negative values");
			System.exit(0);
		}
	}
	
	public double getMoney(){
		//Gets the money amount as a double
		//Returns 5.75 for example
		double money = 0.0;
		money = money + this.dollars + (this.cents * .01);
		//cents is added in decimal form
		return money;
	}
	
	/**
	 * add
	 * 
	 * this is a method that takes a parameter of dollars and adds
	 * it to the instance varaible for dollars
	 * @param dollars
	 * Post: this.dollars will have changed
	 */
	public void add(int dollars) {
		if(dollars >-1) {
			this.dollars = this.dollars + dollars;
		}
	}
	
	/**
	 * add
	 * 
	 * this is a method that takes parameters of dollars and cents
	 * and adds it to the instance variables for dollars and cents
	 * @param dollars
	 * @param cents
	 * post: instance varibles for dollars and cents will have changed
	 */
	public void add (int dollars, int cents){
		if(dollars > -1 && cents > -1) {
			this.setMoney(this.dollars + dollars, this.cents + cents);
		}
	}
	
	/**
	 * add
	 * 
	 * this is a method that takes in another Money Object and adds 
	 * its instance variables to the Money object the method was called on
	 * @param other
	 * Post: only the object the method was called on will have instance variables change
	 */
	public void add(Money other) {
		//Adds the amounts in other to our money object – reducing cents appropriately.
		this.setMoney(this.dollars + other.getDollars(), this.cents + other.getCents());
	}
	
	/**
	 * equals
	 * 
	 * this is a method that checks if the object passed in is not null and that
	 * it is an instance of Money and then checks to see if the value of getMoney()
	 * for both the object passed in and object the method is called are the same
	 * if so it will return true if not it will return false
	 * @param Object Other
	 * @return true if both objects have same dollars and cents in getMoney()
	 * 			returns false if null, not and instance of Money or values are not equal
	 */
	public boolean equals(Object other){
		if(other == null || !(other instanceof Money)) {
			return false;
		}
		Money that = (Money) other;
		if(this.getMoney() == that.getMoney()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * toString
	 * 
	 * this is a method that turns the values of dollars and cents 
	 * into a string in the form $DD.CC
	 * @return String in the form $DD.CC with dollars and cents
	 */
	public String toString(){ 
		String money = "";
		if(cents > 9) {
			//if cents is greater then 9 doesnt need 0
			money = "$" + this.dollars + "." + this.cents;
		}else {
			money = "$" + this.dollars + ".0" + this.cents;
		}
		return money;
	}
	
	/**
	 * compareTo
	 * 
	 * this is a compareTo method that Overrides the method from
	 * the compareable interface and returns an int depending on whether
	 * or not the Bill objects total money combined comes before or 
	 * after the Money object other in the parameter.
	 * @param Money other
	 * @return returns 1 if other comes before the Money the method is called on
	 * 			in terms of total money, a 0 if they are equal, and -1
	 * 			if other is after or greater then the money the method is called
	 * 			on in terms of its total money
	 */
	@Override
	public int compareTo(Money other) {
		if(!(other instanceof Money) || other == null) {
			throw new IllegalArgumentException("can not be compared");
		}
		if(this.equals(other)) {
			return 0;
		}else if(this.getMoney() < other.getMoney()) {
			return -1;
		}else {
			return 1;
		}
	}
	
	/**
	 * clone
	 * 
	 * this is a clone method for the Money class that overrides
	 * the method from Cloneable interface and is used to create and
	 * return a new deep copy clone of the Money object it is called on
	 * @return returns a new deep copy clone of Money object the method 
	 * 			is called on as a new Money Object
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public Money clone()throws CloneNotSupportedException {
		Money copy = (Money)super.clone();
		return copy;
		
	}
}
