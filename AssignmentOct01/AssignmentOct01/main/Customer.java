package main;

public class Customer {
	
	int customerId;
	String name;
	Address address;
	Account accounts[];
	String mobileNo;
	String emailId;
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String name, Address address, Account[] accounts, String mobileNo, String emailId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.accounts = accounts;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
}
