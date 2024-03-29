package com.springproject.bookmyshow.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Component
@Data
public class Movies {


	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int movieId;
	private String movieName;
	private String movieLanguage;
	private String movieGenres;
 
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shows show;
	
}
