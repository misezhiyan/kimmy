package com.kimmy.web.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.kimmy.web.dao.QueryDao;

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
