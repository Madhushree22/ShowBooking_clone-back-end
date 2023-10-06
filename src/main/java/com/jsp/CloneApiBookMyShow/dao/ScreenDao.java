package com.jsp.CloneApiBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.CloneApiBookMyShow.dto.ScreenDto;
import com.jsp.CloneApiBookMyShow.entity.Screen;
import com.jsp.CloneApiBookMyShow.entity.Theatre;
import com.jsp.CloneApiBookMyShow.repository.ScreenRepo;

@Repository
public class ScreenDao {
	
	@Autowired
	private ScreenRepo repo;
	
	public Screen saveScreen(Screen screen)
	{
		return repo.save(screen);
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////	
	public Screen findScreenById(long screenId)
	{
		Optional<Screen> optional=repo.findById(screenId);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Screen updateScreen(long screenId,Screen screen)
	{
       Optional<Screen> optional=repo.findById(screenId);
		
		if(optional.isPresent())
		{
			//Screen oldScreen=optional.get();
			screen.setScreenId(screenId);
			screen.setSeats(optional.get().getSeats());
			screen.setTheatre(optional.get().getTheatre());
			return repo.save(screen);
		}
		return null;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	   public Screen deleteScreenById(long screenId)
	   {
		   Optional<Screen> optional=repo.findById(screenId);
		   if(optional!=null)
		   {
			  Screen screen= optional.get();
			  Theatre theatre=screen.getTheatre();
			  theatre.setScreen(null);
			  screen.setTheatre(theatre);
			   repo.delete(screen);
			   return screen;
		   }
		   return null;
	   }

}
