/* File name: PayrollProcess.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 16th
 * Professor: Angela Giddings                                              
 */

/**
 * Contain the method main and the array of Employee
 * @author Minh-Duc Pham
 * @version 1
 * @since 1.8.0_144
 */
public class PayrollProcess {
	/**
	 * The array of employee
	 */
	private Employee [] payroll;
	
	/**
	 * Initialize the array, populate each array element
	 */
	public PayrollProcess() {
		payroll = new Employee[4];
		
		payroll[0] = new Regular("Jack");
		payroll[1] = new Regular("Jill");
		payroll[2] = new Contractor("James");
		payroll[3] = new Contractor("John");
	}
	
	/**
	 * Call the mehtods
	 */
	public void process() {
		for (int i=0; i<4; i++) {
			payroll[i].payment();
			payroll[i].calculate();
		}
	}
	
	/**
	 * The method main
	 * @param args The command line arguments
	 */
	public static void main (String [] args) {
		PayrollProcess payrollProcess = new PayrollProcess();
		payrollProcess.process();
	}
	
	

}
