package com.niit.collabback.DAO;

import java.util.List;

import com.niit.collabback.model.BlogLikes;

public interface BlogLikeDAO {
	public List<BlogLikes> listByBlogId(int blogId);

	public void save(BlogLikes blogLikes);

	public void update(BlogLikes blogLikes);

	public void saveOrUpdate(BlogLikes blogLikes);
}
