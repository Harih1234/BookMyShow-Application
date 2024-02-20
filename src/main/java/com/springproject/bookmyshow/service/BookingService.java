package com.springproject.bookmyshow.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.dao.BookingDao;
import com.springproject.bookmyshow.entity.Booking;

import com.springproject.bookmyshow.exception.BookingNotFound;
import com.springproject.bookmyshow.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	BookingDao bdao;
	
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking){
		Booking newbooking = bdao.saveBooking(booking);
		
		ResponseStructure<Booking> structure=new ResponseStructure<Booking>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Booking Saved");
		structure.setData(newbooking);
		return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Booking>> findBooking(int bookingId){
		Booking booking = bdao.findBooking(bookingId);
		
		if(booking != null) {
			
			
			ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Booking Found");
			structure.setData(booking);
			return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.CREATED);
		}
		throw new BookingNotFound("Booking not found for the given Id ");
	}
	
	public ResponseEntity<ResponseStructure<Booking>> deletBooking(int bookingId) {
		Booking booking = bdao.findBooking(bookingId);

		
		if(booking !=null){
			Booking book = bdao.deleteBooking(bookingId);

				ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("booking deleted");
				structure.setData(booking);
				return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.OK);
			}
			throw new BookingNotFound("Booking not found for the given id");
		}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking,int bookingId) {
		ResponseStructure<Booking> structure = new ResponseStructure<Booking>();
		Booking book =bdao.updateBooking(bookingId, booking);
	
		
	
		if(book !=null) {
			
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("admin updated");
			structure.setData(bdao.updateBooking(bookingId, booking));
			return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.OK);
		}
		throw new BookingNotFound("Booking not found for the given id in update");
	}
	
//	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBookings(){
//		List<Booking> booking = bdao.findAllBooking();
//		
//				
//		if(booking != null) {
//			ResponseStructure<List<Booking>> structure = new ResponseStructure<List<Booking>>();
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setMessage("found all Admin");
//			structure.setData(booking);
//			return new ResponseEntity<ResponseStructure<List<Booking>>>(structure,HttpStatus.FOUND);
//		}
//		throw new BookingListNotFound("Booking list doesn't exist");
//	}
	
	
}
