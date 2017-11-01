package com.niit.collabback.DAO;

import java.util.List;

import com.niit.collabback.model.BlogDescription;

public interface BlogDescDAO {

	public List<BlogDescription> listByBlogId(int blogId);

	public void save(BlogDescription blogDescription);

	public void update(BlogDescription blogDescription);

	public void saveOrUpdate(BlogDescription blogDescription);
}
