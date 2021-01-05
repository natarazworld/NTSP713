//CustomerInfoMgmtServiceImpl.java
package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerInfoDTO;
import com.nt.entity.CustomerInfo;
import com.nt.repository.ICustomerInfoRepo;

@Service("customerService")
public class CustomerInfoMgmtServiceImpl implements ICustomerInfoMgmtService {
	@Autowired
	private    ICustomerInfoRepo  custRepo;

	@Override
	public String registerCustomer(CustomerInfoDTO dto) {
		//convert DTO  to Entity
		CustomerInfo entity=new CustomerInfo();
		BeanUtils.copyProperties(dto, entity);
		//use  repo
		int id=custRepo.save(entity).getCustId();
		return "Customer is registerd having Id ::"+id;
	}

	@Override
	public List<CustomerInfoDTO> fetchAllCustomerDetails() {
        //use repo
		List<CustomerInfo> listEntities=custRepo.findAll();
		//convert   listEntities to  listDTOs
		List<CustomerInfoDTO> listDTO=new ArrayList();
		listEntities.forEach(entity->{
			CustomerInfoDTO dto=new CustomerInfoDTO();
			BeanUtils.copyProperties(entity,dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}

}
