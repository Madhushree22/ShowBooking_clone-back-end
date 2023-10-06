package com.jsp.CloneApiBookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApiBookMyShow.entity.MovieShow;
import com.jsp.CloneApiBookMyShow.entity.Theatre;
import com.jsp.CloneApiBookMyShow.repository.TheatreRepo;

@Repository
public class TheatreDao {
	
	@Autowired
	private TheatreRepo repo;

	public Theatre saveTheatre(Theatre theatre) {
		return repo.save(theatre);
	}

	public Theatre findTheatreById(long theatreId) {
		Optional<Theatre> optional=repo.findById(theatreId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public Theatre updateTheatreById(long theatreId, Theatre dbTheatre) {
		Optional<Theatre> optional=repo.findById(theatreId);
		if(optional.isPresent())
		{
			Theatre oldTheatre=optional.get();
			dbTheatre.setTheatreId(theatreId);
			dbTheatre.setAddress(oldTheatre.getAddress());
			dbTheatre.setOwner(oldTheatre.getOwner());
			dbTheatre.setMovieshows(oldTheatre.getMovieshows());
			dbTheatre.setScreen(oldTheatre.getScreen());
			return repo.save(dbTheatre);
			
					
		}
		return null;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Theatre deleteTheatreById(long theatreId) {
		Optional<Theatre> optional=repo.findById(theatreId);
		if(optional.isPresent())
		{
			Theatre th=optional.get();
			th.setAddress(null);
			th.setOwner(null);
			List<MovieShow> list=optional.get().getMovieshows();
			for(MovieShow show:list)
			{
				show.setTheatre(null);
			}
			
			
			repo.deleteById(theatreId);
			return optional.get();
		}
		return null;
	}

	
	

}
