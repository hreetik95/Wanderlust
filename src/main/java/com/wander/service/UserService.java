package com.wander.service;

import com.wander.dto.UserDTO;
import com.wander.exception.WanderLustException;

public interface UserService {
	public UserDTO validateUser(String contactNumber,String password) throws WanderLustException;
}
