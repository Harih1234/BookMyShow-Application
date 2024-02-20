package com.springproject.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.entity.Screen;
import com.springproject.bookmyshow.entity.Shows;
import com.springproject.bookmyshow.entity.TypeOfSeats;
import com.springproject.bookmyshow.repo.ScreenRepo;
import com.springproject.bookmyshow.repo.ShowsRepo;

@Repository
public class ScreenDao {

	
	
//	@Autowired
//	TheatreRepo trepo;
	
	@Autowired
	ScreenRepo screpo;
	@Autowired
	ShowsRepo srepo;
	
	public Screen saveScreen(Screen screen) {
		return screpo.save(screen);
	}
	
	public Screen findScreen(int screenId) {
		Optional<Screen> opScreen= screpo.findById(screenId);
		if(opScreen.isPresent()) {
			return opScreen.get();
		}
		return null;
	}
	
	public Screen deleteScreen(int screenId) {
		Screen screen = findScreen(screenId);
		screpo.delete(screen);
		return screen;
	}
	
	public Screen updateScreen(int screenId,Screen screen) {
		Screen exScreen = findScreen(screenId);
		if(exScreen != null) {
		screen.setScreenId(screenId);
		return screpo.save(screen);	
		}
		return null;
   }
	
//	public Screen updateScreenType(Screen screen,int screenId ,int noOfSeats) {
//		Optional<Screen> opType = srepo.findById(screenId);
//		if(opType.isPresent()) {
//		return 	opType.get();
//		}
//		return null;
//	}
	
//	public List<Screen> findAllScreen() {
//	List<Screen> screen = srepo.findAll();
//	return screen;
//	}
//	
	public Screen assignBookingUsingShowsId(Shows shows,Screen screen,int showsId,int screenId) {
	Shows show = srepo.getById(showsId);
	Screen scr =screpo.getById(screenId);
	
	scr.getShows().set(screenId, show);
	return screpo.save(scr);
	


	
}
}
	
