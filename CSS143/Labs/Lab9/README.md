Summary

This lab is designed to introduce you to some frequently encountered Interfaces in Java, and then to get familiar with writing your own interfaces. When a class implements the Comparable interface, we are able to sort objects of this set; if a class implements Cloneable, then we can call clone() to make copies of such an object. We’ll start with an example using Students and the {Comparable, Cloneable} interfaces, then move on to a brief introduction to multithreading (also using Interfaces).

Files you'll need:

InterfaceDriver.javaPreview the document

Application.javaPreview the document

MyWindow.javaPreview the document

Implementing the Comparable Interface for Sorting

We start by building a Student class class that tracks their name and GPA, and then turn to implementing the Comparable Interface for this class. The idea is that we should be able to compare two students by their GPA and then sort a collection of students in order relative to their GPAs.

Build a Student class with only two data items: a String name and a double GPA.
Make some standard getters and setters: setName(String s), getName(), setGPA(double d), getGPA().
Make an equals method where a.equals(b) is true if Student a and Student b have the exact same name and GPA.
Add this toString method: 
public String toString(){return this.name + ":" + this.GPA; }
Modify the class definition so that it “implements Comparable”
When designing the compareTo() method, use the GPA to determine if student1 > student2.
Consider returning the difference between the two students as the magnitude of difference (either positive or negative)
Download and run the InterfaceDriver to test comparing students (comparableDemo in code)
 

Implementing the Cloneable Interface

There are two examples in this section for the Cloneable interface. We’ll do the first one together, which is making students cloneable.

Add “implements Cloneable” to your Student class definition
Define the clone method using “@Override”, make it public and return a new student object  (usually the clone method returns Object, but yours will return Student).
Note: putting "@Override" on the line before a method that is overriding some inherited method is not strictly required but helps to prevent errors, as it will make the compiler check if you're actually overriding a method. For example, if you had a typo in the name or signature of the method (so it's not really overriding the method you think it is), the compiler will catch that and give you a warning -- but only if you have the @Override annotation.
Build a copy constructor for Student and then the clone method can be just one line of code:
“return new Student(this);”
Run the corresponding driver code (cloneableDemo1) to test Student clones.
In this next example, we’ll build a class called StudentDB -- a database of Students. StudentDB just contains one object, an ArrayList of students. StudentDB will also implement the Cloneable interface.  The key idea here is when building the clone method for StudentDB, you need to make a new StudentDB (with its own ArrayList), and then copy (using clone() ) every single Student in current object's ArrayList and add it to the ArrayList in the newly created StudentDB. (Be sure that you DON'T just try to make a copy of the internal ArrayList using ArrayList.clone(), because that creates a shallow copy.)  You can use Java's built in ArrayList, not the one you created.  So be sure to import java.util.ArrayList; 

Start by building a StudentDB class that contains only one data item: an ArrayList of Students: ArrayList<Student>
Create add(Student s) method for adding more students to the database.
Make sure that you add a clone of the student you pass in (s), and not s itself, or you'll have a privacy leak!
Make StudentDB implement Cloneable, and create the clone() method.
Remember to make a deep copy here, so the new StudentDB should have its own ArrayList and each element in the current object's database needs to get cloned and added to the new database in the new StudentDB.
Note that again, if you want, you can create a copy constructor for StudentDB, and then just call that constructor in the clone() method.
Create an equals method for StudentDB that checks if each student in this database equals each student in the other database, AND that they don't share memory locations.  
In other words (after checking that the lists are the same length): for each Student s1, in this database, and for each corresponding student s2 in the other database, check that s1.equals(s2), but s1!=s2. 
Run the demo code in cloneableDemo2() to check that it works.
 

The Serializable Interface

"To serialize an object means to convert its state to a byte stream so that the byte stream can be reverted back into a copy of the object."  -- https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html (Links to an external site.) 

