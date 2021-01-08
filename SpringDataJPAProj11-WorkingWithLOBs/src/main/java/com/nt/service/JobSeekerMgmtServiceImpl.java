package com.nt.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.JobSeekerDTO;
import com.nt.entity.JobSeeker;
import com.nt.repository.JobSeekerRepo;

@Service("jsService")
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	@Autowired
	private  JobSeekerRepo  jsRepo;

	@Override
	public String registerJobSeeker(JobSeekerDTO dto) {
		//convert DTO to  Entity 
		JobSeeker entity=new JobSeeker();
		BeanUtils.copyProperties(dto, entity);
		//use repo
		int id=jsRepo.save(entity).getJsId();
		return "JobSeeker is registered successfully with  id:"+id;
	}

	@Override
	public JobSeekerDTO getJobSeekerInfoById(int id) {
		//use  repo
		Optional<JobSeeker> opt=jsRepo.findById(id); 
		if(opt.isPresent()) {
		//copy  entity object to DTO object
	    JobSeekerDTO  dto=new JobSeekerDTO();
	    BeanUtils.copyProperties(opt.get(),dto);//get() gives the wrapped  Entity obj from Optional obj;
	    return dto;
		}
	    return null;
	}//method

}//class
