Introduction

            For this lab, you’re going to create 6 classes: Date, Point2D, IntList, Square, Circle, and ObjectList. Once you have all of them, and they do what they’re supposed to (according to the specifications below), you should be able to download Picture.java and run the Lab2aDriver.java (with tests uncommented) and the driver should work.

            We’re working on building classes and class composition – that means classes that have other classes inside of them. This lab is meant to serve as a reintroduction to Java programming, using familiar constructs such as primitives, arrays, and instantiating Objects from custom Classes we build here. By building user-defined classes, we are also taking our first steps towards understanding Object-Oriented Programming. Note that we will not use inheritance directly for this project, but once we’ve covered more regarding this technique, we will certainly revisit and improve this code.

            Be sure to test your classes as you build each one. You should start by downloading Picture.javaPreview the document and Lab2aDriver.javaPreview the document to see if you understand them and how they will use the other classes that you’re going to build.  You'll test the classes you build in the main method of Lab2aDriver.java.

           * MAKE IT YOUR THING TO ALWAYS USE GOOD CODING STYLE. *

            That means good comments, javadoc and otherwise, plus readable descriptive variable names, good use of whitespace, etc. When referring to class instance variables, it’s good (required) style to use “this.<variable name>”. Don’t forget the “this.” !

 

Date class

            ( Don't forget to put    // In Class Code: ___________at the top of this class!  )

            We need a class to represent a date: month, day, and year. Let’s store them as ints. Make these instance variables private! YOU control the flow of information here!

Make sure you have at least the default (no-arg) constructor. But if you were to make another kind of constructor (overloading!), what kind of constructor should it be?
Make a function to set the date to something else. Its signature should be:
public void setDate(int m, int d, int y) {…}
Don't let the user set negative values.
optional: don’t let the user set these to other invalid values. (What would invalid values look like for a date?)
Have getters for month, year, and day respectively:
public int getMonth(){ … }
public int getYear(){ … }
public int getDay(){ … }
Make a function to report the date (print it to the console) in the “mm/dd/yyyy” format:
public void report() { … }
Make a toString function which returns a string representation of the date:
public String toString(){ … }
            Test your date class! I started some tests in Lab2aDriver.java, so you can add some more. How do you test? Think of boundary cases. Try to break it.

            Note that when you test the toString function, you can do it without even explicitly calling it:

            Date mydate = new Date();

            System.out.println( mydate );     // equivalent to System.out.println( mydate.toString() );

 

Point2D class

            Now we need a class to represent a 2-dimensional point. It should have an x and y coordinate. Let them be ints. Make them private.

Create a constructor that takes two ints so we can set it when we initialize a Point2D object.
Two setters: Have a setter for the x coordinate and a setter for the y coordinate.
public void setX(int newX){ … }        
public void setY(int newY){ … }
Can you think of any checks you want to do in these functions before just setting x and y?
Should these methods be private or public?
Two getters:
public int getX() {…}
public int getY() {…}
Create a translate method that adds some amount to x and y:
public void translate(int addToX, int addToY){
// this adds addToX to x and adds addToY to y.
Create a toString method which returns a string like this: “x: 52, y: 98”
In the javadoc comment above this method, put @override (can you guess why?)
Create an equals method that tests whether two points are the same:
public boolean equals(Point2D otherPoint) { … // returns true if this is equal to otherPoint. }
Don’t just use this== otherPoint!!   (do you know why?)
Note that the signature here isn’t really what the equals signature is supposed to look like (it’s supposed to take an object of type Object, not a Point2D). But this version will simplify things a bit.
Questions:
Can methods outside of this class use x and y?
Can you use x and y without an associated object (or instance)?
Test all your methods.
 

Square class

            Now let’s make a class to represent a square.

Data members (all private):

Create a variable called location. Its type is Point2D. This is the location of the top left corner of the square.
Have an int variable called sideLength, the length of one side of the square.
A string called shape. It just looks like this: “[ ]”
Methods:

A no-arg constructor
public Square() {…}   // you’ll have to decide on default values for location and sideLength.
HINT: in initializing location, you’ll want something like this:
location = new Point2D(0,0);
A constructor that takes an x coordinate, a y coordinate, and a sideLength:
public Square(int x, int y, int sideLength){ … }
(hey look, we’re overloading the constructor!)
A constructor that takes a Point2D object to set the location, but supplies the default sideLength.
public Square(Point2D location)
(hey look, even more overloading!)
a draw method that just outputs the shape (“[ ]”) to the screen, using the shape variable.
public void draw(){ … }
Getters (all public):
int getX()   // returns the x coordinate of the location
int getY()   // returns the y coordinate of the location
int getSideLength()   // you can guess what this does
double getArea() // returns the area of this square.
Setters (all public):
void setX(int newX){ // changes the x coordinate of the location to newX
void setY(int newY){ // changes the y coordinate of the location to newY
void setSideLength(int newSideLength){ // changes sideLength.
Can you think of any checks you want to do in these methods – things you don’t want your users to be able to do? Invalid values you want to disallow?  Implement at least one check in at least one of these setter methods.
Make a toString method (and put @override in its javadoc):
public String toString(){…}
This will return the string you stored in shape (“[ ]”) along with location and sideLength:
For example:   “{[ ] location: x: 52, y: 98.   Side length: 12}”
Put curly braces around the string so that it will be easier to read if you’re printing out a bunch of squares in a row: “{[ ] location: x: 52, y: 98.   Side length: 12}, {[ ] location: x: 12, y: 2.   Side length: 5}, {[ ] location: x: 6, y: 7.   Side length: 554}”
use Point2D’s toString() method in here.
Put @override in the javadoc.
Build an equals function to compare two squares:
public boolean equals(Square otherSquare){ // returns true if the locations and sideLengths match.
How can you compare locations? Use Point2D’s equal method!
            Test your class!

 

Circle class

            Now you’re going to build a circle class that is really really similar to the Square class. But instead of sideLength it will have radius, and its shape variable will store “O” instead of “[ ]”, and the getArea() method will use a different formula (PI * r2) (Note: use Math.PI in java to get PI). Also, your equals method will have to be slightly different, checking for same radius instead of same sideLength.

            Square and Circle are so similar that you’d be wise to just cut-n-paste all the code from Square and then do some find-and-replace to make the changes in Circle. (In Eclipse, right-click on the definition of the instance variable sideLength. Choose “refactor”->”rename”.   Rename this variable “radius”)

            It should have all the same methods as Square, except that getSideLength() is now getRadius().

            Test your class. (You can probably borrow a lot of the tests you did for Square)

 

IntList class

            Next we’re going to make a class that can hold a list of ints. Yes, it’s just like an array. In fact, it’s a wrapper for an array.  DO NOT USE ARRAYLIST.

Data members (all private):

An array called data, able to store up to 100 integers.
An int called numElements, set initially to 0.
Often times we initialize our private instance variables in the constructors. But here, with a primitive type, and with such a small class, we can just initialize it on the same line that it’s declared on.
Methods:

A default no-arg constructor
Public IntList() {}
If you initialized both your instance variables (data and numElements) when you declared them, you can leave the body of this constructor blank, as there’s nothing else to do.
Technically, you probably could have left this constructor out, and Java would have supplied it for you, but I don’t like trusting the compiler to make a constructor. What if it supplied some default values to these variables that weren’t what you were expecting?
public void add(int n){ // this should add n to the array (in the correct place) and increment numElements
Don’t worry about resizing the array (in the case that someone tries to add more than one hundred elements). Unless you want to, of course.
public String toString()
returns a comma separated list like this:
“4, 8, 15, 16, 23, 42”
start by having an empty string, then do a for loop to iterate through the array and keep adding each new element onto the end of the string. Then, if you’re not at the end, add a comma and a space.
public int sum(){ // a method that returns the sum of all the ints in your list.
public int indexOf(int target){ // a method that returns the index of the first occurrence of target in data (if it exists) and returns -1 if it isn’t found.
This is similar to sum(), in that it’s iterating through the array, so you might cut and paste that code and change it. Or else, you made another indexOf function in lab1 that you could borrow and adapt.
Optional: add a save() function that writes to disk all the elements in the list. (use PrintWriter)
            Test your class!

 

ObjectList class

            What if we want a list of something else, besides just ints? For example, suppose we want a list of Squares and Circles? Let’s make something more general. (AGAIN, DON'T USE ARRAYLIST.) Copy and paste your IntList code to make a new class called ObjectList. Instead of an int array, it’ll be an array of type Object (they’re objects of type Object!) :

                        Object[] data = new Object[100];

      Change your add function so that it takes an Object instead of an int:

                        public void add(Object o){ … }

            Change toString() if necessary: you’ll still iterate through the array, adding the string representation of each element together until it’s one big string. Note that you’ll be assuming that every object that’s being held in data has its own toString method. Why is that a reasonable assumption to make?

            Get rid of functions sum(), indexOf(), and save(). We don’t need them.

            Test this class to see if it can hold a big list of different shapes: Make a couple of random Squares and Circles, and then add them to an ObjectList object. Then print out that object list and see what happens.

            Questions:

Can you hold primitive types in here? Can you still use this to hold a list of ints?
 

Putting it all together:

            If you’ve gotten this far, you should be able to uncomment everything in Lab2aDriver.java and run it; it calls on a class I made called Picture, which uses all these classes that you’ve made.

 
