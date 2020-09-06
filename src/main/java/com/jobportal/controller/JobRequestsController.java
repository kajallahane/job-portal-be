package com.jobportal.controller;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.domain.JobRequest;

@RestController
@CrossOrigin
public class JobRequestsController {
	@GetMapping("/jobrequests")
    public List<JobRequest> listjobrequests() {
    	List<JobRequest> jobRequests = null;
    	try {
    		ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<JobRequest>> typereference = new TypeReference<List<JobRequest>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/jobrequests.json");
			jobRequests = mapper.readValue(inputStream, typereference);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return jobRequests;
    	
        // return "App is working fine";
    }
	
	@PostMapping("/jobrequests")
    public List<JobRequest> intsertjobrequest(@RequestBody JobRequest newjob) {
    	List<JobRequest> jobRequests = null;
    	try {
    		ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<JobRequest>> typereference = new TypeReference<List<JobRequest>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/jobrequests.json");
			jobRequests = mapper.readValue(inputStream, typereference);
			jobRequests.add(newjob);
			URL jobRequestLocation = TypeReference.class.getResource("/json/jobrequests.json");
			mapper.writeValue(new File(jobRequestLocation.getFile()), jobRequests);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return jobRequests;
    	
        // return "App is working fine";
    }
}