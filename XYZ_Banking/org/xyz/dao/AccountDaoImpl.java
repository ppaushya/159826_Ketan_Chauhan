package org.xyz.dao;

import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.Customer;
import org.xyz.util.IdGenerator;

public class AccountDaoImpl implements IAccountDao{

	private Customer customer;
	
	public AccountDaoImpl(Customer customer) {
		super();
		this.customer = customer;
	}

	public Set<Account> getAllAccounts() {
		return customer.getAccounts();
	}

	public Account getAccountFromAccountId(long accountId) {
		Set<Account> accounts = customer.getAccounts();
		for(Account account:accounts) {
			if(account!=null) {
				if(account.getAccountNumber()==accountId) {
					return account;
				}
			}
		}
		return null;
	}

	public void createAccount(Account account) {
		account.setAccountNumber(IdGenerator.generateAccountNumber());
		customer.getAccounts().add(account);
	}

}
