package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@SpringBootApplication
public class SpringDataJpaFinderMehodsEntityOperationsApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaFinderMehodsEntityOperationsApplication.class, args);
		//get Proxy class object
		IEmployeeRepo  repo=ctx.getBean(IEmployeeRepo.class);
		//invoke methods
		//repo.fetchAllEmployees().forEach(System.out::println);
		//repo.fetchAllEmployeesByAddrs("hyd").forEach(System.out::println);
		//repo.fetchAllEmployeeBySalaryRange(10000, 20000).forEach(System.out::println);
		
		//------------------------Retrieving specific multiple col vlaues (scalar queries/projections in BulkSelect)------------
	/*	repo.fetchEmpDetailsByCities("hyd", "delhi","mumbai").forEach(row->{
			  System.out.println(row[0]+"  "+row[1]+"  "+row[2]);
		});
		
		repo.fetchEmpDetailsByNameInitialLetters("r").forEach(row->{
			System.out.println(row[0]+"  "+row[1]);
		}); */
		
		//------------------------Retrieving specific single col vlaues (scalar queries/projections in BlukSelect)------------
		 /*repo.findEmpNamesByEnoRange(10,100).forEach(System.out::println);
		 repo.findEmpSalaryByEnames("raja", "rani","jani").forEach(System.out::println); */
		 
		//------------------------- Retrieving all col values of single row (Entity Operation in SingleRow Select query ) --------------------------
		 /*Employee emp=repo.findEmpAllDetailsByEno(29);
		 System.out.println(emp); */ 
		
		  //------------------------- Retrieving specific multiple   col values of singlerow (scalar/Projection Operation in SingleRow Select query ) --------------------------
		 /*Object obj=repo.findEmpPartialDetailsByEno(29);
		 Object row[]=(Object[])obj;
		 System.out.println("details are::"+row[0]+"  "+row[1]); */
		 
		//------------------------- Retrieving specific single   col value of singlerow (scalar/Projection Operation in SingleRow Select query ) --------------------------
		 /*float salary=repo.findEmpSalaryByEno(29);
		 System.out.println("salary is ::"+salary); */
		
		//  -------------------   HQL/JPQL with aggregate results ---------------------
		/*System.out.println("Employees count ::"+repo.getEmpsCount());
		Object results[]=(Object[]) repo.getEmpsAggerateData();
		System.out.println("Emps count::"+results[0]+" MAX salary:: "+results[1]+" Min salary ::"+results[2]+"  "+"Avg salary::"+results[3]);
		*/
		//--------------------- HQL/JPQL  Non-Select Operations ----------------------
		/*int  count=repo.updateEmpSalaryByAmount(10000,1000);
		System.out.println("no.of records that are effected::"+count);
		
		int count1=repo.deleteEmpsHavingNoAddrs();
		System.out.println("no.of emps that are deleted::"+count1);
		  */
		//--------------------------  Native SQL query ---------------------
		 System.out.println("sys date::"+repo.getSysDate());
		 int count=repo.insertEmployee(678, 9999.0f, "hyd","mohit");
		 if(count==0)
			  System.out.println("record not inserted");
		 else
			 System.out.println("record inserted");
		
	}//main
}//class
