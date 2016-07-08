package com.niit.colloborate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogContent 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int blog_title_id;
	
	@Column(unique=true)
	private String blog_title;
	
	private String blog_name;
	
	private String cust_name,content;
	
	
	public int getBlog_title_id() {
		return blog_title_id;
	}
	public void setBlog_title_id(int blog_title_id) {
		this.blog_title_id = blog_title_id;
	}
	public String getBlog_name() {
		return blog_name;
	}
	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
