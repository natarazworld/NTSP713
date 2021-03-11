package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repo.JobSeekerInfoRepo;

@Service("jsService")
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	@Autowired
   private  JobSeekerInfoRepo  jsRepo;
	
	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		JobSeekerInfo info1=jsRepo.save(info);
		 if(info1!=null)
			 return "JobSeeker is registered successfully with id ::"+info1.getJsId();
		 else
			 return "Problem in JobSeeker Registration";
	}

	@Override
	public List<JobSeekerInfo> getAllFiles() {
		List<JobSeekerInfo> list=(List<JobSeekerInfo>) jsRepo.findAll();
		return  list;
	}

}
