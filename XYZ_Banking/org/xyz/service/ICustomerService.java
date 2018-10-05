package org.xyz.service;

import java.util.List;

import org.xyz.model.Customer;

public interface ICustomerService {

	public void createCustomer(Customer customer) ;
	
	public List<Customer> getAllCustomers();
}
