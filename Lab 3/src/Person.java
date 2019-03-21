/**
 * File name: Person.java
 * Author: Minh Duc Pham, 040905103
 * Course: CST8132-OOP
 * Assignment: 4
 * Date: February 9th
 * Professor: Angela Giddings
 * Purpose: hold informations about persons                                                
 *
 */

/**
 * @author Minh-Duc Pham
 * @version 1
 * @since 1.8.0	_144
 */
public class Person {

	/**
	 * First Name
	 */
	private String firstName;
	/**
	 * Last Name
	 */
	private String lastName;
	/**
	 * Phone Number
	 */
	private long phoneNum;
	/**
	 * Email Address
	 */
	private String emailAddress;

	/**
     * Constructor for Person class
     * @param fName The user's first name
     * @param lName The user's last name
     * @param phone The user's phone number
     * @param email The user's email address
     */
	public Person(String fName, String lName, long phone, String email){
		firstName=fName;
		lastName=lName;
		phoneNum=phone;
		emailAddress=email;
	}
	
	/**
     * Method uses to get a person's first and last name
     * @return User's full names
     */
	public String getName() {
		return firstName + " " + lastName;

	}// end of getName()

	/**
     * Method uses to get a person's phone number
     * @return User's phone number
     */
	public long getPhoneNumber() {
		return phoneNum;

	}// end of getPhoneNumber()
	
	/**
     * Method uses to get a person's email address
     * @return User's email address
     */
	public String getEmailAddress() {
		return emailAddress;

	}// end of getEmailAddress



}
