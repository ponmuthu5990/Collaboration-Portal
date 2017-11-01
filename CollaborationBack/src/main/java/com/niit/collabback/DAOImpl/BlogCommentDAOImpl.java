package com.niit.collabback.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabback.DAO.BlogCommentDAO;
import com.niit.collabback.model.BlogComment;
import com.niit.collabback.model.BlogDescription;

@Repository
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<BlogComment> listByBlogId(int blogId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from BlogComment where blog.id = '" + blogId + "'");
		List<BlogComment> blogCommentList=query.list();
		return blogCommentList;
	}

	public void save(BlogComment blogComment) {
		Session session=sessionFactory.getCurrentSession();
		session.save(blogComment);

	}

	public void update(BlogComment blogComment) {
		Session session=sessionFactory.getCurrentSession();
		session.update(blogComment);

	}

	public void saveOrUpdate(BlogComment blogComment) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blogComment);

	}

}
