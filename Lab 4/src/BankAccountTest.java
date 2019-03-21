/**
 * File name: BankAccountTest.java
 * Author: Minh Duc Pham, 040905103
 * Course: CST8132-OOP
 * Assignment: 4
 * Date: February 27th
 * Professor: Angela Giddings
 * Purpose: 
 *
 */
import java.util.Random;

/**
 * @author Minh-Duc Pham
 * @version 1
 * @since 1.8.0	_144
 * @see java.util.Random
 */
public class BankAccountTest {

   
   public BankAccount[] accounts;
  
   //Declare and Instantiate the months
   
   public final static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
  
   /**
    * Display all of the bank accounts information
    * @param accounts An array of bank accounts
    */
   public void display(BankAccount[] accounts){
       for (int i=0; i < accounts.length; i++){
           System.out.print("#"+(i+1)+": ");
           accounts[i].displayBalance();
       }
   }
   
   /**
    * Call the calculateAndUpdateBalance method on all accounts in the array
    * @param accounts An array contains 5 bank accounts
    */
   public void monthlyProcess(BankAccount[] accounts){
	   for (int i=0; i < accounts.length; i++){
		   accounts[i].calculateAndUpdateBalance();
	   }
   }
   
   /**
    * Instantiate an array hold 5 banks account with different balance. Does monthly balance update on each account and print information of the account balance
    * @param args The command line arguments
    */
   public static void main(String[] args) {
      
       BankAccountTest test = new BankAccountTest();
      
       Random random = new Random();
       
       //Generate the accounts to test around with.
       //Instantiate the Bank Accounts array
       test.accounts = new BankAccount[5];
       
       		// 1000 * random.nextDouble()  // 0.0 - 1.0
       
       test.accounts[0] = new SavingsAccount(random.nextInt(55000)+1);
       test.accounts[1] = new SavingsAccount(random.nextInt(55000)+1);
       test.accounts[2] = new ChequingAccount(random.nextInt(5000)+1);
       test.accounts[3] = new ChequingAccount(random.nextInt(5000)+1);
       test.accounts[4] = new ChequingAccount(random.nextInt(5000)+1);
          
       
      
       //Simulate a year of processes running every month.
       for(int i=0; i < months.length; i++){
           System.out.println("Balances for bank accounts in " + months[i]+":");
           test.monthlyProcess(test.accounts); //Pass the arrays which are generated through the test bank account simulation.
           test.display(test.accounts); //Display the result.
           System.out.println(); //New Line for the next process.
       }
   }// end of main
    
  
}// end of class