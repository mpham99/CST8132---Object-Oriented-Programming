/* File name: BankAccount.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 2
 * Date: April 20th
 * Professor: Angela Giddings                                              
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * The base class and contains all common data members for all Bank Accounts
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public abstract class BankAccount {

	/**
	 * The account's balance
	 */
	protected Double balance = (double) 0;
	
	/**
	 * The account number
	 */
	protected long accNumber;
	
	/**
	 * An object of Person class
	 */
	protected Person accHolder;

	/**
	 * Method to get account index in ArrayList
	 * @return account index in ArrayList
	 */
	public long getAccNumber() {
		return accNumber;
	}

	/**
	 * Method to get account holder
	 * @return account holder
	 */
	public Person getAccHolder()  {
		return accHolder;
	}

	/**
	 * Method to update the account balance
	 * @param amount The amount of money to withdraw/deposit
	 */
	public void updateBalance(double amount) {
		if (amount < 0) {
			amount = Math.abs(amount);
			if (amount > balance) {
				JOptionPane.showMessageDialog(null, "Insufficient funds in the account !", "Error!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			balance -= amount;
		}
		else {
			balance += amount;
		}
	}

	/**
	 * Method to print out Account information
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return "Account Number: " + accNumber + "  " + accHolder.toString() + "  Balance: " + df.format(balance);
	}

	/**
	 * Method to print out Account Information
	 * @return Account Information
	 */
	public abstract Object[] toArray();
	
    /**
     * Process the object with monthly update
     */
	public abstract void monthlyAccountUpdate();

	/**
	 * Method to add savings account
	 * @param interest Interest Rate
	 * @param minBalance Minimum Balance
	 * @return true
	 */
	public boolean addBankAccount(double interest, double minBalance) {
		return true;
	}

	/**
	 * Method to add chequing account
	 * @param monthlyFee Monthly Fee
	 * @return true
	 */
	public boolean addBankAccount(double monthlyFee) {
		return true;
	}
	
}


