/**
 * File name: BankAccount.java
 * Author: Minh Duc Pham, 040905103
 * Course: CST8132-OOP
 * Assignment: 4
 * Date: February 27th
 * Professor: Angela Giddings
 * Purpose: 
 *
 */

/**
 * @author Minh-Duc Pham
 * @version 1
 * @since 1.8.0	_144
 */
public abstract class BankAccount {
	
	/** */
	public double balance;
	
	/**
	 * Default Constructor, initialize balance to 0
	 */
	public BankAccount() {
		balance=0;
	}
	
	/**
	 * Initial constructor
	 * @param balance The accounts balance
	 */
	public BankAccount(double balance) {
		this.balance=balance;
	}
	
	/**
	 * Get bank account balance
	 * @return Bank account balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * The monthly action of the bank account
	 */
	public abstract void calculateAndUpdateBalance();
	
	/**
	 * To display bank account's balance
	 */
	public abstract void displayBalance();
	
}// end of class
