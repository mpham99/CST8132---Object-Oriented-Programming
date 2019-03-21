import java.text.DecimalFormat;

public class SavingsAccount extends BankAccount {

	double interestRate;
	double minimumBalance;
	
	public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
		
		System.out.println("Enter an interest rate: ");
		interestRate = Bank.input.nextDouble();
		
		System.out.println("Enter a minimum balance: ");
		minimumBalance = Bank.input.nextDouble();
		
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
