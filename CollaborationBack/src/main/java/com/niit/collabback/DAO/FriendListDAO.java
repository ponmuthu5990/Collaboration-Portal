package com.niit.collabback.DAO;

import java.util.List;

import com.niit.collabback.model.Customer;
import com.niit.collabback.model.FriendList;

public interface FriendListDAO {

	List<Customer> suggestedCustomer(String username);
	
	public List<FriendList> friendList(String userName);
}
