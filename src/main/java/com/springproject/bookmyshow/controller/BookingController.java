package com.springproject.bookmyshow.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.bookmyshow.entity.Booking;
import com.springproject.bookmyshow.service.BookingService;
import com.springproject.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("booking")
public class BookingController {

	@Autowired
	BookingService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Booking>> findBooking(@RequestParam int bookingId) {
		return service.findBooking(bookingId);
	}
	
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int bookingId) {
		return service.deletBooking(bookingId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking,@RequestParam int bookingId) {
		return service.updateBooking(booking, bookingId);
		
	}
	
//	@GetMapping("findall")
//	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBooking() {
//		return service.findAllBookings();
//	}
	
}
