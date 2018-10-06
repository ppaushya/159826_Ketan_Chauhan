package org.xyz.view;

import java.util.List;
import java.util.Set;

import org.xyz.model.Account;
import org.xyz.model.Customer;
import org.xyz.service.AccountServiceImpl;
import org.xyz.service.CustomerServiceImpl;
import org.xyz.service.IAccountService;
import org.xyz.service.ICustomerService;

public class BootClass {

	public static void main(String[] args) {

//		Customer customer = UserInterface.promptCustomer();
//		System.out.println(customer.getCustomerDetails());
		
		ICustomerService customerService = new CustomerServiceImpl();

		do {
			int choice = UserInterface.getTaskChoiceFromUser();
			switch (choice) {
				case 1:
					Customer customer = UserInterface.promptCustomer();
					boolean success = customerService.createCustomer(customer);
					if(success) {
						UserInterface.printMessage("Customer added successfully.");
					}else {
						UserInterface.printMessage("Invalid customer.");
					}
					break;
				case 2:
					List<Customer> customers = customerService.getAllCustomers();
					UserInterface.printCustomers(customers);
					break;
				case 3:
					Customer currentCustomer = UserInterface.getCustomerFromCustomerId();
					handleCustomerTasks(currentCustomer);
					break;
				case 4:
					UserInterface.printMessage("Thank you!");
					System.exit(0);
					break;
				default:
					break;
			}
		}while(UserInterface.getRepeatConfirmation());

		UserInterface.printMessage("Thank you!");
		System.exit(0);
		
	}
	
	private static void handleCustomerTasks(Customer currentCustomer) {
		IAccountService accountService = new AccountServiceImpl(currentCustomer);
		
		do {
			int choice = UserInterface.getCustomerTaskChoiceFromUser();
			switch (choice) {
				case 1:
					Account account = UserInterface.promptAccount();
					boolean success = accountService.createAccount(account);
					if(success) {
						UserInterface.printMessage("Account added successfully.");
					}else {
						UserInterface.printMessage("Invalid account.");
					}
					break;
				case 2:
					Set<Account> accounts = accountService.getAllAccounts();
					UserInterface.printAccountsOfCustomer(accounts);
					break;
				case 3:
					
					break;
				case 4:
					UserInterface.printMessage("Thank you!");
					System.exit(0);
					break;
				default:
					break;
			}
		}while(UserInterface.getRepeatConfirmation());
	}

}
