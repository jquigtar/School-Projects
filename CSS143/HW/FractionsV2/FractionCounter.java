/**
 * 
 */

/**
 * FractionCounter
 * 
 * this is a class that uses an instance of Fraction object
 * and has a count for each instance of FractionCounter object
 * @author jquigtar
 * @version 1/25/19
 */
public class FractionCounter {

	private Fraction newFraction;
	private int counter = 1;
	//keep track of the count for each new Fraction object

	/**
	 * Constructor
	 * 
	 * stores a fraction object from the parameter as
	 * the instance for this FractionCounter object
	 * @param theFraction
	 */
	public FractionCounter(Fraction theFraction) {
		this.newFraction = theFraction;
	}

	/**
	 * compareAndIncrement
	 * 
	 * this is a function that takes another Fraction object
	 * as a parameter and compares it to the calling objects
	 * instance of Fraction and if they are equal it will up the
	 * count of that instance of FractionCounter and return true
	 * if they are not equal it will return false
	 * @param otherFraction
	 * @return returns true if the two Fraction objects are equal
	 * 			returns false if they are not equal
	 */
	public boolean compareAndIncrement(Fraction otherFraction) {
		if(this.newFraction.equals(otherFraction)) {
			this.counter++;
			return true;
		}else {
			return false;
		}
	}

	/**
	 * toString
	 * 
	 * this is a method that returns a string in the form
	 * A/B has a count of (Count)
	 * if the numerator has 0 then the fraction value = 0
	 * so it prints 0 instead of 0/B
	 * @return
	 */
	public String toString() {
		if(this.newFraction.getNumerator() != 0) {
			return this.newFraction.toString() + " has a count of " + this.counter;
		}else {
			return "0 has a count of " + this.counter;
		}
	}
}
