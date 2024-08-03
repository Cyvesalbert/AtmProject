package ht.atm;

// represents abalance inquiry ATM transaction
public class BalanceInquiry {

	// balanceInquiry contructor
	public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
		super(userAccountNumber, atmScreen, atmBankDatabase);
	}
	
	// performs the transaction
	@Override
	public void execute() {
		// get reference to bankDatabase and screen
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();
		
		// get the available balance for the account involve
		double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
		
		// get total balance for the account involve
		double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());
	
	
	// display the balance information on the screen
	screen.displayMessageLine( "\nBalance Information:" );
	screen.displayMessage( " - Available balance: " );
	screen.displayDollarAmount( availableBalance );
	screen.displayMessage( "\n - Total balance: " );
	screen.displayDollarAmount( totalBalance );
	screen.displayMessageLine( "" );
	
	}	
}
	

