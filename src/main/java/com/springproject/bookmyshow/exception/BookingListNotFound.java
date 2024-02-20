package com.springproject.bookmyshow.exception;

public class BookingListNotFound extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public BookingListNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
