package com.wander.validator;

import com.wander.exception.WanderLustException;

public class UserValidator {
	public static void validateUserForLogin(String contactNumber, String password) throws WanderLustException{
		if(!validateContactNumber(contactNumber)) {
			throw new WanderLustException("UserValidator.INVALID_CONTACT_NUMBER_FORMAT");
		}
		if(!validatePassword(password))
			throw new WanderLustException("UserValidator.INVALID_PASSWORD_FORMAT");
	}

	private static boolean validatePassword(String password) {
		if(password==null) 
			return false;
			if(password.length()>=7 && password.length()<=20) {
				if(password.matches(".*[A-Z]+.*") && password.matches(".*[a-z]+.*")
						&& password.matches(".*[0-9]+.*") && password.matches(".*[!@#$%^&*]+.*")) {
						return true;
				}
			}
		return false;
	}

	private static boolean validateContactNumber(String contactNumber) {
		if(contactNumber==null)
			return false;
		if(contactNumber.matches("[6-9][0-9]{9}"))
			return true;
		
		return false;
	}

}
