package com.jobportal.domain;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class JobRequest {
	
	String jobRequestId;
	ArrayList<String> jobRequestStatus;
	Job jobDetails;
	Candidate candidateDetails;
	
	public String getJobRequestId() {
		return jobRequestId;
	}
	public void setJobRequestId(String jobRequestId) {
		this.jobRequestId = jobRequestId;
	}
	public ArrayList<String> getJobRequestStatus() {
		return jobRequestStatus;
	}
	public void setJobRequestStatus(ArrayList<String> jobRequestStatus) {
		this.jobRequestStatus = jobRequestStatus;
	}
	public Job getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(Job jobDetails) {
		this.jobDetails = jobDetails;
	}
	public Candidate getCandidateDetails() {
		return candidateDetails;
	}
	public void setCandidateDetails(Candidate candidateDetails) {
		this.candidateDetails = candidateDetails;
	}
}
