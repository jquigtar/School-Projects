
/**
 * LLStack
 * 
 * This class will use Nodes to form a linked list. It implements the LIFO
 * (Last In First Out) methodology to reverse the input string.
 *
 *Explain specifically which method is responsible for making sure that LIFO behavior
 * (a characteristic of Stack) is correctly implemented in your software.
 * the method addToStart is what makes sure that this class has LIFO behavior 
 * because it will always make the head the new data coming in and move every other
 * object down the list by new Node(newData, oldData)
 * 
 * @author jquigtar
 * @version 3/1/19
 **/

public class LLStack {
      // This is an inner class specifically utilized for LLStack class,
      // thus no setter or getters are needed
      private class Node  {
          private Object data;
          private Node next;
         
          // Constructor with no parameters for inner class
          public Node(){
             this.data = null;
             this.next = null;
          }
         
          // Parametrized constructor for inner class
          public Node (Object newData, Node nextLink) {
                 this.data = newData;
                this.next = nextLink;
          }
      }
      
      // just one private data member:
      private Node head;
      
      // Constructor with no parameters for outer class
      public LLStack() {
          this.head = new Node();
      }
      
       // Adds a node as the first node element at the start of the list with the specified data.
      public void addToStart(Object itemData) {
           // to do 
           // NOTE: the logic here could be implemented in a single line,
           // but not required to be a one liner.
    	  this.head = new Node(itemData, this.head);
      }
       
       // Removes the node pointed at by head and returns true if the list contains at
       // least one node. Returns false if the list is empty.
      public boolean deleteTop( ) {
         // to do
    	  if(this.head != null) {
    		  this.head = this.head.next;
    		  return true;
    	  }
    	  return false;
      }
      
      // Returns the size of linked list by traversing the list
      public int size( ) {
    	  Node current = this.head;  
    	  int count = 0;
    	  if(current == null) {
    		  return count;
    	  }
    	  while(current.next != null )    {     
    		  count++;      
    		  current = current.next;    
    		  }
    	  return count;
      }
    
      // Finds if there is match for the given object
      public boolean contains(Object item) {
    	  Node current = this.head;  
    	  while(current.next != null )    {     
    		  if(current.data == item) {
    		  return true;    
    		  }
    		  current = current.next; 
    	  }
    	  return false;
      }
      
      // Finds the first node containing the target item, and returns a
      // reference to that node. Return null if target not found.
      // Note that we WANT to return an actual reference to the actual node,
      // not a copy of it.  Don't worry about privacy leaks right now.
      private Node findData(Object target) {
    	  Node current = this.head;  
    	  while(current.next != null )    {     
    		  if(current.data == target) {
    		  return current;    
    		  }
    		  current = current.next; 
    	  }
    	  return null;
      }
    
      
      // This prints out the list to the screen,       
      // with NO spaces between each item.
      public void outputList( ) {
    	  System.out.println(this.toString());
          
          System.out.println(); // to put a carriage return after it prints it all out.
      }
      
      // the string returned should be the list in natural order, starting with the top (head),
      // with NO space between each item.
      public String toString() {
    	  Node current = this.head;   
    	  String string = "";
    	  if(current == null) {
    		  return string;
    	  }
    	  while(current.next != null )    {     
    		 string = string + current.data.toString();     
    		  current = current.next;  
    		  }     
    	  return string;
    	  }
  
      
      public boolean isEmpty( ) {
          // to do
    	  if(this.head.data == null) {
    		  return true;
    	  }
    	  return false;
      }
      
      public void clear( ) {
          this.head = null;
      }
      
      // For two lists to be equal they must contain the same data items in
      // the same order. The equals method of T is used to compare data items.
      public boolean equals(Object otherObject) {
          if (otherObject == null)
            return false;
          
          else if(!(otherObject instanceof LLStack))
            return false;
            
          else {
              LLStack otherList = (LLStack)otherObject;
              Node currentOther = otherList.head;
              Node current = this.head;
              while(current.next != null) {
            	  if(currentOther.data != current.data) {
            		  return false;
            	  }
            		  currentOther = currentOther.next;
            		  current = current.next;
              }
              return true;
            }
      }
      
