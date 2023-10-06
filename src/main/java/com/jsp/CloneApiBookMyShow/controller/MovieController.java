package com.jsp.CloneApiBookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.CloneApiBookMyShow.dto.MovieDto;
import com.jsp.CloneApiBookMyShow.service.MovieService;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(@RequestParam long productionId, @RequestBody MovieDto movieDto)
	{
		return service.saveMovie(productionId,movieDto);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MovieDto>> findMovieById(@RequestParam long movieId)
	{
		return service.findMovieById(movieId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<MovieDto>> updateMovieById(@RequestParam long movieId, @RequestBody MovieDto movieDto)
	{
		return service.updateMovieById(movieId,movieDto);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MovieDto>> deleteMovieById(@RequestParam long movieId)
	{
		return service.deleteMovieById(movieId);
	}

}
