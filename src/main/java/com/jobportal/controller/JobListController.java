package com.jobportal.controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.model.Job;

@RestController
@CrossOrigin
public class JobListController {

    @GetMapping("/joblist")
    public List<Job> joblist() {
    	List<Job> jobs = null;
    	try {
    		ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Job>> typereference = new TypeReference<List<Job>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/joblist.json");
			jobs = mapper.readValue(inputStream, typereference);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return jobs;
    	
        // return "App is working fine";
    }
}