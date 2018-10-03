package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public static boolean validateVerbalData(String str) {
		Pattern namePattern = Pattern.compile("[a-zA-Z ]+");
		Matcher nameMatcher = namePattern.matcher(str);
		return nameMatcher.matches();
	}
	
	public static boolean validateEmail(String email) {
		Pattern namePattern = Pattern.compile("\\w+(\\.?\\w+|\\w*)@\\w+\\.\\w+");
		Matcher nameMatcher = namePattern.matcher(email);
		return nameMatcher.matches();
	}
	
	public static boolean validateMobileNumber(String mobileno) {
		Pattern namePattern = Pattern.compile("\\d{10}");
		Matcher nameMatcher = namePattern.matcher(mobileno);
		return nameMatcher.matches();
	}
	
	public static void main(String[] args) {
		//System.out.println(validateName("Ketan Chauhan"));
		
		/*System.out.println(validateEmail("Ketan.Chauhan@capgemini.com"));
		System.out.println(validateEmail("Ketan@capgemini.com"));
		System.out.println(validateEmail("KetanChauhan.@capgemini.com"));
		System.out.println(validateEmail("Ketan.Chauhan.@capgemini.com"));
		System.out.println(validateEmail("Ketan..Chauhan@capgemini.com"));
		System.out.println(validateEmail("Ketan.+Chauhan@capgemini.com"));
		System.out.println(validateEmail("Ketan.Chauhan@capgemini"));
		System.out.println(validateEmail("Ketan.Chauhan@"));
		System.out.println(validateEmail("Ketan.Chauhan@capgemini.com.com"));
		System.out.println(validateEmail("@capgemini.com"));
		System.out.println(validateEmail("Ketan.Chauhan"));*/
		
		System.out.println(validateMobileNumber("0123456789"));
		System.out.println(validateMobileNumber("012345678"));
		System.out.println(validateMobileNumber("0123456789a"));
		System.out.println(validateMobileNumber("01234 56789"));
	}
}
