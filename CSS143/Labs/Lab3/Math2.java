/**
 * 
 */

/**
 * Math2
 * 
 * this is class that does math functions and
 * includes PI and E as values
 * @author jquigtar
 *
 */
public class Math2 {

	public static final double PI = 3.14159265359;
	public static final double E = 2.71828182845;
	
	/**
	 * max
	 * 
	 * this is a function that finds the max between two doubles
	 * and returns which one is the max
	 * @param a
	 * @param b
	 * @return returns the max between a & b
	 * 			return a if a>b or b if a<b
	 */
	public static double max(double a, double b) {
		if(a >= b) {
			return a;
		}else {
			return b;
		}
	}
	
	/**
	 * pow
	 * 
	 * this is a function that takes two ints and 
	 * returns the base to the power of exp 
	 * in other words base^exp
	 * @param base
	 * @param exp
	 * @return returns base to the power of exp
	 */
	public static int pow(int base, int exp) {
		int num = 1;
		for(int i = 1; i <= exp; i++) {
			num = num * base;
		}
		return num;
	}
}
