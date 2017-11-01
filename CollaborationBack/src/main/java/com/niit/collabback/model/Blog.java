package com.niit.collabback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "blog")
@Component
public class Blog {

	@Id
	@GeneratedValue
	private int id;

	private String blogName;

	/*
	 * @Generated(value = { "" })
	 * 
	 * @Temporal(javax.persistence.TemporalType.DATE) private Date date = new
	 * java.sql.Date(new java.util.Date().getTime());
	 */

	private String approved;

	@OneToMany(mappedBy = "blog", fetch = FetchType.EAGER)
	private List<BlogComment> blogComments;

	@OneToMany(mappedBy = "blog", fetch = FetchType.EAGER)
	private List<BlogLikes> blogLikes;

	@OneToMany(mappedBy = "blog", fetch = FetchType.EAGER)
	private List<BlogDescription> blogDescriptions;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public List<BlogComment> getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(List<BlogComment> blogComments) {
		this.blogComments = blogComments;
	}

	public List<BlogLikes> getBlogLikes() {
		return blogLikes;
	}

	public void setBlogLikes(List<BlogLikes> blogLikes) {
		this.blogLikes = blogLikes;
	}

	public List<BlogDescription> getBlogDescriptions() {
		return blogDescriptions;
	}

	public void setBlogDescriptions(List<BlogDescription> blogDescriptions) {
		this.blogDescriptions = blogDescriptions;
	}

}
