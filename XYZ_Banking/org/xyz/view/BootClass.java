package org.xyz.view;

import java.util.List;

import org.xyz.model.Customer;
import org.xyz.service.CustomerServiceImpl;
import org.xyz.service.ICustomerService;

public class BootClass {

	public static void main(String[] args) {

//		Customer customer = UserInterface.promptCustomer();
//		System.out.println(customer.getCustomerDetails());
		
		ICustomerService customerService = new CustomerServiceImpl();
		List<Customer> customers = customerService.getAllCustomers();
		UserInterface.printCustomers(customers);
	}

}
