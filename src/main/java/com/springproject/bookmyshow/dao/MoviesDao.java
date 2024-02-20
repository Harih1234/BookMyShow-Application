package com.springproject.bookmyshow.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springproject.bookmyshow.entity.Movies;
import com.springproject.bookmyshow.repo.MoviesRepo;

@Repository
public class MoviesDao {

	@Autowired
	MoviesRepo repo;
	
	public Movies saveMovies(Movies movies) {
		return repo.save(movies);
		
	}
	
	public Movies findMovies(int movieId) {
		Optional<Movies> opMovies = repo.findById(movieId);
		if(opMovies.isPresent()) {
			return opMovies.get();
		}
	return null;
	}
	
	
	public Movies deleteMovies(int movieId) {
		Movies movies = findMovies(movieId);
		repo.delete(movies);
		return movies;
	}
	
	public Movies updateMovies(int moviesId, Movies movies) {
		Movies exMovies = findMovies(moviesId);
		if(exMovies != null) {
		movies.setMovieId(moviesId);
		return repo.save(movies);	
	}
		return null;
 }
	
	
//	public List<Movies> findAllMovies() {
//		List<Movies> movies = repo.findAll();
//		return movies;
//	}
}
