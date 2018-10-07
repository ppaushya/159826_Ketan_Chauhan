package org.xyz.service;

import java.util.Set;

import org.xyz.dao.IAccountDao;
import org.xyz.dao.ITransactionDao;
import org.xyz.dao.TransactionDaoImpl;
import org.xyz.dao.AccountDaoImpl;
import org.xyz.model.Account;
import org.xyz.model.Customer;
import org.xyz.model.Transaction;

public class AccountServiceImpl implements IAccountService{

	Customer customer;
	IAccountDao accountDao;
	
	public AccountServiceImpl(Customer customer) {
		super();
		this.customer = customer;
		accountDao = new AccountDaoImpl(customer);
	}

	public boolean createAccount(Account account) {
		accountDao.createAccount(account);
		return true;
	}

	public Set<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	public Account getAccountFromAccountId(long accountId) {
		return accountDao.getAccountFromAccountId(accountId);
	}

	@Override
	public double getCurrentBalanceOfAccount(Account account) {
		ITransactionDao transactionDao = new TransactionDaoImpl();
		Set<Transaction> transactions = transactionDao.getAllTransactionsOfAccount(account);
		double balance = account.getOpeningBalance();
		for(Transaction transaction:transactions) {
			if(transaction.getTransactionType().equals("Credit")) {
				balance += transaction.getAmount();
			}else if(transaction.getTransactionType().equals("Debit")){
				balance -= transaction.getAmount();
			}
		}
		return balance;
	}

}
