/*-----------------------------------------------------------------------------------
 * 
 *	sum( n ) is a summation algorithm defined as follows:
 *				
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *			
 *	(2)	    sum( n ) = n + sum( n - 1 ) 
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 ) 
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1 
 *
 *----------------------------------------------------------------------------------- */ 

import java.awt.Dimension;

import javax.swing.*;
	
public class RecursionLab {
	
	private static JTextArea myArea = new JTextArea();
	private static int count = 0;
	
	public static void main( String args[] ) {	//invoke the recursive method here...
		
		/**
		 * TODO: switch between the two commented lines below and execute this code, 
		 * observing the output for both the iterative solution and the recursive solution.
		 * To watch the recursive behaviour in action, set a breakpoint on the if statement
		 * inside the recursiveSum() function
		 * 
		 */
		//int solution = iterativeSum( 20 );
		//int solution = recursiveSum( 20 );
		
		/*
		//Some GUI details
		myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
		JScrollPane myPane = new JScrollPane( myArea );
		myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myPane.setPreferredSize(new Dimension(600,300));
		JOptionPane.showMessageDialog( null, myPane );
		
		//good form to include an exit call when GUIing in Java 
		System.exit(0);
		*/
		
		System.out.println("factorial(5) = " + factorial(5));
		System.out.println("power1(2,5) = " + power1(2,5));
		System.out.println("power2(2,5) = " + power2(2,5));
		System.out.println("fibNum(6) = " + fibNum(6));
		System.out.println("fibSequence = " + fibSequence(6));
	}
	
	
	
	/** recursion is similar to iterative looping, but we
	 *  use method calls to repeat computations (or decompose the problem) 
	 *  instead of explicit looping control structures 
	 */
	public static int recursiveSum( int n ) {
		updateRecursiveDisplay(n);			//overhead for nice output, not required
		if( n == 1)			//if we're at the base case...
			return 1;		//then return the answer to the simplest problem which we know how to solve
		else				//otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep recursing
			return ( n + recursiveSum( n - 1) );
	}						//for this method to terminate, we must be breaking the problem down into smaller
							//and smaller problems, until we reach the simplest form of the problem which we know
							//how to solve (in this case, it's the fact that sum( 1 ) == 1 )

	//the iterative counterpart to the above recursion
	//notice how it's longer? At times, an iterative solution may require more code than the recursive counterpart, 
	//but, the recursive solution is slower and more memory intensive.  We can always recast recursion as iteration.
	public static int iterativeSum( int i ) {
		int total = 0;
		
		for( int n = i; n >= 1; n--) {
			updateIterativeDisplay(n);
			total = total + n;
		}
		return total;
	}						
	
	public static void updateIterativeDisplay(int n) {
		count++;
		String text = myArea.getText();
		
		text += "\n/*******************Loop iteration " + count + "**************************************";
		text += "\n Calling iterativeSum( int n = " + n +" ). Total += " + n;
		text += "\n***************************************************************************/";
		
		myArea.setText( text );
	}
							
							
	//ignore this method unless interested in the output string						
	public static void updateRecursiveDisplay(int n) {
		
		count++;
		String text = myArea.getText();
		
		
		if( count == 1 )  {
			text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}
		
		
		text += "\n/*******************Method invocation " + count + "*********************";
		
		
		text += "\n Calling recursiveSum( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";
		
		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( "+ (n - 1) +" ));";
		} else {
			text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";
		
		myArea.setText( text );
		
	}
	
	public static int factorial(int n) {
		if (n == 1) {
			return n;
		}
		else {
			return n* factorial(n-1);
		}
	}
	
	public static int power1(int x, int n) {
		System.out.println("Calling Power1(x== " + x +", n== " + n + " )");
		if(n == 0) {
			return 1;
		}
		else {
			return x * power1(x, n-1);
		}
	}
	
	public static int power2(int x, int n) {
		System.out.println("Calling Power2(x== " + x +", n== " + n + " )");
		if(n == 0) {
			return 1;
		}else if (n % 2 == 0) {
			int i = power2(x,n/2);
			return i * i;
		}else {
			int i = power2(x,(n-1)/2);
			return x * (i * i);
		}
	}
	
	public static int fibNum(int n) {
		if (n == 0 || n == 1) {
			return n;
		}else {
			return fibNum(n-1) + fibNum(n-2);
		}
	}
	
	public static String fibSequence(int n) {
		if(n == 0) {
			String num = Integer.toString(n);
			return num;
		}else {
			int num1=1;
			int num2=1; 
			int fib=1; 
			for(int i= 3; i<= n; i++){ 
				//Fibonacci number is sum of previous two Fibonacci number 
				fib = num1 + num2; 
				num1 = num2; 
				num2 = fib; 
			} 
			return(fibSequence(n-1) + " " + fib); //Fibonacci number 
		} 
	}
	
	public static int choose(int n, int r) {
		if(r == 0 || n == r) {
			return 1;
		}else {
			return choose(n - 1, r) + choose(n-1, r-1);
		}
	}
}

/**
 * 
 * Step1 -
 * 
 * “Given a target file to find and a starting directory, determine if and where 
 * the target file exists.”
 * 
 * step2- 
 * 
 * (1) Setup & Initialization (for the program, or a specific function, similar to preconditions)
 * 
 * target file name, start directory to search
 * 
 * (2) Input
 * 
 * name of file, first directory to search
 * 
 * (3) Processing
 * 
 * read each file name in one directory if one matches return true if not go to next directory
 * 
 * (4) Output
 * 
 * true or false if file was found
 * 
 * step3-
 * 
 * while(more directories to look at) {
 * 
 * look at one file or directory and check for a match and return it if found
 * 
 *  if the current item is a directory, we must repeat these steps for this directory as well
 *  
 *  so look through this directory in same fashion
 *  
 *  }
 *  
 *  target not found at this point
 *  return false
 */		