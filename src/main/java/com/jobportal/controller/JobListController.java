package com.jobportal.controller;

import java.io.File;
import java.io.FileInputStream;
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
    	List<Job> job = null;
    	try {
    		ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(new File("/Users/ab30197t/myWork/job-portal-be/jobportal/src/main/database/joblist.json"));
			TypeReference<List<Job>> typereference = new TypeReference<List<Job>>() {};
			job = mapper.readValue(inputStream, typereference);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return job;
    	
        // return "App is working fine";
    }
}