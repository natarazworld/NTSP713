package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeekerInfo;

public interface IJobSeekerMgmtService {
	
	public  String  registerJobSeeker(JobSeekerInfo info);
	public  List<JobSeekerInfo>  getAllFiles();

}
