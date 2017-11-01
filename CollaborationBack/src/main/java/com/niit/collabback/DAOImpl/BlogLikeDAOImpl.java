package com.niit.collabback.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabback.DAO.BlogLikeDAO;
import com.niit.collabback.model.BlogLikes;

@Repository
@Transactional
public class BlogLikeDAOImpl implements BlogLikeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<BlogLikes> listByBlogId(int blogId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogLikes where blog.id = '" + blogId + "'");
		List<BlogLikes> blogLikesList=query.list();
		return blogLikesList;
	}

	public void save(BlogLikes blogLikes) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogLikes);
		
	}

	public void update(BlogLikes blogLikes) {
		Session session=sessionFactory.getCurrentSession();
		session.update(blogLikes);
		
	}

	public void saveOrUpdate(BlogLikes blogLikes) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blogLikes);
		
	}

}
