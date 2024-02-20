package com.springproject.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.entity.Booking;
import com.springproject.bookmyshow.entity.Screen;
import com.springproject.bookmyshow.entity.Shows;
import com.springproject.bookmyshow.repo.BookingRepo;
import com.springproject.bookmyshow.repo.ShowsRepo;

@Repository
public class ShowsDao {

	@Autowired
	ShowsRepo srepo;
	

	
	public Shows saveShows(Shows shows) {
		return srepo.save(shows);
	}
	
	public Shows findShows(int showsId) {
		Optional<Shows> opShows= srepo.findById(showsId);
		if(opShows.isPresent()) {
			return opShows.get();
		}
		return null;
	}
	
	public Shows deleteShows(int showsId) {
		Shows shows = findShows(showsId);
		srepo.delete(shows);
		return shows;
	}
	
	public Shows updateShows(int showsId,Shows shows) {
		Shows exShows = findShows(showsId);
		if(exShows != null) {
		shows.setShowId(showsId);
		return srepo.save(shows);
		}
		return null;
   }
	
	
	
//	public List<Shows> findAllShows() {
//	List<Shows> shows = repo.findAll();
//	return shows;
//	}
}
