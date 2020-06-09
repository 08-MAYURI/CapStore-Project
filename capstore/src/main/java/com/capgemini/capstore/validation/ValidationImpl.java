package com.capgemini.capstore.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidationImpl implements Validation{
	Pattern pattern=null;
    Matcher matcher=null;
	@Override
	public boolean emailValidation(String email) {
		pattern=Pattern.compile("\\w+\\@\\w+\\.\\w+");
		matcher=pattern.matcher(email);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean passwordValidation(String password) {
		pattern=Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,15}");
		matcher=pattern.matcher(password);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean mobileNoValidation(String phoneNumber) {
		pattern=Pattern.compile("[6,7,8,9][0-9]{9}");
		matcher=pattern.matcher(phoneNumber);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

//	@Override
//	public boolean nameValidation(String name) {
//		pattern=Pattern.compile("[a-zA-Zs]+\\s[a-zA-Z]+$");
//		matcher=pattern.matcher(name);
//		if(matcher.matches()) {
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public boolean prouductNameValidation(String productName) {
//		pattern=Pattern.compile("[a-zA-Z]+([\\s][a-zA-Z]+)*");
//		matcher=pattern.matcher(name);
//		if(matcher.matches()) {
//			return true;
//		}
//		return false;
//	}

}
