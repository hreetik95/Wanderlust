package com.wander.service;

import java.util.List;

import com.wander.dto.DestinationDTO;
import com.wander.exception.WanderLustException;

public interface PackageService {
	public List<DestinationDTO> findDestination(String continent) throws WanderLustException;
	public List<DestinationDTO> getHotDeals() throws WanderLustException;
}
