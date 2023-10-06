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

import com.jsp.CloneApiBookMyShow.dto.MovieShowDto;
import com.jsp.CloneApiBookMyShow.entity.MovieShow;
import com.jsp.CloneApiBookMyShow.service.MovieShowService;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/shows")
public class MovieShowController {
	
	@Autowired
	private MovieShowService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MovieShow>> saveMovieshow(@RequestParam long theatreId,@RequestBody MovieShowDto movieShowDto)
	{
		return service.saveMovieshow(theatreId,movieShowDto);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MovieShow>> findMovieshowById(@RequestParam long MshowId)
	{
		return service.findMovieshowById(MshowId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<MovieShow>> updateMovieshowById(@RequestParam long MshowId,@RequestBody MovieShowDto movieShowDto)
	{
		return service.updateMovieshowById(MshowId,movieShowDto);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MovieShowDto>> deleteMovieshowById(@RequestParam long MshowId)
	{
		return service.deleteMovieshowById(MshowId);
	}

}
