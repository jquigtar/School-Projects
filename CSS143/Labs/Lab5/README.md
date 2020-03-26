Summary

            The purpose of this lab is to practice building new classes by inheriting methods and data from existing classes. We’ll start with a toy example and then move on to consider our next homework assignment.
            
            Introduction to Inheritance (the “Is A” Relationship)

Would it be easier to reach great heights by standing on our own toes, or by standing on the shoulders of giants? Many would suggest we leverage (or resuse) the already-existing giants to provide a nice vantage point to aid us in our lofty quest. We can simply climb on-top of this existing structure, adding only a little height to the existing stature of the giant, but yet appear to be a huge monolith. Inheritance is a software engineering technique used to quickly produce new classes by building on top of existing classes. Using inheritance, we could avoid lots of the cutting and pasting we’ve done in this class, as this is effectively what inheritance reduces to: copy all public methods and data to the subclass. Inheritance borrows from Mendelian genetics; in his experiments, Gregor sought to reliably reproduce characteristics of a parent plant in its offspring. In the same way, a class that inherits from another gets a copy of all public methods and data defined in the parent class. (Note that private data would be inaccessible and so is not directly copied; similarly, no constructor is ever inherited). If a superclass Shape defines a getX() and getY() as public, then the subclass Square will also have a (free) copy of these methods as well. Hence, a Square is a Shape, and can do everything a Shape can do (like getX() or getY()) and then some. In fact, a Square will define additional methods not found in Shape, such as getSideLength(); similarly, a Circle will define a radius and getRadius() method, which will be absent from the Shape superclass (or Square sibling class). Similarities such as x,y, and Color will go in the superclass, whereas distinctions such as radius, getSideLength(), and getRadius() will go in specific subclasses. Lets start with a simple inheritance example using only six lines of code.           

 

ColorException Extends RuntimeException

As programs execute, they may encounter exceptional situations in which they could either try to recover or simply terminate due to the situation at hand. We’re going to make a specific type of exception for our SimpleColor (and ColorWithAlpha) class, in the event the user tries to set any channel to anything outside the range [0,255], inclusive. Note that this class will be only a handful of lines, and demonstrates how inheritance can quickly produce fully functioning classes in a short amount of time.

Create a new project for this lab
Define a new class called ColorException
This class should include “extends RuntimeException”
Build a default, no-arg constructor that contains only one line
super( “An error occurred in Color”);
Overload your constructor with a second constructor that takes a String “msg” as input. Then, the only line of code in this function will be:
super(msg);
In the SimpleColorPreview the document class (and in your new ColorWithAlpha class below), modify the setter functions (setRed, setGreen, setBlue, etc.), so that they throw a new ColorException if the user tries to set a value outside of [0,255], inclusive.
To test your exception, make a main in ColorException and include the line:
throw new ColorException(“A test in main”);
 

ColorWithAlpha Extends SimpleColor

