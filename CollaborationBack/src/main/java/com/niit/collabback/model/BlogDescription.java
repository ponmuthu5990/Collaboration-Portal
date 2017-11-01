package com.niit.collabback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "blogDescription")
@Component
public class BlogDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int blogDescId;

	@Column(length = 2500)
	private String content;

	@ManyToOne
	@JoinColumn(name = "bid")
	private Blog blog;

	public int getBlogDescId() {
		return blogDescId;
	}

	public void setBlogDescId(int blogDescId) {
		this.blogDescId = blogDescId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
