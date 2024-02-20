package com.springproject.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
