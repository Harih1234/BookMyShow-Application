package com.springproject.bookmyshow.entity;


import java.time.LocalTime;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Component
@Data
public class Shows {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int showId;
	private String showName;
	@JsonFormat(pattern ="HH:mm:ss",shape=Shape.STRING)
	private LocalTime showTimings;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Screen screen;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Booking booking;


}
