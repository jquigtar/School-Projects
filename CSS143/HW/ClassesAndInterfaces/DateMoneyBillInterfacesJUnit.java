import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * DateMoneyBillInterfacesJUnit
 * 
 * this is a JUnit test case to test the Date money and bill classes
 * @author jquigtar
 * @version 2/28/19
 */
public class DateMoneyBillInterfacesJUnit {

	@Test
	public void moneyCompareToTest() {
		Money money1 = new Money(10);
	    Money money2 = new Money(20);
	    Money money3 = new Money(30);
	    Money money4 = new Money(money2);
	    assertEquals(1, money2.compareTo(money1));
	    assertEquals(0, money2.compareTo(money4));
	    assertEquals(-1, money2.compareTo(money3));
	}
	
	@Test
	public void moneyCloneTest() {
		
		Money money1 = new Money(10);
    
	    try {
	    	Money money6 = money1.clone();
	    	assertEquals(true, money6 != money1);
	    	assertEquals(true, (money6.getClass() == money1.getClass()));
	    	assertEquals(true, (money6.equals(money1)));
	    }catch(CloneNotSupportedException e){
	    	System.out.println(e.toString());
	    	System.exit(0);
	    }
	}
    
    
	@Test
	public void dateCompareToTest() {
    
		Date date1 = new Date(1,2,2017);
		Date date2 = new Date(5,30,2020);
		Date date3 = new Date(8,4,2021);
		Date date4 = new Date(5,30,2020);
    
		assertEquals(1, date2.compareTo(date1));
		assertEquals(0, + date2.compareTo(date4));
		assertEquals(-1, + date2.compareTo(date3));
		
	}
    
	@Test
	public void dateCloneTest() {
		
		Date date1 = new Date(1,2,2017);
		
		try {
	    	Date date5 = date1.clone();
	    	assertEquals(true, (date5 != date1));
	    	assertEquals(true,(date5.getClass() == date1.getClass()));
	    	assertEquals(true, (date5.equals(date1)));
	    }catch(CloneNotSupportedException e){
	    	System.out.println(e.toString());
	    	System.exit(0);
	    }
	}

	
	@Test
	public void billCompareToTest() {
		
		Money money1 = new Money(10);
	    Money money2 = new Money(20);
	    Money money3 = new Money(30);
	    Money money4 = new Money(10);
		
		Date date1 = new Date(1,2,2017);
		Date date2 = new Date(5,30,2020);
		Date date3 = new Date(8,4,2021);
		Date date4 = new Date(5,30,2020);
		
		Bill bill1 = new Bill(money1, date1, "Apple Music");
		Bill bill2 = new Bill(money2, date2, "Seattle City Light");
		Bill bill3 = new Bill(money3, date3, "T-Mobile");
		Bill bill4 = new Bill(money4, date4, "Netflix");
		
		assertEquals(1, + bill2.compareTo(bill1));
		assertEquals(0,bill2.compareTo(bill4));
		assertEquals(-1,bill2.compareTo(bill3));
	}
    
   
    
   
    
	@Test
	public void billCloneTest() {
		
		Money money1 = new Money(10);
		Date date1 = new Date(1,2,2017);
		Bill bill1 = new Bill(money1, date1, "Apple Music");
		
		try {
	    	Bill bill5 = bill1.clone();
	    	assertEquals(true, (bill5 != bill1));
	    	assertEquals(true, (bill5.getClass() == bill1.getClass()));
	    	assertEquals(true, (bill5.equals(bill1)));
	    }catch(CloneNotSupportedException e){
	    	System.out.println(e.toString());
	    	System.exit(0);
	    }
	}
    
    
   
}
