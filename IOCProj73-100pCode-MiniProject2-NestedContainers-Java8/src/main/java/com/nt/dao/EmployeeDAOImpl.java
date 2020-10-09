package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
@PropertySource(value={"com/nt/commons/jdbc.properties","com/nt/commons/jdbc1.properties"})
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	@Autowired
	private  DataSource ds;

	@Value("${jdbc.user}")
    private String  dbuser;
	@Value("${os.name}")
	private String osName;
    

	@Override
	public List<EmployeeBO> getAllEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<EmployeeBO> listBO=null;
		EmployeeBO bo=null;
		System.out.println(dbuser+"   "+osName);
		try {
			//get Pooled jdbc con object
			con=ds.getConnection();
			//create PreparedStatement object
			ps=con.prepareStatement(GET_EMPS_BY_DESGS);
			//set values to query params
			ps.setString(1,desg1); ps.setString(2,desg2); ps.setString(3, desg3);
			//execute the query
			rs=ps.executeQuery();
			//convert ResultSet object records to ListBO
			listBO=new ArrayList();
			while(rs.next()) {
				bo=new EmployeeBO();
				//copy each record of ResultSet obj to BO class object
				bo.setEmpNo(rs.getInt(1));  // here simple int value given by rs.getInt(1) is automatically converted into Integer wrapper obj by using autoboxing feature (java 5)
			   bo.setEname(rs.getString(2));
			   bo.setJob(rs.getString(3));
			   bo.setSal(rs.getFloat(4));  //auto boxing
			   bo.setDeptNo(rs.getInt(5));
			   //add each obj of BO class to List Collection
			   listBO.add(bo);
			}//while
		}//try
		catch(SQLException se) { //known exception
			se.printStackTrace();
			throw se;  //exception rethrowing..
		}
		catch(Exception e) {  //unknow exception
			e.printStackTrace();
			throw e;  //exeception rethrowing
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
		}//finally
		
		return listBO;
	}//getEmpsByDesgs(-,-,-)

}//class
