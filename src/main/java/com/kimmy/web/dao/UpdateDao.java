package com.kimmy.web.dao;

public interface UpdateDao {

	public int insert(String mapperId, Object obj);
	
	public int update(String mapperId, Object obj);
	
	public int delete(String mapperId, Object obj);
}