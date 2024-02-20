package com.springproject.bookmyshow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Component
@Data
public class Screen {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int screenId;
	private String screenName;
	private int noOfSeats;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Shows> shows;
	@Enumerated(EnumType.STRING)
	private TypeOfSeats typeOfSeats;
	
	
	
}
