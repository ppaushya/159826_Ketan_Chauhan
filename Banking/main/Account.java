package main;

import java.time.LocalDate;
import java.util.ArrayList;

import util.AccountType;

public class Account {
	
	private long accountNo;
	private AccountType accountType;
	private LocalDate openingDate;
	private double openingBalance;
	
	public Account() {
		super();
	}
	
	public Account(long accountNo, AccountType accountType, LocalDate openingDate, double openingBalance) {
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
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	
	public double getOpeningBalance() {
		return openingBalance;
	}
	
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", openingDate=" + openingDate
				+ ", openingBalance=" + openingBalance + "]";
	}
	
	/*public double getCurrentBalance() {
		//TODO 
		return openingBalance;
	}*/
	
	public double getCurrentBalanceAfterTransactions(Transaction[] transactions) {
		double balance = openingBalance;
		for(int i=0;i<transactions.length;i++) {
			if(transactions[i]!=null) {
				if(transactions[i].getTransactionType().equals("Debit")) {
					balance -= transactions[i].getAmount();
				}else if(transactions[i].getTransactionType().equals("Credit")) {
					balance += transactions[i].getAmount();
				}
			}
		}
		return balance;
	}
	
	public double getCurrentBalanceAfterTransactions(ArrayList<Transaction> transactions) {
		double balance = openingBalance;
		for(Transaction transaction:transactions) {
			if(transaction.getTransactionType().equals("Debit")) {
				balance -= transaction.getAmount();
			}else if(transaction.getTransactionType().equals("Credit")) {
				balance += transaction.getAmount();
			}
		}
		return balance;
	}
}