        // There is no need to modify the driver
      public static void main(String[] args) {
            
            // input data for testing
            String target = "Alaska is the Ice State";
            //               01234567890123456789012
            String palindrome = "a man a plan a canal panama";
            
            LLStack list1 = new LLStack( );
            // objects to be added to list
            Object object1 = (Character) target.charAt(3); 
            Object object2 = (Character) target.charAt(10);
            Object object3 = (Character) target.charAt(5);
            Object object4 = (Character) target.charAt(15);
            Object object5 = (Character) target.charAt(6); 
            Object object6 = (Character) target.charAt(19);
            Object object7 = (Character) target.charAt(20);
            Object object8 = (Character) target.charAt(22); 
            Object object9 = (Character) target.charAt(13); 
            Object object10 = (Character) target.charAt(14); 
            Object object20 = (Character) target.charAt(0);  // will not be added to list
            
            // add 10 objects to our linked list
            list1.addToStart(object1);
            list1.addToStart(object2);
            list1.addToStart(object3);
            list1.addToStart(object4);
            list1.addToStart(object5);
            list1.addToStart(object6);
            list1.addToStart(object7);
            list1.addToStart(object8);
            list1.addToStart(object9);
            list1.addToStart(object10);
            
            // make sure all are added
            Test("list.size()==10", list1.size()==10);
            System.out.println(list1.size());
            
            // display the newly created list
            System.out.println("Testing outputList and toString. It should print 'I eat cats':");
            list1.outputList( );
            System.out.println("toString = " + list1.toString());
            
            // test findData() here
            Node itemFound = list1.findData(object1); 
            Test("findData(object) returned a Node whose data was an 's'", itemFound.data.equals('s'));
            //System.out.println("Item found: " + itemFound.data);
            
            // Test contains() here
            Test("list.contains(object1)", list1.contains(object1) );
            Test("list DOESN'T contain object20", !list1.contains(object20) );

            
            // Creating a new linked list by iteration using different input   
            LLStack list2 = new LLStack();
          
            for(int i = 0; i < palindrome.length(); i++) {
              Object o = (Character) palindrome.charAt(i);
              list2.addToStart(o);
            }
            // Display your list now
            System.out.println("list2 is:");
            list2.outputList();
             
            // More tests; size() and is Empty()
            Test("list2.size()==27", list2.size()==27);
            Test("list2 is not empty", !list2.isEmpty() );
              
            //testing equals
            // Creating an Object of different class to compare with Character class
            Object mismatchObject = (Integer) Character.getNumericValue(target.charAt(0));
            Test("list2.equals(mismatchObject)==false", list2.equals(mismatchObject)==false);
            Test("list2.equals(list2)==true", list2.equals(list2)==true);
            // make a new list to test equals:
            LLStack list3 = new LLStack();
          
            for(int i = 0; i < palindrome.length(); i++) {
              Object o = (Character) palindrome.charAt(i);
              list3.addToStart(o);
            }
            Test("list2.equals(list3)", list2.equals(list3));
            
            LLStack list4 = new LLStack(); // similar to list2 and list3, but one element shorter
          
            for(int i = 0; i < palindrome.length()-1; i++) {
              Object o = (Character) palindrome.charAt(i);
              list4.addToStart(o);
            }
            Test("list2.equals(list4)==false", list2.equals(list4)==false);
            
           // test deleteTop()   
           list1.deleteTop();
           Test("deleteTop() works", !list1.contains(object10) );
           
          
           while (list1.deleteTop( ));    //Empty loop body.  
                                          //Remember that deleteTop returns false if the list is empty.
           System.out.println("Start of list: (should print out nothing, since it should be empty)");
           list1.outputList( );
           System.out.println("End of list.");
                
                    
           System.out.println("In the begining list2 has " + list2.size() + " nodes");
           list2.clear();
          
           System.out.println("After testing clear(), linkedList has " + list2.size() + " nodes");
           Test("list2.size()==0", list2.size()==0);
      }
            
      /**
         * Test
         * ----
         * This is just a function to make testing things easier.
         * @param testDescription : A string representing what you're going to test
         * @param testPasses: the test itself. When you call this method, 
         *                    you'll put some expression here that will evaluate
         *                    to true if your test passes.
         * PRE: none
         * POST: will print to the console the testDescription and either
         *       "Test PASSED" or "Test FAILED", depending on whether the test
         *       passed or failed.
         */
      public static void Test(String testDescription, boolean testPasses){
            if (testPasses) 
                System.out.println("Test PASSED: " + testDescription);
            else 
                System.out.println("Test FAILED: " + testDescription);
      }
}

          
