package com.jsp.CloneApiBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApiBookMyShow.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long>{

}
