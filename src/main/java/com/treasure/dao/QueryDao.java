package com.treasure.dao;

public interface QueryDao {
	
	public Object queryOne(String mapperId, Object object);
	
	public Object queryList(String mapperId, Object object);
	
}
