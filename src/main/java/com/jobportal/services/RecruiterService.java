package com.jobportal.services;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobportal.domain.Job;
import com.jobportal.domain.JobRequest;

@Service
public class RecruiterService {

	public List<JobRequest> getJobRequests(String recruiterId){
		List<JobRequest> jobRequests = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			TypeReference<List<JobRequest>> typereference = new TypeReference<List<JobRequest>>() {};
			String path = "/json/recruiterStore/recruiterjobrequests"+recruiterId+".json";
			InputStream inputStream = TypeReference.class.getResourceAsStream(path);
			jobRequests = mapper.readValue(inputStream, typereference);
			inputStream.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return jobRequests;
		}
	
	public List<JobRequest> addJobRequest(String recruiterId, JobRequest jobRequest){
		List<JobRequest> jobRequests = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			TypeReference<List<JobRequest>> typereference = new TypeReference<List<JobRequest>>() {};
			String path = "/json/recruiterStore/recruiterjobrequests"+recruiterId+".json";
			InputStream inputStream = TypeReference.class.getResourceAsStream(path);
			jobRequests = mapper.readValue(inputStream, typereference);
			jobRequests.add(jobRequest);
			inputStream.close();
			
			String path1 = "json/recruiterStore/recruiterjobrequests"+recruiterId+".json";
			ClassLoader classLoader = getClass().getClassLoader();
	        URL resource = classLoader.getResource(path1);
	        File file = new File(resource.getFile());
			mapper.writeValue(file, jobRequests);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return jobRequests;
		}
	
	public List<JobRequest> updateJobStatus(String recruiterId, String jobRequestId, String newStatus){
		List<JobRequest> jobRequests = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			TypeReference<List<JobRequest>> typereference = new TypeReference<List<JobRequest>>() {};
			String path = "/json/recruiterStore/recruiterjobrequests"+recruiterId+".json";
			InputStream inputStream = TypeReference.class.getResourceAsStream(path);
			jobRequests = mapper.readValue(inputStream, typereference);
			inputStream.close();
			
			
			for(JobRequest jobRequest : jobRequests) {
			    String tempJobRequestId = jobRequest.getJobRequestId();
			    if(tempJobRequestId.equals(jobRequestId)) {
			    	ArrayList<String> tempJobRequests = jobRequest.getJobRequestStatus();
			    	tempJobRequests.add(newStatus);
			    	jobRequest.setJobRequestStatus(tempJobRequests);
			    }
			}
			
			String path1 = "json/recruiterStore/recruiterjobrequests"+recruiterId+".json";
			ClassLoader classLoader = getClass().getClassLoader();
	        URL resource = classLoader.getResource(path1);
	        File file = new File(resource.getFile());
			mapper.writeValue(file, jobRequests);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return jobRequests;
	}
}
