package com.jsp.CloneApiBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApiBookMyShow.dao.ScreenDao;
import com.jsp.CloneApiBookMyShow.dao.TheatreDao;
import com.jsp.CloneApiBookMyShow.dto.ScreenDto;
import com.jsp.CloneApiBookMyShow.dto.TheatreDto;
import com.jsp.CloneApiBookMyShow.entity.Screen;
import com.jsp.CloneApiBookMyShow.entity.Seat;
import com.jsp.CloneApiBookMyShow.entity.Theatre;
import com.jsp.CloneApiBookMyShow.enums.ScreenAvailabilty;
import com.jsp.CloneApiBookMyShow.enums.ScreenStatus;
import com.jsp.CloneApiBookMyShow.enums.ScreenType;
import com.jsp.CloneApiBookMyShow.enums.SeatType;
import com.jsp.CloneApiBookMyShow.exception.ScreenIdNotFoundException;
import com.jsp.CloneApiBookMyShow.exception.TheatreIdNotFoundExecption;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@Service
public class ScreenService {
	
	@Autowired
	private ScreenDao dao;
	
	@Autowired
	private TheatreDao tdao;
	
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<ScreenDto>> saveScreen(long theatreId, ScreenDto screenDto) {
		Theatre theatre=tdao.findTheatreById(theatreId);
		if(theatre!=null)
		{
			Screen screen=this.modelMapper.map(screenDto, Screen.class);
			
			//screen variable we r having classic platinum gold seat
			// screen is having seat object??? no
			//want to add it now...............
			// screen is having theatre? no but we are having theatre object so need to set it(theatre)
			
			List<Seat> seats=new ArrayList<Seat>();//object creation
			for(int a=screen.getNoOfClassicSeat(); a>0; a--) {
				Seat seat=new Seat();
				seat.setSeatType(SeatType.CLASSIC);
				seat.setScreen(screen);
				seats.add(seat);

			}
			for(int b=screen.getNoOfPlatinumSeat(); b>0; b--) {
				Seat seat=new Seat();
				seat.setSeatType(SeatType.PLATINUM);
				seat.setScreen(screen);
				seats.add(seat);
			}
			for(int c=screen.getNoOfGoldSeat(); c>0; c--) {
				Seat seat=new Seat();
				seat.setSeatType(SeatType.GOLD);
				seat.setScreen(screen);
				seats.add(seat);
			}
		//	screen.setScreenName();
			screen.setSeats(seats);
			screen.setTheatre(theatre);
			screen.setScreenAvailability(ScreenAvailabilty.NOT_ALLOTED);
			screen.setScreenstatus(ScreenStatus.AVAILABLE);
			Screen dbScreen=dao.saveScreen(screen);
			//update   theatre
			if(theatre.getScreen().isEmpty())
			{
				List<Screen> screens =new ArrayList<Screen>();
				screens.add(dbScreen);
				theatre.setScreen(screens);
				 tdao.updateTheatreById(theatreId, theatre);
			}
			else
			{
				 List<Screen> screens=theatre.getScreen();
            	 screens.add(dbScreen);
            	 theatre.setScreen(screens);
            	 tdao.updateTheatreById(theatreId, theatre);
			}
			
			ScreenDto dto=this.modelMapper.map(dbScreen,ScreenDto.class);
			ResponseStructure<ScreenDto> structure=new ResponseStructure<ScreenDto>();
	         structure.setMessage("Screen saved successfully");
	         structure.setStatus(HttpStatus.CREATED.value());
	         structure.setData(dto);
	         return new ResponseEntity<ResponseStructure<ScreenDto>>(structure,HttpStatus.CREATED);  
			
		}
		else
		{
			throw new TheatreIdNotFoundExecption("failed to add screen");
		}
		
	}
	
	
	

	public ResponseEntity<ResponseStructure<ScreenDto>> findScreenById(long screenId) {
		Screen dbscreen=dao.findScreenById(screenId);
		if(dbscreen!=null)
		{
			ScreenDto dto=this.modelMapper.map(dbscreen, ScreenDto.class);
			ResponseStructure<ScreenDto> st=new ResponseStructure<ScreenDto>();
			st.setMessage("screen fetched successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(st);
			return new ResponseEntity<ResponseStructure<ScreenDto>>(st,HttpStatus.FOUND);
		}
		else
		{
			throw new ScreenIdNotFoundException("cant be found..");
		}
	}

	public ResponseEntity<ResponseStructure<ScreenDto>> updateScreen(long screenId, ScreenDto screenDto) {
		
		Screen screen=this.modelMapper.map(screenDto, Screen.class);
		Screen dbScreen=dao.updateScreen(screenId, screen);
		if(dbScreen!=null)
		{
			ScreenDto dto=this.modelMapper.map(dbScreen, ScreenDto.class);
			ResponseStructure<ScreenDto> st=new ResponseStructure<ScreenDto>();
			st.setMessage("screen updated sucessfully");
			st.setStatus(HttpStatus.OK.value());
			st.setData(dto);
			return new ResponseEntity<ResponseStructure<ScreenDto>> (st,HttpStatus.OK);
		}
		else
		{
			throw new ScreenIdNotFoundException("id not found");
		}
	}

	public ResponseEntity<ResponseStructure<ScreenDto>> deleteScreenById(long screenId) {
		Screen dbScreen=dao.deleteScreenById(screenId);
		if(dbScreen!=null)
		{
			ScreenDto dto=this.modelMapper.map(dbScreen, ScreenDto.class);
			ResponseStructure<ScreenDto> st=new ResponseStructure<ScreenDto>();
			st.setMessage("screen deleted sucessfully");
			st.setStatus(HttpStatus.NOT_FOUND.value());
			st.setData(dto);
			return new ResponseEntity<ResponseStructure<ScreenDto>> (st,HttpStatus.NOT_FOUND);
		}
		else
		{
			throw new ScreenIdNotFoundException("id not found");
		}
	}

}
