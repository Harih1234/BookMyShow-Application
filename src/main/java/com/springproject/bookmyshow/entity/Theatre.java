package com.springproject.bookmyshow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Component
@Data
public class Theatre {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int theatreId;
	private String theatreName;
	private String theatreLocation;
	private long theatreContact;
	private double theatreRatings;
	
//@ManyToOne(cascade = CascadeType.ALL)
//private Admin admin;
	
	
@OneToMany(cascade = CascadeType.ALL)
private List<Screen> screen;



}
