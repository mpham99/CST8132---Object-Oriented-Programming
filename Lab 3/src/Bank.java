/**
 * File name: Bank.java
 * Author: Minh Duc Pham, 040905103
 * Course: CST8132-OOP
 * Assignment: 4
 * Date: February 9th
 * Professor: Angela Giddings
 * Purpose: invoke methods to get account details and print the details
 *
 */
import java.util.Scanner;
/**
 * @author Minh-Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0	_144
 */
public class Bank {
	/**
	 * Name of the bank
	 */
	private String bankName;
	
	/**
     * Constructor for Bank class
     * @param name The bank's name
     */
	public Bank(String name) {
        bankName = name;
       
	}// end of constructor
	
	/**
     * Reads and sets personal details, account Number and opening balance. Invoke corresponding constructors 
     * @param accounts An array to hold account details
     * @param numAccHolders Number of account holders in the banking system
     */
	public void generateAccountDetails (Account [] accounts, int numAccHolders) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i<numAccHolders; i++) {	
			System.out.println("Enter details of account holder " + (i+1));
			System.out.println("=================================");
			
			System.out.println("Enter account number :");
			long accNum=input.nextLong();
			
			System.out.println("Enter first name of account holder :");
     		String fName = input.next();
     		
     		System.out.println("Enter last name of account holder :");
    		String lName = input.next();
    		
    		System.out.println("Enter phone number :");
   		    long ph = input.nextLong();
    		
   		    System.out.println("Enter Email address: ");
 		    String email = input.next();
 		    
 		    Person accHolder = new Person(fName, lName, ph, email);
 		    
 		    System.out.println("Enter opening balance :");
 		    double bal = input.nextDouble(); 
 		    
			accounts[i]=new Account(accNum, accHolder, bal);// create accounts
		} 	
		
	}// end of generateAccountDetails
	
	/**
     * Print details of all account holders
     * @param accounts An array to hold account details
     * @param numAccHolders Number of account holders in the banking system
     */
	public void printAccountDetails(Account [] accounts, int numAccHolders) {
		
		System.out.println("\n \n" + bankName + "'s Banking System");
		System.out.println("*********************");
		
		for (int i = 0; i<numAccHolders; i++) {

			System.out.println("AccountNumber: " + accounts[i].getAccNumber() 
					+" Name : " + accounts[i].getName()
					+" Phone Number: " + accounts[i].getPhoneNumber()
					+" Email Address : " + accounts[i].getEmailAddress()
					+" Balance : " + accounts[i].getBalance());
		}
	}// end printAccountDetails 

	
}
