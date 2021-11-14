package com.wander.repository;

import org.springframework.data.repository.CrudRepository;

import com.wander.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{

}
