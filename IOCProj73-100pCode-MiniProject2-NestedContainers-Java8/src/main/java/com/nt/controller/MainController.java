package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.vo.EmployeeVO;

@Controller("controller")
//@Lazy
public class MainController {
	@Autowired()
	private  EmployeeMgmtService service;

	
	
	public  List<EmployeeVO> gatherEmpsByDesgs(String desg1,String desg2,String desg3)throws Exception{
		List<EmployeeDTO> listDTO=null;
		List<EmployeeVO> listVO=new ArrayList();
		//use service
		  listDTO=service.fetchEmpsByDesgs(desg1, desg2, desg3);
		  //convert listDTO to listVO
		   listDTO.forEach(dto->{
			   //convert each dto to each vo
                 EmployeeVO vo=new EmployeeVO();
                  BeanUtils.copyProperties(dto, vo);
                  vo.setSerialNo(String.valueOf(dto.getSerialNo()));
                  vo.setDeptNo(String.valueOf(dto.getDeptNo()));
                  vo.setSal(String.valueOf(dto.getSal()));
                  vo.setEmpNo(String.valueOf(dto.getEmpNo()));
                  //add each vo to listVO
                  listVO.add(vo);
		  });//for
		  return listVO;
	} //method
	

}//class
