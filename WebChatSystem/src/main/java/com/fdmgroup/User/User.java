package com.fdmgroup.User;

/**
 * User represents a user of the Chat System 
 * All users must have a userID, userPassword, userAddress, postalCode, name and contactNumber;
 * 
 * @author Wei Jun
 * @version 1.0
 */
public class User {

	private String username;
	private String userPassword;
	private String userAddress;
	private int postalCode;
	private String name;
	private int contactNumber; 
	private String emailAddress;
	private String userType;
	


	/**
	 * Default Constructor method for User class
	 * 
	 */
	public User(){
		
	}

	
	/**
	 * Constructor for private instance variable userID, username, userPassword, userAddress, postalCode, name, contactNumber;
	 * @param userID set to user object
	 * @param username set to user object
	 * @param userPassword set to user object
	 * @param userAddress set to user object
	 * @param postalCode set to user object
	 * @param name set to user object
	 * @param contactNumber set to user object
	 */
	public User(String username, String userPassword, String emailAddress,
			String userAddress, int postalCode, String name,
			int contactNumber,  String userType) {
		super();
		this.username = username;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.postalCode = postalCode;
		this.name = name;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.userType = userType;
	}

	/**
	 * Getter method for private instance variable username
	 * @return username return from user object
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method for private instance variable username
	 * @param username set to user object
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter method for private instance variable password
	 * @return password return from user object
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * Setter method for private instance variable password
	 * @param password set to user object
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * Getter method for private instance variable userType
	 * @return userType return from user object
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * Setter method for private instance variable UserType
	 * @param userType set to user object
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	/**
	 * Getter method for private instance variable userAddress
	 * @return userAddress return from user object
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * Setter method for private instance variable userAddress
	 * @param userAddress set to user object
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * Getter method for private instance variable postalCode
	 * @return postalCode return from user object
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * Setter method for private instance variable postalCode
	 * @param postalCode set to user object
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Getter method for private instance variable name
	 * @return name return from user object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for private instance variable name
	 * @param name set to user object
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for private instance variable name
	 * @return name return from user object
	 */
	public int getContactNumber() {
		return contactNumber;
	}

	/**
	 * Setter method for private instance variable contactNumber
	 * @param contactNumber set to user object
	 */
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Getter method for private instance variable emailAddress
	 * @return emailAddress return from user object
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Setter method for private instance variable emailAddress
	 * @param emailAddress set to user object
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	



	@Override
	public String toString() {
		return "User [username=" + username + ", userPassword=" + userPassword + ", userAddress=" + userAddress
				+ ", postalCode=" + postalCode + ", name=" + name + ", contactNumber=" + contactNumber
				+ ", emailAddress=" + emailAddress + ", userType=" + userType + "]";
	}
}