Our classes shouldn’t start from scratch when we design them for use in our applications, and we have an opportunity to realize the often-elusive goal of code reuse here in this lab. Use the SimpleColor.java Preview the documentclass as the parent class to build a new class. The purpose of this lab is to get you started with inheritance by building new classes from existing classes. We’ll build a class that can represent an RGB value and an Alpha value, used in determining transparency. Define this new class using the following format: “public class ColorWithAlpha extends SimpleColor {”, and make sure SimpleColor.java is in the same directory as your new ColorWithAlpha.java file. Even though the class is empty, it should compile just fine, and in fact, contains all the methods and data defined in the SimpleColor superclass.

Download the ColorDriver.java Preview the documentclass.
Get your SimpleColor class (which you've modified from the original SimpleColor.javaPreview the document to throw the ColorException if any of the rgb values are out of range).
Build a new subclass called ColorWithAlpha, and extend SimpleColor.
Add a new int called “alpha” for use in determining the color’s alpha channel.  (The alpha channel controls the amount of transparency in an image.)
This too will be clamped from 0-255, representing 8 bits of storage.
Define getters and setters for the new alpha channel.
Build one constructor that takes only an alpha value
This should initialize RGB to 0
Build a second (overloaded) constructor that takes 4 values (RGBA) and calls the superclass constructor to initialize the RGB values.
The first line of your constructor will be “super(r,g,b);”
What does this line accomplish? What function are we calling?
Build a third (overloaded) copy constructor that takes an existing ColorWithAlpha object as input
Make sure your SimpleColor class has a toString() method that prints something like:
      r: 34, g: 98, b: 42
Override the toString() function to print out your “R,G,B,A” values as we do below.
What does the following call to super do?
                        public String toString() {
                                    return super.toString() + ", alpha:"+ alpha;
                        }
In your SimpleColor class, make sure it has an overridden equals(Object o) method to test if two SimpleColor objects are the same.  (They're the same if they have the same R G B values.)
Override the equals(Object o) function to determine if two ColorsWithAlpha are equal
Use “==” for primitives such as your alpha amount, and use “.equals()” with objects such as SimpleColors.  
Run the driver to test your new ColorWithAlpha subclass.
 

Window Extends JFrame

For this demonstration, view the Window.javaPreview the document file example to learn how to produce your own GUI by extending the existing JFrame class. This is defined pictorially above in the example inheritance hierarchies. We will use this feature in future labs.  (Nothing to do here, just check it out.)

 

The Employee Inheritance Hierarchy

Download the following classes for this lab: Employee.javaPreview the document, HourlyWorker.javaPreview the document, SalariedWorker.javaPreview the document, Accountant.javaPreview the document, EmployeeDriver.javaPreview the document.  These classes represent an inheritance hierarchy with the Employee class acting as the Parent class for both HourlyWorker and SalariedWorker. Read the code in each class, and run the corresponding driver to see the output from each employee. In this warm-up exercise, I have created an Accountant class, which inherits from SalariedWorker. SalariedWorker, in turn, inherits from Employee, which is the topmost class in our hierarchy. In fact, Employee is so generic that you cannot even create Employee objects (it’s an abstract class), so we must define subclasses that override the calculateWeeklyPay() method in order to create objects we can use. The Accountant class is rather short, as most of the class’s functionality is inherited from the SalariedWorker class. Your job is to create two classes here: one that inherits from SalariedWorker (see Accountant for such an example), and one that inherits from HourlyWorker. The two classes are called PermanentHire and Consultant.  To start things off, be sure your class header indicates who you are inheriting from, such as: “public class Consultant extends HourlyWorker {…” .

 

PermanentHire Class Extends SalariedWorker

In this section, we’ll experiment with an inheritance hierarchy that has more levels. We seek to build a Permanent Hire class that will model a full-time position as a specific kind of SalariedWorker. That is to say, a PermanentHire “is a” SalariedWorker, and a SalariedWorker “is an” Employee (and an Employee “is an” Object).  The main difference between a PermanentHire and a regular SalariedWorker is that the company also gives the PermanentHire a monthly (tax free) bonus, in addition to their regular monthly pay, as an incentive to stay permanently at the company.

Download the classes outlined in the first inheritance hierarchy on page one. (Employee, SalariedWorker, HourlyWorker, Accountant)
Look at Accountant to see an example of inheritance already completed for you.
Create a class called PermanentHire, and this should inherit from SalariedWorker.
public class PermanentHire extends SalariedWorker {...}
Add a monthly bonus private instance variable.
Create 5 constructors for your class
no arg
one that takes a name and social
one that takes a name, social, and monthly pay
one that takes a name, social, monthly pay, and monthly bonus
copy constructor
note: the first four constructors should call super, the copy constructor could redirect with this(...)
Make a new (overridden) calculateWeeklyPay() method, taking into account the monthly bonus.
Using the EmployeeDriver, build a few PermanentHires with different instance data and add them to the ArrayList of Employees.
Be sure to see your new PermanentHires in the console output.
In the EmployeeDriver, build a ColorWithAlpha object and try to add it to the ArrayList of Employees. What error do you encounter? What does this mean?
 

Consultant Class Extends HourlyWorker

In this section, we’ll produce a class (based on existing classes) for use in modeling a part-time position as a specific kind of HourlyWorker. Your Consultant “is a” HourlyWorker, which “is an” Employee.  Consultants at this company only work 20 hours a week, and they get paid $300 her hour.

Next, create a class called Consultant, and this should inherit from HourlyWorker
public class Consultant extends HourlyWorker
Create 3 constructors for Consultant:
no-arg
one that takes name and social
copy constructor
Override the calculateWeeklyPay() method so that it calculates the hours worked (20 for part-time) by the hourly pay ($300.00/hr) to produce a result.
Using the EmployeeDriver, build a few Consultants with different instance data and add them to the ArrayList of Employees.
Be sure to see your new Consultants in the console output.
Using the EmployeeDriver, build a ColorException and try to add it to the ArrayList of Employees. What error do you encounter? What if you wanted the ArrayList to store both Employees and ColorException – how would this change the way ArrayList is declared?
 

Part II: Inheritance and the Shape Hierarchy
Summary

Build two classes that inherit from an existing Shape superclass. One of these will be Circle and the other will be a shape of your choosing.  These subclasses should all have the phrase “extends Shape” in their class signatures, as in: “public class MyNewShape extends Shape {“. Your classes can and should be tested in isolation before combining your classes with the final drivers, so consider building a main in each subclass that tests out just that class. When you are confident in your subclasses, you can use this driver to see your shapes render to a window (a JPanel).

Introduction

This lab continues exploring the idea of inheritance, which is a critical concept in object-oriented programming. Inheritance (as defined in the software realm) borrows from its Mendelian genetics: just as you can inherit your mother’s eyes or your father’s sense of humor, one child class can inherit characteristics and behaviors of a parent class. More specifically to Java classes, when one child class inherits from a parent class (or a subclass inherits from a superclass), this child class gets a copy of all the methods and data from the parent class – you can envision this as a copy-and-paste operation, from the parent to the child. Once the child class extends the parent class, any methods or data items found in the parent class are now a part of the child class, and the child class is free to define extra features. Everything the parent class has, the child also has. More to the point: any public method defined in the parent will also be defined in the child class, and this acts as a type of contract or guarantee. Indeed, it is a class invariant that the interface for a child class will contain every (public) method defined in the parent class interface (except for constructors). If we can promise that a Circle class has every method found in the Shape class, then anywhere in software a Shape is called for, a Circle could be substituted (this concept is called substitutability and is related to polymorphism, but more on that later). If we have a function that expects a Ball object, and we have a subclass object VolleyBall, then we can pass the VolleyBall to the method with no problems, because a VolleyBall is a Ball, just like a Circle is a Shape. Inheritance then defines this type of “is a” relationship, which is a one-way relation between two classes. Note that the relationship isn’t like the bi-conditional operator in that, all VolleyBalls are definitely Balls, but not all Balls are guaranteed to be VolleyBalls (some could be BaseBalls or BasketBalls, for example). When describing inheritance relationships, we’ll use an arrow to indicate this “one-way” characteristic. When building classes that are interrelated via inheritance, inheritance hierarchies naturally arise; these are simply tree structures that display the “is a” inheritance relationships between the classes in your software.

Before we talk about the methods your Class must provide (or more specifically, override), we should get to know our Parent class Shape. The methods and data for this class are outlined below, and the code is available for download via the website (and you’ll need it in the same directory as your child classes).

Shape Class:

Data Members

int x; //all shapes have an x,y coordinate pair in Java2D
Should this be public? Private?
int y; //and so we’ll have the Parent class manage this data
What access modifier should we use here?
Method Members

Shape(int x, int y) //a constructor used to initialize the data members
double getArea(); //used to calculate the area of this shape
For a Circle, use Math.PI * r * r, and for a Square, side * side.
void paint(Graphics g); //the paint method is called on each shape to draw itself
See the Spray subclass for a sample implementation of the paint function
This was draw() in previous Shape classes.
getX() //accessor
getY() //accessor
setX(int) //mutator
setY(int) //mutator
As you can see from above, the class is quite small. Now take a look in the code to see how many of the Shape functions are actually empty! Shape is really too generic of a class to offer an implementation for draw() or getArea(), as these are custom to specific subclasses of shape – in fact, it’s our job to provide versions of these methods in our subclass that actually do draw shapes or calculate areas. We could easily have made Shape into an abstract class or even an interface, but for this demonstration we’ll stick with a basic, mutable, nonstatic class. Your class will start with the line “public Circle extends Shape”, and this will only compile if Shape.java is also in the same working directory (or project) when compiling. As a Circle, you will need to add more data and methods that are custom to being a Circle; these are specifics that not just any shape would have, such as a radius data item and a getRadius() accessor function.

 

Circle Extends Shape

The first thing we need to do is download the Shape superclass Shape.javaPreview the document, the Spray subclass Spray.javaPreview the document, and the driver PolyDemo.java PolyDemo.javaPreview the document. This should compile and run with no modifications, but will only display a set of “spray” shapes on the screen (which are ovals that randomly change their width and height). You will create two subclasses of Shape (just like Spray) in the following steps.

Download all the files and put them into one project.
Run the PolyDemo.java and observe the output.
Build a new class called “Circle” using the inheritance keyword “extends”
“public class Circle extends Shape”
Next, define members that are custom to Circles, such as:
private double radius;
double getRadius();
void setRadius(double);
private Color myColor;
note: remember to import java.awt.color
note: Colors are immutable, so you don't have to worry about privacy leaks 
public Color getColor();
public void setColor(Color newColor);
Override the getArea() method
This method should return a double corresponding to the area of your shape.
Override the draw() method
This method will draw the shape onto the Graphics context g (or g2D).
Look at Spray for an example of how to do this, or try:
g.draw3DRect(x,y,width,height, raised)
g.drawOval(x,y,width,height)
Modifying the PolyDemo function getRandShape() so that it can create and return objects of your new Circle class.
Do this by replacing one of the switch cases that state “retVal = new Spray()” with “retVal= new Circle()”.
Run the PolyDemo.java and observe your new Circle subclass also being rendered to the screen.
By following the three steps above, you should be able to iteratively develop each Shape subclass and test it first in isolation (make a small main inside that class to test it out), and then in the larger system that will use your subclass to actually draw stuff to the screen (PolyDemo.java).

 

YourClass extends Shape

In this section, it’s up to you to define a second, custom Shape. If you’re uncertain, consider implementing a Square, which is similar in spirit to the Circle above, but the radius becomes a sideLength and your paint() and area() calculations change. If you feel comfortable with making Shapes, consider a more advanced shape, such as a PokeBall, Sierpinski Triangle, Rocket Ship, or anything your can imagine and render in 2D. Cubes in (pseudo) 3D look nice as well. To build your custom class:

Build a new class using the inheritance keyword “extends”
“public class YourClass extends Shape”
Override the getArea() method
This method should return a double corresponding to the area of your shape.
Override the draw() method
This method will draw the shape onto the Graphics context g (or g2D).
Look at Spray for an example of how to do this, or try:
g.draw3DRect(x,y,width,height, raised)
g.drawOval(x,y,width,height)
Define members that are custom to your shape, such as:
A base and height for a triangle or rectangle.
A sidecount for a generic polygon.
A Color
Modifying the PolyDemo function getRandShape() so that it can create and return objects of your new class.
Do this by replacing one of the switch cases that state “retVal = new Spray()” with “retVal= new YourClass()”.
Run the PolyDemo.java and observe your new subclass also being rendered to the screen.
 

A Short Primer on Java2D

In this lab, you are to develop two shape subclasses, and you can draw them however you want using Java2D. Java uses a Graphics2D object to render things into drawable areas in Java’s windows (or JFrames). We won’t need to go much further than a Google search to see all the functions you can call on a Graphics2D object, but some of them are: {drawRect, drawRoundRect, drawFillRect, drawOval, drawString} You could make a Shape subclass that represents a letter, and to draw that letter, you’d provide a line of code in your draw() method like “g.drawString(…)” to draw the individual character. If making ovals, use the drawOval function, and the same strategy for rectangles. While the Savitch text is a bit light on the subject of Graphics, it does cover some data on drawing ovals and arcs on page 1033, and also shows you how to specify colors on page 1045. DrawString is at 1051, and again, there are tons of examples online for Java2D graphics code, but the main idea is: you are given a graphics object, and you make calls on that object to produce graphics you can view on the screen. If your editor has auto-complete enabled, you may simply type “g.”, then the list of graphics functions will be highlighted for you, and there’s a ton, so don’t get overwhelmed. If you like, you can just leave the draw function very minimal until you have a grasp on how your class inherits from Shape, and how it fits into the driver code.
Late Binding & Polymorphism

Two concepts that are critical to Object-Oriented programming are late binding (or dynamic dispatch) of method calls and polymorphism, which allows for many (poly) forms (morph) of the target function to exist – Java’s runtime environment will select the correct draw() function at runtime (this is late binding) from a set of draw() functions each defined in Shape, Square, Circle, Triangle, etc. A language that supports the redefinition of a function by a subclass then might produce multiple versions of one function, such as draw(), toString() or equals(). Having a draw() method in Square and a draw() method in Circle could be ambiguous, as there are now many forms of the draw() method that each exist in different subclasses. In the case of overridden functions (i.e, a function with “many forms”), Java doesn’t determine ahead of time which draw() function to invoke; this is known as static binding, and is used when the specific function can be determined offline or at compile-time. Static binding isn’t possible in all cases if a language supports polymorphism; sometimes the object can only be known at runtime, which requires a mechanism such as late binding that uses RTTI (Run-Time Type Identification) to determine the exact type of the object. Consider the code from PolyDemo.java that returns a random shape (called getRandShape() in PolyDemo.java).

     Shape a = getRandShape(); //a could be a Square, Circle, Triangle, or some other Shape subclass

     a.draw(); //this draw() method could refer to Square’s draw(), Circle’s draw() – many draws exist!

If the getRandShape() function can indeed return any Shape, then how would we know ahead of the function call which draw() function to invoke? If the object is a Square, we want to call the Square’s draw() function, and if the object type is really a Circle, then we don’t want to invoke any draw() method but the one found in the Circle class. How can we accomplish this type determination without an oracle? Java can consider an unknown object and reflect upon its characteristics to determine an objects type, at any point in a program’s execution. Java does this by storing additional information per object at runtime, also known as RTTI (runtime type information). Now that we’ve discussed late binding and polymorphism, lets consider some questions next. Answer these in comments inside your Employee subclasses.

What methods are polymorphic in the Employee Hierarchy?
How could we build a method like getRandShape() above but for use with Employees?
If we built a getRandomEmployee() method that returns various Employee subclass objects; write a few lines of code that would demonstrate late binding
