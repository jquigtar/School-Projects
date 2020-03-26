/**
 * 
 */

/**
 * BinarySearch
 * 
 * this is a class that extends searchAlgorithm
 * and uses its methods to search through a list of words
 * using a binary search algorithm
 * @author jquigtar
 * @version 2/23/19
 */
public class BinarySearch extends SearchAlgorithm {
	
	public BinarySearch() {}
	
	/**
	 * Search
	 * 
	 * this is a method that overrides the search method from SearchAlgorithm class
	 * and searches through an array of words for the wordToFind using a binary search
	 * algorithm which cuts the list in half each time by determining if the list should be
	 * searched above or below the last searched word depending on if the target word 
	 * comes before or after that word alphabetically. if the word is found it will return the 
	 * index of that word +1 since the list starts at 1 and array starts at 0. if the word is not found 
	 * it will throw an ItemNotFoundException
	 * @param words, String array of words in alphabetical order
	 * @param wordToFind String of the word you are searching for
	 * @return index of the found word in the array +1
	 * @throws ItemNotFoundException if the word is not found
	 * Precondition: the array of words must be in alphabetical order.
	 */
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		int lowIndex = 0;
		int highIndex = words.length - 1;
		while(lowIndex <= highIndex) {
			incrementCount();
			//count each time you have checked a word
			int midIndex = (highIndex + lowIndex) / 2;
			if(words[midIndex].equals(wordToFind)) {
				return midIndex + 1;
				//if the word in the middle is the word return where you found the word
			}
			if(words[midIndex].compareTo(wordToFind) > 0) {
				highIndex = midIndex - 1;
				//if the word comes before the middle word searched change the high index you are searching
			}else if(words[midIndex].compareTo(wordToFind) < 0) {
				lowIndex = midIndex + 1;
				//if the word comes after the middle word searched change the low index you are searching
			}
		}
		throw new ItemNotFoundException();
	}
	
	/**
	 * recSearch
	 * 
	 * this method uses the overloaded private recSearch method 
	 * to recursively search through the list of words with a binary
	 * search algorithm
	 * @param words, String array of words in alphabetical order
	 * @param wordToFind String of the word you are searching for
	 * @return index of the found word in the array +1
	 * @throws ItemNotFoundException if the word is not found
	 * Precondition: the array of words must be in alphabetical order.
	 */
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		int lowIndex = 0;
		int highIndex = words.length - 1;
		return recSearch(words, wordToFind, lowIndex, highIndex);
		
	}
	
	/**
	 * recSearch
	 * 
	 * this is a private method that overloads the recSearch method
	 * and is used as a helper method to recursively search through the list of 
	 * words  array for the wordToFind with a binary search algorithm. 
	 * once it sees if the word comes before or after the recently searched word 
	 * alphabetically then it will recursively call itself using new high and low indexes.
	 * @param words String array of words to search through
	 * @param wordToFind string of word to find in list
	 * @param low low index bound to search above
	 * @param high high index bound to search below
	 * @return index in  words array where word is found +1
	 * 			once the recursion reaches the base case
	 * @throws ItemNotFoundException if word is not found
	 * Precondition: words array must be in alphabetical order
	 */
	private int recSearch(String[] words, String wordToFind, int low, int high) throws ItemNotFoundException {
		incrementCount();
		int midIndex = (high + low) / 2;
		if(words[midIndex].equals(wordToFind)) {
			return midIndex + 1;
			//base case if word is at middle index
		}
		if(words[midIndex].compareTo(wordToFind) > 0) {
			return recSearch(words, wordToFind, low, midIndex - 1);
			//if wordToFind comes before searched word alphabetically search below that word
		}else if(words[midIndex].compareTo(wordToFind) < 0) {
			return recSearch(words, wordToFind, midIndex + 1, high);
			//if wordToFind comes after searched word alphabetically search above that word
		}
		throw new ItemNotFoundException();
	}
}
