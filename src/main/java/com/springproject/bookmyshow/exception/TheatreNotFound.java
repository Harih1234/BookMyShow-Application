package com.springproject.bookmyshow.exception;

public class TheatreNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public TheatreNotFound(String message) {
		
		this.message = message;
	}
	
	
}
