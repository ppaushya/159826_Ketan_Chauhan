package org.xyz.dao;

import java.util.List;

import org.xyz.model.Customer;

public interface ICustomerDao {

	public List<Customer> getAllCustomers();
	
	public void createCustomer(Customer customer);
}
