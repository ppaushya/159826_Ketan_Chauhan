package org.xyz.service;

import java.util.Set;

import org.xyz.dao.IAccountDao;
import org.xyz.dao.ITransactionDao;
import org.xyz.dao.TransactionDaoImpl;
import org.xyz.model.Account;
import org.xyz.model.Customer;
import org.xyz.model.Transaction;

public class TransactionServiceImpl implements ITransactionService{
	
	ITransactionDao transactionDao = new TransactionDaoImpl();
	
	@Override
	public Set<Transaction> getAllTransactions() {
		return transactionDao.getAllTransactions();
	}
	
	@Override
	public Set<Transaction> getAllTransactionsOfCustomer(Customer customer) {
		return transactionDao.getAllTransactionsOfCustomer(customer);
	}
	
	@Override
	public Set<Transaction> getAllTransactionsOfAccount(Account Account) {
		return transactionDao.getAllTransactionsOfAccount(Account);
	}
	
	@Override
	public void createTransaction(Transaction transaction) {
		transactionDao.createTransaction(transaction);		
	}

}
