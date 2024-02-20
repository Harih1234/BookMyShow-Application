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

import com.springproject.bookmyshow.entity.Shows;
import com.springproject.bookmyshow.service.ShowsService;
import com.springproject.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("shows")
public class ShowController {

	@Autowired
	ShowsService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Shows>> saveShows(@RequestBody  Shows shows){
		return service.saveShows(shows);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Shows>> findShows(@RequestParam  int showId){
		return service.findShows(showId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Shows>> deleteShows(@RequestParam int showId){
		return service.deleteShows(showId);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Shows>> updateShows(@RequestBody Shows shows,@RequestParam int showId){
		return service.updateShows(shows, showId);
	}
}
