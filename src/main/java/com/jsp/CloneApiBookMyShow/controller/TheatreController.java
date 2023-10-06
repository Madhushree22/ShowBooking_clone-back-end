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

import com.jsp.CloneApiBookMyShow.dto.TheatreDto;
import com.jsp.CloneApiBookMyShow.entity.Theatre;
import com.jsp.CloneApiBookMyShow.service.TheatreService;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
	@Autowired
	private TheatreService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestParam long ownerId,@RequestParam long addressId,@RequestBody  TheatreDto theatredto)
	{
		return service.saveTheatre(ownerId,addressId,theatredto);
		
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Theatre>> findTheatreById(@RequestParam long theatreId)
	{
		return service.findTheatreById(theatreId);
		
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatreById(@RequestParam long theatreId,@RequestBody TheatreDto theatredto )
	{
		return service.updateTheatreById(theatreId,theatredto);
		
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatreById(@RequestParam long theatreId )
	{
		return service.deleteTheatreById(theatreId);
		
	}
	
	

}
