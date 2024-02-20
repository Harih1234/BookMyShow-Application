package com.springproject.bookmyshow.exception;

public class MovieNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public MovieNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
