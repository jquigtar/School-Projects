/**
 * 
 */

/**
 * PermanentHire
 * 
 * this is a class that extends salriedWorker which extends 
 * salried worker
 * @author jquigtar
 *
 */
public class PermanentHire extends SalariedWorker {

	private double monthlyBonus;
	
	public PermanentHire() {
		super();
	}
	
	public PermanentHire(String name, int social) {
		super(name, social);
	}
	
	public PermanentHire(String name, int social, double pay) {
		super(name, social, pay);
	}
	
	public PermanentHire(String name, int social, double pay, double bonus) {
		super(name, social, pay);
		this.monthlyBonus = bonus;
	}
	
	public PermanentHire(PermanentHire toCopy) {
		super(toCopy.getName(), toCopy.getSocial(), toCopy.getMonthlyPay());
		double bonus = toCopy.monthlyBonus;
		this.monthlyBonus = bonus;
	}
	
	@Override
	public double calculateWeeklyPay() {
		return super.calculateWeeklyPay() + this.monthlyBonus;
	}
	
	
	
	}
