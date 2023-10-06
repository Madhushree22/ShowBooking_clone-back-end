package com.jsp.CloneApiBookMyShow.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApiBookMyShow.entity.Booking;
import com.jsp.CloneApiBookMyShow.repository.BookingRepo;

@Repository
public class BookingDao {
	
	@Autowired
	private BookingRepo repo;
	public void saveBookig(Booking booking) {
		repo.save(booking);
	}

}
