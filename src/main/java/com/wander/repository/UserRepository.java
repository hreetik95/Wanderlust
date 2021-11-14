package com.wander.repository;

import org.springframework.data.repository.CrudRepository;

import com.wander.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findUserByContactNumber(String contactNumber);
}
