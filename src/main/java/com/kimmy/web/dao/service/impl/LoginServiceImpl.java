package com.kimmy.web.dao.service.impl;

import com.kimmy.web.dao.QueryDao;
import com.kimmy.web.dao.UpdateDao;
import com.kimmy.web.dao.po.User;
import com.kimmy.web.dao.service.LoginService;

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

		return (int) queryDao.queryOne("com.kimmy.web.dao.po.mapper.UserMapper.checkUser", name);
	}

	@Override
	public int registUser(User user) {

		return updateDao.insert("com.kimmy.web.dao.po.mapper.UserMapper.registUser", user);
	}

	@Override
	public int updateLastRequestTime(User user) {

		return updateDao.update("com.kimmy.web.dao.po.mapper.UserMapper.updateLastRequestTime", user);
	}

	@Override
	public User checkLoginInfo(User user) {
		
		return (User) queryDao.queryOne("com.kimmy.web.dao.po.mapper.UserMapper.checkLoginInfo", user);
	}
}
