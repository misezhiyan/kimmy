package com.kimmy.web.business.service;

import com.kimmy.web.dao.po.User;

/**
 * @Title: SignInController
 * @Description: 登录功能
 * @author Barry
 * @date 2016-09-07
 */
public interface LoginBusinessService{

	boolean checkName(String name);

	boolean registUser(User user);

	boolean checkLoginInfo(User user);
	
}
