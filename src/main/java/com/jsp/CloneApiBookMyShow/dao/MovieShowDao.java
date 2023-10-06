package com.jsp.CloneApiBookMyShow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.CloneApiBookMyShow.entity.MovieShow;
import com.jsp.CloneApiBookMyShow.repository.MovieRepo;
import com.jsp.CloneApiBookMyShow.repository.ShowRepo;

@Repository
public class MovieShowDao {
	

	@Autowired
	private ShowRepo repo;
	
	public MovieShow saveMovieShow(MovieShow movieShow)
	{
		return repo.save(movieShow);
	}

	public MovieShow updateShow(long MshowId, MovieShow movieShow) {
		Optional<MovieShow> optional=repo.findById(MshowId);
		if(optional.isPresent())
		{
			movieShow.setShowId(MshowId);
			movieShow.setTheatre(optional.get().getTheatre());
			return repo.save(movieShow);
		}
		return null;
	}

	public MovieShow findShowById(long MshowId) {
		Optional<MovieShow> optional=repo.findById(MshowId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
	}

	public MovieShow deleteMovieShow(long MshowId) {
		Optional<MovieShow> optional=repo.findById(MshowId);
		if(optional.isPresent())
		{
	
			MovieShow movieShow=optional.get();
			movieShow.setTheatre(null);
			repo.delete(movieShow);
			repo.deleteById(MshowId);
			return optional.get();
		}
		return null;
	}
	

	
	
	
}
	
	
	
	
