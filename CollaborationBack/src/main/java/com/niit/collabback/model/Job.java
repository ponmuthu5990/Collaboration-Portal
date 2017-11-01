package com.niit.collabback.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Job")
@Component
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobId;

	private String jobName;

	private String jobCode;

	private Date addDate;

	private Date interviewDate;
	
	private int experience;
		
	@ManyToOne
	@JoinColumn(name = "companyId")
	private JobCompany jobCompany;

	@OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
	private List<JobDescription> jobDescriptions;
	
	@OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
	private List<JobApplied> jobApplieds;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public JobCompany getJobCompany() {
		return jobCompany;
	}

	public void setJobCompany(JobCompany jobCompany) {
		this.jobCompany = jobCompany;
	}

	public List<JobDescription> getJobDescriptions() {
		return jobDescriptions;
	}

	public void setJobDescriptions(List<JobDescription> jobDescriptions) {
		this.jobDescriptions = jobDescriptions;
	}

	public List<JobApplied> getJobApplieds() {
		return jobApplieds;
	}

	public void setJobApplieds(List<JobApplied> jobApplieds) {
		this.jobApplieds = jobApplieds;
	}
	
	
}
