package ui;

import java.util.Scanner;

import main.Address;
import main.Customer;
import util.Validator;

public class AccountTransaction {
	static Scanner scanner = new Scanner(System.in);

	public static long generateAccountNo() {
		return (long)(Math.random()*100000);
	}
	
	public static long generatetransactionNo() {
		return (long)(Math.random()*1000000000);
	}
	
	public static Customer[] loadCustomer() {
		Customer[] customers = new Customer[5];
		
		Address address1 = new Address("North Avenue","Cross St","Chennai","IN");
		customers[0] = new Customer(1001,"Tom",address1,"1234567890","tom@mail.com");
		
		Address address2 = new Address("South Avenue","Cross St","Chennai","IN");
		customers[1] = new Customer(1002,"Jerry",address2,"7519243565","jerry@mail.com");
		
		Address address3 = new Address("West car st","Cross St","Chennai","IN");
		customers[2] = new Customer(1003,"Amit",address3,"7583692140","amit@mail.com");
		
		Address address4 = new Address("North Avenue","Cross St","Pune","IN");
		customers[3] = new Customer(1004,"Bharat",address4,"1234567890","bharat@mail.com");
		
		Address address5 = new Address("North Avenue","Cross St","Delhi","IN");
		customers[4] = new Customer(1005,"Chetan",address5,"0312456789","chetan@mail.com");
		
		return customers;
	}
	
	public static Customer promptCustomer(int id) {
		String name="";
		while(!Validator.validateName(name)) {
			System.out.println("Enter name: ");
			name = scanner.next();
		}
		
		System.out.println("Enter street name: ");
		String streenName = scanner.next();
		System.out.println("Enter area: ");
		String area = scanner.next();
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
		Address address = new Address(streenName,area,city,state);

		String mobile="";
		while(!Validator.validateMobileNumber(mobile)) {
			System.out.println("Enter mobile number: ");
			mobile = scanner.next();
		}
		String email="";
		while(!Validator.validateEmail(state)) {
			System.out.println("Enter email: ");
			email = scanner.next();
		}
		
		return new Customer(id,name,address,mobile,email);

//		Address address = new Address("streenName","area","city","state");
//		customers[id] = new Customer(id,"name",address,"mobile","email");
	}
	
	public static Customer promptCustomer() {
		Customer customer = new Customer();
		
		System.out.println("Enter Customer details: ");
		System.out.println("Enter customer id: ");
		customer.setCustomerId(scanner.nextInt());
		
		System.out.println("Enter name: ");
		customer.setName(scanner.next());

		Address address = new Address();
		System.out.println("Enter street name: ");
		address.setStreetName(scanner.next());
		System.out.println("Enter area: ");
		address.setArea(scanner.next());
		System.out.println("Enter city: ");
		address.setCity(scanner.next());
		System.out.println("Enter state: ");
		address.setState(scanner.next());
		customer.setAddress(address);

		System.out.println("Enter mobile: ");
		customer.setMobileNo(scanner.next());
		
		System.out.println("Enter email: ");
		customer.setEmailId(scanner.next());
		
		return customer;
	}
	
	public static void main(String[] args) {
		//System.out.println(generateAccountNo());

	}

}
