package com.springproject.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.entity.Shows;

public interface ShowsRepo extends JpaRepository<Shows, Integer>{

}
