package exercise1balance;

public class Account {

	int accountId;
	int customerId;
	float accountBalance;

	public Account() {
		super();
	}

	public Account(float accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}
	
	
	public Account(int accountId, int customerId, float accountBalance) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountBalance = accountBalance;
	}

	public void displayBalance() {
		System.out.println("Account balance: "+accountBalance);
	}
	
}
