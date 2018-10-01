package main;

import java.util.Date;

public class Account {
	
	private long accountNo;
	private String accountType;
	private Date openingDate;
	private double openingBalance;
	
	public Account() {
		super();
	}
	
	public Account(long accountNo, String accountType, Date openingDate, double openingBalance) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.openingBalance = openingBalance;
	}
	
	public long getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public Date getOpeningDate() {
		return openingDate;
	}
	
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	
	public double getOpeningBalance() {
		return openingBalance;
	}
	
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	
}
