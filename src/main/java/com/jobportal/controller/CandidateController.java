package com.jobportal.controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.domain.Candidate;
import com.jobportal.domain.Job;
import com.jobportal.services.CandidateService;

@RestController
public class CandidateController {
	
		private CandidateService candidateService;
		
		public CandidateController(CandidateService candidateService){
			this.candidateService = candidateService;
		}
	
	  @GetMapping("/candidateinfo/{candidateid}")
	    public ResponseEntity<Candidate> candidateInfo(@PathVariable("candidateid") String candidateId) {
		  	
		  	Candidate candidate = candidateService.getCandidateInfo(candidateId);
	    	return new ResponseEntity<>(candidate,HttpStatus.OK);
	    	
	    }
	  
	  @GetMapping("/candidate/joblist")
	    public ResponseEntity<List<Job>> candidateJobList() {
		  	
		  	List<Job> jobs = candidateService.getJobList();
	    	return new ResponseEntity<>(jobs,HttpStatus.OK);
	    	
	    }
	  
	  @GetMapping("/candidaterequestinfo/{candidateid}")
	    public ResponseEntity<Candidate> candidateRequestsInfo(@PathVariable("candidateid") String candidateid) {
		  Candidate candidate = null;
	    	try {
	    		ObjectMapper mapper = new ObjectMapper();
				TypeReference<Candidate> typereference = new TypeReference<Candidate>() {};
				String path = "/json/candidateStore/candidate-"+candidateid+".json";
				InputStream inputStream = TypeReference.class.getResourceAsStream(path);
				candidate = mapper.readValue(inputStream, typereference);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return new ResponseEntity<>(candidate,HttpStatus.OK);
	    	
	    }
	}