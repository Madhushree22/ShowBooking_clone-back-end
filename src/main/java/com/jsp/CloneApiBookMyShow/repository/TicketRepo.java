package com.jsp.CloneApiBookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.CloneApiBookMyShow.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long>{

}
