package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
        
	    //@Query("FROM  com.nt.entity.Employee ")
	   //@Query("FROM  Employee ")
	   //@Query("FROM  Employee e ")
	    @Query("SELECT  e FROM  Employee e ")
	   public  List<Employee> fetchAllEmployees();
	    
	    @Query(" FROM  Employee WHERE  eadd=?1")
	    //@Query(" FROM  Employee WHERE  eadd=:city")
	    public  List<Employee>  fetchAllEmployeesByAddrs(@Param("city")String addrs);
	    
	    @Query("FROM Employee WHERE esalary>=:start and esalary<=:end")
	    public  List<Employee>  fetchAllEmployeeBySalaryRange(float start, float end);
	    
	    //------------------------- Retrieving specific multiple col values (scalar /Projections in BulkSelect ) --------------------------
	    @Query("SELECT eno,ename,esalary FROM  Employee WHERE eadd in(:city1,:city2,:city3)")
	    public List<Object[]>  fetchEmpDetailsByCities(String city1,String city2,String city3);
	    
	    @Query("SELECT eno,ename FROM  Employee WHERE ename like :initialLetters%")
	    public List<Object[]> fetchEmpDetailsByNameInitialLetters(String initialLetters);
	    
	    //------------------------- Retrieving specific single col values (scalar /Projections in BulkSelect ) --------------------------
	    @Query("SELECT ename FROM  Employee WHERE eno>=:start and eno<=:end")
	    public  List<String>  findEmpNamesByEnoRange(int start ,int end);
	    
	    @Query("SELECT esalary FROM  Employee WHERE ename IN(:name1,:name2,:name3)")
	    public  List<Float>  findEmpSalaryByEnames(String name1,String name2,String name3);
	    
	  //------------------------- Retrieving all col values of single row (Entity Operation in SingleRow Select query ) --------------------------
	    @Query(" FROM  Employee WHERE eno=:no")
	    public Employee  findEmpAllDetailsByEno(int no);
	    
		  //------------------------- Retrieving specific multiple   col values of singlerow (scalar/Projection Operation in SingleRow Select query ) --------------------------
	    @Query("SELECT eno,eadd FROM  Employee WHERE eno=:no")
	    public     Object  findEmpPartialDetailsByEno(int no);
	    
	    //------------------------- Retrieving specific single   col value of singlerow (sclar/Projection Operation in SingleRow Select query ) --------------------------
	    @Query("SELECT esalary FROM  Employee WHERE eno=:no")
	    public     float  findEmpSalaryByEno(int no);
	    
	    //-------------------- Supports  aggregate functions (HQL/JPQL) -------------------
	    @Query("SELECT  COUNT(*) FROM Employee")
	    public    int      getEmpsCount();
	        
	    @Query("SELECT  COUNT(*),MAX(esalary),MIN(esalary),avg(esalary) FROM Employee")
	   public    Object    getEmpsAggerateData(); 
	    
	    //--------------   HQL/JPQL  Non-select operations (except insert operation) -----------------------
	    @Query("UPDATE Employee SET esalary=esalary+ :amount WHERE  esalary<=:startSalary")
	    @Modifying
	    @Transactional
	           public int  updateEmpSalaryByAmount(float startSalary, float amount);
	    
	    @Query("DELETE FROM Employee WHERE  eadd IS NULL")
	    @Modifying
	    @Transactional
	    public  int   deleteEmpsHavingNoAddrs();
	    
	    //-------------------------- Native SQL @Query methods  -------------------------------
	    @Query(value="SELECT SYSDATE  FROM DUAL",nativeQuery=true)
	    public  String  getSysDate();
	    
	    @Query(value="INSERT INTO EMPLOYEE VALUES(?,?,?,?)",nativeQuery=true)
	    @Modifying
	    @Transactional
	    public  int  insertEmployee(int no,float salary,  String addrs ,String name);
	   
}
