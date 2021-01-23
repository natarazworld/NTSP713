package com.nt;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.dto.BankAccountDTO;
import com.nt.dto.PersonInfoDTO;
import com.nt.dto.VisaInfoDTO;
import com.nt.service.IPersonInfoMgmtService;

@SpringBootApplication
public class SpringDataMongoDb18SpecialPropertiesHasAOneToManyApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataMongoDb18SpecialPropertiesHasAOneToManyApplication.class, args);
		//get service class obj
		IPersonInfoMgmtService  service=ctx.getBean("personService",IPersonInfoMgmtService.class);
		
		VisaInfoDTO  visaDTO=new VisaInfoDTO(567778L,"USA",LocalDate.of(2030, 10, 10));
		VisaInfoDTO  visaDTO1=new VisaInfoDTO(567718L,"CANDADA",LocalDate.of(2031, 10, 10));
		BankAccountDTO  accDTO1=new BankAccountDTO(1465654L, "savings",70000.0f);
		BankAccountDTO  accDTO2=new BankAccountDTO(2465654L, "current",170000.0f);
		BankAccountDTO  accDTO3=new BankAccountDTO(3465654L, "savings",270000.0f);
		PersonInfoDTO  dto=new PersonInfoDTO(4561, "rakesh", "hyd",
				                                                             Set.of(visaDTO, visaDTO1),
				                                                             Map.of("account1",accDTO1,"account2",accDTO2,"account3",accDTO3));
		
		System.out.println(service.saveData(dto));
		
		
	}

}
