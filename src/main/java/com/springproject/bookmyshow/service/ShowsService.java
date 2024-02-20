package com.springproject.bookmyshow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.dao.BookingDao;
import com.springproject.bookmyshow.dao.ShowsDao;
import com.springproject.bookmyshow.entity.Booking;
import com.springproject.bookmyshow.entity.Shows;

import com.springproject.bookmyshow.exception.ShowNotFound;
import com.springproject.bookmyshow.util.ResponseStructure;

@Service
public class ShowsService {

	@Autowired
	ShowsDao shdao;
	
	@Autowired
	BookingDao bdao;
	
	public ResponseEntity<ResponseStructure<Shows>> saveShows(Shows shows){
		Shows newShows = shdao.saveShows(shows);
		
		ResponseStructure<Shows> structure=new ResponseStructure<Shows>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Booking Saved");
		structure.setData(newShows);
		return new ResponseEntity<ResponseStructure<Shows>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Shows>> findShows(int showsId){
		Shows show = shdao.findShows(showsId);
		
		if(show != null) {
			
			
			ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Booking Found");
			structure.setData(show);
			return new ResponseEntity<ResponseStructure<Shows>>(structure,HttpStatus.CREATED);
		}
		throw new ShowNotFound("Show not found for the given Id ");
	}
	
	public ResponseEntity<ResponseStructure<Shows>> deleteShows(int showId) {
		Shows show = shdao.findShows(showId);

		
		if(show !=null){
			Shows shows = shdao.deleteShows(showId);

				ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("booking deleted");
				structure.setData(shows);
				return new ResponseEntity<ResponseStructure<Shows>>(structure,HttpStatus.OK);
			}
			throw new ShowNotFound("Show not found for the given id");
		}
	
	public ResponseEntity<ResponseStructure<Shows>> updateShows(Shows show,int showId) {
		ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
		Shows shows =shdao.updateShows(showId, show);
	
		
	
		if(shows !=null) {
			
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("admin updated");
			structure.setData(shdao.updateShows(showId, shows));
			return new ResponseEntity<ResponseStructure<Shows>>(structure,HttpStatus.OK);
		}
		throw new ShowNotFound("Show not found for the given id in update");
	}
	
//	public  ResponseEntity<ResponseStructure<Shows>> assignBookingUsingShowId(int showid,int booingId){
//		Shows show =shdao.findShows(showid);
//		Booking booking =bdao.findBooking(booingId);
//		
//		ResponseStructure<Shows> structure = new ResponseStructure<Shows>();
//		if(show != null) {
//			if(booking != null) {
//				show.getBooking().
//			}
//		}
//	}
//	public ResponseEntity<ResponseStructure<List<Shows>>> findAllShowss(){
//		List<Shows> show = shdao.findAllShows();
//		
//				
//		if(show != null) {
//		
//			List<Shows> shows = new ArrayList<Shows>();
//			ModelMapper mapper = new ModelMapper();
//			
//			for(Shows showss : shdao.findAllShows()){
//				Shows showsss = new Shows();
//				mapper.map(showss, showsss);
//				shows.add(showsss);
//			}
//			ResponseStructure<List<Shows>> structure = new ResponseStructure<List<Shows>>();
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setMessage("found all Shows");
//			structure.setData(shows);
//			return new ResponseEntity<ResponseStructure<List<Shows>>>(structure,HttpStatus.FOUND);
//		}
//		throw new ShowListNotFound("Shows list doesn't exist");
//	}
	
}
