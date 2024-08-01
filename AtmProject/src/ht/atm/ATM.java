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
 	private static final int DEPOSOSIT = 3;
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
 		screen.displayMesssage("\nPlease enter your account number: ");
 		int accoutNumber = keypad.getInput(); // input account number
 		screen.displayMessade("\nEnter your PIN: "); // prompt for PIN
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
