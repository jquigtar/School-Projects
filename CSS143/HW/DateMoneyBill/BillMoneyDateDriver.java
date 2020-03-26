/**
 HW3.java: Simple driver to test Money, Date, and Bill classes
 @author Rob Nash, borrowed from cfolsen
 */
public class BillMoneyDateDriver
{

    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args)
    {
        //Construct some money
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        Money money3 = new Money(10, 100);
        //Money money4 = new Money(-10);
        //Money money5 = new Money(money4);
        //Money money6 = new Money(10, -100);
        //test to make sure these couldn't be set
        
        //TODO: do more functional exercises with the money class
	    
        System.out.println("Money objects output:");
        System.out.println("money1: " + money1);
        System.out.println("money2: " + money2);
        System.out.println("money3: " + money3);
        System.out.println("money1.equals(money2): " + money1.equals(money2));
        money1.setMoney(30,100);
        System.out.println("money1: " + money1);
        System.out.println("money2: " + money2);
        System.out.println("money1.equals(money2): " + money1.equals(money2));

        money1.add(1, 75);
        money2.add(0, 1000);
        money1.add(5);
        System.out.println("money1.add(1,75), money1.add(5): " + money1);
        System.out.println("money2.add(0,1000): " + money2);
        money1.add(money2);
        System.out.println("money1.add(money2): " + money1);
        System.out.println("money1.equals(money2): " + money1.equals(money2));
        System.out.println();
	
	
        //Date
        Date date1 = new Date(1,2,2017);
        Date date2 = new Date(date1);
        Date date3 = new Date(1,3,2017);
        Date date4 = new Date(1,1,2017);
        //Date date5 = new Date(0,2,2017);
        //Date date6 = new Date(13,2,2017);
        //Date date7 = new Date(1,0,2017);
        //Date date8 = new Date(1,32,2017);
        //Date date9 = new Date(1,2,2015);
        //Date date10 = new Date(1,2,2030);
        //test cases to make sure these dates couldn't be set
        System.out.println("Date objects output:");
        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
        System.out.println("date3: " + date3);
        System.out.println("date4: " + date4);
        System.out.println("date1.isAfter(date3): " + date1.isAfter(date3));
        System.out.println("date1.isAfter(date4): " + date1.isAfter(date4));
        System.out.println("date1.equals(date2): " + date1.equals(date2));
        System.out.println("date1.equals(date3): " + date1.equals(date3));
        date2.setDay(27);
        date2.setMonth(10);
        date2.setYear(2019);
        System.out.println("date2: " + date2);
        System.out.println("date1.equals(date2): " + date1.equals(date2));



        System.out.println();
        
        //Construct some bills
        System.out.println("Bill objects output:");
        Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2017);
        Bill bill1 = new Bill(amount, dueDate, "The phone company");
       
        Bill bill2 = new Bill(bill1);
        System.out.println("bill1.equals(bill2): " + bill1.equals(bill2));
        bill1.setAmount(money1);
        bill2.setDueDate(new Date(5, 1, 2017));
        amount.setMoney(31, 99);
        dueDate.setDay(29);
        Bill bill3 = new Bill(amount, dueDate, "The record company");
        
        
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);
        System.out.println("bill1.equals(bill2): " + bill1.equals(bill2));
        Date paidDate = new Date(4,30,2017);
        Date paidDate2 = new Date(paidDate);
        System.out.println("bill1.setPaid(paidDate): " + bill1.setPaid(paidDate));
        System.out.println(bill1);
        System.out.println("bill2.setPaid(paidDate2): " + bill2.setPaid(paidDate2));
        System.out.println(bill2);
        System.out.println("bill1.setDueDate(paidDate2): " + bill1.setDueDate(paidDate2));
        paidDate2.setYear(2019);
        System.out.println("bill3.setDueDate(paidDate2): " + bill3.setDueDate(paidDate2));
    }
}
