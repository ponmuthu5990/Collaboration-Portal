package com.niit.collabback;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collabback.DAO.CustomerDAO;
import com.niit.collabback.model.Customer;

public class UserTestCase {

	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CustomerDAO customerDAO;

	@Autowired
	static Customer customer;	
	
	@BeforeClass
	public static void initialize() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		// get the userDAO from context
		customerDAO = (CustomerDAO) context.getBean("UserDAO");

		customer = (Customer) context.getBean("user");
	}

	
	@Test
	public void test() {
		
		
		customer.setContactNo("123456");
		customer.setEmailId("muthu@gmail.com");
		customer.setRole("user");
		customer.setUserName("muth");
	
		customerDAO.saveOrUpdate(customer);
	
		fail("Not yet implemented");
	}

}
