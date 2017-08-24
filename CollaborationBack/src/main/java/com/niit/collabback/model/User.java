package com.niit.collabback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity // to map the data base table
@Table(name = "user") // if the table name and domain class name is different
@Component // context.scan("com.niit") --will scan the pacakge and create
			// singleton instances
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String emailId;

	private String contactNo;

	private String userName;

	private String role;

	private String address;
	
	private String zipCode;
	
	@OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
	private List<Blog> blogs;
	
}
