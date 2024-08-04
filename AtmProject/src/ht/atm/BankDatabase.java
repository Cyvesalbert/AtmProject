package ht.atm;

// represents the bank account information database
public class BankDatabase {

	private Account[] accounts; // array of accounts
	
	//no arguments bankDatabase constructor initializes accounts
	public BankDatabase() {
		accounts = new Account[2]; // just 2 accounts for testing
		accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
		accounts[1] = new Account(98765, 56789, 200.0, 200.0);
	}
	
	// retreive Account object containing specified account number
	private Account getAccount(int accountNumber) {
		// loop through accounts searching for matching account number
		for(Account currentAccount : accounts) {
			// return current account if match found
			if(currentAccount.getAccountNumber() == accountNumber) {
				return currentAccount;
			}
		}
		
		return null; // if no matching account was found , return null
	}
	
	// determine whether user-specified account number and PIN match those of an account in the database
	public boolean authenticateUser(int userAccountNumber, int userPIN) {
		// attempt to retrieve the account with the account number
		Account userAccount = getAccount(userAccountNumber);
		
		// if account exist return the result of account method validate PIN
		if(userAccount != null) {
			return userAccount.validatePin(userPIN);
		}else {
			return false; // account number not found so return false
		}
	}
	
	// return available balance of account with specified account number
	public double getAvailableBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getAvailableBalance();
	}
	
	// return total balance of account with specified account number
	public double getTotalBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getTotalBalance();
	}
	
	// credit an amount to account with specified account number
	public void credit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).credit(amount);
	}
	
	// debit an amount from account with specified account number
	public void debit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).debit(amount);
	}
	

}
