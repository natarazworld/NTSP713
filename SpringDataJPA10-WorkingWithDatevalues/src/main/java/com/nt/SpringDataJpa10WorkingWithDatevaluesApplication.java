package com.nt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerInfoDTO;
import com.nt.service.ICustomerInfoMgmtService;

@SpringBootApplication
public class SpringDataJpa10WorkingWithDatevaluesApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpa10WorkingWithDatevaluesApplication.class, args);
		//get Service class object
		ICustomerInfoMgmtService  service=ctx.getBean("customerService",ICustomerInfoMgmtService.class);
		//invoke method
		//prepare DTO
			CustomerInfoDTO dto=new CustomerInfoDTO();
			dto.setCustName("rajesh"); dto.setBillAmt(9000.0f); 
			dto.setDob(LocalDate.of(1991, 10, 23));
			//dto.setTob(LocalDateTime.of(1990,10,23,17,20, 40));
			dto.setTob(LocalTime.of(18,20, 42));
			dto.setBillDate(LocalDateTime.now());
			try {
			System.out.println(service.registerCustomer(dto));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}
		
		try {
			service.fetchAllCustomerDetails().forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class
