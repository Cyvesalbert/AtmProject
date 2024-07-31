package ht.atm;

// Represents an ATM withdrawal transaction
public class Withdrawal extends Transaction{
	
	// Attributes
	//private int accountNumber; // account to withdraw funds from
	private double amount; // amount to withdraw
	
	// References to associated objects
	//private Screen screen; // ATM's screen
	private Keypad keypad; // ATM's keypad
	private CashDispenser cashDispenser; // ATM's cash dispenser
	//private BankDatabase bankDatabase; // account info database
	
	// no arguments constructor
	public Withdrawal() {
		
	}
	
	//operations
	@Override
	public void execute() {
		
	}
	
}
