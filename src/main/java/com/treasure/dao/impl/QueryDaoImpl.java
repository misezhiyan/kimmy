package com.treasure.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.treasure.dao.QueryDao;

public class QueryDaoImpl implements QueryDao{

	private SqlSessionTemplate session;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.session = sqlSession;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Object queryOne(String mapperId, Object object) {
		return session.selectOne(mapperId, object);
	}
	
	public Object queryList(String mapperId, Object object) {
		return session.selectList(mapperId, object);
	}
	
	
}
