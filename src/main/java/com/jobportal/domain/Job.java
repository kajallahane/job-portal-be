package com.jobportal.domain;

public class Job {
	String jobId;
	String title;
	String expectedExperience;	
	String description;
	String company;
	String location;
	public String getExpectedExperience() {
		return expectedExperience;
	}
	public void setExpectedExperience(String expectedExperience) {
		this.expectedExperience = expectedExperience;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
