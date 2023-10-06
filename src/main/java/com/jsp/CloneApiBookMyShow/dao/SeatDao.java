package com.jsp.CloneApiBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApiBookMyShow.entity.Screen;
import com.jsp.CloneApiBookMyShow.entity.Seat;
import com.jsp.CloneApiBookMyShow.repository.ScreenRepo;
import com.jsp.CloneApiBookMyShow.repository.SeatRepo;

@Repository
public class SeatDao {

	@Autowired
	private SeatRepo repo;
	
	public Seat saveSeat(Seat seat)
	{
		return repo.save(seat);
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////	
	public Seat findSeatById(long seatId)
	{
		Optional<Seat> optional=repo.findById(seatId);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Seat updateSeat(long seatId,Seat seat)
	{
       Optional<Seat> optional=repo.findById(seatId);
		
		if(optional.isPresent())
		{
			
			return repo.save(seat);
		}
		return null;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	   public Seat deleteSeatById(long seatId)
	   {
		   Optional<Seat> optional=repo.findById(seatId);
		   if(optional!=null)
		   {
			   repo.delete(optional.get());
			   return optional.get();
		   }
		   return null;
	   }

}
