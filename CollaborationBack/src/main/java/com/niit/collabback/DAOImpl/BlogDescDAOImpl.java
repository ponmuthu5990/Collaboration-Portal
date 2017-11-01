package com.niit.collabback.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabback.DAO.BlogDescDAO;
import com.niit.collabback.model.Blog;
import com.niit.collabback.model.BlogDescription;

@Repository
@Transactional
public class BlogDescDAOImpl implements BlogDescDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<BlogDescription> listByBlogId(int blogId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogDescription where blog.id = '" + blogId + "'");
		List<BlogDescription> blogDescList=query.list();
		return blogDescList;
	}

	public void save(BlogDescription blogDescription) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogDescription);
	}

	public void update(BlogDescription blogDescription) {
		Session session=sessionFactory.getCurrentSession();
		session.update(blogDescription);
	}

	public void saveOrUpdate(BlogDescription blogDescription) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blogDescription);
	}

}
