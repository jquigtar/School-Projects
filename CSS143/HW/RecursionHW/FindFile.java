import java.io.File;

/**
 * FindFile
 * 
 * this is a class to be used in FindFileDriver and holds
 * instance variables of int count, String[] files, ArrayList
 * filesFound, and a final int constant of MAX_NUMBER_OF_FILES_TO_FIND
 * this class is used to search through files on a computer and find a target 
 * file up to the given number of max number of files to find.
 * @author jquigtar
 * @version 2/23/19
 */
public class FindFile {
	
	private int count;
	private String [] files;
	private ArrayList filesFound = new ArrayList();
	private final int MAX_NUMBER_OF_FILES_TO_FIND;

	public FindFile(int maxFiles) {
		//This constructor accepts the maximum number of files to find.
		this.MAX_NUMBER_OF_FILES_TO_FIND = maxFiles;
		files = new String[this.MAX_NUMBER_OF_FILES_TO_FIND];
	}
	
	/**
	 * directorySearch
	 * 
	 * this is a recursive method that starts at a given directory, and starts
	 * a search for the target file given, which are both given in the parameters
	 * as strings. it will first check that the given directory is a directory
	 * if it is not it will throw an IllegallArgumentException. otherwise it will
	 * begin a search through the directory for the target file. if the method
	 * comes across another directory it will call itself again with the new directory 
	 * and target. once it finds a directory with only files it will search to see
	 * if one or more of the files is the target file. then will bubble back up and search each
	 * directory. each file will fill the filesFound ArrayList until it reaches the 
	 * MAX_NUMBER_OF_FILES_TO_FIND this will stop the count from incrementing as well.
	 * @param String target is the target file to find
	 * @param String dirName is the beginning directory to search
	 * @throws IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundException
	 */
	public void directorySearch(String target, String dirName) {
		//target file will name will be added to end of full directory name
		//to find the target file
		String fullTargetName = dirName + "/" + target;
		File directory = new File(dirName);
		//createda new file with directory name
		
		if(!directory.isDirectory()) {
			//if this new file is not an actual directory throws an exception
			throw new IllegalArgumentException("This is not a directory");
		}
		
		//creates a string array of each file found in this directory
		String [] listOfFiles = directory.list();
		
		for(int i = 0; i < listOfFiles.length; i++) {
			String newFileName = dirName + "/" + listOfFiles[i];
			//creates new file with added file name found in directory
			File newFile = new File(newFileName);
			if(newFile.isDirectory()) {
				//if this new file is another directory call the method again
				//with new directory name
				directorySearch(target, newFileName);
			}
			
			if(newFile.toString().equals(fullTargetName)) {
				//checks if the file that is not a directory
				//is the target file
				if(filesFound.size() < this.MAX_NUMBER_OF_FILES_TO_FIND) {
					//adds this file to the list if it is the target file
					//up until it reaches MAX_NUMBER_OF_FILES_TO_FIND
					this.count++;
					filesFound.insert(newFile, 0);
					//uses ArrayList class
				}else {
					//throw out of bound exception if you pass
					//MAX_NUMBER_OF_FILES_TO_FIND
					throw new ArrayIndexOutOfBoundsException();
				}
			}
		}
		//this method may need to be changed for windows computer since it was tested
		//on a MacBook, but only in the use of the names of directories and target 
		//file names
	}
	
	public int getCount() {
		//This getter returns the number of matching files found
		int copy  = this.count;
		return copy;
	}
	
	public String[] getFiles() {
		//This getter returns the array of file locations, up to maxFiles in size.
		for(int i = 0; i < files.length; i++) {
			if(!filesFound.isEmpty()) {
				//adds to Files array from arrayList with 
				//found files in directory search method
				files[i] = filesFound.remove(0).toString();
			}
		}
		
		String[] copy = new String[this.MAX_NUMBER_OF_FILES_TO_FIND];
		for(int i = 0; i < copy.length; i++) {
			//creates copy array with files found
			copy[i] = files[i];
		}
		return copy;
	}
}
