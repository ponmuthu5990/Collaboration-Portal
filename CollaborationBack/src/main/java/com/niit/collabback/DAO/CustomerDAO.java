package com.niit.collabback.DAO;

import java.util.List;

import com.niit.collabback.model.Customer;

public interface CustomerDAO {
	
	public List<Customer> list();

	public void save(Customer customer);
	
	public void update(Customer customer);
	
	public Customer getById(int id);
	
	public Customer getByEmail(String email);
	
	public Customer getByUserName(String userName);
	
	public void saveOrUpdate(Customer customer);
	
	public Customer login(Customer customer);
}
