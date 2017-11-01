package com.niit.collabback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * @author Acer
 *
 */
@Entity // to map the data base table
@Table(name = "customer") // if the table name and domain class name is
							// different
@Component // context.scan("com.niit") --will scan the pacakge and create
			// singleton instances
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String emailId;

	private String contactNo;

	private String userName;

	private String role;

	private String gender;

	private String password;

	private String status;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Blog> blogs;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<JobApplied> jobApplieds;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<JobApplied> getJobApplieds() {
		return jobApplieds;
	}

	public void setJobApplieds(List<JobApplied> jobApplieds) {
		this.jobApplieds = jobApplieds;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
