package org.xyz.util;

public class Validator {
	public static boolean validateName(String name) {
		return validateVerbalData(name);
	}
	
	public static boolean validateCity(String city) {
		return validateVerbalData(city);
	}
	
	public static boolean validateState(String state) {
		return validateVerbalData(state);
	}
	
	public static boolean validateAccountNumber(String accountNumberString) {
		return accountNumberString.matches("\\d{6,10}");
	}
	
	public static boolean validateVerbalData(String str) {
		return str.matches("[a-zA-Z ]+");
	}
	
	public static boolean validateEmail(String email) {
		return email.matches("\\w+(\\.?\\w+|\\w*)@\\w+\\.\\w+");
	}
	
	public static boolean validateMobileNumber(String mobileno) {
		return mobileno.matches("\\d{10}");
	}
	
	public static boolean validatePinCode(String pincode) {
		return pincode.matches("\\d{6}");
	}
	
	public static boolean validateDate(String dateString) {
		return dateString.matches("([1-9]|0[1-9]|1[0-9]|2[0-9]|3[0-1])[-]([1-9]|0[1-9]|1[0-2])[-][1-2][0-9]{3}");
	}
	
	public static void main(String[] args) {
		
	}
}
