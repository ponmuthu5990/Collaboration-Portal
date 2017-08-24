package com.niit.collabback.DAO;

import java.util.List;

import com.niit.collabback.model.User;

public interface UserDAO {
	
	public List<User> list();

	public void save(User user);
	
	public void update(User user);
	
	public User getById(int id);
	
	public User getByEmail(String email);
	
	public void saveOrUpdate(User user);
}
