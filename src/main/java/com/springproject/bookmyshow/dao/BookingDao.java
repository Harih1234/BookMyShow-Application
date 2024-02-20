package com.springproject.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springproject.bookmyshow.entity.Booking;
import com.springproject.bookmyshow.repo.AdminRepo;
import com.springproject.bookmyshow.repo.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	BookingRepo repo;
	
	@Autowired
	AdminRepo arepo;
	
	
	public Booking saveBooking(Booking booking) {
		return repo.save(booking);
	}
	
	
	public Booking findBooking(int bookingId) {
		Optional<Booking> opBooking = repo.findById(bookingId);
		if(opBooking.isPresent()) {
			arepo.findById(bookingId);
			return opBooking.get();
		}
	return null;
	}
	
	
	public Booking deleteBooking(int bookingId) {
		Booking booking = findBooking(bookingId);
		repo.delete(booking);
		return booking;
	}
	
	public Booking updateBooking(int bookingId, Booking booking) {
		Booking exBooking = findBooking(bookingId);
		if(exBooking != null) {
		booking.setBookingId(bookingId);
		return repo.save(booking);
	}
		return null;
			
 }
	
	
	
//	public List<Booking> findAllBooking() {
//		List<Booking> booking = repo.findAll();
//		return booking;
//	}
	
}
