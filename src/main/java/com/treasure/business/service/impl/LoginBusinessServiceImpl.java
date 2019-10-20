package com.treasure.business.service.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.treasure.business.service.LoginBusinessService;
import com.treasure.dao.po.User;
import com.treasure.dao.service.LoginService;
import com.treasure.util.ContextHolderUtils;


/**
 * @Title: SignInController
 * @Description: 登录功能
 * @author Barry
 * @date 2016-09-07
 */
public class LoginBusinessServiceImpl implements LoginBusinessService {

	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/*************************** 业务功能区	 *****************************************************/

	@Override
	public boolean checkName(String name) {

		int nameCount = loginService.checkName(name);
		if (nameCount > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean registUser(User user) {
		
		int ret = loginService.registUser(user);
		
		if(ret == 1) {
			return true;
		}
		
		return false;
	}

	@Override
	public User checkLoginInfo(User logInUser) {
		
		User user = loginService.checkLoginInfo(logInUser);
		
		return user;
	}

	@Override
	public boolean logOut() {
		
		HttpSession session = ContextHolderUtils.getSession();
		try {
			session.invalidate();
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
