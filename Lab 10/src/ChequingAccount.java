/* File name: ChequingAccount.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 2
 * Date: April 20th
 * Professor: Angela Giddings                                              
 */

import java.text.DecimalFormat;

/**
 * This class will be inherited from BankAccount and contains the data member for a chequing account
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public class ChequingAccount extends BankAccount {

	private double fee;

	/**
	 * Method to add chequing account
	 */
	public boolean addBankAccount(double monthlyFee) {

		if (!super.addBankAccount(monthlyFee)) {
			return false;
		}
		fee = monthlyFee;
		return true;
	}

	/**
	 * Method used to process monthly update
	 */
	public void monthlyAccountUpdate() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		if (balance > fee)
			balance -= fee;
		else
			System.err.println("Insufficent funds to charge " + df.format(fee) + " on account " + accNumber + ".");
	}

	/**
	 * Method used print out chequing account information
	 */
	public Object[] toArray() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		Object[] data = {accNumber, accHolder, df.format(balance), null, null, df.format(fee) };
		return data;
	}
	
	/**
	 * Method used to print account information
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return super.toString() + "  Fee: " + df.format(fee);

	}	

}
