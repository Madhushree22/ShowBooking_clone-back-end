package com.jsp.CloneApiBookMyShow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApiBookMyShow.dao.AddressDao;
import com.jsp.CloneApiBookMyShow.dto.AddressDto;
import com.jsp.CloneApiBookMyShow.entity.Address;
import com.jsp.CloneApiBookMyShow.exception.AddressNotFoundException;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;

	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(AddressDto addressDto) {
		
		Address address=this.modelMapper.map(addressDto, Address.class);
		
		Address dbAddress=addressDao.saveAdress(address);
		ResponseStructure<Address> st=new ResponseStructure<Address>();
		st.setMessage("address saved successfully");
		st.setStatus(HttpStatus.CREATED.value());
		st.setData(dbAddress);
		return new ResponseEntity<ResponseStructure<Address>>(st,HttpStatus.CREATED);
		
		
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(long addressId, AddressDto addressDto) {
		Address address=this.modelMapper.map(addressDto, Address.class);
		Address dbAddress=addressDao.updateAdress(addressId, address);
		if (dbAddress!=null)
		{
			ResponseStructure<Address> st=new ResponseStructure<Address>();
			st.setMessage("address updated successfully");
			st.setStatus(HttpStatus.OK.value());
			st.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(st,HttpStatus.OK);
			
			
		}
		throw new AddressNotFoundException("sorry the failed to update address");
		
	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(long addressId) {
		Address dbAddress=addressDao.getAddressById(addressId);
		if(dbAddress!=null)
		{
			ResponseStructure<Address> st=new ResponseStructure<Address>();
			st.setMessage("address fetched successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(st,HttpStatus.FOUND);
			
		}
		throw new AddressNotFoundException("sorry the failed to fetch the address");
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(long addressId) {
		Address dbAddress=addressDao.deleteAddressById(addressId);
		if(dbAddress!=null)
		{
			ResponseStructure<Address> st=new ResponseStructure<Address>();
			st.setMessage("address deleted successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(st,HttpStatus.FOUND);
			
		}
		throw new AddressNotFoundException("sorry the failed to delete address");
	}
	
	

}
