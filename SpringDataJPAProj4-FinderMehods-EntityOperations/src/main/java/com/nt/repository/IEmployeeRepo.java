package com.nt.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
	  //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE  EADD=?
      public  List<Employee>  findByEadd(String addrs);
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE  ENAME=?
      public  List<Employee>  findByEname(String name);
      public  List<Employee>  findByEnameIs(String name);
      public  List<Employee>  findByEnameEquals(String name);
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE  ESALARY<?
      public  List<Employee>  findByEsalaryLessThan(float startSalary);
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE  ESALARY>=?
      public  List<Employee>  findByEsalaryGreaterThanEqual(float startSalary);
      
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE  ENAME LIKE 'r%'
      public  List<Employee>  findByEnameLike(String chars);
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE  ENAME LIKE 'r%'
      public  List<Employee>  findByEnameStartingWith(String initialChars);
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE  ENAME LIKE '%a%'
      public  List<Employee> findByEnameContaining(String chars);
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE EADD IN('hyd','mumbai','delhi')
      public  Iterable<Employee>  findByEaddIn(Collection<String> cities );
      
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE EADD NOT IN('hyd','mumbai')
      public  Iterable<Employee>  findByEaddNotIn(Collection<String> cities );
      
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE EADD IS NULL
      public  Iterable<Employee>  findByEaddIsNull();
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE EADD ISNOT NULL
      //public  Iterable<Employee>  findByEaddIsNotNull();
      public  Iterable<Employee>  findByEaddNotNull();
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE UPPER(EADD)=UPPER('hyd') 
      public  Iterable<Employee>  findByEaddIgnoreCase(String city);
      
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE EADD='hyd' ORDER BY ENO ASC
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE EADD='hyd' ORDER BY ENO 
      public  Iterable<Employee>   findByEaddOrderByEnoAsc(String city);
      public  Iterable<Employee>   findByEaddOrderByEno(String city);
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE ENAME='raja' AND EADD='hyd'
      public   List<Employee>  findByEnameAndEadd(String name,String addrs);
      
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE ESALARY=10000 OR EADD='hyd'
      public   List<Employee>  findByEsalaryOrEadd(float salary,String addrs);
      
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE ESALARY BETWEEN 10000 AND 20000
      public   List<Employee>  findByEsalaryBetween(float startSalary,float endSalary);
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE ENAME LIKE 'r%'  AND EADD LIKE 'h%'
      public   List<Employee>  findByEnameStartingWithAndEaddStartingWith(String nameInitChars,String addrsInitChars);
      
      //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE  (ENO>=100 AND ENAME LIKE '%j') OR (ESALARY BETWEEN  10000 AND 20000)
      public   List<Employee>  findByEnoGreaterThanEqualAndEnameEndingWithOrEsalaryBetween(int startEno,String namelastChars,float startSalary,float endSalary);
      
      
    //SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE ENAME IN('raja','rani','suresh') OR EADD IN('hyd','mumbai','delhi')
      public   List<Employee>  findByEnameInOrEaddIn(Collection<String> names,Collection<String> addresses);
      
      
      

      
      
}
