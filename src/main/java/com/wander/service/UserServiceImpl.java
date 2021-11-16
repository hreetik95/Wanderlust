package com.wander.service;

import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wander.dto.UserDTO;
import com.wander.entity.User;
import com.wander.exception.WanderLustException;
import com.wander.repository.UserRepository;
import com.wander.utility.HashingUtility;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDTO validateUser(String emailId, String password) throws WanderLustException{
		User user = userRepository.findUserByEmailId(emailId);
		if(user==null) 
			throw new WanderLustException("UserService.INVALID_CREDENTIALS");
		String dbPassword = user.getPassword();
		if(dbPassword!= null) {
			
			try {
				String hashedPassword = HashingUtility.getHashValue(password);
				if(dbPassword.equals(hashedPassword)) {
					UserDTO userDto = new UserDTO();
					userDto.setUserId(user.getUserId());
					userDto.setUserName(user.getUserName());
					userDto.setEmailId(user.getEmailId());
					userDto.setContactNumber(user.getContactNumber());
					return userDto;
				}
				else
					throw new WanderLustException("UserService.INVALID_CREDENTIALS");
			}
			catch (NoSuchAlgorithmException exception) {
				throw new WanderLustException("UserService.HASH_FUNCTION_EXCEPTION");
			}
		}
		throw new WanderLustException("UserService.INVALID_CREDENTIALS");
	}
	
	@Override
	public String registerUser(UserDTO user) throws WanderLustException{
		if(userRepository.findUserByEmailId(user.getEmailId())!=null)
			throw new WanderLustException("UserService.EMAILID_ALREADY_EXISTS");
		try {
			String hashedPassword = HashingUtility.getHashValue(user.getPassword());
			User usr = new User();
			usr.setUserId(user.getUserId());
			usr.setContactNumber(user.getContactNumber());
			usr.setEmailId(user.getEmailId());
			usr.setPassword(hashedPassword);
			usr.setUserName(user.getUserName());
			userRepository.save(usr);
			return usr.getUserName();
			
		}
		catch (NoSuchAlgorithmException exception) {
			throw new WanderLustException("UserService.HASH_FUNCTION_EXCEPTION");
		}
		
	}
}
