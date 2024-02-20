package com.springproject.bookmyshow.controller;

import java.util.List;

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

import com.springproject.bookmyshow.entity.Screen;
import com.springproject.bookmyshow.entity.Theatre;
import com.springproject.bookmyshow.service.ScreenService;
import com.springproject.bookmyshow.service.TheatreService;
import com.springproject.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("screen")
public class ScreenController {

	@Autowired
	ScreenService service;
//	@Autowired
//	TheatreService services;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(@RequestBody  Screen screen){
		return service.saveScreen(screen);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Screen>> finScreen(@RequestParam  int screenId){
		return service.findScreen(screenId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(@RequestParam int screenId){
		return service.deletScreen(screenId);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Screen>> updateScreen(@RequestBody Screen screen,@RequestParam int screenId){
		return service.updateScreen(screen, screenId);
	}
//	@GetMapping("findscreen")
//	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreen(){
//		return service.findAllScreens();
//	}
//
//	@PostMapping("savescreen")
//	public ResponseEntity<ResponseStructure<Screen>> assignScreenUsingTheatre(@RequestBody Theatre theatre,@RequestBody  Screen screen,@RequestParam int theatreId , @RequestParam int screenId){
//		return service.assignScreenUsingTheatre(theatre, screen, screenId, theatreId);
//				
//	}
}