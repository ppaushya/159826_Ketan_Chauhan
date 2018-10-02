package ui;

import java.util.Date;
import java.util.Scanner;

import main.Account;
import main.Address;
import main.Customer;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Customer customers[] = new Customer[5];
	static Customer current;
	
	public static void addCustomer(int id) {
		/*System.out.println("Enter name: ");
		String name = scanner.next();

		System.out.println("Enter street name: ");
		String streenName = scanner.next();
		System.out.println("Enter area: ");
		String area = scanner.next();
		System.out.println("Enter city: ");
		String city = scanner.next();
		System.out.println("Enter state: ");
		String state = scanner.next();
		Address address = new Address(streenName,area,city,state);

		System.out.println("Enter mobile: ");
		String mobile = scanner.next();
		System.out.println("Enter email: ");
		String email = scanner.next();
		
		customers[id] = new Customer(id,name,address,mobile,email);*/

		Address address = new Address("streenName","area","city","state");
		customers[id] = new Customer(id,"name",address,"mobile","email");
	}
	
	public static void doTasks() {
		System.out.println("\nSelect your choice:");
		System.out.println("\n1. Add account");
		System.out.println("\n1. Select account");
		System.out.println("\nEnter your choice:");
		int c = scanner.nextInt();
		if(c==1) {
			Account account = new Account((long)current.getCustomerId()*100+current.getNoOfAccounts(),
					"Saving",new Date(),0.0);
			current.addAccount(account);
		}else {
			for(int i=0;i<current.getNoOfAccounts();i++) {
				current.getAccounts()[i].printAccount();
			}
			System.out.println("\nEnter your choice:");
			int a = scanner.nextInt();
			System.out.println("\nAccount:");
			current.getAccounts()[a].printAccount();
			
		}
	}
	
	public static void main(String[] args) {
		
		
		//add customer
		for(int i=0;i<5;i++) {
			addCustomer(i);
		}
		System.out.println("\nAll Customers:");
		for(int i=0;i<5;i++) {
			customers[i].printCustomer();
		}

		System.out.println("\nEnter your customer Id:");
		current = customers[scanner.nextInt()];
		System.out.println("\nYou are:");
		current.printCustomer();
		
		doTasks();
	}

	
}
