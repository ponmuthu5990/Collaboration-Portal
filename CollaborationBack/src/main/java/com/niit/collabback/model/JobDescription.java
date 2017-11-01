package com.niit.collabback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "JobDescription")
@Component
public class JobDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobDescId;

	@ManyToOne
	@JoinColumn(name = "jobId")
	private Job job;

	@Column(length = 2000)
	private String jobDesc;

	public int getJobDescId() {
		return jobDescId;
	}

	public void setJobDescId(int jobDescId) {
		this.jobDescId = jobDescId;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

}
