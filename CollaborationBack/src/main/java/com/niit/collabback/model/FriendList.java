package com.niit.collabback.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "FriendList")
@Component
public class FriendList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fLId;

	private Date addDate;

	private String status;

	private int frinedId;

	private int userId;

	public int getfLId() {
		return fLId;
	}

	public void setfLId(int fLId) {
		this.fLId = fLId;
	}

	public int getFrinedId() {
		return frinedId;
	}

	public void setFrinedId(int frinedId) {
		this.frinedId = frinedId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

}
