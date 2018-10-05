package org.xyz.util;

public class IdGenerator {

	private static long currentAccountNumber = 159826000000l;
	private static long currentTransactionNumber = 15982600000000l;
	
	public static long generateAccountNumber() {
		return ++currentAccountNumber;
	}
	
	public static long generatetransactionNumber() {
		return ++currentTransactionNumber;
	}
}
