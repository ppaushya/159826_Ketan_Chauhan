package org.xyz.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.xyz.model.Address;
import org.xyz.model.Customer;
import org.xyz.util.IdGenerator;
import org.xyz.util.Validator;

public class UserInterface {

	static Scanner scanner = new Scanner(System.in);

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
	
	private static LocalDate getDateFromUser(String message) {
		String date="";
		while(!Validator.validateDate(date)) {
			System.out.println(message);
			date = scanner.next();
		}
		String dateParts[] = date.split("-");
		return LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
	}
	
	public static void printCustomers(List<Customer> customers) {
		System.out.println("CustomerId\tName\tEmail\t\tMobileNo");
		for(Customer customer:customers) {
			System.out.println(customer.getCustomerId()+"\t"+customer.getFirstName()+"\t"+customer.getEmailId()+"\t"+customer.getMobileNo());
		}
	}
}
