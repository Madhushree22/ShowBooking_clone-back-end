package com.jsp.CloneApiBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApiBookMyShow.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long> {

}
