package com.jobportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.domain.JobRequest;
import com.jobportal.services.RecruiterService;

@RestController
public class RecruiterController {
	
	private RecruiterService recuiterService;
	
	public RecruiterController(RecruiterService recuiterService){
		this.recuiterService = recuiterService;
	}
	 @GetMapping("/recruiter/jobrequests/{recruiterId}")
	  public ResponseEntity<List<JobRequest>> candidateJobRequest(@PathVariable("recruiterId") String recruiterId) {
		  
		  	List<JobRequest> jobRequests = recuiterService.getJobRequests(recruiterId);
	    	return new ResponseEntity<>(jobRequests,HttpStatus.OK) ;
	    	
	    }
}
