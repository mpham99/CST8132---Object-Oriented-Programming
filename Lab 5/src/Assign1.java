/* File name: Assign1.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 9th
 * Professor: Angela Giddings                                              
 */

import java.util.Scanner;

/**
 * Contain the method main, which contain the system's menu
 * @author Minh Duc Pham
 * @version 1
 * @see java.util.Scanner
 * @since 1.8.0_144
 */
public class Assign1 {
	
   /**
    * The method main of the program, hold the system's menu and invoke method from Bank class
    * @param args The command line arguments
    */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// TODO Auto-generated method stub

		Bank object = new Bank();// object of Bank class
		String choice;
		do {

			//Print out list of options
			System.out.println("a: Add new account"
					+ "\nu: Update an account"
					+ "\nd: Display an account"
					+ "\np: Print all accounts"
					+ "\nm: Run monthly update"
					+ "\nq: Quit"
					+ "\nEnter your option: ");

			choice = input.nextLine().toLowerCase();
			switch(choice) {
			case "a": object.addAccount();
			break;
			case "u": object.updateAccount();
			break;
			case "d": object.displayAccount();
			break;
			case "p": object.printAccountDetails();
			break;
			case "m": object.monthlyUpdate();
			break;
			case "q":
				break;
			default : System.out.println("Wrong character! Try again ");
			break;
			}
		}while(!choice.equals(new String("q")));//end of switch
		System.out.println("Good Bye :)");
	}// end of main

}// end of class