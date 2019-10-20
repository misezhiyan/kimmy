package com.treasure.business.service;

import java.util.List;

import com.treasure.dao.po.User;
import com.treasure.dao.po.UserPoker;

/**
 * @Title: SignInController
 * @Description: 绑定poker账号密码功能
 * @author KIMMY
 * @date 2016-09-07
 */
public interface PokerBusinessService{

	List<UserPoker> getPokerList(User user);

	int pokerBind(UserPoker userPoker);

	int checkPoker(String name, String user_id);
	
}
