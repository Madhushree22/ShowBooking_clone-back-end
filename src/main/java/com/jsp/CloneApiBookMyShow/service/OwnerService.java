package com.jsp.CloneApiBookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.CloneApiBookMyShow.dao.OwnerDao;

import com.jsp.CloneApiBookMyShow.dto.OwnerDto;
import com.jsp.CloneApiBookMyShow.entity.Owner;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;
import com.jsp.CloneApiBookMyShow.exception.OwnerIdNotFoundExecption;


@Service
public class OwnerService {
	
	@Autowired
	private OwnerDao ownerDao;
	
	
	public ResponseEntity<ResponseStructure<OwnerDto>> saveOwner(@RequestBody Owner owner)
	{
//		Owner dbbowner=ownerDao.saveOwner(owner);
		
		Owner dbowner= ownerDao.saveOwner(owner);
		OwnerDto dto= new OwnerDto();
		dto.setOwnerId(owner.getOwnerId());
		dto.setOwerName(owner.getOwnerName());
		dto.setOwnerEmail(owner.getOwnerEmail());
		dto.setOwnerPhoneNumber(owner.getOwnerPhoneNumber());
		
		
		ResponseStructure<OwnerDto> st=new ResponseStructure<OwnerDto>();
		st.setMessage("owner saved successfully");
		st.setStatus(HttpStatus.CREATED.value());
		st.setData(dto);
		
		return new ResponseEntity<ResponseStructure<OwnerDto>>(st,HttpStatus.CREATED);
		
		
		
		
	}


	public ResponseEntity<ResponseStructure<OwnerDto>> findOwnerById(long ownerId) {	
		Owner dbOwner=ownerDao.findOwnerById(ownerId);
		if(dbOwner!=null) {
			OwnerDto dto=new OwnerDto();
			dto.setOwnerId(dbOwner.getOwnerId());
			dto.setOwerName(dbOwner.getOwnerName());
			dto.setOwnerEmail(dbOwner.getOwnerEmail());
			dto.setOwnerPhoneNumber(dbOwner.getOwnerPhoneNumber());
			
			ResponseStructure<OwnerDto> structure=new ResponseStructure<OwnerDto>();
			structure.setMessage("OwnerData fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<OwnerDto>>(structure,HttpStatus.FOUND);
		}else {
			
			throw new OwnerIdNotFoundExecption("sorry this cant be fetched");
		}
	}


	public ResponseEntity<ResponseStructure<OwnerDto>> deleteOwnerById(long ownerId) {
		
		Owner dbOwner=ownerDao.deleteOwnerById(ownerId);
		if(dbOwner!=null) {
			OwnerDto dto=new OwnerDto();
			dto.setOwnerId(dbOwner.getOwnerId());
			dto.setOwerName(dbOwner.getOwnerName());
			dto.setOwnerEmail(dbOwner.getOwnerEmail());
			dto.setOwnerPhoneNumber(dbOwner.getOwnerPhoneNumber());
			
			ResponseStructure<OwnerDto> structure=new ResponseStructure<OwnerDto>();
			structure.setMessage("OwnerData deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<OwnerDto>>(structure,HttpStatus.FOUND);
		}
		else
		{
		throw new OwnerIdNotFoundExecption("sorry this cant be fetched");
		}
	}


	public ResponseEntity<ResponseStructure<OwnerDto>> updateOwnerById(long ownerId, Owner owner) {
		Owner dbowner= ownerDao.updateOwnerById(ownerId,owner);
		if(dbowner!=null)
		{
			OwnerDto dto= new OwnerDto();
			dto.setOwnerId(owner.getOwnerId());
			dto.setOwerName(owner.getOwnerName());
			dto.setOwnerEmail(owner.getOwnerEmail());
			dto.setOwnerPhoneNumber(owner.getOwnerPhoneNumber());
			
			
			ResponseStructure<OwnerDto> st=new ResponseStructure<OwnerDto>();
			st.setMessage("owner saved successfully");
			st.setStatus(HttpStatus.CREATED.value());
			st.setData(dbowner);
			
			return new ResponseEntity<ResponseStructure<OwnerDto>>(st,HttpStatus.CREATED);
			
			
		}
		else {
			throw new OwnerIdNotFoundExecption("sorry this cant be fetched");		
 
		}
	}

	

}
