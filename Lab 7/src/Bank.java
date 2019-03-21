import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	private static ArrayList<BankAccount> accounts;
	private int maxSize;
	private int numAccounts;
	
	static Scanner input;
	
	public Bank() {
		this(1000);
	}
	
	public Bank(int bankSize) {
		numAccounts = 0;
		maxSize = bankSize;
		accounts = new ArrayList<BankAccount>(maxSize);
		input = new Scanner(System.in);
	}
	
	public boolean addAccount() {
		
		char option = 'x';
		BankAccount newAccount = null;
		
		System.out.println("Enter details for account number " + (accounts.size() + 1));
		
		do { 
			
			System.out.println("Enter 'c' for Chequing, or 's' for Savings:");
			option = input.next().toLowerCase().charAt(0);
			
			switch (option) {
			case 'c':
				newAccount = new ChequingAccount();
				break;
			case 's':
				newAccount = new SavingsAccount();
				break;
			default:
				System.out.println("Invalid selection. Please try again.");
			}
	
		} while (option != 'c' && option != 's');
		
		if (newAccount.addBankAccount()) {
			accounts.add(newAccount);
			numAccounts += 1;
			return true;
		} 
		
		return false;
	}
	
	public void updateAccount() {
		
		BankAccount acc = findAccount();
		
		if (acc == null) {
			System.out.println("Account number requested not found.");
			return;
		}
		
		System.out.println("Enter an amount:");
		acc.updateBalance(input.nextDouble());
		
	}
	
	public String displayAccount() {
		
		BankAccount acc = findAccount();
		
		if (acc == null) {
			return "Account number requested not found.";
		}
		
		return acc.toString();
	}
	
	public void printAccountDetails() {
		
		for (BankAccount acc : accounts) {
			System.out.println(acc);
		}
		
	}
	
	public void monthlyUpdate() {
		for (BankAccount acc : accounts) {
			acc.monthlyAccountUpdate();
		}
	}
	
	public BankAccount findAccount() {
		
		System.out.println("Enter an account number: ");
		while (!input.hasNextLong()) {
			System.out.println("Invalid account number. Please try again:");
			input.next();
		}
		return searchAccounts(input.nextLong());
	}
	
	public static BankAccount searchAccounts(long accNumToFind) {
		
		for (BankAccount acc : accounts) {
			
			if (acc.getAccNumber() == accNumToFind)
				return acc;
		}
		
		return null;
	}
	
	public int getNumAccounts() {
		return numAccounts;
	}
}
