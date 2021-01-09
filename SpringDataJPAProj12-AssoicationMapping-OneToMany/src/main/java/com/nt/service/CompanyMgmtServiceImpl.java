package com.nt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.repository.IDepartmentRepo;
import com.nt.repository.IEmployeeRepo;

@Service("compService")
public class CompanyMgmtServiceImpl implements ICompanyMgmtService {
	@Autowired
	private IDepartmentRepo deptRepo;
	@Autowired
	private  IEmployeeRepo  empRepo;
	
	   

	@Override
	public void saveDataUsingParent() {
		//prepare Entity objects
	    //child objects 
		Employee emp1=new  Employee();
	     emp1.setEname("raja"); emp1.setEaddrs("hyd"); emp1.setEsalary(90000.0f);
	     Employee emp2=new  Employee();
	     emp2.setEname("rajesh"); emp2.setEaddrs("vizag"); emp2.setEsalary(8000.0f);
	     //parent objs
	     Department dept=new Department();
	     dept.setDeptName("IT"); dept.setDeptLocation("hyd");
	     //map objects
	     dept.setEmps(Set.of(emp1,emp2));   //childs to parent
	     emp1.setDept(dept); emp2.setDept(dept);  //parent to childs
	     
	     //save data  using parent
	         deptRepo.save(dept);
	         System.out.println("parent to child objs are saved...");

	}



	@Override
	public void saveDataUsingChilds() {
		//prepare Entity objects
	    //child objects 
		Employee emp1=new  Employee();
	     emp1.setEname("anil"); emp1.setEaddrs("delhi"); emp1.setEsalary(70000.0f);
	     Employee emp2=new  Employee();
	     emp2.setEname("suraj"); emp2.setEaddrs("delhi"); emp2.setEsalary(81000.0f);
	     //parent objs
	     Department dept=new Department();
	     dept.setDeptName("Accounts"); dept.setDeptLocation("delhi");
	     //map objects
	     dept.setEmps(Set.of(emp1,emp2));   //childs to parent
	     emp1.setDept(dept); emp2.setDept(dept);  //parent to childs
	     //save data using childs
	     empRepo.save(emp1); 
	     empRepo.save(emp2);
	     System.out.println("child to parent objs are saved...");
	}//method



	@Override
	@Transactional
	public void loadDataUsingParent() {
		//use repo
		List<Department> list=deptRepo.findAll();
		list.forEach(dept->{
			System.out.println("parent ::"+dept);
				Set<Employee> childs=dept.getEmps();
				System.out.println("childs count::"+childs.size());
			/*	childs.forEach(emp->{
					System.out.println("child::"+emp);
				}); */
			System.out.println(".........................");
		});
	}//method
	
	@Override
	@Transactional
	public void loadDataUsingChilds() {
		//use repo
		List<Employee> list=empRepo.findAll();
		list.forEach(emp->{
			System.out.println("child::"+emp);
			//get Associated parent
			Department dept=emp.getDept();
			//System.out.println("parent::"+dept);
		});
		
	}
	
	
	
}//class
