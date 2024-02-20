package com.springproject.bookmyshow.exception;

public class BookingNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public BookingNotFound(String message) {
		super();
		this.message = message;
	}
	
	
	
}
