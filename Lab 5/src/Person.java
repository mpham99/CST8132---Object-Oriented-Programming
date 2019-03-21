/* File name: Person.java
 * Author: Minh Duc Pham
 * Course: CST8132-OOP
 * Assignment: 1
 * Date: March 9th
 * Professor: Angela Giddings                                              
 */

/**
 * Hold informations about persons  
 * @author Minh Duc Pham
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
	private String phoneNum;
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
	public Person(String fName, String lName, String phone, String email){
		this.firstName=fName;
		this.lastName=lName;
		this.phoneNum=phone;
		this.emailAddress=email;
	}

	/**
	 * Method uses to get a person's first and last name
	 * @return User's full names
	 */
	public String getName() {
		return this.firstName + " " + this.lastName;
	}// end of getName()

	/**
	 * Method uses to get a person's phone number
	 * @return User's phone number
	 */
	public String getPhoneNumber() {
		return this.phoneNum;

	}// end of getPhoneNumber()

	/**
	 * Method uses to get a person's email address
	 * @return User's email address
	 */
	public String getEmailAddress() {
		return this.emailAddress;

	}// end of getEmailAddress

}