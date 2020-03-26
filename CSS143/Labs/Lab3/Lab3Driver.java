// The following comment is exactly 80 characters long; I put it here to
// make sure that none of my lines ever goes beyond 80 characters:
// 45678901234567890123456789012345678901234567890123456789012345678901234567890
import java.awt.Color;
/**
 * This is the driver for Lab3. 
 * As you work on each of the classes for this Lab, uncomment the tests and 
 * add your own.
 *
 * @author David Nixon and Jordan Quigtar
 * @version 12/25/19
 * 
 * credit: Rob Nash made the original version of this.
 * 
 */
public class Lab3Driver
{
    //In class code: Banjo
	
	//1)when passing a primitive to a method you can not change its value
	//but when passing an object into a method it can do things to the object
	//2)no the scope of that variable is not changed a copy is made in the method
	//3)the scope of the object changes because that object is being used in 
	//method
	//4)the scope of the object that has been passed in a method changes 
	//from to its original scope plus that method
    public static void main(String[] args) {
        System.out.println("EXECUTING LAB 3 DRIVER");
        
        //uncomment the desired Driver or Demo below and run this code to test your progress
        dateDriver();
        shapeDriver();
        charListDriver();
        lineSegmentDriver();
        immutableFractionDriver();
        math2Driver();
        passByReferenceDemo();
        
    }
    
    public static void dateDriver() {
        System.out.println("\nTESTING DATE CLASS:");
        
        Date a = new Date();
        Test("a.toString() == \"6/23/1912\" (checking default Date values)", 
              a.toString().equals("6/23/1912"));
       
        Date b = new Date(1,2,2030);        
              Test("b.toString() == \"1/2/2030\"", b.toString().equals("1/2/2030"));
        
        Date c = new Date(b);
        Test("Date c has been set to b using copy contructor",
                b.toString().equals(c.toString()));
        
        a.setDate(5,5,2010);
        Test("Date a has been set to 5/5/2010", a.toString().equals("5/5/2010"));
        
        Test("b and a are NOT equal" , !b.equals(a) );
        
        Test("b and c ARE equal" , b.equals(c) ); 
        
        Date d = new Date(6,7,1958);
 
        d.setDate(-3,7,1958);
        Test("invalid month not allowed (test 1)", 
             d.toString().equals("6/7/1958"));
        
        d.setDate(13,7,1958);
        Test("invalid month not allowed (test 2)",  
             d.toString().equals("6/7/1958"));
        
        d.setDate(0,7,1958);
        Test("invalid month not allowed (test 3)",  
             d.toString().equals("6/7/1958"));
       
        d.setDate(6,0,1958);
        Test("invalid day not allowed (test 1)", 
             d.toString().equals("6/7/1958"));
       
        d.setDate(6,32,1958);
        Test("invalid day not allowed (test 2)",  
             d.toString().equals("6/7/1958"));
        
        d.setDate(6,7,-1);
        Test("invalid year not allowed",   
             d.toString().equals("6/7/1958"));
        
        Test("a.toString", a.toString().equals("5/5/2010"));
        Test("b.toString", b.toString().equals("1/2/2030"));
        Test("c.toString", c.toString().equals("1/2/2030"));
    }
    
    public static void shapeDriver(){
        System.out.println("\nTESTING SHAPE CLASS:");
        
        Shape a = new Shape();
		Shape b = new Shape(10,10, Color.DARK_GRAY);
		Shape c = new Shape(b);
		
		
		b.setY(140);
		
		System.out.println("a: " +a.toString() + 
		                   "  <--(Should be default shape values)" ) ;
		a.setX(120);
		System.out.println("a: " +a.toString() + 
		                   "  <--(Should be (120,0) - default color)" ) ;
		
		System.out.println("b: " +b.toString() + 
		          "  <--(Should be: (10,140)- java.awt.Color[r=64,g=64,b=64])" );
		System.out.println("c: " +c.toString() + 
		          "  <--(Should be: (10,10)- java.awt.Color[r=64,g=64,b=64])" );	
        
        
    }
    
    private static void charListDriver() {
        System.out.println("\nTESTING CHARLIST CLASS:");
		CharList a = new CharList();
		CharList b = new CharList("Batman");
		CharList c = new CharList(b);
		
		a.add('K');
		a.add('a');
		a.add('t');
		a.add('n');
		a.add('i');
		a.add('s');
		System.out.println(a.toString());
		Test("a.toString.equals(\"Katnis\")", a.toString().equals("Katnis"));
		Test("a.size() == 6", a.size() == 6);
		
		System.out.println(b.toString());
		Test("b.toString.equals(\"Batman\")", b.toString().equals("Batman"));
		Test("b.size() == 6", b.size() == 6);
		System.out.println(c.toString());
		Test("c.toString.equals(\"Batman\")", c.toString().equals("Batman"));
		Test("c.size() == 6", c.size() == 6);
		
		Test("a and b are NOT equal", !(b.equals(a)) );
		Test("b and c ARE equal", b.equals(c));
	}
    
