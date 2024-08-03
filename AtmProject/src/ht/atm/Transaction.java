package ht.atm;

// abstract superclass transaction represents an ATM transaction
public class Transaction {
	
	private int accountNumber; // indicates account involved
	private Screen screen; // ATM's screen
	private BankDatabase bankDatabase; // account info database
	
	// Transaction constructor invoked by subclasses using super
	public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
		accountNumber = userAccountNumber;
		screen = atmScreen;
		bankDatabase = atmBankDatabase;
	}
	
	// return account number
	public int getAccount() {
		return accountNumber;
	}
	
	// return reference to screen
	public Screen getScreen()
	{
		return screen;
	}
	
	// return reference to bankDatabase
	public BankDatabase getBankDatabase(){
		return bankDatabase;
	}
		
	// perform the transaction (overriden by each superclass
	abstract public void execute();
	
	
	

}
