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


import com.jsp.CloneApiBookMyShow.dto.AddressDto;
import com.jsp.CloneApiBookMyShow.entity.Address;
import com.jsp.CloneApiBookMyShow.service.AddressService;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> SaveAddress( @RequestBody AddressDto addressDto)
	{
		return service.saveAddress(addressDto);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam long addressId,@RequestBody AddressDto addressDto )
	{
		return service.updateAddress(addressId,addressDto);
	} 
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam long addressId)
	{
		return service.getAddressById(addressId);
	} 
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam long addressId)
	{
		return service.deleteAddressById(addressId);
	}

}

	
