package com.treasure.dao.service;

import com.treasure.dao.po.User;

public interface LoginService {

	int checkName(String name);

	int registUser(User user);

	int updateLastRequestTime(User user);

	User checkLoginInfo(User user);

}
