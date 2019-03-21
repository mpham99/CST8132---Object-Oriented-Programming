/* File name: SavingsAccount.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 9th
 * Professor: Angela Giddings                                              
 */

/**
 * This class will be inherited from BankAccount and contains the data member for a savings account
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public class SavingsAccount extends BankAccount {

	/**
	 * The interest rate
	 */
	private double interestRate;
	
	/**
	 * The minimum balance in the saving accounts
	 */
	private double minimumBalance;

	/**
	 * Default constructor
	 */
	public SavingsAccount() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean addBankAccount() {
		boolean error = true;
		super.addBankAccount();

		do {
			try {
				System.out.println("Enter minimum balance: ");
				minimumBalance = input.nextDouble();
				while(minimumBalance>balance) {
					System.out.println("The minimum balance must be smaller than the opening balance ! Please enter again: ");
					minimumBalance = input.nextDouble();
				}
				while(minimumBalance<0) {
					System.out.println("The minimum balance must be larger than 0 ! Please enter again: ");
					minimumBalance = input.nextDouble();
				}
				error=false;
			}
			catch(Exception e) {
				System.out.println("Invalid input ! Please enter again: ");
				input.next();
			}
		} while (error); //catch minimum balance exception

		do {
			try {
				error=true;
				System.out.println("Enter interest rate (should be a number in (0,1): ");
				interestRate = input.nextDouble();
				while(interestRate <=0 || interestRate>=1) {
					System.out.println("Invalid input ! Please enter again: ");
					interestRate = input.nextDouble();
				}
				error = false;
			}
			catch(Exception e) {
				System.out.println("Wrong input ! Please enter again");
				input.next();
			}
		} while (error); //catch interest rate exception

		return true;
	}// end of addBankAccount

	/**
	 * {@inheritDoc}. As long as bank balance is more than the minimum balance, else displays error message
	 */
	@Override
	public void monthlyAccountUpdate() {
		if(balance>minimumBalance) {
			balance += interestRate*balance;
		}else
			System.out.println("Balance is lower than minimum value !");
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return super.toString() + " Minimum Balance: " + minimumBalance + " Interest Rate: " + interestRate;
	}


}