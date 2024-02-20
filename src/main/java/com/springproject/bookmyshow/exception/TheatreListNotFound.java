package com.springproject.bookmyshow.exception;

public class TheatreListNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public TheatreListNotFound(String message) {
	
		this.message = message;
	}
	
	
}
