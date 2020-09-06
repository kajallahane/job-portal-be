package com.jobportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class JobRequest {
	
	String jobRequestId;
	String[] jobRequestStatus;
	Job jobDetails;
	Candidate candidateDetails;
	public String getJobRequestId() {
		return jobRequestId;
	}
	public void setJobRequestId(String jobRequestId) {
		this.jobRequestId = jobRequestId;
	}
	public String[] getJobRequestStatus() {
		return jobRequestStatus;
	}
	public void setJobRequestStatus(String[] jobRequestStatus) {
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
