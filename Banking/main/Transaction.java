package main;

import java.time.LocalDate;

public class Transaction {

	private long transactionId;
	//long accountNo;
	private LocalDate transactionDate;
	private String transactionType;
	private double amount;
	//String transactionSummary;
	private Account account;
	
	public Transaction() {
		super();
	}

	public Transaction(int transactionId, LocalDate transactionDate, String transactionType, double amount,
			Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
		this.account = account;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/*@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + ", amount=" + amount + ", account=" + account + "]";
	}*/
	
	@Override
	public String toString() {
		return "Transaction: " + transactionId + "\tDate=" + transactionDate
				+ "\tType=" + transactionType + "\tAmount=" + amount + "\tAccount=" + account.getAccountType();
	}
	
	
}
