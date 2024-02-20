package com.springproject.bookmyshow.exception;

public class MovieListNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public MovieListNotFound(String message) {
		super();
		this.message = message;
	}
	
}
