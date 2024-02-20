package com.springproject.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.dao.AdminDao;
import com.springproject.bookmyshow.dao.ScreenDao;
import com.springproject.bookmyshow.dao.TheatreDao;
import com.springproject.bookmyshow.dto.AdminDto;
import com.springproject.bookmyshow.entity.Admin;
import com.springproject.bookmyshow.entity.Screen;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.entity.User;
import com.springproject.bookmyshow.exception.ScreenNotFound;
import com.springproject.bookmyshow.exception.TheatreListNotFound;
import com.springproject.bookmyshow.exception.TheatreNotFound;
import com.springproject.bookmyshow.util.ResponseStructure;

@Service
public class TheatreService {

//	@Autowired
//	User udao;
	
	@Autowired
	AdminDao adao;
	
	@Autowired
	TheatreDao tdao;
	
	@Autowired
	ScreenDao sdao;
	
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre){
		Theatre newtheatre = tdao.saveThreatre(theatre);
		
		ResponseStructure<Theatre> structure=new ResponseStructure<Theatre>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Theatre Saved");
		structure.setData(newtheatre);
		return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(int theatreId){
		Theatre theatre = tdao.findTheatre(theatreId);
		
		if(theatre != null) {
			
			
			ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Theatre Found");
			structure.setData(theatre);
			return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.CREATED);
		}
		throw new TheatreNotFound("Theatre not found for the given Id ");
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> deletTheatre(int theatreId) {
		Theatre theatre = tdao.findTheatre(theatreId);

		
		if(theatre !=null){
			Theatre theatre1 = tdao.deleteTheatre(theatreId);

				ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("Theatre deleted");
				structure.setData(theatre);
				return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
			}
			throw new TheatreNotFound("Theatre not found for the given id");
		}
	
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(Theatre theatre,int theatreId) {
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		Theatre theatre2 =tdao.updateTheatre(theatre, theatreId);
	
		if(theatre2 !=null) {
			
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Theatre updated");
			structure.setData(tdao.updateTheatre(theatre2, theatreId));
			return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
		}
		throw new TheatreNotFound("Theatre not found for the given id in update");
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> assignScreenUsingTheatreId(int theatreId,int screenId){
		Theatre thea = tdao.findTheatre(theatreId);
		Screen scre = sdao.findScreen(screenId);
		ResponseStructure<Theatre> structure = new ResponseStructure<Theatre>();
		
		if(thea != null) {
			if(scre != null) {
				thea.getScreen().add(scre);
				structure.setData(tdao.updateTheatre(thea, theatreId));
				structure.setMessage("Screen Assigned to Theatre");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
			}
			throw new ScreenNotFound("Screen Not Found  Using Theatre Id");
		}
		return null;
	}
	
//	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatres(){
//		List<Theatre> theatre = tdao.findAllTheatre();
//		
//				
//		if(theatre != null) {
//			
//			List<Theatre> theatres = new  ArrayList<Theatre>();
//			ModelMapper mapper = new ModelMapper();
//			
//			for(Theatre  thea : tdao.findAllTheatre()) {
//				Theatre theatree = new Theatre();
//				mapper.map(thea, theatree);
//		}
//			ResponseStructure<List<Theatre>> structure = new ResponseStructure<List<Theatre>>();
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setMessage("found all Admin");
//			structure.setData(theatre);
//			return new ResponseEntity<ResponseStructure<List<Theatre>>>(structure,HttpStatus.FOUND);
//	}
//		throw new TheatreListNotFound(" Theatre list doesn't exist ");
//	}
//
	
	
	
}
