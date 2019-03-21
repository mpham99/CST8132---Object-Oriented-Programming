import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class BankAccount {

	protected Double balance = (double) 0;
	protected long accNumber;
	protected Person accHolder;
	protected Scanner input = new Scanner(System.in);

	public boolean addBankAccount() {

		long accNum = 0;
		do {
			System.out.println("Enter an account number:");
			String accN = input.next();

			if (accN.length() <= 8) {
				try {
					accNum = Long.parseLong(accN);
					if (Bank.searchAccounts(accNum) != null) {
						accNum = 0;
						System.out.println("Account number already in use. Please try again.");
					}
				} catch (Exception e) {
					accNum = 0;
					System.out.println("Invalid account number. Please try again.");
				}
			}

		} while (accNum == 0);
		accNumber = accNum;


		System.out.println("Enter an opening balance amount:");
		while (!input.hasNextDouble()) {
			System.out.println("Invalid opening balance amount. Please try again:");
			input.next();
		}
		balance = input.nextDouble();

		System.out.println("Enter a first name:");
		String fName = input.next();
		while(!fName.matches("[a-zA-Z]+")) {
			System.out.println("Found invalid character ! Please enter a word");
			fName = input.next();
		}
		
		System.out.println("Enter a last name:");
		String lName = input.next();
		while(!lName.matches("[a-zA-Z]+")) {
			System.out.println("Found invalid characters ! Please enter a word");
			lName = input.next();
		}

		long phoneNum = 0;
		do {
			System.out.println("Enter a phone number:");
			String pNum = input.next();

			if (pNum.length() == 7 || pNum.length() == 10) {
				try {
					phoneNum = Long.parseLong(pNum);
				} catch (Exception e) {
					phoneNum = 0;
					System.out.println("Invalid phone number. Please try again.");
				}
			}
		} while (phoneNum == 0);
		
		boolean isValid = true;
		String email = " ";
		do {
			System.out.println("Enter Email address: ");
			email = input.next();
			
			int atPos = email.indexOf('@');
			int dotPos = email.lastIndexOf('.');
			
			while (atPos==-1 || dotPos==-1 || atPos>dotPos) {
				System.out.println("Invalid email address ! Please enter again: ");
				email = input.next();
				atPos = email.indexOf('@');
				dotPos = email.lastIndexOf('.');
			}
	        isValid = true;	
		}while (isValid==false);

		accHolder = new Person(lName, fName, phoneNum, email);
		return true;
	}

	public long getAccNumber() {
		return accNumber;
	}

	public Person getAccHolder()  {
		return accHolder;
	}

	public void updateBalance(double amount) {
		if (amount < 0) {
			amount = Math.abs(amount);
			if (amount > balance) {
				System.out.println("Insufficient funds.");
				return;
			}
			balance -= amount;
		}
		else {
			balance += amount;
		}
	}

	public String toString() {

		DecimalFormat df = new DecimalFormat("$###,###.##");
		return "Account Number: " + accNumber + "  " + accHolder.toString() + "  Balance: " + df.format(balance);

	}

	public abstract void monthlyAccountUpdate();

	
	public boolean addBankAccount(double interest, double minBalance) {
		return true;
	}

	public boolean addBankAccount(double monthlyFee) {
		return true;
	}
	
}


