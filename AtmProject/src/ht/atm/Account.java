package ht.atm;
 
// represents a  bank account
public class Account {

	private int accountNumber; // account number
	private int pin; // PIN for authentication
	private double availableBalance; // funds available for withdrawal
	private double totalBalance; // funds available + pendings deposits
	
	// Account constructor initialize attribute 
	public Account(int theAccountNumber, int thePin, double theAvailableBalance, double theTotalBalance) {
		accountNumber = theAccountNumber;
		pin = thePin;
		availableBalance = theAvailableBalance;
		totalBalance = theTotalBalance;
	}
	
	// determines whether a user-specified PIN matches PIN in account
	public boolean validatePin(int userPIN) {
		if(userPIN == pin) {
			return true;
		}else {
			return false;
		}
	}
	
	// returns available balance
	public double getAvailableBalance() {
		return availableBalance;
	}
	
	// returns the total balance
	public double getTotalBalance() {
		return totalBalance;
	}
	
	// credits an amount to the account
	public void credit(double amount) {
		totalBalance += amount; // add to total Balance
	}
	
	// debits an amount from the account
	public void debit(double amount) {
		availableBalance -= amount; //subtract from available balance
		totalBalance -= amount; // subtract from total balance
	}
	
	// return account number
	public int getAccountNumber() {
		return accountNumber;
	}
	
	
}
