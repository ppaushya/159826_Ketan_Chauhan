package ui;

import java.time.LocalDate;
import java.util.Scanner;

import main.Account;
import main.CustomerOld;
import main.Transaction;
import util.AccountType;

public class MainOld {
	static Scanner scanner = new Scanner(System.in);
	static CustomerOld[] customers;
	static Transaction[] transactions = new Transaction[100];
	
	public static void printAllCustomers() {
		System.out.println("Available customers: ");
		customers = AccountTransaction.loadCustomerArray();
		for(CustomerOld customer:customers) {
			System.out.println(customer.getCustomerId()+"\t"+customer.getName()+"\t"+customer.getMobileNo()+"\t"+customer.getEmailId());
		}
	}
	
	public static boolean printAccountsOfCustomer(CustomerOld customer) {
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
	
	public static void printAllAccountTypes() {
		AccountType[] accountTypes = AccountType.values();
		int count=0;
		for(AccountType accountType : accountTypes) {
			System.out.println((++count)+". "+accountType);
		}
		
	}
	
	public static AccountType getAccountTypeFromValue(int value) {
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
	
	private static CustomerOld findCustomerFromId(int customerId) {
		for(CustomerOld customer:customers) {
			if(customer.getCustomerId()==customerId) {
				return customer;
			}
		}
		return null;
	}
	
	private static Account findAccountFromAccountNumber(CustomerOld customer,int accountNo) {
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
	
	private static void printTransactionsOfAccount(Account account) {
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

	private static CustomerOld getCustomerFromUser() {
		printAllCustomers();
		CustomerOld customer=null;
		
		while(customer==null) {
			System.out.println("Choose customer id: ");
			int customerId = scanner.nextInt();
			customer = findCustomerFromId(customerId);
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
	
	private static Account addAccountFromUser() {
		Account account = new Account();
		account.setAccountNo(AccountTransaction.generateAccountNo());
		
		System.out.println();
		System.out.println("Enter account details:");
		AccountType accountType=null;
		int accountTypeNo;
		while(accountType==null) {
			System.out.println("Enter account type");
			printAllAccountTypes();
			accountTypeNo = scanner.nextInt();
			accountType = getAccountTypeFromValue(accountTypeNo);
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
		return account;
	}
	
	private static Account selectAccountFromUser(CustomerOld customer) {
		int accountChoice;
		Account account=null;
		while(account==null) {
			System.out.println("Enter account number: ");
			accountChoice = scanner.nextInt();
			account = findAccountFromAccountNumber(customer,accountChoice);
			if(account==null) {
				System.out.println("Invalid account number");
			}
		}
		return account; 
	}
	
	private static int getTransactionChoiceFromUser() {
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
		return transactionChoice;
	}
	
	private static void makeTransaction(Account account,int transactionChoice) {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(AccountTransaction.generatetransactionNo());
		transaction.setTransactionDate(LocalDate.now());
		transaction.setAccount(account);
		System.out.println("Enter amount: ");
		double amount = scanner.nextDouble();
		
		if(transactionChoice==1) {
			double balance = account.getCurrentBalanceAfterTransactions(transactions);
			if(balance<amount) {
				System.out.println("Insufficient balance.");
				return;
			}
			transaction.setTransactionType("Debit");
		}else if (transactionChoice==2) {
			transaction.setTransactionType("Credit");
		}	
		transaction.setAmount(amount);
		addTransaction(transaction);
		System.out.println(transaction);
		printCurrentBalance(account);
		//printAllTransactions();
	}
	
	private static void printCurrentBalance(Account account) {
		System.out.println("Current balance: "+account.getCurrentBalanceAfterTransactions(transactions));
	}
	
	public static void main(String[] args) {
		CustomerOld customer = getCustomerFromUser();
		
		int choice=0;		
		do {
			choice = getTaskChoiceFromUser();
			
			if(choice==1) {
				Account account = addAccountFromUser();
				customer.addAccount(account);
				choice=0;
			}else if(choice==2) {
				if(!printAccountsOfCustomer(customer)) {
					System.out.println("You are having no accounts. Please add account.");
					choice=0;
					continue;
				}
				
				Account account=selectAccountFromUser(customer);
				
				int transactionChoice=getTransactionChoiceFromUser();
				makeTransaction(account,transactionChoice);
				choice=0;				
			}else if(choice==3){
				if(!printAccountsOfCustomer(customer)) {
					System.out.println("You are having no accounts. Please add account.");
					choice=0;
					continue;
				}
				
				Account account=selectAccountFromUser(customer);
				printTransactionsOfAccount(account);
				//printAllTransactions();
				choice=0;		
			}else if(choice==4){
				System.out.println("Thank you!");
				break;
			}
			
		}while(choice!=3);

	}

	
	
}