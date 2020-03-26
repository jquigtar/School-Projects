import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
// The following comment is exactly 80 characters long; I put it here to
// make sure that none of my lines ever goes beyond 80 characters:
// 45678901234567890123456789012345678901234567890123456789012345678901234567890
/**
 * Reviewof142_students
 * --------------------
 * Description: This is a class to help students remember and practice 
 *              some of the basic concepts they learned in CSS 142
 *              (formerly known as CSS 161)
 *
 * @author Jordan Quigtar
 * @version 1/11/19
 */
public class Reviewof142_students
{
    public static void main(String[] args) {
        System.out.println("Hello." +
            "This program will help me practice some 142 basics.");

        /* CONTROL STRUCTURES: */

        for(int i = 0; i<10; i++){
            System.out.println(i);
        }

        int count = 0;
        int currentNumber =0;
        while(count<10){
            if (currentNumber % 2 == 0){
                System.out.println(currentNumber);
                count++;
                currentNumber++;
            }
            else{
                currentNumber++;
            }
        }

        int quizSum = 0;
        int quizScore = 0;
        count = 0;
        Scanner keyboard = new Scanner(System.in);
        while(keyboard.hasNextInt() && count < 5){
            quizScore = keyboard.nextInt();
            quizSum = quizSum + quizScore;
            count++;
        }
        System.out.println("quiz score is " + quizSum);

        double quizAvg = (double)quizSum / 5.0;
        System.out.println("quiz averages is " + quizAvg);

        char letterGrade = 'X';
        if(quizAvg >= 95){
            letterGrade = 'A';
        }else if(quizAvg< 95 && quizAvg >=85){
            letterGrade = 'B';
        }else if(quizAvg <85 && quizAvg >= 75){
            letterGrade = 'C';
        }else if(quizAvg < 75 && quizAvg >=65){
            letterGrade = 'D';
        }else if(quizAvg< 65){
            letterGrade = 'F';
        }
        System.out.println("Student grade is " + letterGrade);

        /*a switch statement for this case wouldnt really make much sense
         * since there are various number for each grade, also
         * you can not use a double in a switch statement
         */

        /* ARRAYS */
        int [] array = {1,2,3,4,5,6};
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println();

        int arraySum = arraySum(array);
        System.out.println("The sum of my array of ints is " + arraySum);

        double arrayAvg = arraySum/ array.length;
        System.out.println("The average of the ints in my array is " + arrayAvg);

        System.out.println(indexOf(array,3));
        System.out.println(indexOf(array,7));

        // 11. Write a function to sum up only the positive integers in an array
        //     signature:     public static int positiveSum(int[] data)
        //     Test it here. 
        //     Be sure, when you're testing to first print out something like
        //     "Testing positiveSum() function now. If successful,
        //      this should print out the number 42."  
        //      Then print the return value of the function.

        int sumOfArray = positiveSum(array);
        System.out.println("Testing positiveSum() function now. If successful,"
            + "this should print out the number 12." );

        System.out.println(sumOfArray);
        // 12. Write a function to populate an int array with values 
        //     obtained from the console.
        //     signature:   public static void populateArray(int[] data)
        //     Test it here. Practice good testing habits (as above).
        populateArray(array);

        System.out.println("Testing populateArray() function now. If successful,"
            + "this should print out the elements of the array." );
        for (int i = 0; i< array.length;i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println();;

        /* FILE IO */

        PrintWriter pw;
        try {
            pw = new PrintWriter(new File("arrayData.txt"));
            for (int i = 0; i< array.length;i++){
                pw.print(array[i] + ", ");
            }
            pw.println();
            pw.println("the sum of the array is " + arraySum(array));
            arrayAvg = arraySum(array) / array.length;
            pw.println("the average fo teh array is " + arrayAvg);
            pw.close();
        }

        catch(Exception e){
            System.out.println("Uh-oh, I don't see that file here.");
        }

        // 17. Create and test a new function that takes in a string 
        //     which is the name of a file, and 
        //     it then opens that file and prints the contents
        //     to the screen.  Test that function on arrayData.txt.
        //     Since you're testing the function and your file writing 
        //     from #13-15, be sure to print something on the screen so 
        //     we know that's what's happening and we don't just get a bunch
        //     of numbers printed without knowing why.
        //     Make sure you give this function (and all your functions) 
        //     good descriptive names.

        writeFromFile("arrayData.txt");
        System.out.println("now testing writeFromFile() function which " +
            "which will print the array from the text file");
        /* A FACTORIAL PROGRAM */

        factorial();

        // 45678901234567890123456789012345678901234567890123456789012345678901234567890

        /* FINDING DIVISORS PROGRAM */
        // 19. Create a function that will use a scanner to ask the user for a 
        //     number n, then print out that number's divisors (all the 
        //     numbers that n is evenly divisible by).
        //     Test the function here.
        //     We'll find the divisors by using a simple algorithm
        //     described below. Notice that we'll need to
        //     make use of an if statement to determine if the number n is 
        //     evenly divisible by some divisor d. The code to determine if a
        //     number n is evenly divisible by a divisor d is here:
        //     "if n divided by d produces a remainder of 0, then d evenly 
        //      divides n"   or in Java...
        //     if(n % d == 0) { // yes, d is a divisor...
        //
        //     Notice that we will also need an if statement for special cases;
        //     What if the user enters a 0 or a 1? Handle these special cases by 
        //     wrapping your logic in an if statement that handles the case where 
        //     n is 0, 1 , or greater than 1.
        //     
        //     Here is a sample execution:
        //       Enter a number:  12
        //       Divisors are 6 4 3 2 1
        //
        //     Steps to create this function:
        //     1. Create a scanner and ask the user for a number n.
        //     2. Build an if statement to handle cases such as 0, 1,
        //        or greater than 1.
        //     3. In the >1 case, build a loop starting at n (or n/2?) 
        //        and ending at 1.
        //     4. Using the if statement above, print out your loop variable
        //        if it evenly divides n

        findingDivisors();

        /* BIGGER CHALLENGE: INFIX CALCULATOR */
        // 20. Build and test an Infix Calculator function.
        //     (The function is started below)
        //     This will take in a string like "1 * -3 + 6 / 3"
        //     and return the value of (((1 * -3) + 6) / 3).
        //     See how it ignores the normal order of operations and just
        //     calculates from left to right?
        //     So "4 + 4 / 2" will equal 4, not 6.
        //     The input strings need to separate operators and numbers
        //     with spaces.  (So, "4 + 4 / 2", not "4+4/2")
        //     --Except for negative numbers, where there's no space:  "-3" 
        //     Test your function on a variety of inputs including:
        //     "4 + 4",  "4 + 4 / 2",  "1 * -3", "1 * -3 +6 / 3", "5" , "-5"
        //     You'll probably want to take advantage of StringTokenizer
        //     to separate the inputString into individual string tokens
        //     that you can then check one by one to see if it is a 
        //     number or an operator.
        //     (You can also use Scanner to do this)

    } // end of main

    /**
     * arraySum                         
     * --------
     * This function takes in an array of integers
     * and returns the sum of all those integers.
     * @param inputArray : This is the array of integers
     * @return : this returns an int which is the sum of all
     *           the elements in the array
     * PRE:  NONE
     * POST: returns an int, doesn't change inputArray
     */
    public static int arraySum(int[] inputArray){
        int arraySum = 0;
        for(int i = 0; i<inputArray.length; i++){
            arraySum = arraySum + inputArray[i];
        }
        return arraySum;   // change this later.
    }

    /**
     * populateArray                         
     * --------
     * This function takes in an array of integers
     * and prompts the user to change the values in that array
     * @param inputArray : This is the array of integers
     * PRE:  NONE
     * POST: changes data array
     */
    public static void populateArray(int[] data){
        System.out.println("enter integers to populate the array");
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i<data.length; i++){
            data[i] = keyboard.nextInt();
        }
    }

