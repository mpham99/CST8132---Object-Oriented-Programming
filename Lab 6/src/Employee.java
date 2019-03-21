/* File name: Employee.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 16th
 * Professor: Angela Giddings                                              
 */

/**
 * Contain
 * @author Minh-Duc Pham
 * @version 1
 * @since 1.8.0_144
 */
public abstract class Employee {
	
	/**
	 * The hourly rate
	 */
	protected double hRate;
	
	/**
	 * The working hour per week
	 */
	protected double hPerWeek;
	
	/**
	 * The employee's name
	 */
	protected String name;
	
	/**
	 * Constructor
	 * @param n The employee's name
	 */
	public Employee(String n) {
		this.name = n;
	}
	/**
	 * Method to print out payment message
	 */
	public abstract void payment();
	
	/**
	 * Method to calculate weekly salary 
	 * @return
	 */
	public abstract double calculate();

}
