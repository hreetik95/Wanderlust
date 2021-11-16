package com.wander.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wander.dto.DestinationDTO;
import com.wander.dto.DetailsDTO;
import com.wander.dto.ItineraryDTO;
import com.wander.entity.Destination;
import com.wander.exception.WanderLustException;
import com.wander.repository.DestinationRepository;

@Service(value = "destination")
@Transactional
public class PackageServiceImpl implements PackageService{
	@Autowired
	private DestinationRepository destinationRepository;

	@Override
	public List<DestinationDTO> findDestination(String continent) throws WanderLustException {
		List<Destination> destinations = destinationRepository.findDestinationByContinent(continent);
		if(destinations.isEmpty() || destinations.size()==0)
			throw new WanderLustException("PackageSearch.NO_CONTINENT_FOUND");
		else {
			ArrayList<DestinationDTO> destList = (ArrayList<DestinationDTO>)destinations.stream().map(a->{
				ItineraryDTO i = new ItineraryDTO(a.getDetails().getItinerary().getItineraryId(),
						a.getDetails().getItinerary().getFirstDay(), a.getDetails().getItinerary().getRestOfDays(), 
						a.getDetails().getItinerary().getLastDay());
				DetailsDTO d = new DetailsDTO(a.getDetails().getDetailsId(), a.getDetails().getAbout(),
						a.getDetails().getPackageInclusion(), a.getDetails().getHighlights(), a.getDetails().getPace(), i);
				DestinationDTO des = new DestinationDTO(a.getDestinationId(), a.getContinent(), a.getDestinationName(),
						a.getImageUrl(), a.getNoOfNights(), a.getFlightCharge(), a.getChargePerPerson(), a.getDiscount(),
						a.getAvailability(), d);
				return des;
			}).collect(Collectors.toList());
			return destList;
		}
	}

	@Override
	public List<DestinationDTO> getHotDeals() throws WanderLustException {
		List<Destination> destinations = destinationRepository.findAll(); 
		if(destinations.isEmpty() || destinations.size()==0)
			throw new WanderLustException("PackageService.NO_DEALS_AVILABLE");
		else {
			
			ArrayList<DestinationDTO> destList = (ArrayList<DestinationDTO>)destinations.stream().map(a->{
				ItineraryDTO i = new ItineraryDTO(a.getDetails().getItinerary().getItineraryId(),
						a.getDetails().getItinerary().getFirstDay(), a.getDetails().getItinerary().getRestOfDays(), 
						a.getDetails().getItinerary().getLastDay());
				DetailsDTO d = new DetailsDTO(a.getDetails().getDetailsId(), a.getDetails().getAbout(),
						a.getDetails().getPackageInclusion(), a.getDetails().getHighlights(), a.getDetails().getPace(), i);
				DestinationDTO des = new DestinationDTO(a.getDestinationId(), a.getContinent(), a.getDestinationName(),
						a.getImageUrl(), a.getNoOfNights(), a.getFlightCharge(), a.getChargePerPerson(), a.getDiscount(),
						a.getAvailability(), d);
				return des;
			}).filter(a->a.getDiscount()>0.0).collect(Collectors.toList());
			return destList;
		}
	}
	
	

}
