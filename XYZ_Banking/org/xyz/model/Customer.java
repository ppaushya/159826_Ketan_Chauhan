package org.xyz.model;

import java.time.LocalDate;
import java.util.Set;

public class Customer {

	private long customerId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String emailId;
	private String mobileNo;
	private Address address;
	private Set<Account> accounts;
	
	public Customer() {
		super();
	}
	
	public Customer(long customerId, String firstName, String lastName, LocalDate dateOfBirth, String emailId,
			String mobileNo, Address address, Set<Account> accounts) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.address = address;
		this.accounts = accounts;
	}

	public Customer(long customerId, String firstName, String lastName, LocalDate dateOfBirth, String emailId,
			String mobileNo, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public String getCustomerDetails() {
		return "***Customer Details***\nCustomer Id: " + customerId + "\nFirst Name: " + firstName + "\nLast Name: " + lastName
				+ "\nDate Of Birth: " + dateOfBirth + "\nEmail Id: " + emailId + "\nMobile Number: " + mobileNo + "\nAddress: "
				+ address + "\nAccounts: " + accounts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", address="
				+ address + ", accounts=" + accounts + "]";
	}
	
	
	
}
