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
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int userId;
	private String userName;
	private String userMail;
	private String userPassword;
	private long userContact;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> booking;

	
	
}
