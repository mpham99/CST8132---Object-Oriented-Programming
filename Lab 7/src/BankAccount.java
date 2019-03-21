import java.text.DecimalFormat;

public abstract class BankAccount {

	protected double balance = 0;
	protected long accNumber;
	protected Person accHolder;
	
	public boolean addBankAccount() {
		
		long accNum = 0;
		do {
			System.out.println("Enter an account number:");
			String accN = Bank.input.next();
			
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
		while (!Bank.input.hasNextDouble()) {
			System.out.println("Invalid opening balance amount. Please try again:");
			Bank.input.next();
		}
		balance = Bank.input.nextDouble();
		
		System.out.println("Enter a first name:");
		String fName = Bank.input.next();
		
		System.out.println("Enter a last name:");
		String lName = Bank.input.next();
		
		long phoneNum = 0;
		do {
			System.out.println("Enter a phone number:");
			String pNum = Bank.input.next();
			
			if (pNum.length() == 7 || pNum.length() == 10) {
				try {
					phoneNum = Long.parseLong(pNum);
				} catch (Exception e) {
					phoneNum = 0;
					System.out.println("Invalid phone number. Please try again.");
				}
			}
		
		} while (phoneNum == 0);
		
		System.out.println("Enter an email address:");
		String email = Bank.input.next();
		
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
	
}


