package org.xyz.view;

import java.util.List;
import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.AccountType;
import org.xyz.model.Customer;
import org.xyz.model.Transaction;
import org.xyz.service.AccountServiceImpl;
import org.xyz.service.IAccountService;

public class UserDisplay {

	public static void printCustomers(List<Customer> customers) {
		System.out.println("---------------------------------------------------------");
		System.out.println("CustomerId\tName\tEmail\t\tMobileNo");
		System.out.println("---------------------------------------------------------");
		for(Customer customer:customers) {
			System.out.println(customer.getCustomerId()+"\t"+customer.getFirstName()+"\t"+customer.getEmailId()+"\t"+customer.getMobileNo());
		}
		System.out.println("---------------------------------------------------------");
	}
	
	public static void printAccountsOfCustomer(Customer customer) {
		Set<Account> accounts = customer.getAccounts();
		System.out.println("Available accounts: ");
		for(Account account:accounts) {
			System.out.println(account.getAccountNumber()+"\t"+account.getAccountType());
		}
	}
	
	public static void printTransactionsOfCustomer(Set<Transaction> transactions) {		
		System.out.println("---------------------------------------------------------");
		System.out.println("Date\t\tAccount\t\tTransaction\tAmount");
		System.out.println("---------------------------------------------------------");
		for(Transaction transaction:transactions) {
			String str = transaction.getTransactionDate()
					+"\t"+transaction.getFromAccount().getAccountNumber()
					+"\t"+transaction.getTransactionType()
					+"\t\t"+transaction.getAmount();
			System.out.println(str);
		}
		System.out.println("---------------------------------------------------------");
	}
	
	public static void printCurrentBalance(double balance) {
		System.out.println("Current balance: "+balance);
	}
	
	public static void printAllAccountTypes() {
		AccountType[] accountTypes = AccountType.values();
		int count=0;
		for(AccountType accountType : accountTypes) {
			System.out.println((++count)+". "+accountType);
		}
	}
	
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
