package com.jobportal.domain;

public class UpdateRequest {
	private String jobRequestId;
	private String newStatus;
	private String recruiterId;
	private String candidateId;
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}
	public String getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(String recruiterId) {
		this.recruiterId = recruiterId;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getJobRequestId() {
		return jobRequestId;
	}
	public void setJobRequestId(String jobRequestId) {
		this.jobRequestId = jobRequestId;
	}
	
	
}
