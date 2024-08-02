package ht.atm;

// represents the deposit slot of the ATM
public class DepositSlot {

	// indicates wether envelope was received(always returs true, 
	// because this is only a software simulation of a real deposit slot
	public boolean isEnvelopeReceived() {
		return true; // deposit envelope was received
	}
	
}
