package com.springproject.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.bookmyshow.dto.AdminDto;
import com.springproject.bookmyshow.entity.Admin;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.service.AdminService;
import com.springproject.bookmyshow.service.TheatreService;
import com.springproject.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("theatre")
public class TheatreController {

//	@Autowired
//	AdminService aservice;
	
	@Autowired
	TheatreService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestBody Theatre theatre){
		return service.saveTheatre(theatre);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(@RequestParam int theatreId){
		return service.findTheatre(theatreId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(@RequestParam int theatreId){
		return service.deletTheatre(theatreId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(@RequestBody Theatre theatre ,@RequestParam int theatreId){
		return service.updateTheatre(theatre, theatreId);
	}
	@PutMapping("assignScreen")
	public ResponseEntity<ResponseStructure<Theatre>> assignScreenUsingTheatreId(@RequestParam int screenId,@RequestParam int theatreId){
		return service.assignScreenUsingTheatreId(theatreId, screenId);
	}
//	@GetMapping("findall")
//	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatre(){
//		return service.findAllTheatres();
//	}
	
	
	
	
	
}
