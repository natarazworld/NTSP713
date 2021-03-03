package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Employee;

@Component("pdfReport")
public class EmployeePdfReport extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// read model data
		List<Employee> listEmps=(List<Employee>)map.get("empList");
		// add Paragraph
		Paragraph para=new Paragraph("Employee Report", new Font(Font.BOLDITALIC));
		doc.add(para);
		//add table 
		Table table=new  Table(4,listEmps.size());
		for(Employee emp:listEmps) {
			table.addCell(String.valueOf(emp.getEno()));
			table.addCell(emp.getEname());
			table.addCell(emp.getEadd());
			table.addCell(String.valueOf(emp.getSalary()));
		}
		doc.add(table);
	}

}
