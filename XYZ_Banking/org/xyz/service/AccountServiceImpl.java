package org.xyz.service;

import java.util.Set;

import org.xyz.dao.IAccountDao;
import org.xyz.dao.AccountDaoImpl;
import org.xyz.model.Account;
import org.xyz.model.Customer;

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

	public Account getAccountFromAccountId(int accountId) {
		return accountDao.getAccountFromAccountId(accountId);
	}

}
