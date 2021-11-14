package com.wander.repository;

import org.springframework.data.repository.CrudRepository;

import com.wander.entity.Details;

public interface DetailsRepository extends CrudRepository<Details, String>{
	
}
