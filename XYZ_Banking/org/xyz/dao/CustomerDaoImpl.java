package org.xyz.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.xyz.model.Address;
import org.xyz.model.Customer;
import org.xyz.util.IdGenerator;


public class CustomerDaoImpl implements ICustomerDao{

	private static List<Customer> customers = dummyDB();
	
	private static List<Customer> dummyDB() {
		List<Customer> customers = new ArrayList<Customer>();
		
		Address address1 = new Address("North Avenue","Cross St","Chennai","IN","122345");
		customers.add(new Customer(IdGenerator.generateCustomerNumber(),"Tom","Smith",LocalDate.of(1985, 3, 15),"tom@mail.com","1234567890",address1));
		
		Address address2 = new Address("South Avenue","Cross St","Chennai","IN","122345");
		customers.add(new Customer(IdGenerator.generateCustomerNumber(),"Jerry","Bill",LocalDate.of(2005, 9, 1),"jerry@mail.com","7519243565",address2));
		
		Address address3 = new Address("West car st","Cross St","Chennai","IN","122345");
		customers.add(new Customer(IdGenerator.generateCustomerNumber(),"Amit","Patel",LocalDate.of(1990, 4, 30),"amit@mail.com","7583692140",address3));
		
		Address address4 = new Address("North Avenue","Cross St","Pune","IN","122345");
		customers.add(new Customer(IdGenerator.generateCustomerNumber(),"Bharat","Shah",LocalDate.of(1995, 5, 5),"bharat@mail.com","1234567890",address4));
		
		Address address5 = new Address("North Avenue","Cross St","Delhi","IN","122345");
		customers.add(new Customer(IdGenerator.generateCustomerNumber(),"Chetan","Parmar",LocalDate.of(2000, 12, 19),"chetan@mail.com","0312456789",address5));
		
		return customers;
	}
	
	public List<Customer> getAllCustomers() {
		return customers;
	}

	public void createCustomer(Customer customer) {
		customer.setCustomerId(IdGenerator.generateCustomerNumber());
		customers.add(customer);
		
	}

	public Customer getCustomerFromCustomerId(long customerId) {
		for(Customer customer:customers) {
			if(customer.getCustomerId()==customerId) {
				return customer;
			}
		}
		return null;
	}


}
