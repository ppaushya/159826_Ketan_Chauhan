package org.xyz.util;

public class IdGenerator {

	private static long currentCustomerNumber = 1598263300l;
	private static long currentAccountNumber = 1598261100l;
	private static long currentTransactionNumber = 159826990000l;
	
	public static long generateCustomerNumber() {
		return ++currentCustomerNumber;
	}
	
	public static long generateAccountNumber() {
		return ++currentAccountNumber;
	}
	
	public static long generateTransactionNumber() {
		return ++currentTransactionNumber;
	}
}
