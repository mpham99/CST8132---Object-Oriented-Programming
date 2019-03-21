/* File name: Regular.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 16th
 * Professor: Angela Giddings                                              
 */
import java.text.DecimalFormat;

/**
 * Contains information about Regular employees
 * @author Minh-Duc Pham
 * @version 1
 * @since 1.8.0_144
 */
public class Regular extends Employee {
	
	/**
	 * Constructor
	 * @param name Employee's name
	 */
	public Regular (String name) {
		super(name);
		this.hRate = 45;
		this.hPerWeek = 25;
	}
	
	/**
	 * The tax rate
	 */
	protected double tax = 0.13;
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double calculate() {
		double amount=hRate*hPerWeek*(1+tax);
		return amount;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void payment() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		System.out.println("Mailed a cheque to " + super.name + " for " + df.format(calculate()) );
	}

}
