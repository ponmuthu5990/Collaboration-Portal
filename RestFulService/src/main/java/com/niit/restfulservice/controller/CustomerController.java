package com.niit.restfulservice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collabback.DAO.BlogCommentDAO;
import com.niit.collabback.DAO.BlogDAO;
import com.niit.collabback.DAO.BlogDescDAO;
import com.niit.collabback.DAO.BlogLikeDAO;
import com.niit.collabback.DAO.CustomerDAO;
import com.niit.collabback.model.Blog;
import com.niit.collabback.model.BlogComment;
import com.niit.collabback.model.BlogDescription;
import com.niit.collabback.model.BlogLikes;
import com.niit.collabback.model.Customer;
import com.niit.collabback.model.Error;

@RestController
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private BlogDAO blogDAO;

	@Autowired
	private BlogCommentDAO blogCommentDAO;

	@Autowired
	private BlogLikeDAO blogLikeDAO;

	@Autowired
	private BlogDescDAO blogDescDAO;

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getUsers() {
		List<Customer> customers = customerDAO.list();
		for (Customer customer : customers) {
			customer.setBlogs(null);
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = "/getProfile/{cid}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("cid") int cid) {

		Customer customer = customerDAO.getById(cid);

		List<Blog> blogs = blogDAO.listByUserId(cid);

		for (Blog blog : blogs) {

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

			blog.setCustomer(null);
		}

		customer.setBlogs(blogs);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

		// ONLY FOR AUTHENTICATION

	}

	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
		System.out.println("haaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaai");
		customer.setStatus("FALSE");
		customerDAO.save(customer);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@RequestMapping(value = "/loginCustomer", method = RequestMethod.POST)
	public ResponseEntity<?> loginCustomer(@RequestBody Customer customer, HttpSession session) {

		Customer validcustomer = customerDAO.login(customer);
		if (validcustomer == null) {
			Error error = new Error(3, "Invalid credentials.. please enter valid username");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		} else {

			validcustomer.setBlogs(null);
			session.setAttribute("validcustomer", validcustomer);
		}
		return new ResponseEntity<Customer>(validcustomer, HttpStatus.OK);
	}

	@RequestMapping(value = "/checkingPassword", method = RequestMethod.POST)
	public ResponseEntity<?> checkingPassword(@RequestBody Customer customer, HttpSession session) {

		Customer validcustomer = (Customer) session.getAttribute("validcustomer");
		System.out.println(validcustomer.getPassword() + "==" + customer.getPassword());
		if (validcustomer.getPassword().equals(customer.getPassword())) {
			customer.setStatus("TRUE");
			customer.setBlogs(null);
			customerDAO.saveOrUpdate(customer);
			session.setAttribute("userName", customer.getUserName());
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {

			Error error = new Error(3, "Invalid credentials.. please enter valid password");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}

	}

	@RequestMapping(value = "/signOut")
	public ResponseEntity<?> logout(HttpSession session) {
		System.out.println("signOut mapping");
		// Customer customer = (Customer) session.getAttribute("validcustomer");
		// System.out.println(customer.getUserName());

		if (session.getAttribute("userName") == null) {
			Error error = new Error(5, "UnAuthorized User");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		String userName = (String) session.getAttribute("userName");
		System.out.println(userName);

		Customer customer = customerDAO.getByUserName(userName);
		customer.setBlogs(null);
		customer.setJobApplieds(null);
		customer.setStatus("FALSE");

		customerDAO.saveOrUpdate(customer);
		session.removeAttribute("userName");
		session.invalidate();
		Error error = new Error(4, "Logged Out Succeffully");
		return new ResponseEntity<Error>(error, HttpStatus.OK);
	}
}
