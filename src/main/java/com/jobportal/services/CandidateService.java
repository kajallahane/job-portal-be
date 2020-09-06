package com.jobportal.services;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.domain.Candidate;
import com.jobportal.domain.Job;

@Service
public class CandidateService {

	public Candidate getCandidateInfo(String candidateId) {
		Candidate candidate = null;
    	try {
    		ObjectMapper mapper = new ObjectMapper();
			TypeReference<Candidate> typereference = new TypeReference<Candidate>() {};
			String path = "/json/candidateStore/candidate-"+candidateId+".json";
			InputStream inputStream = TypeReference.class.getResourceAsStream(path);
			candidate = mapper.readValue(inputStream, typereference);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return candidate;
	}
	
	public List<Job> getJobList(){
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
	}
}
