/**
 * 
 */

/**
 * FindFileDriver
 * 
 * this is a driver class for the FindFile class. it is used 
 * to test the methods from the FindFile class on a computer
 * search for a file
 * @author jquigtar
 * @version 2/23/19
 */
public class FindFileDriver {

	/**
	 * main
	 * 
	 * this is the main method where a target file and directory are created as strings
	 * and entered into the directorySearch method, there is a try catch to see
	 * if the searches reaches the max number of files to find. if the max is reached
	 * it is printed to the screen and then the program will end. if not it will
	 * then print how many times the file was found as well as print all the 
	 * locations where it was found.
	 * @param args
	 */
	public static void main(String[] args) {
		String targetFile = "a1.pdf";
		String pathToSearch = "/Users/jquigtar/toSearch";
		//set target file name and beginning directory
		FindFile finder = new FindFile(10);
		//creates FindFile object with set MAX_NUMBER_OF_FILES_TO_FIND
		
		try {
			finder.directorySearch(targetFile, pathToSearch);
			//begins search of target file at beginning directory
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Found target file more then " + finder.getCount() + " times");
			System.out.println("Ending program.");
			System.exit(0);
		}
		
		System.out.println("The target file was found " + finder.getCount() + " time(s)");
		System.out.println();
		
		if(finder.getCount() > 0) {
			String [] files = finder.getFiles();
			//creates String array with locations of where the file was found
			//the print all of the locations
			System.out.println("Printing files found");
			
			for(int i = 0; i < finder.getCount(); i++) {
				System.out.println(files[i].toString());
			}
		}
	}

}
