/**
 * 
 */

/**
 * Fraction
 * 
 * this is a Class that stores a numerator and denominator and 
 * converts these two ints into a fraction of the form A/B
 * @author jquigtar
 *
 */
public class Fraction {

	public final int numerator;
	public final int denominator;
	
	public Fraction(int numerator, int denominator) {
		int gcd = gcd(numerator, denominator);
		this.numerator = numerator / gcd;
		//if(denominator != 0) {
			this.denominator = denominator / gcd;	
		//}
		//since its a final it has to be set and not null
	}
	
	public Fraction(Fraction other){
		Fraction copy = new Fraction(other.numerator, other.denominator);
		this.numerator = copy.numerator;
		this.denominator = copy.denominator;
		
	}
	/**
	 * toString
	 * 
	 * this is a function that takes the numerator and the denominator 
	 * and turns it into a string of form A/B
	 * @return returns a string of the fraction in the from A/B
	 */
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	
	/**
	 * add
	 * 
	 * this is a function that takes a fraction object and adds
	 * it to the calling Fraction object
	 * @param that
	 * @return returns a new fraction object with a different value
	 */
	public Fraction add(Fraction that) {
		int numerator = 0;
		int denominator = 0;
		Fraction newFraction;
		if(this.denominator == that.denominator) {
			//just add numerators if denominator is the same
			numerator = this.numerator + that.numerator;
			newFraction = new Fraction(numerator, this.denominator);
		}else {
			denominator = this.denominator * that.denominator;
			numerator = (this.numerator * that.denominator) + 
					(this.denominator * that.numerator);
			newFraction = new Fraction(numerator, denominator); 
		}
		return newFraction;
	}
	
	/**
	 * gcd
	 * 
	 * https://stackoverflow.com/questions/13673600/how-to-write-a-simple
	 * -java-program-that-finds-the-greatest-common-divisor-betwee
	 * this is a function with logic found on stackoverflow that takes the
	 * numerator and denominator and finds the greatest common denominator
	 * between the two
	 * @param numerator
	 * @param denominator
	 * @return returns the greatest common divisor between two numbers
	 */
	private int gcd(int numerator, int denominator){
		int gcd = 1;
		if(numerator > denominator)
		{
			for(int i = denominator; i >= 1; i--)
			{
				if(numerator % i == 0 && denominator % i == 0)
				{
					return i;
				}
			}
		}
		else
		{
			for(int j = numerator; j >= 1; j--)
			{
				if(numerator % j == 0 && denominator % j == 0)
				{
					return j;
				}
			}
		}   
		return gcd;
	}
	
	/**
	 * equals
	 * 
	 * this is a function that takes in an object, checks
	 * if it is a Fraction and compares it to the calling
	 * Fraction and sees if they are equal
	 * @return returns true if the two fractions are equal
	 * 			returns false if object being passed in
	 * 			is null, not a Fraction, or not equal to
	 * 			Fraction object it is called on
	 */
	  public boolean equals(Object other) {

          if ( other == null || ! (other instanceof Fraction ) ) {
        	  return false; 
          }

          Fraction that = (Fraction) other; //and this code?

          if(this.numerator == that.numerator && this.denominator == that.denominator) {
        	  return true;
          }else {
        	  return false;
          }
          //to do: code goes here

}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}
	  
	  
}
