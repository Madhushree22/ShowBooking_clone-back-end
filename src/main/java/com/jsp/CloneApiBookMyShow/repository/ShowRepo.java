package com.jsp.CloneApiBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApiBookMyShow.entity.MovieShow;

public interface ShowRepo extends JpaRepository<MovieShow, Long> {

}
