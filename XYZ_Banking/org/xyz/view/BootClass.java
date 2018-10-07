package org.xyz.view;

import java.util.List;
import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.Customer;
import org.xyz.model.Transaction;
import org.xyz.service.AccountServiceImpl;
import org.xyz.service.CustomerServiceImpl;
import org.xyz.service.IAccountService;
import org.xyz.service.ICustomerService;
import org.xyz.service.ITransactionService;
import org.xyz.service.TransactionServiceImpl;

public class BootClass {

	static ICustomerService customerService = new CustomerServiceImpl();
	static ITransactionService transactionService = new TransactionServiceImpl();
	
	public static void main(String[] args) {

		handleTasks();
	}
	
	private static void handleTasks() {

		do {
			int choice = UserMenu.getTaskChoiceFromUser();
			switch (choice) {
				case 1:
					Customer customer = UserPrompt.promptCustomer();
					boolean success = customerService.createCustomer(customer);
					if(success) {
						UserDisplay.printMessage("Customer added successfully.");
					}else {
						UserDisplay.printMessage("Invalid customer.");
					}
					break;
				case 2:
					List<Customer> customers = customerService.getAllCustomers();
					UserDisplay.printCustomers(customers);
					break;
				case 3:
					Customer currentCustomer = UserPrompt.getCustomerFromPromptedCustomerId();
					handleCustomerTasks(currentCustomer);
					break;
				case 4:
					UserDisplay.printMessage("Thank you!");
					System.exit(0);
					break;
				default:
					break;
			}
		}while(UserMenu.getRepeatConfirmation());

		UserDisplay.printMessage("Thank you!");
		System.exit(0);
	}
	
	private static void handleCustomerTasks(Customer currentCustomer) {
		IAccountService accountService = new AccountServiceImpl(currentCustomer);
		
		do {
			int totalAccounts = currentCustomer.getAccounts().size();
			int choice = UserMenu.getCustomerTaskChoiceFromUser();
			switch (choice) {
				case 1:
					Account account = UserPrompt.promptAccount();
					boolean success = accountService.createAccount(account);
					if(success) {
						UserDisplay.printMessage("Account added successfully.");
					}else {
						UserDisplay.printMessage("Invalid account.");
					}
					break;
				case 2:
					if(totalAccounts>0) {
						UserDisplay.printAccountsOfCustomer(currentCustomer);
						Account currentAccount = UserPrompt.getAccountFromPromptedAccountId(accountService);
						handleTransactionTasks(currentCustomer,currentAccount,accountService.getCurrentBalanceOfAccount(currentAccount));
					}else {
						UserDisplay.printMessage("No account present.");
					}
					break;
				case 3:
					if(totalAccounts>0) {
						UserDisplay.printTransactionsOfCustomer(transactionService.getAllTransactionsOfCustomer(currentCustomer));
					}else {
						UserDisplay.printMessage("No account present.");
					}
					break;
				case 4:
					if(totalAccounts>0) {
						UserDisplay.printAccountsOfCustomer(currentCustomer);
						Account acc = UserPrompt.getAccountFromPromptedAccountId(accountService);
						UserDisplay.printCurrentBalance(accountService.getCurrentBalanceOfAccount(acc));
					}else {
						UserDisplay.printMessage("No account present.");
					}break;
				case 5:
					return;
				default:
					break;
			}
		}while(UserMenu.getRepeatConfirmation());
	}

	private static void handleTransactionTasks(Customer currentCustomer,Account account,double currentBalance) {
		
		int choice = UserMenu.getTransactionTypeChoiceFromUser();
		switch (choice) {
			case 1:
				Transaction transactionDebit = UserPrompt.promptTransaction(account,currentBalance, 1);
				if(transactionDebit!=null) {
					transactionService.createTransaction(transactionDebit);
				}else {
					UserDisplay.printMessage("Insufficient balance");
				}
				break;
			case 2:
				Transaction transactionCredit = UserPrompt.promptTransaction(account,currentBalance, 2);
				transactionService.createTransaction(transactionCredit);
				break;
			case 3:
				return;
			default:
				break;
		}
	}
}
