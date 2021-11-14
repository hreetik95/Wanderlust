package com.wander.repository;

import org.springframework.data.repository.CrudRepository;

import com.wander.entity.Itinerary;

public interface ItineraryRepository extends CrudRepository<Itinerary, String>{

}
