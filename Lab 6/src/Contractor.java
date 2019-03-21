/* File name: Contractor.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 16th
 * Professor: Angela Giddings                                              
 */
import java.text.DecimalFormat;
/**
 * Contain informations about Contractor employees
 * @author Minh-Duc Pham
 * @version 1
 * @since 1.8.0_144
 */
public class Contractor extends Employee{

	/**
	 * Constructor
	 * @param name The employees name
	 */
	public Contractor (String name) {
		super(name);
		this.hRate = 30;
		this.hPerWeek = 37.5;
	}
	
	/**
	 * Deduction rate
	 */
	protected double deduction = 0.27;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double calculate() {
		double amount=hRate*hPerWeek*(1-deduction);
		return amount;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void payment() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		System.out.println("Direct depositing " + df.format(calculate()) + " to " + name + "'s bank account" );
	}

}
