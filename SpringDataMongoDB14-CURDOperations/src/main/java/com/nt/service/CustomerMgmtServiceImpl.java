package com.nt.service;

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
	public String registerCustomer(CustomerDTO dto) {
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
	public String updateCustomer(CustomerDTO dto) {
		//convert dto to document obj
		Customer doc=new Customer();
		BeanUtils.copyProperties(dto, doc);
		//update the document
		//doc=custRepo.insert(doc);
		doc=custRepo.save(doc);
		return doc.getCno()+"Document is updated ";
	}

}
