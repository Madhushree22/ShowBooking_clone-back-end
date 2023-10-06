package com.jsp.CloneApiBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApiBookMyShow.dao.BookingDao;
import com.jsp.CloneApiBookMyShow.dao.CustomerDao;
import com.jsp.CloneApiBookMyShow.dao.MovieShowDao;
import com.jsp.CloneApiBookMyShow.dao.SeatDao;
import com.jsp.CloneApiBookMyShow.dao.TicketDao;
import com.jsp.CloneApiBookMyShow.entity.Booking;
import com.jsp.CloneApiBookMyShow.entity.Customer;
import com.jsp.CloneApiBookMyShow.entity.MovieShow;
import com.jsp.CloneApiBookMyShow.entity.Seat;
import com.jsp.CloneApiBookMyShow.entity.Ticket;
import com.jsp.CloneApiBookMyShow.enums.BookingStatus;
import com.jsp.CloneApiBookMyShow.enums.SeatType;
import com.jsp.CloneApiBookMyShow.enums.ShowStatus;
import com.jsp.CloneApiBookMyShow.enums.TicketStatus;
import com.jsp.CloneApiBookMyShow.exception.CustomerIdNotFoundException;
import com.jsp.CloneApiBookMyShow.exception.SeatIdNotFoundException;
import com.jsp.CloneApiBookMyShow.exception.ShowIsNotActiveException;
import com.jsp.CloneApiBookMyShow.exception.TicketAlreadyCancelledException;
import com.jsp.CloneApiBookMyShow.exception.TicketAlreadyExpiredException;
import com.jsp.CloneApiBookMyShow.exception.TicketCannotBeCancelledException;
import com.jsp.CloneApiBookMyShow.exception.TicketIdNotFoundException;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@Service
public class TicketService {
	@Autowired
	private TicketDao dao;
	@Autowired
	private CustomerDao cdao;
	@Autowired
	private MovieShowDao mdao;
	@Autowired
	private SeatDao sdao;
	@Autowired
	private BookingDao bDao;

	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(long customerId, long showId, long seatId) {
		Customer dbCustomer=cdao.findCustomerById(customerId);
		Ticket ticket=new Ticket();
		if(dbCustomer!=null)
		{
			ticket.setCustomer(dbCustomer);
		}
		else
		{
			throw new CustomerIdNotFoundException("ticket cant be booked");
		}
		
		MovieShow dbMovieShow=mdao.findShowById(showId);
		if(dbMovieShow!=null)
		{
			if(dbMovieShow.getShowStatus().equals(ShowStatus.ACTIVE))
			{
				ticket.setMovieshow(dbMovieShow);
			}
			else
			{
				throw new ShowIsNotActiveException("ticket cant be booked");
			}
		}
		else
			{
			throw new CustomerIdNotFoundException("ticket cant be booked");
			}
		
		List<Booking> bookings=new ArrayList<Booking>();
		List<Seat> seats=new ArrayList<Seat>();
		double totalPrice=0;
		
		Seat dbSeat=sdao.findSeatById(seatId);
		if(dbSeat!=null)
		{
			Booking booking=new Booking();
			booking.setSeatId(dbSeat.getSeatId());
			booking.setSeatType(dbSeat.getSeatType());
			booking.setBookingstatus(BookingStatus.ACTIVE);
			booking.setBookingFromTime(dbMovieShow.getShowStartTime());
			booking.setBookingTillTime(dbMovieShow.getShowEndTime());
			
			SeatType seatType=booking.getSeatType();
			switch (seatType) {
			case CLASSIC:
				booking.setSeatPrice(dbMovieShow.getClassicSeatPrice());
				totalPrice+=dbMovieShow.getClassicSeatPrice();
				break;
				
			case PLATINUM:
				booking.setSeatPrice(dbMovieShow.getPlatinumSeatPrice());
				totalPrice+=dbMovieShow.getPlatinumSeatPrice();
				break;
				
			case GOLD:
				booking.setSeatPrice(dbMovieShow.getGoldSeatPrice());
				totalPrice+=dbMovieShow.getGoldSeatPrice();
				break;

			
			}
			
			bookings.add(booking);
			seats.add(dbSeat);
			bDao.saveBookig(booking);
			
			ticket.setBookings(bookings);
			ticket.setTotalPrice(totalPrice);
			ticket.setTicketStatus(TicketStatus.ACTIVE);
			Ticket dbTicket=dao.saveTicket(ticket);
			ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
		     structure.setMessage("Ticket Booked successfully");
		     structure.setStatus(HttpStatus.CREATED.value());
		     structure.setData(dbTicket);
		     return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.CREATED);
		     
		}
		
		
		
		
		else
		{
			throw new SeatIdNotFoundException("ticket cant be booked");
		}
		
		
		
	}

	public ResponseEntity<ResponseStructure<Ticket>> cancelTicket(long ticketId) {
		Ticket dbTicket=dao.cancelTicket(ticketId);
		if(dbTicket!=null)
		{
			if(dbTicket.getMovieshow().getShowStatus().equals(ShowStatus.ONGOING))
			{
				throw new TicketCannotBeCancelledException("sorry failed to cancel the ticket");
			}
			else if(dbTicket.getTicketStatus().equals(TicketStatus.CANCELLED))
			{
				throw new TicketAlreadyCancelledException("sorry failed to cancel the ticket");
			}
			else if(dbTicket.getTicketStatus().equals(TicketStatus.EXPIRED))
			{
				throw new TicketAlreadyExpiredException("sorry failed to cancel the ticket");
			}
			else
			{
				List<Booking> bookings=dbTicket.getBookings();
				for(Booking b:bookings)
				{
					b.setBookingstatus(BookingStatus.CANCELLED);
					bDao.saveBookig(b);
				}
				dbTicket.setTicketStatus(TicketStatus.CANCELLED);
				dao.saveTicket(dbTicket);
				ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
			     structure.setMessage("Ticket deleted successfully");
			     structure.setStatus(HttpStatus.FOUND.value());
			     structure.setData(dbTicket);
			     return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.FOUND);
			     
				
			}
			
		}
		else
		{
			throw new TicketIdNotFoundException("sorry cant cancel the ticket");
			
		}
		
		
	}

}
