package com.nt.service;

import com.nt.dto.JobSeekerDTO;

public interface IJobSeekerMgmtService {
     public   String  registerJobSeeker(JobSeekerDTO dto);
     public  JobSeekerDTO  getJobSeekerInfoById(int id);
}
