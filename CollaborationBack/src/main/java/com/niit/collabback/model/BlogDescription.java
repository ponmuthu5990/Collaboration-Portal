package com.niit.collabback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "blogDescription") 
@Component
public class BlogDescription {
	
	private int blogDescId;

	@Column(length = 2500)
	private String content;
	
	
	@ManyToOne
	@JoinColumn(name = "bid")
	private Blog blog;
}