    public static void lineSegmentDriver() {
        System.out.println("\nTESTING LINESEGMENT CLASS:");
		LineSegment a = new LineSegment();
		LineSegment b = new LineSegment(new Point2D(1,1), new Point2D(2,2));
		LineSegment c = new LineSegment(b);
		
		a.setStartPoint(new Point2D(3,3));
		a.setEndPoint(new Point2D(4,4));
		
		
		Test("a.toString().equals(\"Line start(3,3) and end(4,4)\")",
		      a.toString().equals("Line start(3,3) and end(4,4)") );
		
		Test("b.toString().equals(\"Line start(1,1) and end(2,2)\")",
		      b.toString().equals("Line start(1,1) and end(2,2)") );
		
		Test("c.toString().equals(\"Line start(1,1) and end(2,2)\")",
		      c.toString().equals("Line start(1,1) and end(2,2)") );
		      
		Test("Line b's distance is approximately 1.414" , 
		      b.distance() > 1.414 && b.distance() < 1.415 );
		
		Test("a and b are NOT equal", !a.equals(b) );  
		Test("b and c ARE equal", b.equals(c) );  
		
		System.out.println("   Privacy Leak Tests:");
		Point2D p1 = new Point2D(7,8);
		Point2D p2 = new Point2D(2,2);
		LineSegment d = new LineSegment(p1, p2);
		p1.setX(0); // this shouldn't affect d
		Test("no privacy leak in LineSegment constructor taking two points",
		     d.getStartPoint().getX() == 7 );
		
		Point2D dsp = d.getStartPoint(); // dsp = "d start point"
		dsp.setX(13); // this shouldn't affect d
		Test("no privacy leak in getStartPoint()",
		      d.getStartPoint().getX() == 7 );
		
		Point2D newPoint = new Point2D(21,22);
		d.setStartPoint(newPoint); // should change d's startpoint to (21,22)
		newPoint.setX(66); // this shouldn't affect d
		Test("no privacy leak in setStartPoint()",
		      d.getStartPoint().getX() == 21 );
		
		
		Point2D dep = d.getEndPoint();    // dep = "d end point"
		dep.setX(17); // this shouldn't affect d
		Test("no privacy leak in getEndPoint()",
		      d.getEndPoint().getX() == 2 );
		
		Point2D newEndPoint = new Point2D(31,32);
		d.setEndPoint(newEndPoint); // should change d's endpoint to (31,32)
		newEndPoint.setX(77); // this shouldn't affect d
		Test("no privacy leak in setEndPoint()",
		      d.getEndPoint().getX() == 31 );
		
		
		LineSegment e = new LineSegment();
		LineSegment f = new LineSegment(new Point2D(1,1), new Point2D(2,2));
		LineSegment g = new LineSegment(b);
		
		e.setStartPoint(new Point2D(3,3));
		e.setEndPoint(new Point2D(4,4));
		
		
		Test("e.toString().equals(\"Line start(3,3) and end(4,4)\")",
		      e.toString().equals("Line start(3,3) and end(4,4)") );
		
		Test("f.toString().equals(\"Line start(1,1) and end(2,2)\")",
		      f.toString().equals("Line start(1,1) and end(2,2)") );
		
		Test("g.toString().equals(\"Line start(1,1) and end(2,2)\")",
		      g.toString().equals("Line start(1,1) and end(2,2)") );
		      
		Test("Line f's distance is approximately 1.414" , 
		      f.distance() > 1.414 && f.distance() < 1.415 );
		
		Test("e and f are NOT equal", !e.equals(f) );  
		Test("f and g ARE equal", f.equals(g) );  
		
		
	}
	
	public static void immutableFractionDriver() {
        System.out.println("\nTESTING (IMMUTABLE) FRACTION CLASS:");
		Fraction a = new Fraction(10,20);
		Fraction b = new Fraction(3,4);
		Fraction c = new Fraction(b);
	      
		Test("a.toString().equals(\"1/2\") (testing reducer and toString)",
		      a.toString().equals("1/2") ); 
		      
		Test("b.toString().equals(\"3/4\")",
		      b.toString().equals("3/4") );
		
		Test("c.toString().equals(\"3/4\")",
		      c.toString().equals("3/4") );
		
		Fraction sum = a.add(b);
		Test("add method (sum of a and b == 5/4)",
		     sum.toString().equals("5/4") );
		
		Test("a and b are NOT equal", !a.equals(b) );
		Test("b and c ARE equal", b.equals(c) );
		
		// which of the following code is correct to change the fraction a?
		a.add(b);//this fraction
		a = a.add(b);
	}
	
	private static void math2Driver() {
        System.out.println("\nTESTING MATH2 CLASS:");
		double a = Math2.PI;
		double b = Math2.E;
		double c = a + b;
		
		Test("max() test 1: Math2.max(10,20) == 20", 
		     Math2.max(10,20) == 20);
		Test("max() test 2: Math2.max(10.34,10.31) == 10.34", 
		     Math2.max(10.34,10.31) == 10.34);
		Test("2^8 is 256", Math2.pow(2,8) == 256);
		
	}
	
	public static void passByReferenceDemo() {
		System.out.println("\nPASS BY REFERENCE/VALUE DEMO:");
	    int a = 3; 						//a primitive (pass-by-value)
		Point2D b = new Point2D(0,0);  //an Object (pass-by-reference)
		
		System.out.println("I've just initialized variables a (an int) and b (a Point2D object).");
		System.out.println("Their values are:");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("...");
		mutate(a);
		mutate(b);
		System.out.println("But now that I've done mutate(a) and mutate(b), their values are:");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println();
		System.out.println("What happened? Which one changed and which one didn't? And most importantly: Why?");
		
	}
	
	public static void mutate(int z) {  //does it matter that I called my input data "z" here?
		z = -1000;  
	}
	
	public static void mutate(Point2D c) {  
		c.setX(42);
		c.setY(66);
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
