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

import com.springproject.bookmyshow.entity.Movies;
import com.springproject.bookmyshow.service.MovieService;
import com.springproject.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("movies")
public class MoviesController {

	@Autowired
	MovieService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Movies>> saveMovies(@RequestBody Movies movies) {
		return service.saveMovies(movies);
		}
	@GetMapping
	public ResponseEntity<ResponseStructure<Movies>> findMovies(@RequestParam int movieId){
		return service.findMovies(movieId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movies>> deleteMovies(@RequestParam int movieId){
		return service.deleteMovies(movieId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Movies>> updateMovies(@RequestBody Movies movies,@RequestParam int movieId){
		return service.updateMovies(movies, movieId);
	}
//	@GetMapping("findmovies")
//	public ResponseEntity<ResponseStructure<List<Movies>>> findAll(){
//		return service.findAllMovies();
//	}
	
}

