package com.wander.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wander.entity.Destination;

public interface DestinationRepository extends CrudRepository<Destination, String>{
	public List<Destination> findDestinationByContinent(String continent);
	public List<Destination> findAll();
}
