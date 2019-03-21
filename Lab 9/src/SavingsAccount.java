import java.text.DecimalFormat;

public class SavingsAccount extends BankAccount {

	public double interestRate;
	public double minimumBalance;

	public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
		boolean error = true;

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
	}
	public boolean addBankAccount(double interest,double minBal) {

		if (!super.addBankAccount(interest,minBal)) {
			return false;
		}
		interestRate = interest;
		minimumBalance = minBal;
		return true;
	}

	public void monthlyAccountUpdate() {

		DecimalFormat df = new DecimalFormat("$###,###.##");		

		if (balance > minimumBalance)
			balance += balance * interestRate;
		else
			System.err.println("Minimum balance of " + df.format(minimumBalance) + " on account " + accNumber + " not met.");
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return super.toString() + "  Interest Rate: " + interestRate + "%  Minimum Balance: " + df.format(minimumBalance);

	}
}
