/**
 * 
 */

/**
 *CharList
 *
 *this is a class that holds an array of characters for a string
 *or in other words breaks a word into its seperate characters
 * @author jquigtar
 *
 */
public class CharList {

	private char [] characters = new char[100];
	private int totalChar = 0;
	
	public CharList() {
		
	}
	
	public CharList(String startStr) {
		//use string to set up internals
		for(int i = 0; i < startStr.length(); i++) {
			char letter = startStr.charAt(i);
			this.characters[i] = letter;
			totalChar++;
		}
	}
	
	public CharList(CharList other) {
		for(int i = 0; i< this.characters.length; i++) {
			char letter = other.characters [i];
			this.characters[i] = letter;
		}
		this.totalChar = other.totalChar;
	}
	
	/**
	 * add
	 * 
	 * adds another character to the end of the list for
	 * the array holding each character of a word
	 * @param next
	 */
	public void add(char next) {
		this.characters[totalChar] = next;
		totalChar++;
	}
	
	public char get(int index) {
		// gets the character at this index.
		return characters[index];
	}
	
	/**
	 * size
	 * 
	 * this is a method that returns an int of the size of the
	 * list of characters
	 * @return returns the totalchar for total number of 
	 * 			characters
	 * 
	 */
	public int size() {
		// returns the size of the CharList
		return totalChar;
	}
	
	/**
	 * toString
	 * 
	 * this is a function that returns a string of each character 
	 * as one full word
	 * @return
	 */
	public String toString() {
		//Return a string that is the concatenated result of 
		//combining every character in your char array. 
		//(In other words: no spaces between your characters, 
		//and no spaces at the beginning or end either.
		String word = "";
		for(int i = 0; i < this.totalChar; i++) {
			word = word + characters[i] ;
		}
		return word;
	}
	
	/**
	 * equals
	 * 
	 * this is a function that returns a boolean of 
	 * if two charList are the exact same in size and same characters
	 * @return if the two charList have the same exact characters 
	 * 			it returns true if not it returns false
	 */
	public boolean equals(Object other) {
	boolean same = false;
	if( other == null || !(other instanceof CharList )) {
		return false; //follow this pattern to check for null and verify class types
	}else {
	CharList that = (CharList) other;
	if(this.totalChar == that.totalChar) {
		for(int i = 0; i < this.totalChar; i++) {
			if(this.characters[i] == that.characters[i]) {
				same = true;
			}else {
				same = false;
				return same;
			}
		}
	}else {
		return false;
	}
	}
	return same;
	}
}
