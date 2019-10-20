package com.kimmy.web.dao.service;

import com.kimmy.web.dao.po.User;

public interface LoginService {

	int checkName(String name);

	int registUser(User user);

	int updateLastRequestTime(User user);

	User checkLoginInfo(User user);

}
