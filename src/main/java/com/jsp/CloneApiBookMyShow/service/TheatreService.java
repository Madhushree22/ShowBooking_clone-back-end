package com.jsp.CloneApiBookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApiBookMyShow.dao.AddressDao;
import com.jsp.CloneApiBookMyShow.dao.OwnerDao;
import com.jsp.CloneApiBookMyShow.dao.TheatreDao;
import com.jsp.CloneApiBookMyShow.dto.TheatreDto;
import com.jsp.CloneApiBookMyShow.entity.Address;
import com.jsp.CloneApiBookMyShow.entity.Owner;
import com.jsp.CloneApiBookMyShow.entity.Theatre;
import com.jsp.CloneApiBookMyShow.exception.AddressIsAlreadyTookExecption;
import com.jsp.CloneApiBookMyShow.exception.AddressNotFoundException;
import com.jsp.CloneApiBookMyShow.exception.OwnerIdNotFoundExecption;
import com.jsp.CloneApiBookMyShow.exception.TheatreIdNotFoundExecption;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@Service
public class TheatreService {
	
	@Autowired
	private TheatreDao dao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private OwnerDao ownerDao;
	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(long ownerId,long addressId,TheatreDto theatredto) {
		Owner dbOwner=ownerDao.findOwnerById(ownerId);
		if(dbOwner!=null)
			//if it is not null ie if the owner is present we are gng to add the theatre to that owner
		{
			Address address=addressDao.getAddressById(addressId);
			if(address!=null)
			{
				Theatre addressTheatre=address.getTheatre();
				if(addressTheatre!=null)
				{
					throw new AddressIsAlreadyTookExecption("the address is already occupied by another theatre");
				}
				
				
				Theatre theatre=this.modelMapper.map(theatredto,Theatre.class );//conversion of theatredto to entity
				
				//as the input was dto layer there was no mapping so set the values fr owner and addess using setter method
				theatre.setOwner(dbOwner);
				theatre.setAddress(address);
				
				//update the owner
				if(dbOwner.getTheatres().isEmpty())//if it is empty create new arraylist then add the theatre to that
				{
					List<Theatre> list=new ArrayList<Theatre>();
					list.add(theatre);
					dbOwner.setTheatres(list);
				}
				else//if already list is present just add to it
				{
					List<Theatre> list=dbOwner.getTheatres();
					list.add(theatre);
					dbOwner.setTheatres(list);
					
				}
				
				//update address
				address.setTheatre(theatre);
				
				//add theatre
				
				Theatre dbtheatre=dao.saveTheatre(theatre);
				ResponseStructure<Theatre> st=new ResponseStructure<Theatre>();
				st.setMessage("Theatre Added Successfully");
		        st.setStatus(HttpStatus.CREATED.value());
		        st.setData(dbtheatre);
		        return new ResponseEntity<ResponseStructure<Theatre>>(st,HttpStatus.CREATED);
				
			}
			else
			{
				throw new AddressNotFoundException("sorry failed to add...");
			}
			
		}
		else
		{
			throw new OwnerIdNotFoundExecption("sorry owner is not found");
		}
	
	}


	public ResponseEntity<ResponseStructure<Theatre>> findTheatreById(long theatreId) {
		
		Theatre dbtheatre=dao.findTheatreById(theatreId);
		if(dbtheatre!=null)
		{
			ResponseStructure<Theatre> st=new ResponseStructure<Theatre>();
			st.setMessage("Theatre is found successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbtheatre);
			return new ResponseEntity<ResponseStructure<Theatre>>(st,HttpStatus.FOUND);
		}
		else
		{
		
		throw new TheatreIdNotFoundExecption("sorry no Theatre is not for this id..");
	}

	}

	public ResponseEntity<ResponseStructure<Theatre>> updateTheatreById(long theatreId, TheatreDto theatredto) {
		
		Theatre theatre=this.modelMapper.map(theatredto, Theatre.class);
		Theatre dbTheatre=dao.updateTheatreById(theatreId,theatre);
		if(dbTheatre!=null)
		{
			ResponseStructure<Theatre> st=new ResponseStructure<Theatre>();
			st.setMessage("the theatre is updated successfully");
			st.setStatus(HttpStatus.OK.value());
			st.setData(dbTheatre);
			return new ResponseEntity<ResponseStructure<Theatre>>(st,HttpStatus.OK);
			
		}
		else
		{
			throw new TheatreIdNotFoundExecption("sorry no Theatre is not for this id..");
		}
	}

	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatreById(long theatreId) {
		Theatre dbtheatre=dao.deleteTheatreById(theatreId);
		if(dbtheatre!=null)
		{
			ResponseStructure<Theatre> st=new ResponseStructure<Theatre>();
			st.setMessage("Theatre is deleted successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbtheatre);
			return new ResponseEntity<ResponseStructure<Theatre>>(st,HttpStatus.FOUND);
		}
		
		else
		{
			throw new TheatreIdNotFoundExecption("sorry no Theatre is not for this id..");	
		}
	}
}
