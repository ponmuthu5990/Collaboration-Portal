package com.niit.collabback.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabback.DAO.BlogDAO;
import com.niit.collabback.model.Blog;
import com.niit.collabback.model.Customer;


@Repository
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Blog> listBasedOnStatus(boolean status) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where status = '" + status + "'");
		List<Blog> blogList=query.list();
		return blogList;
	}

	public List<Blog> listByUserId(int userId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where customer.userId = '" + userId + "'");
		List<Blog> blogList=query.list();
		return blogList;
	}

	public void save(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blog);

	}

	public void update(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		session.update(blog);
	}

	public void saveOrUpdate(Blog blog) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
	}

	public Blog getBlog(int blogId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where id = '" + blogId + "'");
		Blog blog = (Blog) query.uniqueResult();
		return blog;
	}

}
