package com.niit.collabback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;

	private int userId;

	private String commends;

	@ManyToOne
	@JoinColumn(name = "bid")
	private Blog blog;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCommends() {
		return commends;
	}

	public void setCommends(String commends) {
		this.commends = commends;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
