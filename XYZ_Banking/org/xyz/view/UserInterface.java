package org.xyz.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.AccountType;
import org.xyz.model.Address;
import org.xyz.model.Customer;
import org.xyz.service.CustomerServiceImpl;
import org.xyz.service.ICustomerService;
import org.xyz.util.IdGenerator;
import org.xyz.util.Validator;

public class UserInterface {

	static Scanner scanner = new Scanner(System.in);
	static ICustomerService customerService = new CustomerServiceImpl();

	public static Customer promptCustomer() {
		Customer customer = new Customer();
		
		customer.setCustomerId(IdGenerator.generateAccountNumber());
		
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
		account.setAccountNumber(IdGenerator.generateAccountNumber());
		
		System.out.println();
		System.out.println("Enter account details:");
		AccountType accountType=null;
		int accountTypeNo;
		while(accountType==null) {
			System.out.println("Enter account type");
			printAllAccountTypes();
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
	
	public static void printAllAccountTypes() {
		AccountType[] accountTypes = AccountType.values();
		int count=0;
		for(AccountType accountType : accountTypes) {
			System.out.println((++count)+". "+accountType);
		}
	}
	
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
	
	private static LocalDate getDateFromUser(String message) {
		String date="";
		while(!Validator.validateDate(date)) {
			System.out.println(message);
			date = scanner.next();
		}
		String dateParts[] = date.split("-");
		return LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
	}
	
	public static int getTaskChoiceFromUser() {
		int choice=0;
		while(choice<1 || choice>4) {
			System.out.println();
			System.out.println();
			System.out.println("1. Create a new Customer");
			System.out.println("2. List Customers");
			System.out.println("3. Select Customer");
			System.out.println("4. Exit");
			System.out.println("Enter your choice[1,2,3,4]: ");
			choice = scanner.nextInt();
			if(choice<1 || choice>4) {
				System.out.println("Sorry! Invalid choice. Please try again!");
			}
		}
		return choice;
	}
	
	public static int getCustomerTaskChoiceFromUser() {
		int choice=0;
		while(choice<1 || choice>4) {
			System.out.println();
			System.out.println();
			System.out.println("1. Create a new Account");
			System.out.println("2. List Accounts");
			System.out.println("3. Select Account");
			System.out.println("4. Exit");
			System.out.println("Enter your choice[1,2,3,4]: ");
			choice = scanner.nextInt();
			if(choice<1 || choice>4) {
				System.out.println("Sorry! Invalid choice. Please try again!");
			}
		}
		return choice;
	}
	
	public static void printCustomers(List<Customer> customers) {
		System.out.println("CustomerId\tName\tEmail\t\tMobileNo");
		for(Customer customer:customers) {
			System.out.println(customer.getCustomerId()+"\t"+customer.getFirstName()+"\t"+customer.getEmailId()+"\t"+customer.getMobileNo());
		}
	}
	
	public static void printAccountsOfCustomer(Set<Account> accounts) {
		System.out.println("Available accounts: ");
		for(Account account:accounts) {
			System.out.println(account.getAccountNumber()+"\t"+account.getAccountType());
		}
	}
	
	public static Customer getCustomerFromCustomerId() {
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
	
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	public static boolean getRepeatConfirmation() {
		boolean shouldRepeat = false;
		System.out.println("Do you wish to continue? [y/n]:");
		String choice = scanner.next();
		shouldRepeat = choice.charAt(0)=='y' || choice.charAt(0)=='Y';
		return shouldRepeat;
	}
}
