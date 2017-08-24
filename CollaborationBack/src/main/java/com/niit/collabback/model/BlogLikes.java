package com.niit.collabback.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BlogLikes {
	
	

	private int likeId;
	
	
	
	private String userId;
	
	@ManyToOne
	@JoinColumn(name = "bid")
	private Blog blog;
}
