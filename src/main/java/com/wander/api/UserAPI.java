package com.wander.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wander.dto.UserDTO;
import com.wander.exception.WanderLustException;
import com.wander.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/wanderlust")
public class UserAPI {
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> validateUser(@RequestBody UserDTO user) throws WanderLustException{
		try {
			UserDTO userDto = userService.validateUser(user.getContactNumber(), user.getPassword());
			return new ResponseEntity<>(userDto,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(e.getMessage()),e );
		}	
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO user) throws WanderLustException{
		try {
			String name = userService.registerUser(user);
			String msg = environment.getProperty("UserAPI.REGISTER_USER_SUCCESS1")+ name + 
					environment.getProperty("UserAPI.REGISTER_USER_SUCCESS2");
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(e.getMessage()),e);
		}
	}
	
}
