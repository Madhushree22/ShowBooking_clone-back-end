package com.jsp.CloneApiBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApiBookMyShow.dao.MovieDao;
import com.jsp.CloneApiBookMyShow.dao.MovieShowDao;
import com.jsp.CloneApiBookMyShow.dao.ScreenDao;
import com.jsp.CloneApiBookMyShow.dao.TheatreDao;
import com.jsp.CloneApiBookMyShow.dto.MovieShowDto;
import com.jsp.CloneApiBookMyShow.entity.Movie;
import com.jsp.CloneApiBookMyShow.entity.MovieShow;
import com.jsp.CloneApiBookMyShow.entity.Screen;
import com.jsp.CloneApiBookMyShow.entity.Theatre;
import com.jsp.CloneApiBookMyShow.enums.ScreenAvailabilty;
import com.jsp.CloneApiBookMyShow.exception.MovieIdNotFoundException;

import com.jsp.CloneApiBookMyShow.exception.ScreenAlreadyAllotedException;
import com.jsp.CloneApiBookMyShow.exception.ScreenIdNotFoundException;
import com.jsp.CloneApiBookMyShow.exception.ShowIdNotFoundException;
import com.jsp.CloneApiBookMyShow.exception.TheatreIdNotFoundExecption;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@Service
public class MovieShowService {
	
	@Autowired
	private MovieShowDao dao;
	@Autowired
	private TheatreDao tdao;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private ScreenDao sdao;
	
	@Autowired
	private MovieDao mdao;

	public ResponseEntity<ResponseStructure<MovieShow>> saveMovieshow(long theatreId, MovieShowDto movieShowDto) {
		Theatre dbtheatre=tdao.findTheatreById(theatreId);
		if(dbtheatre!=null)
		{
			MovieShow movieshow=this.modelmapper.map(movieShowDto, MovieShow.class);
			long screenId=movieshow.getScreenId();
			Screen dbScreen=sdao.findScreenById(screenId);
			if(dbScreen!=null)
			{
				if(dbScreen.getScreenAvailability().equals(ScreenAvailabilty.NOT_ALLOTED))
				{
					long movieId=movieshow.getMovieId();
					Movie dbMovie =mdao.getMovieById(movieId);
					if(dbMovie!=null)
					{
						//now add show to that movie
						movieshow.setMovieDescription(dbMovie.getMovieDescription());
						movieshow.setMovieDuration(dbMovie.getMovieDuration());
						movieshow.setMovieLanguage(dbMovie.getLanguage());
						movieshow.setMovieName(dbMovie.getMovieName());
						movieshow.setShowLocation(dbScreen.getScreenName());
						movieshow.setTheatre(dbtheatre);
						MovieShow show=dao.saveMovieShow(movieshow);
						
						if(dbtheatre.getMovieshows().isEmpty())
						{
							List<MovieShow> list=new ArrayList<MovieShow>();
							list.add(movieshow);
							dbtheatre.setMovieshows(list);
							tdao.updateTheatreById(theatreId, dbtheatre);
						}
						else
						{
							List<MovieShow> list=dbtheatre.getMovieshows();
							list.add(movieshow);
							dbtheatre.setMovieshows(list);
							tdao.updateTheatreById(theatreId, dbtheatre);
							
						}
						
						ResponseStructure<MovieShow> st=new ResponseStructure<MovieShow>();
						st.setMessage("show added successfully");
						st.setStatus(HttpStatus.CREATED.value());
						st.setData(show);
						return new ResponseEntity<ResponseStructure<MovieShow>>(st,HttpStatus.CREATED);
					}
					else
					{
						throw new MovieIdNotFoundException("sorry failed to add show");
					}
				}
				else
				{
					throw new ScreenAlreadyAllotedException ("sorry failed to add show");
				}
			}
			else
			{
				throw new ScreenIdNotFoundException("sorry failed to add show");
			}
		}
		else
		{
			throw new TheatreIdNotFoundExecption("sorry failed to add shows...");
		}
		
		
		
	}

	public ResponseEntity<ResponseStructure<MovieShow>> findMovieshowById(long MshowId) {
		MovieShow dbMovieShow=dao.findShowById(MshowId);
		if(dbMovieShow!=null)
		{
			ResponseStructure<MovieShow> st=new ResponseStructure<MovieShow>();
			st.setMessage("show fetched successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbMovieShow);
			return new ResponseEntity<ResponseStructure<MovieShow>>(st,HttpStatus.FOUND);
		}
		else
		{
			throw new ShowIdNotFoundException("sorry failed to update");
		}
	}

	public ResponseEntity<ResponseStructure<MovieShow>> updateMovieshowById(long MshowId, MovieShowDto movieShowDto) {
		MovieShow movieShow =this.modelmapper.map(movieShowDto, MovieShow.class);
		MovieShow dbMovieShow=dao.updateShow(MshowId,movieShow);
		if(dbMovieShow!=null)
		{

			ResponseStructure<MovieShow> st=new ResponseStructure<MovieShow>();
			st.setMessage("show updated successfully");
			st.setStatus(HttpStatus.OK.value());
			st.setData(dbMovieShow);
			return new ResponseEntity<ResponseStructure<MovieShow>>(st,HttpStatus.OK);
		}
		else
		{
			throw new ShowIdNotFoundException("sorry failed to update");
		}
		
		
	}

	public ResponseEntity<ResponseStructure<MovieShowDto>> deleteMovieshowById(long MshowId) {
		MovieShow dbMovieShow=dao.deleteMovieShow(MshowId);
		
		if(dbMovieShow!=null)
		{

			ResponseStructure<MovieShowDto> st=new ResponseStructure<MovieShowDto>();
			st.setMessage("show deleted successfully");
			st.setStatus(HttpStatus.OK.value());
			st.setData(dbMovieShow);
			return new ResponseEntity<ResponseStructure<MovieShowDto>>(st,HttpStatus.OK);
		}
		else
		{
			throw new ShowIdNotFoundException("sorry failed to update");
		}
		
	}

}
