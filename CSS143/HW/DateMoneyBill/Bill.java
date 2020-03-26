/**
 * 
 */

/**
 * Bill
 * 
 * this is class bill that hold values for the amount due on a bill
 * using Money class as well as a date due and paid using Date class
 * and the name of the originator of the bill as a string
 * @author jquigtar
 * @version 2/8/2019
 */
public class Bill {
	
	private Money amount;
	private Date dueDate;
	private Date paidDate;
	private String originator;


	public Bill (Money amount, Date dueDate, String originator){
		//Constructor.  (paidDate set to null)
		this.amount = new Money(amount);
		Date due = new Date(dueDate);
		this.dueDate = due;
		String origCopy = originator;
		this.originator = origCopy;
		this.paidDate = null;
	}
	
	public Bill (Bill toCopy){
		//copy constructor (paidDate set to null)
		Date copyDate = new Date(toCopy.dueDate);
		Money copyMoney = new Money(toCopy.amount);
		String origCopy = toCopy.getOriginator();
		this.amount = copyMoney;
		this.dueDate = copyDate;
		this.originator = origCopy;
		this.paidDate = null;
	}
	
	public Money getAmount() {
		Money amt = this.amount;
		return amt;
	}
	
	public Date getDueDate() {
		Date dueDate = this.dueDate;
		return dueDate;
	}
	
	public String getOriginator() {
		String originator = this.originator;
		return originator;
	}
	
	/**
	 * isPaid
	 * 
	 * this is a method that returns true if the bill is paid or in
	 * other words the amount owed is 0 dollars and false if amount is greater
	 * then 0
	 * @return  returns true for if amount is 0 and false if it is not
	 */
	public boolean isPaid(){
		//returns true if bill is paid.  Else false. 
		if(this.amount.getMoney() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * setPaid
	 * 
	 * this is a method that returns true if the date entered in as parameter 
	 * is past before the dueDate and then sets bill amount to 0 and the 
	 * date paid to that date, otherwise the method will return false
	 * @param datePaid
	 * @return if datePaid parameter is before the dueDate it will return true
	 * 			else it will return false
	 */
	public boolean setPaid(Date datePaid) {
		if(datePaid.isAfter(this.dueDate)) {
			this.paidDate = datePaid;
			this.amount.setMoney(0, 0);
			return true;
		}
		return false;
	}
	
	/**
	 * setDueDate
	 * 
	 * this method Resets the due date – If the bill is already paid, this call fails 
	 * and returns false. Else it resets the due date and returns true.
	 * @param nextDate
	 * @return returns true if the due date is reset and false if it is already paid
	 */
	public boolean setDueDate(Date nextDate){
		
		if(this.isPaid()) {
			return false;
		}else {
			this.dueDate = nextDate;
			return true;
		}
	}
	
	/**
	 * setAmount
	 * 
	 * Change the amount owed.  If already paid, returns false and does not
	 * change the amount owed else changes the amount and returns true. 
	 * @param amount
	 * @return returns true if the amount is changed and false if it is already paid
	 */
	public boolean setAmount(Money amount){
		
		if(this.isPaid()) {
			return false;
		}else {
			this.amount = amount;
			return true;
		}
	}
	
	public void setOriginator(String originator){
		this.originator = originator;
	}
	
	/**
	 * toString
	 * 
	 * this is a method that Builds a string that reports the amount, 
	 * when due, to whom, if paid, and if paid the date paid
	 * @return a string in the form 
	 * "amount is due to originator on duedate. has been paid on paidDate"
	 */
	public String toString(){
		String bill = this.amount.toString() + " is due to " + this.originator +
				" on " + this.dueDate + ".";
		if(this.isPaid() == true) {
			bill = bill + " has been paid on " + this.paidDate;
		}
		return bill;
	}
	
	/**
	 * equals
	 * 
	 * this is a method that first checks if the object passed in is null 
	 * or not an instance of Bill, if it is then it will see if the amount,
	 * dueDate, originator, and paid date are the same if it is then it will
	 * return true, if it is not it will return false
	 * @param Object toCompare
	 * @return returns true if amount, dueDate, originator is the same
	 * 			returns false if they are not and if the object is null or not a bill
	 */
	public boolean equals(Object toCompare) {
		if(toCompare == null || !(toCompare instanceof Bill)) {
			return false;
		}
		Bill that = (Bill) toCompare;
		if(this.amount.equals(that.amount) && 
				this.dueDate.equals(that.dueDate) &&
				this.getOriginator() == that.getOriginator()) {
			return true;
		}else {
			return false;
		}
		
	}
}
