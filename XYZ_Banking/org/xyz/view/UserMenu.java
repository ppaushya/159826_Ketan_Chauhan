package org.xyz.view;

import java.util.Scanner;

public class UserMenu {

	static Scanner scanner = new Scanner(System.in);
	
	public static int getTaskChoiceFromUser() {
		int choice=0;
		while(choice<1 || choice>4) {
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println("1. Create a new Customer");
			System.out.println("2. List Customers");
			System.out.println("3. Select Customer");
			System.out.println("4. Exit");
			System.out.println("Enter your choice[1,2,3,4]: ");
			choice = scanner.nextInt();
			if(choice<1 || choice>4) {
				System.out.println("Sorry! Invalid choice. Please try again!");
			}
		}
		return choice;
	}
	
	public static int getCustomerTaskChoiceFromUser() {
		int choice=0;
		while(choice<1 || choice>5) {
			System.out.println();
			System.out.println();
			System.out.println("1. Create a new Account");
			System.out.println("2. Perform Transaction");
			System.out.println("3. Transaction summary");
			System.out.println("4. Current Balance");
			System.out.println("5. Cancel");
			System.out.println("Enter your choice[1,2,3,4,5]: ");
			choice = scanner.nextInt();
			if(choice<1 || choice>5) {
				System.out.println("Sorry! Invalid choice. Please try again!");
			}
		}
		return choice;
	}
	
	public static int getTransactionTypeChoiceFromUser() {
		int choice=0;
		while(choice<1 || choice>3) {
			System.out.println();
			System.out.println();
			System.out.println("1. Debit");
			System.out.println("2. Credit");
			System.out.println("3. Fund Transfer");
			System.out.println("4. Cancel");
			System.out.println("Enter your choice[1,2,3,4]: ");
			choice = scanner.nextInt();
			if(choice<1 || choice>3) {
				System.out.println("Sorry! Invalid choice. Please try again!");
			}
		}
		return choice;
	}
	
	public static boolean getRepeatConfirmation() {
		boolean shouldRepeat = false;
		System.out.println("Do you wish to continue? [y/n]:");
		String choice = scanner.next();
		shouldRepeat = choice.charAt(0)=='y' || choice.charAt(0)=='Y';
		return shouldRepeat;
	}
}
