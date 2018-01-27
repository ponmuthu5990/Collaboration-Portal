package com.niit.collabback.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabback.DAO.FriendListDAO;
import com.niit.collabback.model.Customer;
import com.niit.collabback.model.FriendList;

@Repository
@Transactional
public class FriendListDAOImpl implements FriendListDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> suggestedCustomer(String username) {
		Session session = sessionFactory.getCurrentSession();
		String queryString = "select * from Customer where userName in(select userName from Customer where userName != ? minus (select userId from FriendList where frinedId= ? union select frinedId from FriendList where userId= ?))";

		SQLQuery query = session.createSQLQuery(queryString);
		query.setString(0, username);
		query.setString(1, username);
		query.setString(2, username);
		query.addEntity(Customer.class);
		@SuppressWarnings("unchecked")
		List<Customer> suggestedUsers = query.list();
		return suggestedUsers;
	}

	public List<FriendList> friendList(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from FriendList where (userId=? or frinedId=?) and status = ?");
		query.setString(0, userName);
		query.setString(1, userName);
		query.setCharacter(2, 'A');

		return query.list();
	}

}
