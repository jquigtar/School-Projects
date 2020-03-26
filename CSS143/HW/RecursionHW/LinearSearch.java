/**
 * 
 */

/**
 * LinearSearch
 * 
 * this is a class that extends SearchAlgorithm and uses its methods
 * to search linearly through a list of words. 
 * @author jquigtar
 * @version 2/23/19
 */
public class LinearSearch extends SearchAlgorithm {

	public LinearSearch() {}
	
	/**
	 * Search
	 * 
	 * this is a method that overrides the Search method from SearchAlgorithm  
	 * and iterates the whole list of words searching for
	 * the wordToFind every time it searches the list the count is incremented
	 * and if the word is found it will return the index of where it was found
	 * +1 because the array starts at 0 but the list of words starts at 1.
	 * if the word is not found it will throw an ItemNotFoundException
	 * @param words String array with stored words
	 * @param wordToFind String of word to find
	 * @return index of target word in the list of words
	 * @throws ItemNotFoundException of the wordToFind 
	 * 			is not found
	 */
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		for(int i = 0; i < words.length; i++) {
			incrementCount();
			if(words[i].equals(wordToFind)) {
				return i + 1;
			}
		}
		throw new ItemNotFoundException();
	}
	
	
	/**
	 * recSearch
	 * 
	 * this is supposed to be a recursive linear search but can not be used 
	 * on this assignment because it will reach a stack overflow with such a long list of
	 * words
	 * @param words
	 * @param wordToFind
	 * @return index of found word in list
	 */
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		return 1;
		/*
		boolean same = words[words.length - 1].equals(wordToFind);
		if(same == true) {
			return words.length - 1;
		}else {
			String [] copy = new String[words.length -1];
			for(int i = 0; i< copy.length; i++) {
				copy[i] = words[i];
			}
			return recSearch(copy, wordToFind);
		}
		*/
	}
}
