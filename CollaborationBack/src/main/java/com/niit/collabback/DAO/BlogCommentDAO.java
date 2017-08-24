package com.niit.collabback.DAO;

import java.util.List;

import com.niit.collabback.model.BlogComment;

public interface BlogCommentDAO {

	public List<BlogComment> listByUserId(int blogId);

	public void save(BlogComment blogComment);

	public void update(BlogComment blogComment);

	public void saveOrUpdate(BlogComment blogComment);
}
