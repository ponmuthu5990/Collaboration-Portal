package com.niit.collabback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "blog") 
@Component
public class Blog {
	
	private int blogId;

	private String blogName;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	private User user;
	
	
	
	/*@Generated(value = { "" })
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date = new java.sql.Date(new java.util.Date().getTime());*/
	
	private boolean status;
	
	
	@OneToMany(mappedBy = "blog", fetch=FetchType.EAGER)
	private List<BlogComment> blogComments;
	
	@OneToMany(mappedBy = "blog", fetch=FetchType.EAGER)
	private List<BlogLikes> blogLikes; 
	
	@OneToMany(mappedBy = "blog", fetch=FetchType.EAGER)
	private List<BlogDescription> blogDescriptions;
	
	
	
}
