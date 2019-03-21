import java.text.DecimalFormat;

public class ChequingAccount extends BankAccount {

	private double fee;
	
	public boolean addBankAccount() {
		
		if (!super.addBankAccount()) {
			return false;
		}
		
		System.out.println("Enter a monthly fee:");
		fee = Bank.input.nextDouble();
		
		return true;
		
	}
	
	public void monthlyAccountUpdate() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		if (balance > fee)
			balance -= fee;
		else
			System.err.println("Insufficent funds to charge " + df.format(fee) + " on account " + accNumber + ".");
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("$###,###.##");
		return super.toString() + "  Fee: " + df.format(fee);
		
	}	
	
}
