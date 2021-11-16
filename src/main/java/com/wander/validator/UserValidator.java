package com.wander.validator;

import com.wander.dto.UserDTO;
import com.wander.exception.WanderLustException;

public class UserValidator {
	public static void validateUserForLogin(String emailId, String password) throws WanderLustException{
		if(!validateContactNumber(emailId)) {
			throw new WanderLustException("UserValidator.INVALID_EMAILID");
		}
		if(!validatePassword(password))
			throw new WanderLustException("UserValidator.INVALID_PASSWORD_FORMAT");
	}
	public static void validateUserForRegister(UserDTO user) throws WanderLustException{
		if(!validateName(user.getUserName()))
			throw new WanderLustException("UserValidator.INVALID_USERNAME_FORMAT");
		if(!validateEmailId(user.getEmailId()))
			throw new WanderLustException("UserValidator.INVALID_EMAIL_ID_FORMAT");
		if(!validateContactNumber(user.getContactNumber())) {
			throw new WanderLustException("UserValidator.INVALID_CONTACT_NUMBER_FORMAT");
		}
		if(!validatePassword(user.getPassword()))
			throw new WanderLustException("UserValidator.INVALID_PASSWORD_FORMAT");
	}

	private static boolean validateEmailId(String emailId) {
		if(emailId==null)
			return false;
		if(emailId.matches("[A-za-z]+@[A-Za-z]+[.com]"))
			return true;
		return false;
	}
	private static boolean validateName(String name) {
		if(name==null || name.trim().length()!=name.length())
			return false;
		if(name.matches("[A-Za-z ]+"))
			return true;
		return false;
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
