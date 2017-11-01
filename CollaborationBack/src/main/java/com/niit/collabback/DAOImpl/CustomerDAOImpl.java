package com.niit.collabback.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabback.DAO.CustomerDAO;
import com.niit.collabback.model.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Customer> list() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> userList = query.list();
		return userList;
	}

	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);

	}

	public void update(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
	}

	public Customer getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where userId= '" + id + "'");
		// query.setString(0,username);
		Customer customer = (Customer) query.uniqueResult();
		return customer;
	}

	public Customer getByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where emailId= '" + email + "'");
		// query.setString(0,username);
		Customer customer = (Customer) query.uniqueResult();
		return customer;
	}

	public void saveOrUpdate(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	public Customer login(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Customer where userName=?");
		query.setString(0, customer.getUserName());
		Customer validCustomer = (Customer) query.uniqueResult();
		trans.commit();
		return validCustomer;
	}

	public Customer getByUserName(String userName) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Customer where userName=?");
		query.setString(0, userName);
		Customer validCustomer = (Customer) query.uniqueResult();
		trans.commit();
		return validCustomer;
	}

}
