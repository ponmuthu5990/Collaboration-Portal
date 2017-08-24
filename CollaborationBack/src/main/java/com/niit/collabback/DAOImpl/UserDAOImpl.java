package com.niit.collabback.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabback.DAO.UserDAO;
import com.niit.collabback.model.User;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<User> list() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		List<User> userList=query.list();
		return userList;
	}

	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		
	}

}
