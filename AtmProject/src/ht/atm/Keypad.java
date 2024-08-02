package ht.atm;

import java.util.Scanner;

// represents the keypad of the ATM
public class Keypad {

	private Scanner input; // reads data from the command line
	
	// no arguments contructor initializes the Scanner
	public Keypad() {
		input = new Scanner(System.in);
	}
	
	public int getInput() {
		return input.nextInt();
	}
	
	
	
	
	
	
	
	
}
