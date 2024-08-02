package ht.atm;

// represents adeposit ATM transaction
public class Deposit extends Transaction{

	private double amount; // amount to deposit
	private Keypad keypad; // reference to keypad
	private DepositSlot depositSlot; //reference to deposit slot
	private final static int CANCELED = 0; // constant for cancel option
	
	// deposit constructor
	public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
		super(userAccountNumber, atmScreen, atmBankDatabase); // initialize superclass variable
		keypad = atmKeypad; // initialize reference to keypad
		depositSlot = atmDepositSlot; // initialize reference to deposit slot
	}
	
	// perform transaction
	@Override
	public void execute() {
		BankDatabase bankDatabase = getBankDatabase(); // get reference
		Screen screen  = getScreen(); // get reference
		amount = promptForDepositAmount(); // get deposit amount from user
		
		//check wether user entered a deposit amount or canceled
		if(amount != CANCELED) {
			// request deposit envelope containing specified amount 
			screen.displayMessage("\nPlease insert a deposit envelope containing ");
			screen.displayDollarAmount(amount);
			screen.displayMessageLine(".");
			 
			boolean envelopeReceived = deposit.isEnvelopeReceived(); // receive deposit envelope
			
			// chech wether deposit envelope was received 
			if(envelopeReceived) {
				screen.displayMessageLine( "\nYour envelope has been " +
						"received.\nNOTE: The money just deposited will not " +
						"be available until we verify the amount of any " +
						"enclosed cash and your checks clear." );
				bankDatabase.credit(getAccountNumber, amount); // credit account to reflect the deposit 

			}else { // deposit envelope not received
				screen.displayMessageLine("\nyou did not insert an " + "envelope, so the ATM has cancelled your transaction" );
			}
		}else { // user cancelled instead of entering amount
			screen.displayMessageLine("\nCancelling transaction...");
		}
	}
	
	// prompt user to enter a deposit amount in cents
	private double promptForDepositAmount() {
		Screen screen = getScreen(); // get reference
		 
		// display the prompt
		screen.displayMessage("\nplease enter a deposit amount in " + " CENTS (or 0 to cancel): ");
		int input = keypad.getInput(); // receive input of deposit
		
		// check wether the user canceled or entered a valid amount
		if(input == CANCELED) {
			return CANCELED;
		}else {
			return (double) input / 100; // return dollar amount
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
