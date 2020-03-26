import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * FractionsV2Driver
 * 
 * This is a class that uses classes Fraction, FractionCounter
 * and ObjectList and reads in fractions from a txt file
 * and counts the number of unique fractions and prints
 * their count to the screen.
 * @author jquigtar
 *
 */
public class FractionsV2Driver {

	/**
	 * main
	 * 
	 * runs and reads in fractions from  text file using scanner
	 * then turns them into Fraction objects with complimentary
	 * FractionCounter objects that are added to an ObjectList
	 * and printed to a screen with their count
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner inputCount = null, inputRead = null;
		int lengthOfFile = 0;
		String [] fractionsSplit = new String[2];
		String [] fractions = null;
		ObjectList fractionList = null;
		//created all variables to be used

		

		try{
			inputCount = new Scanner(new FileInputStream("fractions.txt"));
			inputRead = new Scanner(new FileInputStream("fractions.txt"));
			//two scanners one to count the number of lines one to store each
			//fraction as a string in an array

			while(inputCount.hasNextLine()){
				inputCount.nextLine();
				lengthOfFile++;//counts total number of fractions
			}
			inputCount.close();
			
			fractionList = new ObjectList(lengthOfFile);
			//list created with total number of fractions to hold
			//FractionCounter objects later
			
			fractions = new String[lengthOfFile];
			//array created with correct number of elements

			while(inputRead.hasNextLine()) {
				for(int i = 0; i<fractions.length; i++) {
					fractions[i] = inputRead.nextLine();
				}
			}// each element in the array is a fraction from the text file
			//as a String
			inputRead.close();
		}
		catch(FileNotFoundException e){
			System.out.println("This File could not be found");
			System.exit(0);
		}     

		int numerator = 0;
		int denominator = 0;
		// numerator and denominator set to read in from string array

		for(int i = 0; i < fractions.length; i++) {
			fractionsSplit = fractions[i].split("/");
			//splits the string into two strings separated by "/"
			//then stores into array as two numbers
			//these two numbers are split into numerators and denominators
			numerator = Integer.parseInt(fractionsSplit[0]);
			denominator = Integer.parseInt(fractionsSplit[1]);

			if(denominator != 0) {
				//skips invalid fractions (A/0)
				
				Fraction newFraction = new Fraction(numerator, denominator); 
				//new Fraction object created using num and den
				
				if (i == 0) { 
					//if its the very first fraction for sure add this one to the list
					
					FractionCounter countFraction = new FractionCounter(newFraction); 
					//create new FractionCounter for the Fraction object
					
					fractionList.add(countFraction); 
					//add the new object to the ObjectList
					
				} else {//other FractionCounters need to be checked if in the list
					boolean counted = false; 
					
					for (int j = 0; j < fractionList.getNumElements(); j++) { 
						//read through the fractionList to see if FractionCounter object is
						//already in list
						FractionCounter currentCount = (FractionCounter) fractionList.getObject(j); 
						//new FractionCounter object at each index
						
						if (currentCount.compareAndIncrement(newFraction)) { 
							//compares fractionCounter in list to new Fraction counter
							//being passed in
							counted = true; //this fraction has already been added
							break; 
							//break since you already see its in the list
						}
					}
					
					if (counted == false){ //if currentCount is not in the list
						FractionCounter newCurrentCount = new FractionCounter(newFraction);
						//create new FractionCounter object new Fraction being passed in
						
						fractionList.add(newCurrentCount);
						//and add this fraction to the ObjectList
					}
				}
			}
		}
		
		for(int i = 0; i <fractionList.getNumElements(); i++) {
			System.out.println(fractionList.getObject(i).toString());
		}//prints each FractionCounter object on its own line
	}
}
