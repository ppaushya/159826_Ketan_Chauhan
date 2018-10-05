package ui;

import java.util.ArrayList;
import java.util.Scanner;

import org.xyz.util.Validator;

import main.Address;
import main.Customer;
import main.CustomerOld;

public class AccountTransaction {
	static Scanner scanner = new Scanner(System.in);

	public static long generateAccountNo() {
		long number=10000000;
		boolean sucess = false;
		while(!sucess) {
			number = (long)(Math.random()*10000000);
			sucess = Validator.validateAccountNumber(String.valueOf(number));
		}
		return number;
	}	
	
	/*public static long generateAccountNo() {
		return (long)Math.random()*10000000;
	}*/
	
	public static long generatetransactionNo() {
		return (long)(Math.random()*1000000000);
	}
	
	public static CustomerOld[] loadCustomerArray() {
		CustomerOld[] customers = new CustomerOld[5];
		
		Address address1 = new Address("North Avenue","Cross St","Chennai","IN");
		customers[0] = new CustomerOld(1001,"Tom",address1,"1234567890","tom@mail.com");
		
		Address address2 = new Address("South Avenue","Cross St","Chennai","IN");
		customers[1] = new CustomerOld(1002,"Jerry",address2,"7519243565","jerry@mail.com");
		
		Address address3 = new Address("West car st","Cross St","Chennai","IN");
		customers[2] = new CustomerOld(1003,"Amit",address3,"7583692140","amit@mail.com");
		
		Address address4 = new Address("North Avenue","Cross St","Pune","IN");
		customers[3] = new CustomerOld(1004,"Bharat",address4,"1234567890","bharat@mail.com");
		
		Address address5 = new Address("North Avenue","Cross St","Delhi","IN");
		customers[4] = new CustomerOld(1005,"Chetan",address5,"0312456789","chetan@mail.com");
		
		return customers;
	}
	
	public static ArrayList<Customer> loadCustomer() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Address address1 = new Address("North Avenue","Cross St","Chennai","IN");
		customers.add(new Customer(1001,"Tom",address1,"1234567890","tom@mail.com"));
		
		Address address2 = new Address("South Avenue","Cross St","Chennai","IN");
		customers.add(new Customer(1002,"Jerry",address2,"7519243565","jerry@mail.com"));
		
		Address address3 = new Address("West car st","Cross St","Chennai","IN");
		customers.add(new Customer(1003,"Amit",address3,"7583692140","amit@mail.com"));
		
		Address address4 = new Address("North Avenue","Cross St","Pune","IN");
		customers.add(new Customer(1004,"Bharat",address4,"1234567890","bharat@mail.com"));
		
		Address address5 = new Address("North Avenue","Cross St","Delhi","IN");
		customers.add(new Customer(1005,"Chetan",address5,"0312456789","chetan@mail.com"));
		
		/*for(int i=0;i<5;i++) {
			customers.add(promptCustomer(i));
		}*/
		
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
		while(!Validator.validateEmail(email)) {
			System.out.println("Enter email: ");
			email = scanner.next();
		}
		
		return new Customer(id,name,address,mobile,email);

//		Address address = new Address("streenName","area","city","state");
//		customers[id] = new Customer(id,"name",address,"mobile","email");
	}
	
}
