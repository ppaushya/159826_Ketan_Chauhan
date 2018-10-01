package main;

import java.util.Date;

public class Transaction {

	int transactionId;
	long accountNo;
	Date transactionDate;
	char transactionType;
	double amount;
	String transactionSummary;
	
	public Transaction() {
		super();
	}
	
	public Transaction(int transactionId, long accountNo, Date transactionDate, char transactionType, double amount,
			String transactionSummary) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionSummary = transactionSummary;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public long getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public char getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(char transactionType) {
		this.transactionType = transactionType;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getTransactionSummary() {
		return transactionSummary;
	}
	
	public void setTransactionSummary(String transactionSummary) {
		this.transactionSummary = transactionSummary;
	}
	
	
}
