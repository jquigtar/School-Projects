/**
 * 
 */

/**
 * Lab2aDriver
 * -----------
 * This is a class to test the Picture class, which in turn
 * draws on these classes:
 * Date, Point2D, Square, Circle, IntList, and ObjectList
 *
 * @author (Your Name)
 * @version (Date or version number)
 */
public class Lab2Driver {

    public static void main(String[] args){
        System.out.println("Lab 2 Driver");
        System.out.println("************\n");
        // as you finish a class, uncomment its tests and add more of your own.
        
        // Date Tests:
        
        Date BDayOfPrince = new Date(6, 7, 1958);
        Test("BDayOfPrince.getMonth() == 6", BDayOfPrince.getMonth() == 6);
        // add more tests of your own
        
        Date BDayOfJayZ = new Date(12, 4, 1969);
        Test("BDayOfJayZ.getMonth() == 12", BDayOfJayZ.getMonth() == 12);
        Test("BDayOfJayZ.getDay() == 4", BDayOfJayZ.getDay() == 4);
        
        // Point2D Tests:
        
        Point2D p1 = new Point2D(25, 62);
        Test("p1.getX() == 25 && p1.getY() == 62",
             p1.getX() == 25 && p1.getY() == 62);
        // add more tests of your own
        
        Point2D p2 = new Point2D(55, 72);
        Test("p2.getX() == 55 && p2.getY() == 72",
             p2.getX() == 55 && p2.getY() == 72);
        
        Point2D p3 = new Point2D(5, 6);
        Test("p3.getX() == 5 && p3.getY() == 6",
             p3.getX() == 5 && p3.getY() == 6);
        
        
        // Square Tests:
        
        Square testSquare = new Square(10, 20, 5);
        Test("testSquare.getArea() == 25", testSquare.getArea() == 25);
        // add more tests of your own
        
        Square testSquare2 = new Square(1, 2, 7);
        Test("testSquare2.getArea() == 49", testSquare2.getArea() == 49);
        
        Square testSquare3 = new Square(11, 21, 15);
        Test("testSquare3.getArea() == 225", testSquare3.getArea() == 225);
        
        // Circle Tests:
        
        Circle testCircle = new Circle(10, 20, 3);
        Test("testCircle.getArea() == 3 * 3 * PI ", 
             testCircle.getArea() == (3 * 3 * Math.PI));
        // add more tests of your own
        
        Circle testCircle2 = new Circle(10, 20, 7);
        Test("testCircle2.getArea() == 7 * 7 * PI ", 
             testCircle2.getArea() == (7 * 7 * Math.PI));
        
        Circle testCircle3 = new Circle(10, 20, 9);
        Test("testCircle3.getArea() == 9 * 9 * PI ", 
             testCircle3.getArea() == (9 * 9 * Math.PI));
        
        // IntList Tests:
        
        System.out.println("\n\n IntList test:");
        IntList i = new IntList();
        i.add(5);
        i.add(6);
        i.add(8);
        i.add(-4);
        i.add(8);
        Test("i.toString().equals(\"5, 6, 8, -4, 8\")", 
              i.toString().equals("5, 6, 8, -4, 8"));
        Test("i.indexOf(8) == 2", i.indexOf(8) == 2);
        System.out.println(i.toString());
        System.out.println();
        // add more tests of your own
        
        System.out.println("\n\n IntList test:");
        IntList j = new IntList();
        j.add(7);
        j.add(10);
        j.add(81);
        j.add(-14);
        j.add(18);
        Test("j.toString().equals(\"7, 10, 81, -14, 18\")", 
              j.toString().equals("7, 10, 81, -14, 18"));
        Test("j.indexOf(81) == 2", j.indexOf(81) == 2);
        System.out.println(j.toString());
        System.out.println();
        
       // ObjectList Tests:
       // make some tests of your own
        
       
       
       // UNCOMMENT THIS WHEN ALL TESTS PASS for 
       // Date, Point2D, Square, Circle, IntList, and ObjectList,
       // and see if Picture now works:
          
        Picture randomPicture1 = new Picture();
        Picture randomPicture2 = new Picture();
        Picture randomPicture3 = new Picture();
        
        System.out.println("Here's 3 random pictures:");
        System.out.println("\n#1: \n" + randomPicture1);
        System.out.println("\n#2: \n" + randomPicture2);
        System.out.println("\n#3: \n" + randomPicture3);
       
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

