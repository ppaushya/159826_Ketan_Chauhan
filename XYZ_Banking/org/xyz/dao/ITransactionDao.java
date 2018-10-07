package org.xyz.dao;

import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.Customer;
import org.xyz.model.Transaction;

public interface ITransactionDao {
	
	public Set<Transaction> getAllTransactions();
	
	public Set<Transaction> getAllTransactionsOfCustomer(Customer customer);
	
	public Set<Transaction> getAllTransactionsOfAccount(Account Account);
		
	public void createTransaction(Transaction transaction);
}
