package com.jobportal.services;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.domain.Candidate;
import com.jobportal.domain.Job;
import com.jobportal.domain.JobRequest;

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
	
	public List<JobRequest> getJobRequests(String candidateId){
		List<JobRequest> jobRequests = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			TypeReference<List<JobRequest>> typereference = new TypeReference<List<JobRequest>>() {};
			String path = "/json/candidateStore/candidatejobrequests"+candidateId+".json";
			InputStream inputStream = TypeReference.class.getResourceAsStream(path);
			jobRequests = mapper.readValue(inputStream, typereference);
			inputStream.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return jobRequests;
		}
	
	public List<JobRequest> addJobRequest(String candidateId, JobRequest jobRequest){
		List<JobRequest> jobRequests = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			TypeReference<List<JobRequest>> typereference = new TypeReference<List<JobRequest>>() {};
			String path = "/json/candidateStore/candidatejobrequests"+candidateId+".json";
			System.out.print("Path to get " + path);
			InputStream inputStream = TypeReference.class.getResourceAsStream(path);
			jobRequests = mapper.readValue(inputStream, typereference);
			jobRequests.add(jobRequest);
			inputStream.close();
			
			
			String path1 = "/json/candidateStore/candidatejobrequests"+candidateId+".json";
	        URL resource = TypeReference.class.getResource(path1);
	        File file = new File(resource.getFile());
			mapper.writeValue(file, jobRequests);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return jobRequests;
		}
}
