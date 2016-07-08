package com.niit.colloborate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.colloborate.model.Blog;
import com.niit.colloborate.model.BlogContent;

@Repository
@Transactional
public class BlogDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void createNewBlog(Blog blog)
	{
		Session s=sessionFactory.openSession();
		s.save(blog);
		s.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Blog> getBlogList(String cust_name)
	{
		Session s=sessionFactory.openSession();
		Criteria c=s.createCriteria(Blog.class);
		c.add(Restrictions.eq("cust_name", cust_name));
		List <Blog> b=c.list();
		return b;
	}
	
	public void insertPost(BlogContent content)
	{
		Session s=sessionFactory.openSession();
		s.save(content);
		s.flush();
	}
	@SuppressWarnings("unchecked")
	public List<BlogContent> getBlogContent(String blog_name)
	{
		Session s=sessionFactory.openSession();
		Criteria cr=s.createCriteria(BlogContent.class);
		cr.add(Restrictions.eq("blog_name", blog_name));
		return cr.list();
		
	}
}
