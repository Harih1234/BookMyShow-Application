package com.springproject.bookmyshow.entity;

import java.time.LocalDate;



import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Component
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@NotNull(message="Booking Id cannot Be Null")
	private int bookingId;
	@NotNull(message="Booking Name cannot Be Null")
	private String bookingMovieName;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
	
	@NotNull(message="Booking Date cannot Be Null")
	private LocalDate bookingDate;
	@NotNull(message="Booking NoOfTickets cannot Be Null")
	private int noOfTickets;
		
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	
		
	}