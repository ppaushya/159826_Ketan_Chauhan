package main;

import java.util.Arrays;

public class CustomerOld {
	
	private int customerId;
	private String name;
	private Address address;
	private Account accounts[]=new Account[5];
	private String mobileNo;
	private String emailId;
	
	public CustomerOld() {
		super();
	}
	
	public CustomerOld(int customerId, String name, Address address, String mobileNo, String emailId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	
	public CustomerOld(int customerId, String name, Address address, Account[] accounts, String mobileNo, String emailId) {
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", accounts="
				+ Arrays.toString(accounts) + ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]";
	}
	
	public void addAccount(Account account) {
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i]==null) {
				accounts[i]=account;
				break;
			}
		}
	}
	
	public int getNoOfAccount() {
		int count=0;
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i]!=null) {
				count++;
			}
		}
		return count;
	}
	
}
