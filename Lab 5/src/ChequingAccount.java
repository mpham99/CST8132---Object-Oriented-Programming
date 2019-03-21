/* File name: ChequingAccount.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 9th
 * Professor: Angela Giddings                                              
 */

/**
 * This class will be inherited from BankAccount and contains the data member for a chequing account
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public class ChequingAccount extends BankAccount {
	
	/**
	 * The account's fee
	 */
	private double fee;

	/**
	 * Default constructor
	 */
	public ChequingAccount() {
		super();
	}

	/**
	 * ({@inheritDoc}
	 */
	public boolean addBankAccount() {
		boolean error = true;
		super.addBankAccount();

		do {
			try {
				System.out.println("Enter monthly fee: ");
				fee = input.nextDouble();
				while(fee<0) {
					System.out.println("The monthly fee must be larger than 0! Please enter again: ");
					fee = input.nextDouble();
				}
				error=false;
			}
			catch(Exception e) {
				System.out.println("Invalid input ! Please enter again");
				input.next();
			}
		} while (error); //catch minimum balance exception

		return true;
	}// end of addBankAccount

	/**
	 * {@inheritDoc}. As long as the bank balance is more than fee, else displays error message
	 */
	@Override
	public void monthlyAccountUpdate() {
		if(balance>fee) {
			balance-=fee;
		}else 
			System.out.println("The bank balance amount must be more than the fee amount");
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return super.toString() + " Fee: " + fee;
	}

     
}