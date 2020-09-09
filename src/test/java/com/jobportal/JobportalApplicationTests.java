package com.jobportal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jobportal.domain.Candidate;
import com.jobportal.domain.Job;
import com.jobportal.domain.JobRequest;

@ComponentScan(basePackages = "com.jobportal")
public class JobportalApplicationTests extends AbstractTest {
	
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
	
	@Test
	public void getJobList() throws Exception {
	  String uri = "http://localhost:8085/candidate/joblist";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   
	   String content = mvcResult.getResponse().getContentAsString();
	   Job[] joblist = super.mapFromJson(content, Job[].class);
	   assertTrue(joblist.length > 0);
	}
	
	@Test
	public void insertJob() throws Exception {
	   String uri = "http://localhost:8085/candidate/insertjobrequest";
	   JobRequest jr = new JobRequest();
	   jr.setJobRequestId("jr123");
	   ArrayList<String> jobStatus = new ArrayList<String>();
	   jobStatus.add("Applied");
	   jr.setJobRequestStatus(jobStatus);
	   Job job = new Job();
	   job.setCompanyId("123");
	   jr.setJobDetails(job);
	   Candidate can = new Candidate();
	   can.setCandidateId("1235");
	   jr.setCandidateDetails(can);
	   
	   String inputJson = super.mapToJson(jr);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "Inserted");
	}
	
}
