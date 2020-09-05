package com.jobportal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.model.Candidate;

@RestController
@CrossOrigin
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public Candidate healthcheck() {
    	Candidate candidate = null;
    	try {
    		ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(new File("/Users/ab30197t/myWork/job-portal-be/jobportal/src/main/database/candidate.json"));
			TypeReference<Candidate> typereference = new TypeReference<Candidate>() {};
			candidate = mapper.readValue(inputStream, typereference);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return candidate;
    	
        // return "App is working fine";
    }
}
