/**
 * File name: SavingsAccount.java
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
public class SavingsAccount extends BankAccount {
	
	/** 
	 * Interest rate
	 */
	public double interestRate = 1.1;
	
	/**
	 * Default constructor of this class
	 */
	public SavingsAccount() {
		super(0);
	}

	/**
	 * Initial constructor
	 * @param balance The saving account balance
	 */
	public SavingsAccount(double balance) {
		super(balance);
	}
	
	/**
	 * {@inheritDoc} 
	 * Add money to balance
	 */
	@Override
	public void calculateAndUpdateBalance() {
		balance *=interestRate;
	}
	
	/**
	 * {@inheritDoc}
	 * Display the balance of a saving account
	 */
	@Override
	   public void displayBalance() {
	       String formattedBalance = String.format("%.2f", getBalance());
	       System.out.println("Saving Account Balance: $" + formattedBalance);
	   }
	
}//end of class
