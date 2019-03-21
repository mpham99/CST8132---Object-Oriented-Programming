/* File name: Bank.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 2
 * Date: April 20th
 * Professor: Angela Giddings                                              
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Hold the ArrayList of ank accounts and method interacts with the bank accounts
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public class Bank {

	/**
	 * The accounts ArrayList
	 */
	protected static ArrayList<BankAccount> accounts;
	private int maxSize;
	private int numAccounts;
	/**
	 * Object of BankAccount class
	 */
	BankAccount newAccount;

	/**
	 * Default Constructor. Set bankSize to 1000
	 */
	public Bank() {
		this(1000);
	}

	/**
	 * Argumented Constructor. Initialize value
	 * @param bankSize The maximum amount of bank accounts the bank can ho,d
	 */
	public Bank(int bankSize) {
		numAccounts = 0;
		maxSize = bankSize;
		accounts = new ArrayList<BankAccount>(maxSize);
	}

	/**
	 * Method to add the accounts into the ArrayList
	 * @param type The type of the account
	 * @param num The account number
	 * @param fn The account holder's first name
	 * @param ln The account holder's last name
	 * @param pn The account holder's phone number
	 * @param email The account holder's email
	 * @param bal The account balance
	 * @param minBal The savings account's minimum balance
	 * @param interest The savings account's interest rate
	 * @param fee The chequing account's monthly fee
	 * @return true
	 */
	public boolean addAccount(char type, int num, String fn, String ln, long pn, String email, double bal, double minBal, double interest, double fee) {

		if(String.valueOf(type).equals("c")) {
			newAccount = new ChequingAccount();
		}
		else if(String.valueOf(type).equals("s")) {
			newAccount = new SavingsAccount();
		}

		newAccount.accNumber = num;
		newAccount.accHolder = new Person(fn,ln,pn,email);
		newAccount.balance = bal;

		if(String.valueOf(type).equals("c")) {
			newAccount.addBankAccount(fee);
		}
		else if(String.valueOf(type).equals("s")) {
			newAccount.addBankAccount(interest, minBal);
		}

		accounts.add(newAccount);
		numAccounts += 1;

		return true;
	}

	/**
	 * Method to read data from a file into the database
	 * @param filename The name of the file
	 * @return true if the data be read into the database, otherwise, false
	 */
	public boolean readFile(String filename) {
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(Paths.get(filename));
			
			while(sc.hasNext()) {

				String option = sc.next();

				if(option.equals("c")) {
					newAccount = new ChequingAccount();
				}
				else if(option.equals("s")) {
					newAccount = new SavingsAccount();

				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid account option", "Error!", JOptionPane.ERROR_MESSAGE);
					//return false;
					continue;
				}

				newAccount.accNumber = sc.nextLong();
				if (Bank.searchAccounts(newAccount.accNumber) != null) {
					JOptionPane.showMessageDialog(null, "Account number already in use. Please try again.", "Error!", JOptionPane.ERROR_MESSAGE);
					throw new Exception();
				}
				
				String fName = sc.next();
				String lName = sc.next();
				long phno = sc.nextLong();
				String email = sc.next();
				
				newAccount.accHolder = new Person(fName,lName,phno,email);

				newAccount.balance = sc.nextDouble();
				
				if(option.equals("c")) {
					newAccount.addBankAccount(sc.nextDouble());
				}
				else if(option.equals("s")) {
					newAccount.addBankAccount(sc.nextDouble(), sc.nextDouble());
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid account type.", "Error!", JOptionPane.ERROR_MESSAGE);
					throw new Exception();
				}
				accounts.add(newAccount);
				numAccounts += 1;
				
			}
			return true;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No file found", "Error!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Found exception", "Error!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		finally {
			if (sc != null)
				sc.close();
		}
		
	}// end of readFile

	/**
	 * Method used to deposit/withdraw money from an account
	 */
	public void updateAccount() {
		double amount = 0;
		String input = "";
		boolean isDouble = false;
		BankAccount acc = findAccount();
		if (acc == null) {
			JOptionPane.showMessageDialog(null, "Account number requested not found.", "Error!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JFrame frameUpdateAccount = new JFrame("Update account");
		input = JOptionPane.showInputDialog(frameUpdateAccount, "Enter an amount");
		
		try{
			amount = Double.parseDouble(input);
		    isDouble = true;
		}catch( Exception ex ){
			isDouble = false;
		}
		
		if(isDouble == false) {
			JOptionPane.showMessageDialog(null, "Invalid deposit/withdraw amount", "Error!", JOptionPane.ERROR_MESSAGE);
			amount = 0;
		}else 
			acc.updateBalance(amount);
	}

	/**
	 * Method used to display account information
	 */
	public void displayAccount() {

		BankAccount acc = findAccount();

		if (acc == null) {
			JOptionPane.showMessageDialog(null, "Cannot found the account number", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, acc.toString());
		}
	}

	/**
	 * Method used to print account details
	 */
	public void printAccountDetails() {
		for (BankAccount acc : accounts) {
			System.out.println(acc);
		}
	}

	/**
	 * Method used to process through each current account in the array and updates the balance appropriately
	 */
	public void monthlyUpdate() {
		
		for (BankAccount acc : accounts) {
			acc.monthlyAccountUpdate();
		}
		if(accounts.isEmpty())
			JOptionPane.showMessageDialog(null, "No bank accounts in the database", "Error!", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Method prompts user to enter account number, and used the searchAccounts() method to find the account
	 * @return The account in the ArrayList
	 */
	public BankAccount findAccount() {
		
		String input = "";
		int accNum = 0;

		JFrame frameFindAccount = new JFrame("Find account");
		input = JOptionPane.showInputDialog(frameFindAccount, "Please input the file account number");
		try {
			accNum = Integer.parseInt(input);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid account number. Please try again", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return searchAccounts(accNum);
	}

	/**
	 * Method used to search an account in the ArrayList
	 * @param accNumToFind The account's number
	 * @return The account in ArrayList
	 */
	public static BankAccount searchAccounts(long accNumToFind) {
		for (BankAccount acc : accounts) {
			if (acc.getAccNumber() == accNumToFind)
				return acc;
		}
		return null;
	}
	
	/**
	 * Method used to get the account's index number in ArrayList
	 * @return index number of the account in ArrayList
	 */
	public int getNumAccounts() {
		return numAccounts;
	}


}
