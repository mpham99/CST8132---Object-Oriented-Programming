/* File name: SavingsAccount.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 2
 * Date: April 20th
 * Professor: Angela Giddings                                              
 */

import java.text.DecimalFormat;

/**
 * This class will be inherited from BankAccount and contains the data member for a savings account
 * @author Minh Duc Pham
 * @version 1
 * @since 1.8.0_144
 */
public class SavingsAccount extends BankAccount {

	private double interestRate;
	private double minimumBalance;

    /**
     * Method used to add savings account
     */
	public boolean addBankAccount(double interest,double minBal) {

		if (!super.addBankAccount(interest,minBal)) {
			return false;
		}
		interestRate = interest;
		minimumBalance = minBal;
		return true;
	}

	/**
	 * Method used to process monthly update
	 */
	public void monthlyAccountUpdate() {

		DecimalFormat df = new DecimalFormat("$###,###.##");		

		if (balance > minimumBalance)
			balance += balance * interestRate;
		else
			System.err.println("Minimum balance of " + df.format(minimumBalance) + " on account " + accNumber + " not met.");
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] toArray() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		Object[] data = {accNumber, accHolder, df.format(balance), df.format(minimumBalance), interestRate, null };
		return data;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return super.toString() + "  Interest Rate: " + interestRate + "%  Minimum Balance: " + df.format(minimumBalance);

	}
}
