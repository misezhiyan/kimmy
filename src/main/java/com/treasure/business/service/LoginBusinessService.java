package com.treasure.business.service;

import com.treasure.dao.po.User;

/**
 * @Title: SignInController
 * @Description: 登录功能
 * @author Barry
 * @date 2016-09-07
 */
public interface LoginBusinessService{

	boolean checkName(String name);

	boolean registUser(User user);

	User checkLoginInfo(User user);

	boolean logOut();
	
}
