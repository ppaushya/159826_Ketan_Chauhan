package ui;

import java.time.LocalDate;
import java.util.Scanner;

import main.Account;
import main.Customer;
import main.Transaction;
import util.AccountType;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Customer[] customers;
	static Transaction[] transactions = new Transaction[100];
	
	public static void printCustomers() {
		System.out.println("Available customers: ");
		customers = AccountTransaction.loadCustomer();
		for(Customer customer:customers) {
			System.out.println(customer.getCustomerId()+"\t"+customer.getName()+"\t"+customer.getMobileNo()+"\t"+customer.getEmailId());
		}
	}
	
	public static boolean printAccounts(Customer customer) {
		if(customer.getNoOfAccount()==0) {
			return false;
		}
		Account[] accounts = customer.getAccounts();
		System.out.println("Available accounts: ");
		for(Account account:accounts) {
			if(account!=null) {
				System.out.println(account.getAccountNo()+"\t"+account.getAccountType());
			}
		}
		return true;
	}
	
	public static void printAccountType() {
		AccountType[] accountTypes = AccountType.values();
		int count=0;
		for(AccountType accountType : accountTypes) {
			System.out.println((++count)+". "+accountType);
		}
		
	}
	
	public static AccountType assignAccountType(int value) {
		switch (value) {
			case 1:
				return AccountType.SAVINGS;
			case 2:
				return AccountType.CURRENT;
			case 3:
				return AccountType.RD;
			case 4:
				return AccountType.FD;
			default:
				System.out.println("Invalid Account type");
				return null;
		}
	}
	
	private static Customer findCustomer(int customerId) {
		for(Customer customer:customers) {
			if(customer.getCustomerId()==customerId) {
				return customer;
			}
		}
		return null;
	}
	
	private static Account findAccount(Customer customer,int accountNo) {
		Account[] accounts = customer.getAccounts();
		for(Account account:accounts) {
			if(account!=null) {
				if(account.getAccountNo()==accountNo) {
					return account;
				}
			}
		}
		return null;
	}
	
	private static void addTransaction(Transaction transaction) {
		for(int i=0;i<transactions.length;i++) {
			if(transactions[i]==null) {
				transactions[i]=transaction;
				break;
			}
		}
	}
	
	private static void printTransactions(Account account) {
		System.out.println();
		int count=0;
		
		System.out.println("All Transactions: ");
		for(int i=0;i<transactions.length;i++) {
			if(transactions[i]!=null) {
				if(transactions[i].getAccount().getAccountNo()==account.getAccountNo()) {
					count++;
					System.out.println(transactions[i].toString());
				}
			}
		}
		if(count==0) {
			System.out.println("No Transactions");
			return;
		}
	}
	
	private static void printAllTransactions() {
		System.out.println();
		if(transactions[0]==null) {
			System.out.println("No Transactions");
			return;
		}
		System.out.println("All Transactions: ");
		for(int i=0;i<transactions.length;i++) {
			if(transactions[i]!=null) {
				System.out.println(transactions[i].toString());
			}
		}
	}

	private static Customer getCustomerFromUser() {
		printCustomers();
		Customer customer=null;
		
		while(customer==null) {
			System.out.println("Choose customer id: ");
			int customerId = scanner.nextInt();
			customer = findCustomer(customerId);
			if(customer==null) {
				System.out.println("Invalid customer id");
			}
		}
		return customer;
	}
	
	private static int getTaskChoiceFromUser() {
		int choice=0;
		while(choice<1 || choice>4) {
			System.out.println();
			System.out.println();
			System.out.println("1. Create a new Account");
			System.out.println("2. Perform transaction");
			System.out.println("3. Transaction summary");
			System.out.println("4. Exit");
			System.out.println("Enter your choice[1,2,3,4]: ");
			choice = scanner.nextInt();
			if(choice<1 || choice>4) {
				System.out.println("Sorry! Invalid choice. Please try again!");
			}
		}
		return choice;
	}
	
	public static void main(String[] args) {
		Customer customer = getCustomerFromUser();
		
		int choice=0;		
		int accountTypeNo;
		do {
			choice = getTaskChoiceFromUser();
			
			if(choice==1) {
				Account account = new Account();
				account.setAccountNo(AccountTransaction.generateAccountNo());
				
				System.out.println();
				System.out.println("Enter account details:");
				AccountType accountType=null;
				while(accountType==null) {
					System.out.println("Enter account type");
					printAccountType();
					accountTypeNo = scanner.nextInt();
					accountType = assignAccountType(accountTypeNo);
				}
				account.setAccountType(accountType);
				
				System.out.println("Enter account opening date:");
				System.out.println("Enter year:");
				int year = scanner.nextInt();
				System.out.println("Enter month:");
				int month = scanner.nextInt();
				System.out.println("Enter day:");
				int day = scanner.nextInt();
				LocalDate date = LocalDate.of(year, month, day);
				account.setOpeningDate(date);
				
				System.out.println("Enter account opening balance:");
				double balance = scanner.nextDouble();
				account.setOpeningBalance(balance);
				
				System.out.println(account.toString());
				customer.addAccount(account);
				choice=0;
				//System.out.println(customer.toString());
			}else if(choice==2) {
				if(!printAccounts(customer)) {
					System.out.println("You are having no accounts. Please add account.");
					choice=0;
					continue;
				}
				int accountChoice;
				Account account=null;
				while(account==null) {
					System.out.println("Enter account number: ");
					accountChoice = scanner.nextInt();
					account = findAccount(customer,accountChoice);
					if(account==null) {
						System.out.println("Invalid account number");
					}
				}
				
				int transactionChoice=0;
				while(transactionChoice<1 || transactionChoice>2) {
					System.out.println("1. Debit");
					System.out.println("2. Credit");
					System.out.println("Enter transaction type: ");
					transactionChoice = scanner.nextInt();
					if(transactionChoice<1 || transactionChoice>2) {
						System.out.println("Invalid transaction type");	
					}
				}
				
				
				if(transactionChoice==1) {
					Transaction transaction = new Transaction();
					transaction.setTransactionId(AccountTransaction.generatetransactionNo());
					transaction.setTransactionDate(LocalDate.now());
					transaction.setTransactionType("Debit");
					transaction.setAccount(account);
					
					System.out.println("Enter amount: ");
					double amount = scanner.nextDouble();
					double balance = account.getCurrentBalanceAfterTransactions(transactions);
					if(balance<amount) {
						System.out.println("Insufficient balance.");
					}else {
						transaction.setAmount(amount);
						addTransaction(transaction);
						System.out.println("Current balance: "+account.getCurrentBalanceAfterTransactions(transactions));
						//printAllTransactions();
					}
				}else if(transactionChoice==2){
					Transaction transaction = new Transaction();
					transaction.setTransactionId(AccountTransaction.generatetransactionNo());
					transaction.setTransactionDate(LocalDate.now());
					transaction.setTransactionType("Credit");
					transaction.setAccount(account);
					
					System.out.println("Enter amount: ");
					double amount = scanner.nextDouble();
					transaction.setAmount(amount);
					addTransaction(transaction);
					System.out.println("Current balance: "+account.getCurrentBalanceAfterTransactions(transactions));
					//printAllTransactions();
				}
				choice=0;				
			}else if(choice==3){
				if(!printAccounts(customer)) {
					System.out.println("You are having no accounts. Please add account.");
					choice=0;
					continue;
				}
				int accountChoice;
				Account account=null;
				while(account==null) {
					System.out.println("Enter account number: ");
					accountChoice = scanner.nextInt();
					account = findAccount(customer,accountChoice);
					if(account==null) {
						System.out.println("Invalid account number");
					}
				}
				printTransactions(account);
				//printAllTransactions();
				choice=0;		
			}else if(choice==4){
				System.out.println("Thank you!");
				break;
			}
			
		}while(choice!=3);

	}

	
	
}