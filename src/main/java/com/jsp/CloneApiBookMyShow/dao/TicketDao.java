package com.jsp.CloneApiBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApiBookMyShow.entity.Ticket;
import com.jsp.CloneApiBookMyShow.repository.TicketRepo;

@Repository
public class TicketDao {
	@Autowired
	private TicketRepo repo;

	public Ticket saveTicket(Ticket ticket) {
		return repo.save(ticket);
	}

	public Ticket cancelTicket(long ticketId) {
		Optional<Ticket> optional=repo.findById(ticketId);
		if(optional.isPresent())
		{
			 repo.deleteById(ticketId);
			 return  optional.get();
		}
		else
		{
			return null;
		}
		
	}

}
