package com.springproject.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.dao.MoviesDao;
import com.springproject.bookmyshow.entity.Booking;
import com.springproject.bookmyshow.entity.Movies;
import com.springproject.bookmyshow.exception.MovieListNotFound;
import com.springproject.bookmyshow.exception.MovieNotFound;
import com.springproject.bookmyshow.util.ResponseStructure;

@Service
public class MovieService {

	@Autowired
	MoviesDao mdao;
	
	public ResponseEntity<ResponseStructure<Movies>> saveMovies(Movies movies){
		Movies newMovies = mdao.saveMovies(movies);
		
		ResponseStructure<Movies> structure=new ResponseStructure<Movies>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Movies Saved");
		structure.setData(newMovies);
		return new ResponseEntity<ResponseStructure<Movies>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Movies>> findMovies(int moviesId){
		Movies movies = mdao.findMovies(moviesId);
		
		if(movies != null) {
			
			ResponseStructure<Movies> structure = new ResponseStructure<Movies>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Movies Found");
			structure.setData(movies);
			return new ResponseEntity<ResponseStructure<Movies>>(structure,HttpStatus.CREATED);
		
		}
		
		throw new MovieNotFound("Movies not found for the given Id ");
	}
	
	public ResponseEntity<ResponseStructure<Movies>> deleteMovies(int moviesId) {
		Movies movies = mdao.findMovies(moviesId);

		
		if(movies !=null){
			Movies movie = mdao.deleteMovies(moviesId);

				ResponseStructure<Movies> structure = new ResponseStructure<Movies>();
				structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("Movies deleted");
				structure.setData(movie);
				return new ResponseEntity<ResponseStructure<Movies>>(structure,HttpStatus.OK);
			}
			throw new MovieNotFound("Movies not found for the given id");
		}
	
	public ResponseEntity<ResponseStructure<Movies>> updateMovies(Movies movies,int movieId) {
		ResponseStructure<Movies> structure = new ResponseStructure<Movies>();
		Movies movie =mdao.updateMovies(movieId, movies);
	
		
	
		if(movie !=null) {
			
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Movies updated");
			structure.setData(mdao.updateMovies(movieId, movies));
			return new ResponseEntity<ResponseStructure<Movies>>(structure,HttpStatus.OK);
		}
		throw new MovieNotFound("Booking not found for the given id in update");
	}
	
//	public ResponseEntity<ResponseStructure<List<Movies>>> findAllMovies(){
//		List<Movies> movies = mdao.findAllMovies();
//		
//		if(movies != null) {
//			List<Movies> movie = new ArrayList<Movies>();
//			ModelMapper mapper = new ModelMapper();
//			
//			for(Movies mov : mdao.findAllMovies()) {
//				Movies moviess = new Movies();
//				mapper.map(mov, moviess);
//				movie.add(moviess);
//			}
//			
//			ResponseStructure<List<Movies>> structure = new ResponseStructure<List<Movies>>();
//			structure.setStatus(HttpStatus.FOUND.value());
//			structure.setMessage("found all Movies");
//			structure.setData(movie);
//			
//			return new ResponseEntity<ResponseStructure<List<Movies>>>(structure,HttpStatus.FOUND);
//		}
//		throw new MovieListNotFound("Movie list doesn't exist");
//	}
	
}

