
public class Assign1 {

	public static void displayMenu() {
		
		System.out.println("a: Add new account");
		System.out.println("u: Update an account");
		System.out.println("d: Display an account");
		System.out.println("p: Print all accounts");
		System.out.println("m: Run monthly update");
		System.out.println("q: Quit");
		System.out.println("Enter an option:");
		
	}
	
	public static void main(String[] args) {
		
		Bank bank = new Bank(10);
		
		char option = 'x';
		
		do {
			
			displayMenu();
			
			option = Bank.input.next().toLowerCase().charAt(0);
			
			switch(option) {
			
			case 'a':
				bank.addAccount();
				break;
			case 'd':
				System.out.println(bank.displayAccount());
				break;
			case 'm':
				bank.monthlyUpdate();
				break;
			case 'p':
				bank.printAccountDetails();
				break;
			case 'q':
				break;
			case 'u':
				bank.updateAccount();
				break;
			default:
				System.out.println("Invalid selection. Please try again.");
			}
			
		} while (option != 'q');
		 
		Bank.input.close();
		
		System.out.println("Have a nice day!");
		
	}
	
}
