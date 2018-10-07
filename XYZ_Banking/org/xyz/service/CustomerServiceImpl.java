package org.xyz.service;

import java.time.LocalDate;
import java.util.List;

import org.xyz.dao.CustomerDaoImpl;
import org.xyz.dao.ICustomerDao;
import org.xyz.model.Customer;

public class CustomerServiceImpl implements ICustomerService{

	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	public boolean createCustomer(Customer customer) {
		if(isValidCustomer(customer)) {
			customerDao.createCustomer(customer);
			return true;
		}else {
			return false;
		}
	}

	private boolean isValidCustomer(Customer customer) {
		boolean success = false;
		if(customer.getDateOfBirth().isBefore(LocalDate.now())) {
			if(customer.getMobileNo().matches("[7-9]{1}\\d{9}")) {
				success = true;
			}else {
				success = false;
			}
		}
		return success;
	}

	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerFromCustomerId(long customerId) {
		return customerDao.getCustomerFromCustomerId(customerId);
	}
}
