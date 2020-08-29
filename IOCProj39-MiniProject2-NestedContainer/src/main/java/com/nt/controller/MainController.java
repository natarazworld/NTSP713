package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.vo.EmployeeVO;

public class MainController {
	private  EmployeeMgmtService service;

	public MainController(EmployeeMgmtService service) {
			this.service = service;
	}
	
	public  List<EmployeeVO> gatherEmpsByDesgs(String desg1,String desg2,String desg3)throws Exception{
		List<EmployeeDTO> listDTO=null;
		List<EmployeeVO> listVO=null;
		EmployeeVO vo=null;
		//use service
		  listDTO=service.fetchEmpsByDesgs(desg1, desg2, desg3);
		  //convert listDTO to listVO
		  listVO=new ArrayList();
		  for(EmployeeDTO dto:listDTO) {
			  //convert each dto to each vo
                  vo=new EmployeeVO();
                  BeanUtils.copyProperties(dto, vo);
                  vo.setSerialNo(String.valueOf(dto.getSerialNo()));
                  vo.setDeptNo(String.valueOf(dto.getDeptNo()));
                  vo.setSal(String.valueOf(dto.getSal()));
                  vo.setEmpNo(String.valueOf(dto.getEmpNo()));
                  //add each vo to listVO
                  listVO.add(vo);
		  }//for
		  return listVO;
	} //method
	

}//class
