/**
 * 
 */

/**
 * Consultant 
 * 
 * this is a class that extends hourlyworker which is an 
 * Extension of employee
 * @author jquigtar
 *
 */
public class Consultant extends HourlyWorker {

	public Consultant() {
		super();
	}
	
	public Consultant(String name, int social) {
		super(name, social, 300);
	}
	
	public Consultant(Consultant toCopy) {
		super(toCopy.getName(), toCopy.getSocial(), toCopy.getHourlyPay());
	}
	
	
	@Override
	public double calculateWeeklyPay() {
		return this.getHourlyPay() * 20;
		//each consulatant gets paid $300 * 20 hours
	}
}