    /**
     * indexOf                       
     * --------
     * This function takes in an array of integers 
     * and returns index of that target in the array
     * @param data : This is the array of integers
     * @param target: This is the target integer youre 
     *                looking for in the array
     * @return : this returns an int which is the index of the array
     *           where the target integer appears or returns -1 if target
     *           not found
     * PRE:  NONE
     * POST: returns an int, doesn't change data
     */
    public static int indexOf(int[] data, int target){
        for(int i = 0; i<data.length; i++){
            if(data[i] == target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 
     */
    public static void factorial(){
        Scanner keyboard = new Scanner(System.in);
        int product = 1;
        System.out.println("enter an integer n");
        int n = keyboard.nextInt();
        for(int i = 1; i <= n; i++){
            product = product * i;
        }
        System.out.println(n + " factorial = " + product);
    }

    /**
     * positiveSum                       
     * --------
     * This function takes in an array of integers 
     * and returns the sum of all the positive integers
     * @param data : This is the array of integers
     * @return : this returns an int which is the sum of all the 
     *           positive integers in the array
     * PRE:  NONE
     * POST: returns an int, doesn't change data
     */
    public static int positiveSum(int[] data){
        int sum = 0;
        for(int i = 0; i<data.length;i++){
            if(data[i] % 2 == 0){
                sum = sum + data[i];
            }
        }
        return sum;
    }

    /**
     * 
     */
    public static void writeFromFile(String fileName){
        Scanner input;
        try {
            input = new Scanner(new File(fileName));
            while(input.hasNextLine()){
                System.out.print(input.nextLine());
            }
        }

        catch(Exception e){
            System.out.println("Uh-oh, I don't see that file here.");
        }
    }

    /**
     * 
     */
    public static void findingDivisors(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number n");
        int n = keyboard.nextInt();
        int [] divisors = new int[n];
        if(n == 0){
            System.out.println("0 is not divisible by any numbers");
        }else if (n == 1){
            System.out.println("1 is only divisible by 1");
        }else if (n > 1){
            for(int i = n; i>=1; i--){
                if(n % i == 0){
                    System.out.println(i + " is a divisor of " + n);
                }
            }
        }
    }

    /**
     * infixCalculator                         
     * ---------------
     * This function takes in a string like "4 + 4 / 2"
     * and calculates the value of that string reading from left to right
     * (so in this case, 4.)
     * 
     * @param inputString : a string representing 
     * @return : a double, the value of the calculations
     * PRE:  inputString must have a single space between any numbers 
     *       and operators (except for negative numbers, where the 
     *       negation sign must be right next to the number)
     *       input must be properly formatted -- no guarantees if
     *       we're given gibberish.
     * POST: returns a double, otherwise no changes to anything.
     */
    public static double infixCalculator(String inputString){
        double lhs = 0 , rhs = 0; //short for left-hand & right-hand side
        String operation;
        StringTokenizer tokenizer =
            new StringTokenizer(inputString);
        // int number1 =tokenizer.nextToken();
        int number2 = 1;

        /*while(tokenizer.hasMoreTokens())
        {
            operation = tokenizer.nextToken();
            number2 = tokenizer.nextToken();
            if(operation == '/'){
                number1 = number1 / number2;
            }else if(operation == '*'){
                number1 = number1 * number2;
            }else if(operation == '+'){
                number1 = number1 + number2;
            }else if(operation == '-'){
                number1 = number1-number2;
            }else if(operation == '%'){
                number1 = number1 % number2;
            }

        }
        */
        return lhs;   
    }

}
