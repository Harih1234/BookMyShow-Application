package com.springproject.bookmyshow.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.dto.AdminDto;
import com.springproject.bookmyshow.entity.Admin;
import com.springproject.bookmyshow.entity.Screen;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.repo.AdminRepo;
import com.springproject.bookmyshow.repo.ScreenRepo;
import com.springproject.bookmyshow.repo.TheatreRepo;

@Repository
public class TheatreDao {

	@Autowired
	AdminRepo arepo;
	
	@Autowired
	TheatreRepo trepo;
	
	@Autowired
	ScreenRepo srepo;
	
	@Autowired
	AdminDao adao;

	
	
	public Theatre saveThreatre(Theatre theatre) {
		return trepo.save(theatre);
	}
	
	public Theatre findTheatre(int theatreId) {
		Optional<Theatre> opTheatre = trepo.findById(theatreId);
		if(opTheatre.isPresent()) {
			return opTheatre.get();
		}
		return null;		
	}
	
	public Theatre deleteTheatre(int theatreId) {
		Theatre theatre = findTheatre(theatreId);
		trepo.delete(theatre);
		return theatre;
	}
	
	public Theatre updateTheatre(Theatre theatre,int theatreId) {
		Theatre exTheatre = findTheatre(theatreId);
		if(exTheatre != null) {
			theatre.setTheatreId(theatreId);
			return trepo.save(theatre);
		}
		return null;
	}
	
	public Theatre assignScreenUsingTheatreId(Theatre theatre, Screen screen,int theatreId,int screenId) {
		Theatre theatree = trepo.getById(theatreId);
		Screen screens = srepo.getById(screenId);
		
		theatree.getScreen().set(theatreId, screens);
		return trepo.save(theatre);
	}
	
//	public List<Theatre> findAllTheatre() {
//		List<Theatre> theatre = repo.findAll();
//		return theatre;
//	}
//	
	
	
//	public List<Theatre> getAllTheatre()
//	{
//		return trepo.findAll();
//	}
	
}
