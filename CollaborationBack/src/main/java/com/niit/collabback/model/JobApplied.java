package com.niit.collabback.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "JobApplied")
@Component
public class JobApplied {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appliedId;

	@ManyToOne
	@JoinColumn(name = "jobId")
	private Job job;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer customer;

	private Date applyDate;

	public int getAppliedId() {
		return appliedId;
	}

	public void setAppliedId(int appliedId) {
		this.appliedId = appliedId;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

}
