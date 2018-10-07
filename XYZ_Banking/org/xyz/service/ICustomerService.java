package org.xyz.service;

import java.util.List;

import org.xyz.model.Customer;

public interface ICustomerService {

	public boolean createCustomer(Customer customer) ;
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerFromCustomerId(long customerId);
}
