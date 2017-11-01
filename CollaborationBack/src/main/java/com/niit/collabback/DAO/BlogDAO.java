package com.niit.collabback.DAO;

import java.util.List;

import com.niit.collabback.model.Blog;

public interface BlogDAO {

	public List<Blog> listBasedOnStatus(boolean status);

	public List<Blog> listByUserId(int userId);

	public void save(Blog blog);

	public void update(Blog blog);

	public void saveOrUpdate(Blog blog);

	public Blog getBlog(int blogId);

}
