/* File name: Person.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 2
 * Date: April 20th
 * Professor: Angela Giddings                                              
 */

/**
 * Hold informations about persons  
 * @author Minh Duc Pham
 * @version 1
 * @since 1.8.0	_144
 */
public class Person {

	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String email;
	
	/**
	 * Argumented constructor. Initialize value
	 * @param firstName The account holder's first name
	 * @param lastName The account holder's last name
	 * @param phoneNumber The account holder's phone number
	 * @param email The account holder's email
	 */
	public Person(String firstName, String lastName, long phoneNumber, String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	}
	
	/**
	 * Method used to get account holder's first and last name
	 * @return Account holder's first and last name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * Method used to get account holder's phone number
	 * @return Account holder's phone number
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Method used to get account holder's email
	 * @return Account holder's email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Method used to print account holder's information
	 */
	public String toString() {
		return "Name: " + getName() + "  Phone: " + phoneNumber + "  Email: " + email;
	}
	
	
}
