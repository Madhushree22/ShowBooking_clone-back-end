package com.jsp.CloneApiBookMyShow.service;

import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.CloneApiBookMyShow.dao.OwnerDao;
import com.jsp.CloneApiBookMyShow.dao.ProductionHouseDao;
import com.jsp.CloneApiBookMyShow.dto.ProductionHouseDto;
import com.jsp.CloneApiBookMyShow.entity.Owner;
import com.jsp.CloneApiBookMyShow.entity.ProductionHouse;
import com.jsp.CloneApiBookMyShow.exception.OwnerIdNotFoundExecption;
import com.jsp.CloneApiBookMyShow.exception.ProductionHouseIdNotFoundException;
import com.jsp.CloneApiBookMyShow.util.ResponseStructure;

@Service
public class ProductionHouseService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ProductionHouseDao houseDao;
	@Autowired
	private OwnerDao ownerDao;
	

	public ResponseEntity<ResponseStructure<ProductionHouse>> saveProductionHouse(long ownerId, ProductionHouseDto houseDto) {
		Owner dbOwner=ownerDao.findOwnerById(ownerId);
		if(dbOwner!=null)
		{
			ProductionHouse house=this.modelMapper.map(houseDto,ProductionHouse.class);
			if(dbOwner.getHouses().isEmpty()) 
			{
				List<ProductionHouse> list=new ArrayList<ProductionHouse>();
				list.add(house);
				dbOwner.setHouses(list);	
			}
			else 
			{
				List<ProductionHouse> list=dbOwner.getHouses();
				list.add(house);
				dbOwner.setHouses(list);
			
			}
	     
	        house.setOwner(dbOwner);
	        ProductionHouse dbProductionHouse= houseDao.saveProductionHouse(house);
	        ResponseStructure<ProductionHouse> st=new ResponseStructure<ProductionHouse>();
	        st.setMessage("ProductionHouse Added Successfully");
	        st.setStatus(HttpStatus.CREATED.value());
	        st.setData(dbProductionHouse);
	        return new ResponseEntity<ResponseStructure<ProductionHouse>>(st,HttpStatus.CREATED);
	        
		}
		
		
		else
		{
			//Raise one exception ownerIdisnot present
			throw new OwnerIdNotFoundExecption("Sorry failed to add productionHouse");
		}
	}

	public ResponseEntity<ResponseStructure<ProductionHouse>> updateProductionHouse(long houseId, ProductionHouseDto houseDto) {
       ProductionHouse house=this.modelMapper.map(houseDto, ProductionHouse.class);
		
		ProductionHouse dbHouse=houseDao.updateProductionHouse(houseId,house);
		if(dbHouse!=null) {
			ResponseStructure<ProductionHouse> st=new ResponseStructure<ProductionHouse>();
			st.setMessage("ProductionHouse Update successfully");
			st.setStatus(HttpStatus.OK.value());
			st.setData(dbHouse);
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(st,HttpStatus.OK);
		}else {
			throw new  ProductionHouseIdNotFoundException("Sorry failed to update ProductionHouse");
		}
	}

	public ResponseEntity<ResponseStructure<ProductionHouse>> getProductionHouse(long houseId) {
		ProductionHouse dbhouse=houseDao.getProductionHouseById(houseId);
		if(dbhouse!=null)
		{
		
			ResponseStructure<ProductionHouse> st=new ResponseStructure<ProductionHouse>();
			st.setMessage("ProductionHouse Updated successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbhouse);
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(st,HttpStatus.FOUND);
		}
		
		else
		{
			throw new ProductionHouseIdNotFoundException("Sorry failed to update ProductionHouse");
		}
	}

	public ResponseEntity<ResponseStructure<ProductionHouse>> deleteProductionHouse(long houseId) {
		
		ProductionHouse dbhouse=houseDao.deleteProductionHouse(houseId);
		if(dbhouse!=null)
		{
		
			ResponseStructure<ProductionHouse> st=new ResponseStructure<ProductionHouse>();
			st.setMessage("ProductionHouse deleted successfully");
			st.setStatus(HttpStatus.FOUND.value());
			st.setData(dbhouse);
			return new ResponseEntity<ResponseStructure<ProductionHouse>>(st,HttpStatus.FOUND);
		}
		
		else
		{
			throw new ProductionHouseIdNotFoundException("Sorry failed to delete ProductionHouse");
		}
	}

}
