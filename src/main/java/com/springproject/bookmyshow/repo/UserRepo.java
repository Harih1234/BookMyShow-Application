package com.springproject.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
