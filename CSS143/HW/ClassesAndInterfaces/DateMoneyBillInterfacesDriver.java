import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * DateMoneyBillInterfacesDriver
 * 
 * this is a test driver for the Date, Money, and Bill classes that test
 * the newly implemented interfaces of Comparable, Cloneable, and Serializable
 * for all three classes as well as testing the ArrayList class and ExpenseAccount 
 * class with the implemented Iterable interface
 * @author jquigtar
 * @version 2/28/19
 */
public class DateMoneyBillInterfacesDriver {

	/**
	 * main
	 * 
	 * this main method first test Money class for compareTo method, clone methods
	 * and serializable methods then goes on to run the same tests on Date class and
	 * bill class. this main also adds bills to the ExpenseAccount object bills and
	 * attempts to use iterator to print them to the console.
	 * @param args
	 */
	public static void main(String[] args) {
		
		String moneyFile = "moneyFile.txt";
		
		System.out.println("***Money Tests***");
		Money money1 = new Money(10);
        Money money2 = new Money(20);
        Money money3 = new Money(30);
        Money money4 = new Money(10);
        Money money5 = new Money(money2);
        
        System.out.println("money1 == " + money1);
        System.out.println("money2 == " + money2);
        System.out.println("money3 == " + money3);
        System.out.println("money4 == " + money4);
        System.out.println("money5 == " + money5);
        
        System.out.println("---compareTo Tests---");
        
        System.out.println("money2.compareTo(money1) == " + money2.compareTo(money1));
        System.out.println("money2.compareTo(money5) == " + money2.compareTo(money5));
        System.out.println("money2.compareTo(money3) == " + money2.compareTo(money3));
        System.out.println("money1.compareTo(money4) == " + money1.compareTo(money4));
        
        System.out.println("---clone Tests---");
        
        try {
        	Money money6 = money1.clone();
        	System.out.println("money6 != money1: " + (money6 != money1));
        	System.out.println("money6.getClass() == money1.getClass(): " + (money6.getClass() == money1.getClass()));
        	System.out.println("money6.equals(money1) : " + (money6.equals(money1)));
        }catch(CloneNotSupportedException e){
        	System.out.println(e.toString());
        	System.exit(0);
        }
        
        System.out.println("---serialization Tests---");
        
        try {
        	FileOutputStream file = new FileOutputStream(moneyFile);             
        	ObjectOutputStream out = new ObjectOutputStream(file);// Method for serialization of object   
        	out.writeObject(money1);            
        	out.close();             
        	file.close(); 
        	System.out.println("money1 has been serialized to " + moneyFile);
        }catch(IOException e){
        	System.out.println(e.toString());
        }
        
        try {               
        	// Reading the object from a file           
        	FileInputStream file = new FileInputStream(moneyFile);         
        	ObjectInputStream in = new ObjectInputStream(file); // Method for deserialization of object
        	Money object1 = (Money) in.readObject();            
        	in.close();            
        	file.close();             
        	System.out.println("money1 has been deserialized from " + moneyFile);            
        	System.out.println("dollars = " + object1.getDollars());            
        	System.out.println("cents = " + object1.getCents());
        }catch (ClassNotFoundException e) {
        	System.out.println(e.toString());
        	System.exit(0);
		} catch(IOException e){
        	System.out.println(e.toString());
        	System.exit(0);
        } 
        
        System.out.println();
        
        System.out.println("***Date Tests***");
        
        String dateFile = "dateFile.txt";
        
        Date date1 = new Date(1,2,2017);
        Date date2 = new Date(5,30,2020);
        Date date3 = new Date(8,4,2021);
        Date date4 = new Date(5,30,2020);
        
        System.out.println("date1 == " + date1);
        System.out.println("date2 == " + date2);
        System.out.println("date3 == " + date3);
        System.out.println("date4 == " + date4);
        
        System.out.println("---compareTo Tests---");
        
        System.out.println("date2.compareTo(date1) == " + date2.compareTo(date1));
        System.out.println("date2.compareTo(date3) == " + date2.compareTo(date3));
        System.out.println("date2.compareTo(date4) == " + date2.compareTo(date4));
        
        System.out.println("---clone Tests---");
        
        try {
        	Date date5 = date1.clone();
        	System.out.println("date5 != date1: " + (date5 != date1));
        	System.out.println("date5.getClass() == date1.getClass(): " + (date5.getClass() == date1.getClass()));
        	System.out.println("date5.equals(date1) : " + (date5.equals(date1)));
        }catch(CloneNotSupportedException e){
        	System.out.println(e.toString());
        	System.exit(0);
        }
        
        System.out.println("---serialization Tests---");
        
        try {
        	FileOutputStream file = new FileOutputStream(dateFile);             
        	ObjectOutputStream out = new ObjectOutputStream(file);// Method for serialization of object   
        	out.writeObject(date1);            
        	out.close();             
        	file.close(); 
        	System.out.println("date1 has been serialized to " + dateFile);
        }catch(IOException e){
        	System.out.println(e.toString());
        }
        
        try {               
        	// Reading the object from a file           
        	FileInputStream file = new FileInputStream(dateFile);         
        	ObjectInputStream in = new ObjectInputStream(file); // Method for deserialization of object
        	Date object1 = (Date) in.readObject();            
        	in.close();            
        	file.close();             
        	System.out.println("date1 has been deserialized from " + dateFile);            
        	System.out.println("month = " + object1.getMonth());            
        	System.out.println("day = " + object1.getDay());
        	System.out.println("year = " + object1.getYear());
        }catch (ClassNotFoundException e) {
        	System.out.println(e.toString());
        	System.exit(0);
		} catch(IOException e){
        	System.out.println(e.toString());
        	System.exit(0);
        } 
        
        System.out.println();
        
        String billFile = "billFile.txt";
		
		System.out.println("***Bill Tests***");
        
        Bill bill1 = new Bill(money1, date1, "Apple Music");
        Bill bill2 = new Bill(money2, date2, "Seattle City Light");
        Bill bill3 = new Bill(money3, date3, "T-Mobile");
        Bill bill4 = new Bill(money4, date4, "Netflix");
        
        System.out.println("bill1 == " + bill1);
        System.out.println("bill2 == " + bill2);
        System.out.println("bill3 == " + bill3);
        System.out.println("bill4 == " + bill4);
        
        System.out.println("---compareTo Tests---");
        
        System.out.println("bill2.compareTo(bill1) == " + bill2.compareTo(bill1));
        System.out.println("bill2.compareTo(bill4) == " + bill2.compareTo(bill4));
        System.out.println("bill2.compareTo(bill3) == " + bill2.compareTo(bill3));
        
        System.out.println("---clone Tests---");
        
        try {
        	Bill bill5 = bill1.clone();
        	System.out.println("bill5 != bill1: " + (bill5 != bill1));
        	System.out.println("bill5.getClass() == bill1.getClass(): " + (bill5.getClass() == bill1.getClass()));
        	System.out.println("bill5.equals(bill1) : " + (bill5.equals(bill1)));
        }catch(CloneNotSupportedException e){
        	System.out.println(e.toString());
        	System.exit(0);
        }
        
        System.out.println("---serialization Tests---");
        
        try {
        	FileOutputStream file = new FileOutputStream(billFile);             
        	ObjectOutputStream out = new ObjectOutputStream(file);// Method for serialization of object   
        	out.writeObject(bill1);            
        	out.close();             
        	file.close(); 
        	System.out.println("bill1 has been serialized to " + billFile);
        }catch(IOException e){
        	System.out.println(e.toString());
        }
        
        try {               
        	// Reading the object from a file           
        	FileInputStream file = new FileInputStream(billFile);         
        	ObjectInputStream in = new ObjectInputStream(file); // Method for deserialization of object
        	Bill object1 = (Bill) in.readObject();            
        	in.close();            
        	file.close();             
        	System.out.println("bill1 has been deserialized from " + billFile);            
        	System.out.println("amount = " + object1.getAmount());            
        	System.out.println("dueDate = " + object1.getDueDate());
        	System.out.println("originator = " + object1.getOriginator());
        }catch (ClassNotFoundException e) {
        	System.out.println(e.toString());
        	System.exit(0);
		} catch(IOException e){
        	System.out.println(e.toString());
        	System.exit(0);
        } 
        
        System.out.println();
        System.out.println("***Extra Credit ArrayList/ExpenseAccount/Iterator***");
        ArrayList bills = new ArrayList();
        bills.insert(bill4.toString(), 0);
        bills.insert(bill3.toString(), 0);
        bills.insert(bill2.toString(), 0);
        bills.insert(bill1.toString(), 0);
        for (Object bill : bills) {
            System.out.println(bill); 
        }
	}
}
