package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentMgmtService {
    public  StudentDTO  fetchStudentByNo(int no);
    public  List<StudentDTO> fetchStudentsByCities(String city1,String city2,String city3);
    public  List<StudentDTO> fetchStudentsByCities1(String city1,String city2,String city3);
    
}
