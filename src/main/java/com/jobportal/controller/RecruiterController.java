package com.jobportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.domain.JobRequest;
import com.jobportal.domain.UpdateRequest;
import com.jobportal.services.CandidateService;
import com.jobportal.services.RecruiterService;

@RestController
@CrossOrigin
public class RecruiterController {
	
	private RecruiterService recuiterService;
	private CandidateService candidateService;
	
	public RecruiterController(RecruiterService recuiterService, CandidateService candidateService){
		this.recuiterService = recuiterService;
		this.candidateService = candidateService;
	}
	 @GetMapping("/recruiter/jobrequests/{recruiterId}")
	  public ResponseEntity<List<JobRequest>> recruiterJobRequest(@PathVariable("recruiterId") String recruiterId) {
		  
		  	List<JobRequest> jobRequests = recuiterService.getJobRequests(recruiterId);
	    	return new ResponseEntity<List<JobRequest>>(jobRequests,HttpStatus.OK) ;
	    	
	    }
	 
	 @PostMapping("/recruiter/updatejobrequests")
	  public ResponseEntity<List<JobRequest>> recruiterUpdateJobRequest(@RequestBody UpdateRequest updateRequest) {
		  
		 	String recruiterId = updateRequest.getRecruiterId();
		 	String jobRequestId = updateRequest.getJobRequestId();
		 	String candidateId = updateRequest.getCandidateId();
		 	String jobStatus = updateRequest.getNewStatus();
		  	List<JobRequest> jobRequestsRecruiter = recuiterService.updateJobStatus(recruiterId,jobRequestId,jobStatus);
		  	candidateService.updateJobStatus(candidateId,jobRequestId,jobStatus);
	    	return new ResponseEntity<List<JobRequest>>(jobRequestsRecruiter,HttpStatus.OK) ;
	    	
	    }
}