To Serialize objects, we must first indicate that this is a permissible operation for our class. Certain classes should never be “frozen” to disk, such as real-time bank transactions or pacemaker operations. Java asks that you specifically indicate it’s ok to write your object to disk using this Tagging interface. Such an interface has no methods, but serves to identify sets of objects. Writing an object to disk requires a FileOutputStream() to write bytes to a file decorated by an ObjectOutputStream(), which will translate Objects to bytes for the FOS. This chain of operations looks like the diagram below. 

objectObjectstreamBytesFileOutputSteamFile.png

To create an Object writer, use the code:

ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.obj"));

And to correspondingly read those objects, consider the code:

ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.obj"));

In Student.java, add: import java.io.Serializable;
In your Student.java file and add “implements Serializable”
Note that no additional coding is required, as this interface has no methods.
Run the corresponding driver code (serializableDemo()) from the interface driver.
What was the output?
What did we accomplish?
 

The Runnable Interface 

A thread is a bit of code that can be run at the same time as other threads.  In this section, we’ll expand our Student class so that it can be run along other threads in a multithreaded (or multi-core) architecture.   In Java, there exists a Thread class that we can extend and override to provide Thread specific activities, but even easier than this (and preferred) is to implement the Runnable Interface. The Runnable Interface has only one method (public void run() ), and any object that is Runn-able can be handed to a Thread Constructor and is queued for concurrent execution.

add “Runnable” to the list of interfaces that your Student class implements.
Create a public void run() method.  In it, print out (to the console) each letter in a Student's name on a separate line:
D
A
V
I
D
Look at the code in runnableDemo():
I create two students, one whose name is "***********", and the other whose name is "--------------".
Then I create two Thread objects, t1 and t2. The Thread's constructor takes in a Runnable object (which your Student class is, now).
Then I call the start method on each of those threads. This calls the run() method of each of those Student objects that were passed to the Threads in the constructor. 
Run the runnableDemo().  Run it a number of times, to see what happens. (It might take a few runs for some of you to see why I'm asking you to run it multiple times.)  What's going on here?
 

Implementing Interfaces Using ActionListener

Implementing interfaces is one technique Java uses to allow for multiple inheritance. In this section, we’ll be working with a Window Class (called a JFrame) that has only one GUI component added to it: a JButton. When you download and run this code, pressing the button currently does nothing. In this section, your job is to modify the Application Class so that it will handle the button’s events. This class will need to implement the ActionListener interface, and then we can attach or register this event handler with the button we’re interested in.

Extend the Application Class so that it “implements ActionListener”
Define the ActionListener method “public void actionPerformed(ActionEvent e)” for the Application Class
Make this function do something noticeable, like pop up a JOptionPane message dialog, so you know when your class is actually being called to handle events.
In the code, look for and uncomment the line of code that looks like: “myButton.addActionListener( this );”
 

Implementing the MouseListener Interface

Now we're going to see a project in action where you can do some drawing with your mouse. (Actually it will draw lines between your subsequent mouse clicks.)  

Add MyWindow.java to your project. Take a look at it, see if you can figure out what it does.  Look at the private instance variables and the methods.
Change it so that it implements the MouseListener interface.
In the constructor, add this: addMouseListener(this);  This will add a mouse listening object to the window. Once you have a mouse listening object, it will automatically call one of various mouse methods like mouseClicked or mouseReleased.
run mouseListenerDemo().  (All it does is create an instance of MyWindow.)  Click around in the window to see what happens. 
Try messing around with paint() and with some of the mouse methods.
 

return type

method desctiption

void

mouseClicked(MouseEvent e)

Invoked when the mouse button has been clicked (pressed and released) on a component.

void

mouseEntered(MouseEvent e)

Invoked when the mouse enters a component.

void

mouseExited(MouseEvent e)

Invoked when the mouse exits a component.

void

mousePressed(MouseEvent e)

Invoked when a mouse button has been pressed on a component.

void

mouseReleased(MouseEvent e)

Invoked when a mouse button has been released on a component.
