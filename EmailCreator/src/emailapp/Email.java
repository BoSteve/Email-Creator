package emailapp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companyFormat = "stevesproject.com";

	// Constructor for first and last name

	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Call a method asking for the department then return the department
		this.department = setDepartment();
		 
		//Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyFormat;
	}

	// Ask for department
	private String setDepartment() {
		System.out.print("New employee: " + firstName + " " + lastName + "\nDepartment Codes for new employees:\n1 for Sales\n2 for Development\n3 for Support\n0 for other\n>>Enter " + firstName + " " + lastName + "'s department code: ");
		Scanner scanner = new Scanner(System.in);
		int departmentChoice = scanner.nextInt();
		if (departmentChoice == 1) {
			return "sales";
		} else if (departmentChoice == 2) {
			return "development";
		} else if (departmentChoice == 3) {
			return "support";
		} else {
			return "general";
		}
		
	}
	// Generate random password

	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[] password = new char[length];
		for (int i =0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// set mailbox capacity

	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	// Change the password
	public void changePassword(String pass) {
		this.password = pass;
	}
	
	public int getMailboxCapacity() {
		return mailBoxCapacity;
	}
	
	public String getAltEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "NEW EMPLOYEE EMAIL ACCOUNT CREATED:" + "\nEMPLOYEE NAME: " + firstName + " " + lastName + " " + "\nCOMPANY EMAIL: " + email + " " + "\nEMPLOYEE PASSWORD: " + password + "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
		
	}
}
