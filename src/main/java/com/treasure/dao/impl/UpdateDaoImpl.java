package com.treasure.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.treasure.dao.UpdateDao;

public class UpdateDaoImpl implements UpdateDao{

	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	


	public int insert(String mapperId, Object obj) {
		
		return sqlSession.insert(mapperId, obj);
	}

	public int update(String mapperId, Object obj) {
		
		return sqlSession.update(mapperId, obj);
	}

	public int delete(String mapperId, Object obj) {
		
		return sqlSession.delete(mapperId, obj);
	}

}
