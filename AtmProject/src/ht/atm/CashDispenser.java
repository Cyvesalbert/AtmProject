package ht.atm;

// represents the cash dispenser of the ATM
public class CashDispenser {

	private final static int INITIAL_COUNT = 500; // the default initial number of bills in the cash dispenser
	private int count; // number of $20 bills remaining
	
	// no arguments instructor initialize count to default
	public CashDispenser() {
		count = INITIAL_COUNT; // set count attribute to default
	}
	
	// simulates dispensing of specified amount of cash
	public void dispenseCash(int amount) {
		int billsRequired = amount / 20; // number of $20 bills required
		count -= billsRequired; // update the counts of bills
	}
	
	// indicates wether cash dispenser can dispense desired amount
	public boolean isSufficientCashAvailable(int amount) {
		int billsRequired = amount / 20; // number of $20 bills required
		
		if(count >= billsRequired) {
			return true; // enough bills available
		}else {
			return false; // not enough bills available
		}
	}
	
}
