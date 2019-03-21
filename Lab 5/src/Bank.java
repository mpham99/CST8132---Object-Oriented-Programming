/* File name: Bank.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 9th
 * Professor: Angela Giddings                                              
 */

import java.util.Scanner;

/**
 * Contain the array of BankAccount objects. Contains method to interact with the bank accounts.
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public class Bank {

	/**
	 * Array of BankAccount object
	 */
	private BankAccount[] accounts;

	/**
	 * The index of bank accounts in the array
	 */
	private int numAccounts;
	
	/**
	 * The maximum bank accounts that the system can hold
	 */
	private int maxSize;


	Scanner input = new Scanner(System.in);

	/**
	 * Default Constructor. Allocate default size of 1000
	 */
	public Bank() {
		this.maxSize = 1000;
		this.numAccounts = 0;
		accounts = new BankAccount[maxSize];
	}
	
	/**
	 * Parameterized Constructor
	 * @param mSize The maximum amount of bank accounts the system can hold.
	 */
	public Bank(int mSize) {
		this.maxSize = mSize;
		this.numAccounts = 0;
		this.accounts = new BankAccount[maxSize];
	}

	/**
	 * Method prompts user to enter data used to add a new account if there is room.
	 * @return false if no account is created
	 * @return true if an account is added
	 */
	public boolean addAccount() {
		boolean error=true;
		if(numAccounts >= maxSize) {
			System.out.println("There is no room for new account");
			return false;
		}
		else {
			System.out.println("Enter details of account holder "+(numAccounts+1));
			System.out.println("=================================");
			do {
				System.out.println("Enter account type (s for savings, c for checking): ");
				String accType=input.next();

				switch(accType) {
				case "s": accounts[numAccounts] = new SavingsAccount();
				error=false;
				break;
				case "c": accounts[numAccounts] = new ChequingAccount();
				error=false;
				break;
				default: System.out.println("Invalid character ! Please enter account type again");
				break;
				}
			}while(error);
			
			//Account added successfully
			if(accounts[numAccounts].addBankAccount()) {
				numAccounts++;
			}
			else {
				System.out.println("Account not added");
			}

			return true;
		}
	}// end of addAccount()

	/**
	 * Prompts user to enter account number to display. Return data of the account or put an error message
	 * @return the information of the account user want to display
	 */
	public String displayAccount() {
		String print="";
		boolean error = true;
		if(numAccounts==0) {
			System.out.println("No bank account available");
			return print;

		}else {
			do {
				try {
					System.out.println("Please enter the account number: ");
					int accN =input.nextInt();
					for (int i = 0; i<numAccounts; i++) {
						if(accN==accounts[i].accNumber) {
							print = accounts[i].toString();
							break;
						}// end of if
						else {
							System.out.println("Can't find the account !");
						}
					}// end of for
					error = false;
				} catch (Exception e) {
					System.out.println("Invalid character ! ");
					input.next();
				}// end of catch accN exception
			}while(error);

			System.out.println(print);
			return print;
		}// end of else

	}//end of displayAccount() method

	/**
	 * Prints detail of all account
	 */
	public void printAccountDetails() {
		if(numAccounts==0) {
			System.out.println("No bank account available");
		}else {
			System.out.println("\n\nBanking System"
					+ "\n*********************"
					+ "\nNumber of Account holders: "+numAccounts);
			for(int i=0; i<numAccounts; i++)
				System.out.println(accounts[i].toString());
		}
	}// end of printAccountDetails

	/**
	 * Prompts user enter which account number to update and by how much. Updates the balance and return success/error message
	 */
	public void updateAccount() {
		double balAmount = 0;
		boolean error=true;
		int fAcc = findAccount();

		if(fAcc==-1) {
			System.out.println("No bank account available");
		}else {
			do {
				try {
					System.out.println("Enter amount to deposit/withdraw (positive number to deposit. negative number to withdraw): " );
					balAmount=input.nextDouble();
					accounts[fAcc].updateBalance(balAmount);
					error = false;
				}catch (Exception e) {
					System.out.println("Invalid character ! Please enter the amount again: ");
					input.next();
				}
			}while(error); // catch balance exception
		}// end of if

	}// end of updateAccount() method

	/**
	 * Prompts users to enter which account number they wish to find
	 * @return array index if the needed account is found
	 * @return -1 if no bank account available
	 */
	public int findAccount() {
		if (numAccounts == 0) {
			System.out.println("Error ! No bank account available ");
			return -1;
		}
		int accNum;
		do {
			System.out.println("Enter account number: ");
			try {
				accNum = input.nextInt();
				for(int i = 0; i < numAccounts; i++) {
					if (accounts[i].accNumber == accNum)
						return i;
				}
			}catch(Exception e) {
				System.out.println("Invalid input ! Please enter again");
				input.next();
			}// catch accNumber	
		}while (true); // end of do
	}//end of findAccount

	/**
	 * Process through each current account in the array and updates the balance apporiately
	 */
	public void monthlyUpdate() {
		if(numAccounts==0)
			System.out.println("No bank account available");
		else {
			for (int i=0; i < numAccounts; i++){
				accounts[i].monthlyAccountUpdate();
			}// end of for
		}// end of if
	}// end of monthlyUpdate
	
}// end of class