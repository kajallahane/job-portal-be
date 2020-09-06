package com.jobportal.controller;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.domain.Candidate;
import com.jobportal.domain.Job;
import com.jobportal.domain.JobRequest;
import com.jobportal.services.CandidateService;
import com.jobportal.services.RecruiterService;

@RestController
public class CandidateController {
	
		private CandidateService candidateService;
		private RecruiterService recruiterService;
		
		public CandidateController(CandidateService candidateService, RecruiterService recruiterService){
			this.candidateService = candidateService;
			this.recruiterService = recruiterService;
		}
	
	  @GetMapping("/candidate/info/{candidateid}")
	    public ResponseEntity<Candidate> candidateInfo(@PathVariable("candidateid") String candidateId) {
		  	
		  	Candidate candidate = candidateService.getCandidateInfo(candidateId);
	    	return new ResponseEntity<>(candidate,HttpStatus.OK);
	    	
	    }
	  
	  @GetMapping("/candidate/joblist")
	    public ResponseEntity<List<Job>> candidateJobList() {
		  	
		  	List<Job> jobs = candidateService.getJobList();
	    	return new ResponseEntity<>(jobs,HttpStatus.OK);
	    	
	    }
	  
	  @GetMapping("/candidate/jobrequests/{candidateid}")
	  public ResponseEntity<List<JobRequest>> candidateJobRequest(@PathVariable("candidateid") String candidateId) {
		  
		  	List<JobRequest> jobRequests = candidateService.getJobRequests(candidateId);
	    	return new ResponseEntity<>(jobRequests,HttpStatus.OK) ;
	    	
	    }
	  
	  @PostMapping("/candidate/jobrequests")
	    public ResponseEntity<String> intsertjobrequest(@RequestBody JobRequest newjob) {
		  
		  	Candidate candidate = newjob.getCandidateDetails();
		  	Job job = newjob.getJobDetails();
		  	String candidateId = candidate.getCandidateId();
		  	String companyId = job.getCompanyId();
		  	candidateService.addJobRequest(candidateId, newjob);
		  	recruiterService.addJobRequest(companyId, newjob);
		  	return new ResponseEntity<>("Inserted",HttpStatus.OK) ;
	        // return "App is working fine";
	    }
	}