/* File name: BankAccount.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 9th
 * Professor: Angela Giddings                                              
 */

import java.util.Scanner;

/**
 * The base class and contains all common data members for all Bank Accounts
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public abstract class BankAccount {

	/**
	 * The account number
	 */
	protected int accNumber;

	/**
	 * An object of class Person
	 */
	protected Person accHolder;

	/**
	 * The Bank Account balance
	 */
	protected double balance;

	Scanner input = new Scanner(System.in);

	/**
	 * Default constructor
	 */
	public BankAccount() {

	}

	/**
	 * Updates the balance in the object by the amount of parameter
	 * @param bal The amount to update in the Bank Account balance
	 */
	public void updateBalance(double bal) {  
		if(balance+bal<0) {
			System.out.println("Insufficient funds in the account !");
		}else {
			balance+=bal;
		}// end of if
	}// end of updateBalance

	/**
	 * Prompts user to enter data for this object from keyboard - edits data, and doesn't allow user to continue with bad data
	 * @return True after successfully enter all data for the bank account
	 */
	public boolean addBankAccount() {
		boolean error=true;
		String ph="";
		
		//get account number
		do {
			try {
				System.out.println("Enter account number: ");
				accNumber = input.nextInt();
				while(accNumber<0) {
					System.out.println("Please enter a positive number: ");
					accNumber = input.nextInt();
				}
				error=false;
			}
			catch(Exception e) {
				System.out.println("Invalid input ! Please enter again");
				input.next();
			}
		} while (error); //catch accntNumber exception

		//get first name
		System.out.println("Enter first name of account holder:");
		String fName = input.next();
		while(!fName.matches("[a-zA-Z]+")) {
			System.out.println("Found invalid character ! Please enter a word");
			fName=input.next();
		}

		//get last name
		System.out.println("Enter last name of account holder:");
		String lName = input.next();
		while(!lName.matches("[a-zA-Z]+")) {
			System.out.println("Found invalid characters ! Please enter a word");
			lName=input.next();
		}

		//get phone number
		do {
			try {
				error=true;
				System.out.println("Enter phone number: ");
				ph = input.next();

				while(!ph.matches("\\d{10}")) {
					System.out.println("Phone number must a positive, 10-digit number (Ignore the +1 prefix) ! Please enter again: ");
					ph=input.next();
				}
				error=false;
			}
			catch(Exception e) {
				System.out.println("Invalid input ! Please enter again");
				input.next();
			}
		} while (error); //catch ph exception

        boolean isValid = false;
        String email ="";
		do {
			System.out.println("Enter Email address: ");
			email = input.next();
			
			int atPos = email.indexOf('@');
			int dotPos = email.lastIndexOf('.');
			
			while (atPos==-1 || dotPos==-1 || atPos>dotPos) {
				System.out.println("Invalid email address ! Please enter again: ");
				email=input.next();
				atPos = email.indexOf('@');
				dotPos = email.lastIndexOf('.');
			}
	        isValid = true;	
		}while (isValid==false);
		
        
		//get opening balance
		do {
			try {
				error=true;
				System.out.println("Enter opening balance:");
				balance = input.nextDouble();
				while(balance<0) {
					System.out.println("The opening balance must be a positive number ! Please enter again: ");
					balance = input.nextDouble();
				}
				error=false;
			}
			catch(Exception e) {
				System.out.println("Invalid input ! Please enter again");
				input.next();
			}
		} while (error); //catch balance exception

		//create object of Person class
		this.accHolder = new Person(fName, lName, ph, email);
		return true;

	}// end of addBankAccount()

	/**
	 * Print the data of accounts
	 * @return The data of account formatted to display
	 */
	public String toString() {
		String print = "Account Number: " + accNumber 
				+ " Name: " + this.accHolder.getName() 
				+ " Phone Number: " + this.accHolder.getPhoneNumber()
				+ " Email Address: "+ this.accHolder.getEmailAddress()
				+ " Balance: "+ balance;
		return print;
	}

	/**
	 * Process the object with monthly update
	 */
	public abstract void monthlyAccountUpdate();

}// end of class