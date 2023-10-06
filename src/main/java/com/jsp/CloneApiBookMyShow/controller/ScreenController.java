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

import com.jsp.CloneApiBookMyShow.dto.ScreenDto;
import com.jsp.CloneApiBookMyShow.entity.Screen;
import com.jsp.CloneApiBookMyShow.service.ScreenService;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/screen")
public class ScreenController {
	
	@Autowired
	private ScreenService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> saveScreen(@RequestParam long theatreId,@RequestBody ScreenDto screenDto)
	{
		return  service.saveScreen(theatreId, screenDto);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> findScreenById(@RequestParam long screenId)
	{
		return service.findScreenById(screenId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> updateScreen(@RequestParam long screenId,@RequestBody ScreenDto screenDto)
	{
		return service.updateScreen(screenId,screenDto);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ScreenDto>> deleteScreenById(@RequestParam long screenId)
	{
		return service.deleteScreenById(screenId);
	}
	
	
	

}
