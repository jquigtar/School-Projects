import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;;
/*
 * MorseTree.java
 * CSSSKL 162 Binary Search Tree Lab
 * Author: Rob Nash
 * 
 * This class reads in data from a text file ("data.txt") and populates a binary tree with an 
 * ordering constraint.  See the lab instructions for more information, but in general, dots go right 
 * and dashes go left when constructing or traversing a Morse code tree.  Search for //TODO
 * in the code to see what code you have to implement.
 * 
 * Start with the constructor. In your constructor read each line in from the textfile first, 
 * calling add() for each {letter, morseCodeStr} pair.
 * 
 */

public class MorseTree {
    //TODO: data member called "root" goes here
    private TreeNode<Character> root;
    
    //TODO: Complete constructor
    public MorseTree() {
       
		//first, open data.txt, add each line to the tree
		Scanner fin;
		try {
			fin = new Scanner(new FileInputStream("data.txt"));
			//for each line in the file, 
			while(fin.hasNextLine()) {
			//  get the letter(char) and the Morse string
				char letter = fin.next().charAt(0);
				String morseString = fin.nextLine();
			//  call add() with this data
				this.add(morseString, letter);
				System.out.println("letter: " + letter + " morseString: " + morseString);
			}
			
			
			//  print out the letter and Morse string here for debugging
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("there was an error creating this MorseTree");
			e.printStackTrace();
			System.exit(0);
		}
	}

    
    
    public void add(String morseStr, char letter) {
        root = insertInSubtree(morseStr, letter, root);
    }
    
    //TODO: recursively complete this function.  It's only a few characters different from findInSubtree()
	private TreeNode<Character> insertInSubtree(String morseStr, char letter, TreeNode<Character> subtree) {
		//base case 1 : subtree is null
		if(subtree == null) {
			subtree = new TreeNode<Character>();
		}
		//base case 2 : morseStr is of length 0
		if(morseStr.length() == 0) {
			subtree.data = letter;
			return subtree;
		}
		if(morseStr.charAt(0) == '.') {
			//recursive case 1: the first char in morseStr is a '.', so recursively traverse tree
			subtree.right = insertInSubtree(morseStr.substring(1), letter, subtree.right);
		}
		else{
			//recursive case 2: the first char in the morseStr is a '-', so recurse accordingly
			subtree.left = insertInSubtree(morseStr.substring(1), letter, subtree.left);
		}
		
		return subtree;  //always the last line, always return the node you are working on
	}
    
    
    // This takes in the morse code for a single character (like ".-") 
    // and returns the character it stands for: 'A' 
    public Character translate(String morseStr) {
        return findInSubtree(morseStr, root);
    }
    
    //TODO: recursively complete this function.  Very similar to insertInSubtree()
	private Character findInSubtree(String morseStr, TreeNode<Character> subtree) {
		//base case 1 : subtree is null 
		if(subtree == null) {
			return null;
		}
		//base case 2 : morseStr is of length 0
		if(morseStr.length() == 0) {
			return (Character)subtree.data;
		}
		if(morseStr.charAt(0) == '.') {
			//recursive case 1: the first char in morseStr is a '.', so recursively traverse tree
			return findInSubtree(morseStr.substring(1), subtree.right);
		}
		else{
			//recursive case 2: the first char in the morseStr is a '-', so recurse accordingly
			return findInSubtree(morseStr.substring(1), subtree.left);
		}
	}
    
    //TODO: Non-recursive function that calls other (recursive) functions
    // This method takes in a string like ".-" and returns "A"
    // Or it can take in space-separated morse code tokens in a string, like, 
    // "... --- ..." and it returns "SOS"
	public String translateString(String tokens) {
		String retVal = "";
		
		Scanner readTokens = new Scanner(tokens);
		
		while(readTokens.hasNext()){
			char letter = findInSubtree(readTokens.next(), this.root);
			retVal = retVal + letter;
		}
		//build a scanner here using tokens as input (OR: create an array of tokens usings tokens.split(" "); 
		//iterate over the tokens calling translate on each token (substring separated by a space)
		//concat these characters and return them
		
		readTokens.close();
		
		return retVal;
	}
	
	// This method takes in a character like 'A' and returns the morse code for it: ".-"
    public String toMorseCode(Character c) {
        //walk the tree looking for the TreeNode with the char c in it
            //preorder walk?
            //inorder walk?
            //postorder walk?
        
        //when you've found the char c, report the path from the root to the node
        //and build the morse code by adding a "." when you go right, "-" when you go left
        return new String("You complete me.");
    }
    
    public String toString() {
        return inorderWalk();
    }
    
    private String inorderWalk() {  
        
        return new String("Another wish.");
    }  
    
    public static void main(String[] args) {
        MorseTree mt = new MorseTree();  //builds our tree using data from a file

        System.out.println("Should print S: " + mt.translate("..."));  //prints out S
        System.out.println("Should print O: " + mt.translate("---"));  //prints out O
        System.out.println("Should print nothing: " + mt.translate(".......-"));  //prints out nothing
        
        System.out.println("Should print SOS: " + mt.translateString("... --- ..."));  //SOS
        System.out.println("Morse code for X is: " + mt.toMorseCode('X') + "  (<-- Should be -..-)");  //find where we are in the tree, remember path to root
        System.out.println("Next we'll do toString, which, as an inorder traversal, should print out: \n" +
                            "          0 ? 9 O . 8 M Q G Z 7 T Y K C N X D B 6 1 J W P A R L E 2 - U F I 3 V S 4 H 5");
        System.out.println("toString: " + mt);
    }

    // Inner class to create the linked structure
    private class TreeNode<T> {
        
        private Object data;     // holds a given node's data
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode() {
            this.data = null;
            this.right = null;
            this.left = null;
        }
        
        // add a constructor that takes data, right, and left.
        public TreeNode(T data, TreeNode right, TreeNode left) {
        	this.data = data;
        	this.right = right;
        	this.left = left;
        }
        
        
        public void setRight(TreeNode rightNode) {
            this.right = rightNode;
        }
        
         public void setLeft(TreeNode leftNode) {
            this.left = leftNode;
        }
            
    }
}
