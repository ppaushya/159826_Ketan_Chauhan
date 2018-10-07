package org.xyz.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.Customer;
import org.xyz.model.Transaction;
import org.xyz.util.IdGenerator;

public class TransactionDaoImpl implements ITransactionDao{

	private static Set<Transaction> transactions = new HashSet<>();
	
	@Override
	public Set<Transaction> getAllTransactions() {
		return transactions;
	}

	@Override
	public Set<Transaction> getAllTransactionsOfCustomer(Customer customer) {
		Set<Account> customerAccounts = customer.getAccounts();
		
		Set<Transaction> customerTransactions = new HashSet<>();
		
		for(Transaction transaction:transactions) {
			if(customerAccounts.contains(transaction.getFromAccount())) {
				customerTransactions.add(transaction);
			}
		}
		
		return customerTransactions;
	}

	@Override
	public Set<Transaction> getAllTransactionsOfAccount(Account Account) {
		Set<Transaction> customerTransactions = new HashSet<>();
		
		for(Transaction transaction:transactions) {
			if(transaction.getFromAccount().equals(Account)) {
				customerTransactions.add(transaction);
			}
		}
		
		return customerTransactions;
	}

	@Override
	public void createTransaction(Transaction transaction) {
		transaction.setTransactionId(IdGenerator.generateTransactionNumber());
		transactions.add(transaction);
		
	}

}
