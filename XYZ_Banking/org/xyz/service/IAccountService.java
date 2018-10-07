package org.xyz.service;

import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.Customer;

public interface IAccountService {

	public boolean createAccount(Account account) ;
	
	public Set<Account> getAllAccounts();
	
	public Account getAccountFromAccountId(long accountId);

	public double getCurrentBalanceOfAccount(Account account);
}
