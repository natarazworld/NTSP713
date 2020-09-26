package com.nt.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("stDAO")
@Scope("singleton")
public class StudentDAOImpl implements IStudentDAO {
	
	public StudentDAOImpl() {
		System.out.println("StudentDAOImpl:: 0-param constructor");
	}

	@Override
	public int registerStudent(StudentBO bo) throws Exception {
	     System.out.println("inserting into  Student DB table  having data ::"+bo);
		return 1;
	}

}
