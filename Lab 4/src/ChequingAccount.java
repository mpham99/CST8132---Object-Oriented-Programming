/**
 * File name: ChequingAccount.java
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
public class ChequingAccount extends BankAccount {
	
	/**
	 * Chequing fee
	 */
	public double fee = 10;
	
	/**
	 * Default constructor of this class
	 */
	public ChequingAccount() {
		super(0);
	}
	
	/**
	 * Initial constructor of this class
	 * @param balance The chequing account balance
	 */
	public ChequingAccount(double balance) {
		super(balance);
	}
	
	/**
	 * {@inheritDoc}
	 * Subtract money of the balance
	 */
	@Override
	public void calculateAndUpdateBalance() {
		balance -= fee;
	}
	
	/**
	 * {@inheritDoc}
	 * Display the balance of a chequing account
	 */
	@Override
	   public void displayBalance() {
	       String formattedBalance = String.format("%.2f", getBalance());
	       System.out.println("Chequing account balance: $" + formattedBalance);
	   }

}// end of class
