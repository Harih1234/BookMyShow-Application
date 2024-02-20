package com.springproject.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.dao.ScreenDao;
import com.springproject.bookmyshow.dao.ShowsDao;
import com.springproject.bookmyshow.dao.TheatreDao;
import com.springproject.bookmyshow.entity.Admin;
import com.springproject.bookmyshow.entity.Booking;
import com.springproject.bookmyshow.entity.Movies;
import com.springproject.bookmyshow.entity.Screen;
import com.springproject.bookmyshow.entity.Shows;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.entity.TypeOfSeats;
import com.springproject.bookmyshow.exception.BookingListNotFound;
import com.springproject.bookmyshow.exception.BookingNotFound;
import com.springproject.bookmyshow.exception.MovieListNotFound;
import com.springproject.bookmyshow.exception.ScreenListNotFound;
import com.springproject.bookmyshow.exception.ScreenNotFound;
import com.springproject.bookmyshow.util.ResponseStructure;

@Service
public class ScreenService {

	@Autowired
	ScreenDao sdao;
	
	@Autowired
	TheatreDao tdao;
	@Autowired
	ShowsDao shdao;
	
	
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen screen){
		Screen newScreen = sdao.saveScreen(screen);
		
		ResponseStructure<Screen> structure=new ResponseStructure<Screen>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Screen Saved");
		structure.setData(newScreen);
		return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Screen>> findScreen(int screenId){
		Screen screen = sdao.findScreen(screenId);
		
		if(screen != null) {
			
			
			ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Screen Found");
			structure.setData(screen);
			return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.CREATED);
		}
		throw new ScreenNotFound("Screen not found for the given Id ");
	}
	
	public ResponseEntity<ResponseStructure<Screen>> deletScreen(int screenId) {
		Screen screen = sdao.findScreen(screenId);

		
		if(screen !=null){
			Screen screens = sdao.deleteScreen(screenId);

				ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("Screen deleted");
				structure.setData(screens);
				return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
			}
			throw new ScreenNotFound("Screen not found for the given id");
		}
	
	public ResponseEntity<ResponseStructure<Screen>> updateScreen(Screen screen,int screenId) {
		ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
		Screen screens =sdao.updateScreen(screenId, screen);
	
		
	
		if(screen !=null) {
			
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Screen updated");
			structure.setData(sdao.updateScreen(screenId, screens));
			return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
		}
		throw new ScreenNotFound("Screen not found for the given id in update");
	}
	
	public ResponseEntity<ResponseStructure<Screen>> assignShowUsingScreenId(int screenId,int showId){
		Screen scr = sdao.findScreen(screenId);
		Shows show = shdao.findShows(showId);
		ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
		
		if(scr!=null) {
			if(show != null) {
				scr.getShows().set(showId, show);
				structure.setData(sdao.updateScreen(screenId, scr));
				structure.setMessage("Theatre Assigned to Admin");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
				
			}
			return null;
		}	
		return null;
	}
	
//	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreens(){
//			List<Screen> screen = sdao.findAllScreen();
//			
//			if(screen != null) {
//				List<Screen> screens = new ArrayList<Screen>();
//				ModelMapper mapper = new ModelMapper();
//				
//				for(Screen scr : sdao.findAllScreen()) {
//					Screen screenss = new Screen();
//					mapper.map(scr, screenss);
//					screen.add(screenss);
//				}
//				
//				ResponseStructure<List<Screen>> structure = new ResponseStructure<List<Screen>>();
//				structure.setStatus(HttpStatus.FOUND.value());
//				structure.setMessage("found all Screen");
//				structure.setData(screens);
//				
//				return new ResponseEntity<ResponseStructure<List<Screen>>>(structure,HttpStatus.FOUND);
//			}
//			throw new MovieListNotFound("Screen list doesn't exist");
//		}
//	
	
	
//	public ResponseEntity<ResponseStructure<Screen>> updateScreenSeats(Screen screen,int screenId,int noOfSeats) {
//		Screen screenType =sdao.findScreen(screenId);
//		if(screenType!=null) {
//			TypeOfSeats arr[]= {TypeOfSeats.FIRST_CLASS,TypeOfSeats.SECOND_CLASS,TypeOfSeats.THIRD_CLASS};
//			for(int i= 0 ;i<arr.length;i++) {
//				System.out.println("Type Of Seat"+i+" "+arr[i]);
//			}
//			
//		Screen seats =sdao.findScreen(noOfSeats);
//		
//			if(seats != null) {
//			seats.getNoOfSeats();
//				for(int i=0;i<=10;i++) {
//					System.out.println("No of Seats Booked"+i);
//					seats.setNoOfSeats(noOfSeats);
//					screenType.setNoOfSeats(noOfSeats);
//				}
//			}
//		
//			ResponseStructure<Screen> structure = new ResponseStructure<Screen>();
//			structure.setStatus(HttpStatus.CREATED.value());
//			structure.setMessage("Seats boooked");
//			structure.setData(screenType);
//			return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
//	}
//		throw new ScreenNotFound("Screen not found for the given id in update");
//	}
	
}
