package org.xyz.dao;

import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.Customer;

public interface IAccountDao {
	
	public Set<Account> getAllAccounts();
	
	public Account getAccountFromAccountId(long accountId);
	
	public void createAccount(Account account);
}
