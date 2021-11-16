package com.wander.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wander.dto.DestinationDTO;
import com.wander.exception.WanderLustException;
import com.wander.service.PackageService;
@CrossOrigin
@RestController
@RequestMapping("/wanderlust")
public class PackageAPI {
	@Autowired
	private PackageService packageService;
	@Autowired
	private Environment environment;
	
	// Package Search
	@GetMapping("/package/{continent}")
	public ResponseEntity<List<DestinationDTO>> findDestination(@PathVariable("continent") String continent) throws WanderLustException{
		try {
			List<DestinationDTO> destinations = packageService.findDestination(continent);
			ResponseEntity<List<DestinationDTO>> response = new ResponseEntity<>(destinations,HttpStatus.OK);
			return response;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(e.getMessage()));
		}
		
	}
	
	// Hot Deals
	@GetMapping("/hotdeals")
	public ResponseEntity<List<DestinationDTO>> getHotDeals() throws WanderLustException{
		try {
			List<DestinationDTO> hotDeals = packageService.getHotDeals();
			return new ResponseEntity<List<DestinationDTO>>(hotDeals,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty(e.getMessage()));
		}
	}
	
}
