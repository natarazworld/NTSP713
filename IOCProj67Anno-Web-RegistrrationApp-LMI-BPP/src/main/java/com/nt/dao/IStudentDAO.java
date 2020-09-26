package com.nt.dao;

import com.nt.bo.StudentBO;

public interface IStudentDAO {
    public   int  registerStudent(StudentBO bo)throws Exception;
}
