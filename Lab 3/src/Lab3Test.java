/**
 * File name: Lab3Test.java
 * Author: Minh Duc Pham, 040905103
 * Course: CST8132-OOP
 * Assignment: 4
 * Date: February 9th
 * Professor: Angela Giddings
 * Purpose: hold main class, provide different options for accounts                                                   
 *
 */
import java.util.Scanner;
/**
 * A description of each class.
 * 
 * @author Minh-Duc Pham
 * @author Anu Thomas
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0	_144
 */
public class Lab3Test {
	
	/**
     * Read name to set as bank's name. Read the number of account holders. Call method for bank processing (deposit, withdraw and print all accounts)
     * @param args The command line arguments
     */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		String choice = new String("a");
		char opt = choice.charAt(0);
		int index = -1;
		double amnt;
		
		System.out.println("Enter your name : ");
		String name = in.next();
        // get users name
		
		System.out.print("How many account holders are there in your banking System : ");
		int num = in.nextInt();
        // get ammount of account holders
		
		Bank bank = new Bank(name);
		Account[] accounts = new Account[num];
		
		bank.generateAccountDetails(accounts, num); 
		bank.printAccountDetails(accounts, num);
		// invoke method
		
		while (opt != 'n') {

			System.out.println("d: Deposit \nw: Withdraw \np: Print all accounts \nn: Quit \nEnter your option : ");

			choice = in.next().toLowerCase();
			opt = choice.charAt(0);

			if (opt == 'd') { //for deposit
				do {
					System.out.println("Enter account index : ");
					index = in.nextInt();
					
					if (index >= num)
						System.out.println("Enter an index less than " + num);
					
				} while (index >= num);

				System.out.println("Enter deposit amount: ");
				amnt = in.nextDouble();

				accounts[index].deposit(amnt);

				bank.printAccountDetails(accounts, num);
				
			} else if (opt == 'w') { // for withdrawal
				do {
					System.out.println("Enter account index : ");
					index = in.nextInt();
					
					if (index >= num)
						System.out.println("Enter an index less than " + num);
					
				} while (index >= num);
				
				System.out.println("Enter withdrawal amount: ");
				amnt = in.nextDouble();
				int res = accounts[index].withdraw(amnt);
				
				if (res == -1)// check if account balance is sufficient for the withdrawal
					System.out.println("Insufficient funds"); 
				
				bank.printAccountDetails(accounts, num);
				
			} else if (opt == 'p') // for printing account details
				bank.printAccountDetails(accounts, num);

			  else if(opt == 'n')
				System.out.println("GOOD BYE");

			  else 
				System.out.println("Wrong choice. try again");
			
		} // end of while
		in.close();
	}// end of main
}// end of class
