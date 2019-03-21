import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	private static ArrayList<BankAccount> accounts;
	private int maxSize;
	private int numAccounts;
	BankAccount newAccount;
	Scanner input;

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
		newAccount = null;

		System.out.println("Enter details for account number " + (accounts.size() + 1));

		do { 
			System.out.println("Enter account type (s for savings, c for checking): ");
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

	public boolean readFile() {
		
		System.out.println("Enter the file name with bank account details");
		String filename = new Scanner(System.in).next();
		
		File file = new File(filename);
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
					System.out.println("Invalid account option");
					//return false;
					continue;
				}

				newAccount.accNumber = sc.nextLong();
				if (Bank.searchAccounts(newAccount.accNumber) != null) {
					throw new Exception("Account number already in use. Please try again.");
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
				else
					throw new Exception("Invalid account type.");
				
				accounts.add(newAccount);
				numAccounts += 1;
				
			}
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
			return false;
		}
		catch (Exception ex) {
			System.err.println(ex);
			return false;
		}
		finally {
			if (sc != null)
				sc.close();
		}
		
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
