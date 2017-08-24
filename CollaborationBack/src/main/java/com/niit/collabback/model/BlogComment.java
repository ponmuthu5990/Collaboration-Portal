package com.niit.collabback.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "blogComment") 
@Component
public class BlogComment {

	/*
	 * @Id
	 * 
	 * @Column(name="CommentId")
	 * 
	 * @GeneratedValue
	 */
	private int commentId;

	
	
	private int userId;
		
	private String commends;

	@ManyToOne
	@JoinColumn(name = "bid")
	private Blog blog;
	
}
