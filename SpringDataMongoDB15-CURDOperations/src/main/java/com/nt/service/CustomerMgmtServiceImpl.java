package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Customer;
import com.nt.dto.CustomerDTO;
import com.nt.repository.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private CustomerRepo  custRepo;

	@Override
	public String registerOrUpdateCustomer(CustomerDTO dto) {
		//convert dto to document obj
		Customer doc=new Customer();
		BeanUtils.copyProperties(dto, doc);
		//save document
		//doc=custRepo.insert(doc);
		doc=custRepo.save(doc);
		System.out.println(doc);
		return "Document is saved having cno:"+doc.getCno();
	}

	@Override
	public List<CustomerDTO> fetchAllCustomers() {
		//use  repo
		List<Customer>  listDocs=custRepo.findAll();
		//convert  listDocs ot listDTO
		List<CustomerDTO> listDTO=new ArrayList();
		listDocs.forEach(doc->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(doc, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public Optional<CustomerDTO> fetchCustomerByCno(int cno) {
	//use reop
		Optional<Customer> doc=custRepo.findById(cno);
		//convert  Document obj to DTO object
		Optional<CustomerDTO> dto=null;
		if(doc.isPresent()) {
			 dto=Optional.of(new CustomerDTO());
		    BeanUtils.copyProperties(doc.get(),dto.get());
		}
		else
		  dto=Optional.empty();
		
		return dto;
	}

	@Override
	public List<CustomerDTO> fetchCustomersByCadd(String cadd) {
		//use repo
		List<Customer> listDocs=custRepo.findByCadd(cadd);
		//convert listDocs to  listDTO
		List<CustomerDTO> listDTO=new ArrayList();
		listDocs.forEach(doc->{
		  CustomerDTO dto=new CustomerDTO();
		  BeanUtils.copyProperties(doc, dto);
		  listDTO.add(dto);
		});
		
		return listDTO;
	}

	@Override
	public List<CustomerDTO> fetchCustomersByCnoRange(int start, int end) {
		//use repo
				List<Customer> listDocs=custRepo.findByCnoBetween(start, end);
				//convert listDocs to  listDTO
				List<CustomerDTO> listDTO=new ArrayList();
				listDocs.forEach(doc->{
				  CustomerDTO dto=new CustomerDTO();
				  BeanUtils.copyProperties(doc, dto);
				  listDTO.add(dto);
				});
				
				return listDTO;
	}

	
}//class
