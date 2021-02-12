package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.EmployeeDTO;

@Controller
public class EmployeeController {
	
	@RequestMapping("/list")
	public  String   listData(Map<String,Object> map) {
		//create model data
		map.put("name", "raja");
		map.put("age", 30);
		// -----------------------------------------------------------------
		//collections as Model data
		  List<String>  fruitsList=List.of("apple","banana","mango");   //java9
		  Set<Long>  phonesSet=Set.of(4666633455L,54354355435L,53454534L,543523566L); //java 9
		  Map<String,Integer>  subjectMarksMap=Map.of("physics",89,"maths",78,"chemistry",76);   //java 9
		  String favColors[]=new String[] {"red","white","green"};
		  map.put("fruitsList",fruitsList);
		  map.put("phonesSet",phonesSet);
		  map.put("subjectMarksMap",subjectMarksMap);
		  map.put("favColors",favColors);
		  //-----------------------------------------------------------------------
		    //Model obj /Java bean obj as  Model data
		  EmployeeDTO dto=new EmployeeDTO(101,"raja","hyd",665655.0f);
		  map.put("empData", dto);
		  
		  // Collection Model objs/Java bean objs /DTO objs
		  List<EmployeeDTO>  listDTO=List.of(new EmployeeDTO(901,"ramesh","hyd",6676.0f),
				                                                         new EmployeeDTO(902,"suresh","vizag",6761.0f),
				                                                         new EmployeeDTO(903,"jani","delhi",47761.0f)
				                                                       );
		  map.put("empList",listDTO);
		  
		//return lvn
		return  "show";
	}//method
}//class
