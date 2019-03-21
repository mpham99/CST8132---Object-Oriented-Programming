import java.text.DecimalFormat;

public class ChequingAccount extends BankAccount {

	private double fee;

	public boolean addBankAccount() {
		if (!super.addBankAccount()) {
			return false;
		}
		boolean error = true;

		do {
			try {
				System.out.println("Enter monthly fee: ");
				fee = input.nextDouble();
				while(fee<0) {
					System.out.println("The monthly fee must be larger than 0! Please enter again: ");
					fee = input.nextDouble();
				}
				error=false;
			}
			catch(Exception e) {
				System.out.println("Invalid input ! Please enter again");
				input.next();
			}
		} while (error); //catch minimum balance exception

		return true;

	}
	public boolean addBankAccount(double monthlyFee) {

		if (!super.addBankAccount(monthlyFee)) {
			return false;
		}
		fee = monthlyFee;
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
