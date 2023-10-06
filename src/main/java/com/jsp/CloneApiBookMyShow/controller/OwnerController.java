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

import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

import com.jsp.CloneApiBookMyShow.dto.OwnerDto;
import com.jsp.CloneApiBookMyShow.entity.Owner;
import com.jsp.CloneApiBookMyShow.service.OwnerService;

@RestController
@RequestMapping("/ownerrr")
public class OwnerController {
	
	@Autowired
	private OwnerService service;
	
   @PostMapping
	public ResponseEntity<ResponseStructure<OwnerDto>> saveOwner(@RequestBody Owner owner){
		return service.saveOwner(owner);
	}
   @GetMapping
   public ResponseEntity<ResponseStructure<OwnerDto>> findOwnerById(@RequestParam long ownerId){
	  return service.findOwnerById(ownerId); 
   }
   
   @DeleteMapping
   public ResponseEntity<ResponseStructure<OwnerDto>> deleteOwnerById(@RequestParam long ownerId){
		  return service.deleteOwnerById(ownerId); 
	   }
   
   @PutMapping
   public ResponseEntity<ResponseStructure<OwnerDto>> updateOwnerById(@RequestParam long ownerId,@RequestBody Owner owner){
		  return service.updateOwnerById(ownerId,owner); 
	   }
   
   
}