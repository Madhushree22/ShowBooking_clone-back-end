package com.jsp.CloneApiBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApiBookMyShow.dao.MovieDao;
import com.jsp.CloneApiBookMyShow.dao.ProductionHouseDao;
import com.jsp.CloneApiBookMyShow.dto.MovieDto;
import com.jsp.CloneApiBookMyShow.entity.Movie;
import com.jsp.CloneApiBookMyShow.entity.ProductionHouse;
import com.jsp.CloneApiBookMyShow.exception.MovieIdNotFoundException;
import com.jsp.CloneApiBookMyShow.exception.ProductionHouseIdNotFoundException;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@Service
public class MovieService {
	
	@Autowired
	private MovieDao dao;
	
	@Autowired
	private ProductionHouseDao pdao;
	
	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(long productionId, MovieDto movieDto) {
		ProductionHouse house=pdao.getProductionHouseById(productionId);
		if(house!=null)
		{
			//add movie
			Movie movie=this.modelMapper.map(movieDto, Movie.class);
			movie.setProductionHouse(house);
			Movie dbMovie=dao.saveMovie(movie);
			//update production house
			if(house.getMovies().isEmpty())
			{
				List<Movie> list=new ArrayList<Movie>();
				list.add(movie);
				house.setMovies(list);
				pdao.updateProductionHouse(productionId, house);
			}
			else
			{
				List<Movie> list=house.getMovies();
				list.add(movie);
				house.setMovies(list);
				pdao.updateProductionHouse(productionId, house);
			}
			
			ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie Saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(this.modelMapper.map(dbMovie, MovieDto.class));
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.CREATED);
			
		}
		else
		{
			throw new ProductionHouseIdNotFoundException("sorry cant add the movies");
		}
	}



	public ResponseEntity<ResponseStructure<MovieDto>> findMovieById(long movieId) {
		Movie dbmovie=dao.getMovieById(movieId);
		if(dbmovie!=null)
		{
			ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie fecthed successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(this.modelMapper.map(dbmovie, MovieDto.class));
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.FOUND);
			
		}
		else
		{
			throw new MovieIdNotFoundException("cant fetch the movie");
		}
		
	}



	public ResponseEntity<ResponseStructure<MovieDto>> updateMovieById(long movieId, MovieDto movieDto) {
		
		Movie movie=this.modelMapper.map(movieDto, Movie.class);
		Movie dbMovie=dao.UpdateMovie(movieId, movie);
		if(dbMovie!=null)
		{
			ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(this.modelMapper.map(dbMovie, MovieDto.class));
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.OK);
			
		}
		else
		{
			throw new MovieIdNotFoundException("sorry failed to update the movie");
		}
	}



	public ResponseEntity<ResponseStructure<MovieDto>> deleteMovieById(long movieId) {
		Movie dbmovie=dao.deleteMovieById(movieId);
		if(dbmovie!=null)
		{
			ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
			structure.setMessage("Movie deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(this.modelMapper.map(dbmovie, MovieDto.class));
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.FOUND);
			
		}
		else
		{
			throw new MovieIdNotFoundException("cant fetch the movie");
		}
	}

}
