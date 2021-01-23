package com.nt.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.doc.BankAccount;
import com.nt.doc.PersonInfo;
import com.nt.doc.VisaInfo;
import com.nt.dto.BankAccountDTO;
import com.nt.dto.PersonInfoDTO;
import com.nt.dto.VisaInfoDTO;
import com.nt.repository.IPersonInfoRepo;

@Service("personService")
public class PersonInfoMgmtServiceImpl implements IPersonInfoMgmtService {
	@Autowired
     private  IPersonInfoRepo  repo;
	@Override
	public String saveData(PersonInfoDTO dto) {
	  //convert  dto object  Doc object
		PersonInfo doc=new PersonInfo();
		BeanUtils.copyProperties(dto, doc);
		//convert mapBankAccountDTOs   to  mapBankAccount doc objs
		Map<String,BankAccountDTO>  accountsDTO=dto.getAccounts();
		Map<String,BankAccount>  accountsDoc=new HashMap();
		accountsDTO.forEach((key,badto)->{
			BankAccount acDoc=new BankAccount();
			BeanUtils.copyProperties(badto, acDoc);
			accountsDoc.put(key, acDoc);
		});
		//convert  SetVisaDTOs   to  setVisa Docs
		Set<VisaInfoDTO>  SetvisaDTO=dto.getVisas();
		Set<VisaInfo>  SetvisaDoc=new HashSet();
		SetvisaDTO.forEach(visadto->{
			VisaInfo  vsdoc=new VisaInfo();
			BeanUtils.copyProperties(visadto, vsdoc);
			SetvisaDoc.add(vsdoc);
		});
		doc.setAccounts(accountsDoc);
		doc.setVisas(SetvisaDoc);
		//save obj
		return  "Doc is saved with"+ repo.save(doc).getPid();
	}
	

}
