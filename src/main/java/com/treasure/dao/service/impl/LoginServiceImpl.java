package com.treasure.dao.service.impl;

import com.treasure.dao.QueryDao;
import com.treasure.dao.UpdateDao;
import com.treasure.dao.po.User;
import com.treasure.dao.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private QueryDao queryDao;
	private UpdateDao updateDao;

	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}

	public void setUpdateDao(UpdateDao updateDao) {
		this.updateDao = updateDao;
	}

	/****************************************************************************************************************************************************************/

	@Override
	public int checkName(String name) {

		return (int) queryDao.queryOne("com.treasure.dao.po.mapper.UserMapper.checkUser", name);
	}

	@Override
	public int registUser(User user) {

		return updateDao.insert("com.treasure.dao.po.mapper.UserMapper.registUser", user);
	}

	@Override
	public int updateLastRequestTime(User user) {

		return updateDao.update("com.treasure.dao.po.mapper.UserMapper.updateLastRequestTime", user);
	}

	@Override
	public User checkLoginInfo(User user) {
		
		return (User) queryDao.queryOne("com.treasure.dao.po.mapper.UserMapper.checkLoginInfo", user);
	}
}
