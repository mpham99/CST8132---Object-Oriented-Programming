/**
 * File name: Account.java
 * Author: Minh Duc Pham, 040905103
 * Course: CST8132-OOP
 * Assignment: 4
 * Date: February 9th
 * Professor: Angela Giddings
 * Purpose: invoke methods and store datas related to accounts
 *
 */

/**
 * @author Minh-Duc Pham
 * @version 1
 * @since 1.8.0	_144
 */
public class Account {
	/** 
	 * Account Number 
	 */
	private long accNumber;
	/** 
	 * Account Holder
	 */
	private Person accHolder;
	/** 
	 * Account Balance 
	 */
	private double balance;
	
	/**
     * Constructor for Account class
     * @param accNum The account number
     * @param p Account Holder
     * @param bal Account's balance
     */
	public Account(long accNum, Person p, double bal) {
		accNumber=accNum;
		accHolder=p;
		balance=bal;
	}

	/**
     * Updates balance by adding the deposit ammount
     * @param amount The amount of money the user want to deposit
     */
	public void deposit(double amount) {
		balance +=amount;
	}// end of deposit

	/**
     * Check sufficiency of fund. Updates balance if the fund is enough
     * @param amount the amount of money 
     * @return -1 if fund is not available, 0 if it is enough
     */
	public int withdraw(double amount) {
		if(balance<amount) {
			System.out.println("Not enough money");
			return -1;
		}
		else {
			balance-=amount;
			return 0;
		}
	}// end of withdraw

	/**
     * Return account number
     * @return Account number
     */
	public long getAccNumber() {
		return accNumber;
	}// end of getAccNumber

	/**
     * Return account holder
     * @return Object to invoke method from Person class
     */
	public Person getAccHolder() {
		return accHolder;
	}// end of getAccHolder

	/**
     * Return balance
     * @return The balance in an account
     */
	public double getBalance() {
		return balance;
	}// end of getBalance

	/**
     * Return account holder's name
     * @return Account holders' names
     */
	public String getName() {
		return accHolder.getName();
	}// end of getName

	/**
     * Return account holder's email address
     * @return Account holder's email address
     */
	public String getEmailAddress() {
		return accHolder.getEmailAddress();
	}// end of getEmailAddress

	/**
     * Return account holder's phone number
     * @return Account holder's phone number
     */
	public long getPhoneNumber() {
		return accHolder.getPhoneNumber();
	}// end of getPhoneNumber()


}
