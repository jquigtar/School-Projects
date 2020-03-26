import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for Date, Money, and Bill classes
 * @author Lesley Kalmin, jquigtar
 *CSS162
 * @version
 */
public class DateMoneyBillJUnit {

	@Test
	public void ConstructMoneyTest() {
		Money money1 = new Money(10);
		Money money2 = new Money(10,1001);
		Money money3 = new Money(money1);
		money3.add(5);
		
		assertEquals(10, money1.getDollars());	
		assertEquals(20, money2.getDollars());
		assertEquals(1, money2.getCents());
		assertEquals(10, money1.getDollars());
		assertEquals(15, money3.getDollars());
	}
	
	@Test
	public void SetMoneyTest()
	{
		Money money1 = new Money();
		
		money1.setMoney(30,50);
        assertEquals(30, money1.getDollars());      
        assertEquals(50, money1.getCents());
	}
	
	@Test
	public void ConstructMoneyCopyTest() {
		Money money1 = new Money();
		money1.setMoney(10,40);		
		
        Money money2 = new Money(money1);
        
        assertEquals(10, money1.getDollars());       
        assertEquals(40, money2.getCents());
	}
	
	@Test
	public void PrintMoneyTest()
	{
		Money money1 = new Money(10);

        money1.setMoney(30,50);
        assertEquals("$30.50", money1.toString());
	}
	
	@Test
	public void ConstructDateTest() {
		Date date1 = new Date(10,10,2019);
		
		assertEquals(10, date1.getMonth());	
		assertEquals(10, date1.getDay());
		assertEquals(2019, date1.getYear());
	}
	
	@Test
	public void SetDateTest()
	{
		Date date1 = new Date(10,10,2019);
		
		date1.setDay(9);
		date1.setMonth(4);
		date1.setYear(2024);
		
        assertEquals(4, date1.getMonth());
        assertEquals(9, date1.getDay());
        assertEquals(2024, date1.getYear());
	}
	
	@Test
	public void ConstructDateCopyTest() {
		Date date1 = new Date(1,1,2017);
			
		
        Date date2 = new Date(date1);
        date1.setDay(27);	
        
        assertEquals(27, date1.getDay());       
        assertEquals(1, date2.getDay());
	}
	
	@Test
	public void PrintDateTest()
	{
		Date date1 = new Date(1,1,2017);

        assertEquals("01/01/2017", date1.toString());
	}
}
