package com.niit.restfulservice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collabback.DAO.BlogCommentDAO;
import com.niit.collabback.DAO.BlogDAO;
import com.niit.collabback.DAO.BlogDescDAO;
import com.niit.collabback.DAO.BlogLikeDAO;
import com.niit.collabback.model.Blog;
import com.niit.collabback.model.BlogComment;
import com.niit.collabback.model.BlogDescription;
import com.niit.collabback.model.BlogLikes;

@RestController
public class BlogController {

	@Autowired
	private BlogDAO blogDAO;

	@Autowired
	private BlogCommentDAO blogCommentDAO;

	@Autowired
	private BlogLikeDAO blogLikeDAO;

	@Autowired
	private BlogDescDAO blogDescDAO;

	@RequestMapping(value = "/getBlog/{bid}", method = RequestMethod.GET)
	public ResponseEntity<?> getBlog(@PathVariable("bid") int id, HttpSession session) {

		Blog blog = blogDAO.getBlog(id);
		List<BlogComment> blogComments = blogCommentDAO.listByBlogId(blog.getId());
		for (BlogComment blogComment : blogComments) {
			blogComment.setBlog(null);
		}
		blog.setBlogComments(blogComments);

		List<BlogLikes> blogLikes = blogLikeDAO.listByBlogId(blog.getId());
		
		for (BlogLikes blogLike : blogLikes) {
			blogLike.setBlog(null);
		}
		
		blog.setBlogLikes(blogLikes);

		List<BlogDescription> blogDescriptions = blogDescDAO.listByBlogId(blog.getId());
		for (BlogDescription blogDescription : blogDescriptions) {
			blogDescription.setBlog(null);
		}
		blog.setBlogDescriptions(blogDescriptions);

		blog.getCustomer().setBlogs(null);

		session.setAttribute("blog", blog);

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);

	}

	@RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
	public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
		blogDAO.saveOrUpdate(blog);
		
		/* ngModel should be blog.blogComment.comment */
		
		List<BlogComment> blogComments = blog.getBlogComments();

		if (!blogComments.isEmpty()) {
			for (BlogComment blogComment : blogComments) {
				blogCommentDAO.save(blogComment);
			}
		}

		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveBlogComment", method = RequestMethod.POST)
	public ResponseEntity<BlogComment> saveBlogComment(@RequestBody BlogComment blogComment, HttpSession session) {

		Blog blog = (Blog) session.getAttribute("blog");

		blog.setBlogComments(null);
		blog.setBlogDescriptions(null);
		blog.setBlogLikes(null);
		blog.setCustomer(null);

		blogComment.setBlog(blog);
		/*
		 * blogComment.getBlog().setBlogComments(null);
		 * blogComment.getBlog().setBlogDescriptions(null);
		 * blogComment.getBlog().setBlogLikes(null);
		 */

		blogCommentDAO.saveOrUpdate(blogComment);
		return new ResponseEntity<BlogComment>(blogComment, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveBlogLike", method = RequestMethod.POST)
	public ResponseEntity<BlogLikes> saveBlogLike(@RequestBody BlogLikes blogLikes, HttpSession session) {

		Blog blog = (Blog) session.getAttribute("blog");

		blog.setBlogComments(null);
		blog.setBlogDescriptions(null);
		blog.setBlogLikes(null);
		blog.setCustomer(null);
		
		blogLikes.setBlog(blog);
		/*
		 * blogComment.getBlog().setBlogComments(null);
		 * blogComment.getBlog().setBlogDescriptions(null);
		 * blogComment.getBlog().setBlogLikes(null);
		 */
		
		blogLikeDAO.saveOrUpdate(blogLikes);
		return new ResponseEntity<BlogLikes>(blogLikes, HttpStatus.OK);
	}
}
