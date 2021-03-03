package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.model.Employee;

@Component("excelReport")
public class EmployeeExcelReport extends AbstractXlsView {
    private static int i;
	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// read model data
			List<Employee> listEmps=(List<Employee>)map.get("empList");
		//create Sheet
			Sheet sheet1=workbook.createSheet("Sheet1");
		// add cells to sheet
		   
			listEmps.forEach(emp->{
				Row row=sheet1.createRow(i);
				row.createCell(0).setCellValue(emp.getEno());
				row.createCell(1).setCellValue(emp.getEname());
				row.createCell(2).setCellValue(emp.getEadd());
				row.createCell(3).setCellValue(emp.getSalary());
				i++;
			});

	}

}
