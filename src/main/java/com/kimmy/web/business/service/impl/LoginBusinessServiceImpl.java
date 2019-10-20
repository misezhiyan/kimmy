package com.kimmy.web.business.service.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.kimmy.web.business.service.LoginBusinessService;
import com.kimmy.web.dao.po.User;
import com.kimmy.web.dao.service.LoginService;
import com.kimmy.web.util.ContextHolderUtils;

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
	public boolean checkLoginInfo(User logInUser) {
		
		User user = loginService.checkLoginInfo(logInUser);
		if(user != null) {
			
			HttpSession session = ContextHolderUtils.getSession();
			session.setAttribute("user", user);
			
			//检验该账号是否已处于登录状态, 如果已处于登录状态, 将原来登录session解散掉, 并登录新的session
			Map<String, HttpSession> sessionMap = ContextHolderUtils.getSessionMap();
			HttpSession oldSession = sessionMap.get(user.getUser_id());
			if(null != oldSession) {
				oldSession.invalidate();
			}
			
			
			Set keys = sessionMap.keySet();
			Iterator iterator = keys.iterator();
			while(iterator.hasNext()) {
				String key = iterator.next().toString();
				System.err.println("摧毁后map中key值:" + key);
				System.err.println("摧毁后map中session:" + sessionMap.get(key));
			}
			
			
			sessionMap.put(user.getUser_id(), session);
			
			return true;
		}
		
		return false;
	}
}
