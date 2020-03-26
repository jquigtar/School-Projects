

/**
 * 
 */

/**
 * Fraction
 * 
 * this is a class that stores a fraction in the form A/B
 * it has two instance variables of numerator and denominator
 * @author jquigtar
 * @version 1/25/19
 */
public class Fraction {

	private int numerator;
	private int denominator;

	// no-arg constructor
	public Fraction() {

	}

	/**
	 * Fraction (Constructor)
	 * 
	 * this is a constructor that takes in the numerator and denominator
	 * and decides whether the fraction is positive or negative
	 * as well as if the denominator is 0, it then finds the greatest
	 * common denominator between the numerator and denominator and
	 * reduces the fraction 
	 * @param numerator
	 * @param denominator
	 */
	public Fraction(int numerator, int denominator) {
		int gcd = reFactor(numerator, denominator);
		//reduce fraction using this number

		if(numerator > 0 && denominator > 0) {//both are (+)
			this.numerator = numerator / gcd;
			this.denominator = denominator / gcd;
		}else if (numerator < 0 && denominator > 0) {//num is (-) den (+)
			this.numerator = numerator / gcd;
			this.denominator = denominator / gcd;
		}else if (numerator < 0 && denominator < 0) {//both are (-)
			this.numerator = (numerator * -1) / gcd;//fraction is positive
			this.denominator = (denominator * -1) / gcd;
		}else if(numerator > 0 && denominator < 0) {//den(-) num(+)
			this.numerator = (numerator * -1) / gcd;
			this.denominator = (denominator * -1) / gcd;
		}else if(numerator == 0) {//fraction = 0
			this.numerator = 0;
			//reduces all fractions=0 to 0/1
			this.denominator = 1;
		}else if(denominator == 0) {//can not divide by 0
			System.out.println("Invalid fraction");
		}
	}

	/**
	 * reFactor
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
	private int reFactor(int numerator, int denominator){
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
	 * this is method that takes ones fraction object and compares it to 
	 * the calling fraction object to see if they are equal
	 * logic used to check if they are equal is 
	 * (A/B) =? (C/D) ==> A=?C and  B=?D
	 * @param otherFraction
	 * @return returns true if the two fractions are equal
	 * 			or false if they are not equal
	 */
	public boolean equals(Fraction otherFraction) {
		if(this.numerator == otherFraction.numerator &&
				this.denominator == otherFraction.denominator) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * toString
	 * 
	 * this is a function that takes the numerator and denominator
	 * of an instance of Fraction and turns it to a string in the
	 * form A/B
	 * @return returns a string in the form A/B
	 */
	public String toString() {

		return this.numerator + "/" + this.denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
}
