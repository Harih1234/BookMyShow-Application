package com.springproject.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.entity.Movies;

public interface MoviesRepo extends JpaRepository<Movies, Integer> {

}
