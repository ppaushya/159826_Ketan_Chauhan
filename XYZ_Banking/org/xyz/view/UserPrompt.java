package org.xyz.view;

import java.time.LocalDate;
import java.util.Scanner;

import org.xyz.model.Account;
import org.xyz.model.AccountType;
import org.xyz.model.Address;
import org.xyz.model.Customer;
import org.xyz.model.Transaction;
import org.xyz.service.AccountServiceImpl;
import org.xyz.service.CustomerServiceImpl;
import org.xyz.service.IAccountService;
import org.xyz.service.ICustomerService;
import org.xyz.util.Validator;

public class UserPrompt {

	static Scanner scanner = new Scanner(System.in);
	static ICustomerService customerService = new CustomerServiceImpl();

	public static Customer promptCustomer() {
		Customer customer = new Customer();
				
		String firstName="";
		while(!Validator.validateName(firstName)) {
			System.out.println("Enter first name: ");
			firstName = scanner.next();
		}
		customer.setFirstName(firstName);
		
		String lastName="";
		while(!Validator.validateName(lastName)) {
			System.out.println("Enter last name: ");
			lastName = scanner.next();
		}
		customer.setLastName(lastName);

		LocalDate dateOfBirth = getDateFromUser("Enter date of birth: ");
		customer.setDateOfBirth(dateOfBirth);
		
		String email="";
		while(!Validator.validateEmail(email)) {
			System.out.println("Enter email: ");
			email = scanner.next();
		}
		customer.setEmailId(email);
		
		String mobile="";
		while(!Validator.validateMobileNumber(mobile)) {
			System.out.println("Enter mobile number: ");
			mobile = scanner.next();
		}
		customer.setMobileNo(mobile);
		
		System.out.println("Enter address line 1: ");
		System.out.print("");
		String addressLine1 = scanner.next();
		System.out.print("");
		System.out.println("Enter address line 2: ");
		String addressLine2 = scanner.next();
		String city="";
		while(!Validator.validateCity(city)) {
			System.out.println("Enter city: ");
			city = scanner.next();
		}
		String state="";
		while(!Validator.validateState(state)) {
			System.out.println("Enter state: ");
			state = scanner.next();
		}
		String pinCode="";
		while(!Validator.validatePinCode(pinCode)) {
			System.out.println("Enter pincode: ");
			pinCode = scanner.next();
		}
		Address address = new Address(addressLine1,addressLine2,city,state,pinCode);
		customer.setAddress(address);
		
		return customer;
	}
	
	public static Account promptAccount() {
		Account account = new Account();
		
		System.out.println();
		System.out.println("Enter account details:");
		AccountType accountType=null;
		int accountTypeNo;
		while(accountType==null) {
			System.out.println("Enter account type");
			UserDisplay.printAllAccountTypes();
			accountTypeNo = scanner.nextInt();
			accountType = getAccountTypeFromValue(accountTypeNo);
		}
		account.setAccountType(accountType);
		
		account.setOpeningDate(getDateFromUser("Enter account opening date[dd-mm-yyyy]:"));
		
		System.out.println("Enter account opening balance:");
		double balance = scanner.nextDouble();
		account.setOpeningBalance(balance);
		
		System.out.println(account.toString());
		return account;
	}
	
	public static Transaction promptTransaction(Account account,double currentBalance,int transactionChoice) {
		Transaction transaction = new Transaction();
		
		transaction.setTransactionDate(LocalDate.now());
		transaction.setFromAccount(account);
		transaction.setToAccount(account);
		
		System.out.println("Enter amount: ");
		double amount = scanner.nextDouble();
		
		if(transactionChoice==1) {
			if(currentBalance<amount) {
				return null;
			}
			transaction.setTransactionType("Debit");
		}else if (transactionChoice==2) {
			transaction.setTransactionType("Credit");
		}
		transaction.setAmount(amount);
		
		System.out.println(transaction);
		return transaction;
	}
	
	public static Transaction promptFundTransferTransaction(Customer currentCustomer,Account account,double currentBalance,IAccountService accountService) {
		Transaction transaction = new Transaction();
		
		transaction.setTransactionDate(LocalDate.now());
		transaction.setFromAccount(account);
		
		System.out.println("Enter amount: ");
		double amount = scanner.nextDouble();
		
		if(currentBalance<amount) {
			return null;
		}
		transaction.setTransactionType("Fund Transfer");
		System.out.println("Choose account:");
		UserDisplay.printAccountsOfCustomer(currentCustomer);
		Account toAccount = getAccountFromPromptedAccountId(accountService);
		transaction.setToAccount(toAccount);
		
		transaction.setAmount(amount);
		
		System.out.println(transaction);
		return transaction;
	}
	
	public static Customer getCustomerFromPromptedCustomerId() {
		Customer customer=null;
		
		while(customer==null) {
			System.out.println("Choose customer id: ");
			long customerId = scanner.nextLong();
			customer = customerService.getCustomerFromCustomerId(customerId);
			if(customer==null) {
				System.out.println("Invalid customer id");
			}
		}
		return customer;
	}
	
	public static Account getAccountFromPromptedAccountId(IAccountService accountService) {
		Account account=null;
		
		while(account==null) {
			System.out.println("Choose account id: ");
			long accountId = scanner.nextLong();
			account = accountService.getAccountFromAccountId(accountId);
			if(account==null) {
				System.out.println("Invalid account id");
			}
		}
		return account;
	}
	
	private static LocalDate getDateFromUser(String message) {
		String date="";
		while(!Validator.validateDate(date)) {
			System.out.println(message);
			date = scanner.next();
		}
		String dateParts[] = date.split("-");
		return LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
	}
	
	//Other
	public static AccountType getAccountTypeFromValue(int value) {
		switch (value) {
			case 1:
				return AccountType.SAVING;
			case 2:
				return AccountType.CURRENT;
			case 3:
				return AccountType.RD;
			case 4:
				return AccountType.FD;
			default:
				System.out.println("Invalid Account type");
				return null;
		}
	}
}
