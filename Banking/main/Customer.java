package main;

import java.util.ArrayList;

public class Customer {
	
	private int customerId;
	private String name;
	private Address address;
//	private Account accounts[]=new Account[5];
	private ArrayList<Account> accounts=new ArrayList<>();
	private String mobileNo;
	private String emailId;
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String name, Address address, String mobileNo, String emailId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	
	public Customer(int customerId, String name, Address address, ArrayList<Account> accounts, String mobileNo, String emailId) {
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

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", accounts="
				+ accounts + ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]";
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public int getNoOfAccount() {
		return this.accounts.size();
	}
	
}
