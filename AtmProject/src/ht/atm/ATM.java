package ht.atm;

// represents an automated teller machine
public class ATM {

	private boolean userAuthenticated; // wheter user is authenticated
	private int currentAccountNumber; // current user's account number
	private Screen screen; // ATM's screen
 	private Keypad keypad; // ATM's keypad 
 	private CashDispenser cashDispenser; // ATM's  cash dispenser
 	private DepositSlot depositSlot; // ATM's deposit slot
 	private BankDatabase bankDatabase; // account information database
 	
 	// constants corresponding to main menu options
 	private static final int BALANCE_INQUIRY = 1; 
 	private static final int WITHDRAWAL = 2;
 	private static final int DEPOSIT = 3;
 	private static final int EXIT = 4;
 	
 	// no argument atm constructor initialize instance variables
 	public ATM() {
 		userAuthenticated = false; // user is not authenticated to start
 		currentAccountNumber = 0; // no current account number to start
 		screen = new Screen(); // create screen
 		keypad = new Keypad(); // create keypad
 		cashDispenser = new CashDispenser(); // create cash dispenser
 		depositSlot = new DepositSlot(); // create deposit slot
 		bankDatabase = new BankDatabase(); // create account info database
 	}
	
 	//start ATM
 	public void run() {
 		// welcome and authenticate user; perform transactions
 		while(true) {
 			// loop while user is not yet authenticated
 			while(!userAuthenticated) {
 				screen.displayMessageLine("\nWelcome");
 				authenticateUser(); // authenthicate user
 			}
 			
 			performTransactions(); // user is now authenticated
 			userAuthenticated = false; // reset before next ATM session
 			currentAccountNumber = 0; // reset before next ATM sesion
 			screen.displayMessageLine("\nThank you! good bye!");
 		}
 	}
 	
 	// attempts to authenticate user against database
 	public void authenticateUser() {
 		screen.displayMessage("\nPlease enter your account number: ");
 		int accountNumber = keypad.getInput(); // input account number
 		screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
 		int pin = keypad.getInput(); // input PIN
 		
 		// set userAuthenticated to boolean value returnde by database
 		userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
 		
 		// check wether authentication succeed
 		if(userAuthenticated) {
 			currentAccountNumber = accountNumber; // save user account Number
 		}else {
 			screen.displayMessageLine("invalid account Number or PIN. Please try again");
 		}
 	}
 	
 	// display the main menu and perform transactions
 	private void performTransactions() {
 		Transaction currentTransaction = null; // local variable to store transaction currently being processed
 		boolean userExited = false; // user has not chosen to exit
 		
 		// loop while user has not choosen to exit system
 		while(!userExited) {
 			int mainMenuSelection = displayMainMenu(); // show main menu and get user selection 
 			
 			// decide how to proceed based on user's menu selection
 			switch(mainMenuSelection) {
 			// user chose to perform one of three transactions types
 				case BALANCE_INQUIRY:
 				case WITHDRAWAL:
 				case DEPOSIT:
 					currentTransaction = createTransaction(mainMenuSelection); //initialize as new object of chosen type
 					currentTransaction.execute(); // execute transaction
 					break;
 				case EXIT: // user chose to terminate session
 					screen.displayMessageLine("\nExixting the system...");
 					userExited = true; // this ATM session should end
 					break;
 				default: // user did not enter an integer from 1-4
 					screen.displayMessageLine("\nYou did not enter a valid selection. try again.");
 					break;
 			}
 		}
 	}
 		
 		//display the main menu and return an input selection
 		private int  displayMainMenu() {
 			screen.displayMessageLine("\nMain menu:");
 			screen.displayMessageLine("1 - View Balance");
 			screen.displayMessageLine("2 - Withdraw cash");
 			screen.displayMessageLine("3 - Deposit funds");
 			screen.displayMessageLine("4 - Exit\n");
 			screen.displayMessageLine("Enter a choice: ");
 			return keypad.getInput(); // return user's selection
 		}
 		
 		// return object of specified transaction subclass
 		private Transaction createTransaction(int type) {
 			
 			Transaction temp = null; // temporary Transaction variable
 			
 			switch(type) {
 				case BALANCE_INQUIRY: // create new balance inquiry transaction
 					temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
 					break;
 				case WITHDRAWAL: // create new withdrawal transaction
 					temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
 					break;
 				case DEPOSIT: // create new deposit transaction
 					temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
 					break;
 					
 			}
 			
 			return temp; // return the newly created object
 		}
	
	
}
